package nl.lveekhout.app;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileServer extends AbstractHandler
{
    private static Integer port;
    private static File directory;

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            File f = new File(directory + baseRequest.getPathInfo());
            if (f.exists()) {
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType(Files.probeContentType(f.toPath()));
                baseRequest.setHandled(true);
                FileUtils.copyFile(f, response.getOutputStream());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } finally {
            System.out.println("[" + s.format(new Date()) + "] " + baseRequest.getMethod() + " " + baseRequest.getPathInfo() + " ... " + response.getStatus());
        }
    }

    public static void main(String[] args) throws Exception
    {
        port = Integer.parseInt(args[0]);
        directory = new File(args[1]);

        if (!directory.isDirectory()) throw new RuntimeException(args[1] + " is geen geldige directory");

        Server server = new Server(port);
        server.setHandler(new FileServer());

        server.start();
        server.join();
    }
}