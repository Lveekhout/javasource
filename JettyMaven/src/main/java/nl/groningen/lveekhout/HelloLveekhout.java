package nl.groningen.lveekhout;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by eekhout.l on 30-11-2015.
 * class HelloLveekhout
 */
public class HelloLveekhout extends AbstractHandler {

    public static void main(String args[]) {
        Server server = new Server(8080);
        server.setHandler(new HelloLveekhout());

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getHeader("Host").split(":")[0].equals("localhost") || request.getHeader("Host").split(":")[0].equals("w7vm39")) {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html; charset=utf-8");

            PrintWriter writer = response.getWriter();
            writer.printf("getMethod: %s<BR>", request.getMethod());
            writer.printf("getPathInfo: %s<BR>", request.getPathInfo());
            writer.printf("getPathTranslated: %s<BR>", request.getPathTranslated());
            writer.printf("getQueryString: %s<BR>", request.getQueryString());
            writer.printf("getRemoteUser: %s<BR>", request.getRemoteUser());
            writer.printf("getRequestedSessionId: %s<BR>", request.getRequestedSessionId());
            writer.printf("getRequestURI: %s<BR>", request.getRequestURI());
            writer.printf("getServletPath: %s<BR>", request.getServletPath());
            writer.printf("getLocalAddr: %s<BR>", request.getLocalAddr());
            writer.printf("getLocalName: %s<BR>", request.getLocalName());
            writer.printf("request.getHeader(\"Host\"): %s<BR>", request.getHeader("Host"));
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/plain");

            PrintWriter writer = response.getWriter();
            writer.print("unknown host");
        }
        baseRequest.setHandled(true);
    }
}
