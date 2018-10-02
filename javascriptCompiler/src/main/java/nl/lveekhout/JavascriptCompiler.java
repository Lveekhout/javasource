package nl.lveekhout;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/* https://jsoup.org/apidocs/overview-summary.html */

public class JavascriptCompiler {
    public static void main(String[] args) throws IOException {
        if (args.length!=1) {
            System.out.println("1 argument verwacht met pad naar bestand");
            return;
        }
        File fIn = new File(args[0]);
        if (!fIn.exists()) throw new RuntimeException("Bestand bestaat niet");
        if (!fIn.isFile()) throw new RuntimeException("Bestand is geen file");
        if (!"text/html".equals(Files.probeContentType(fIn.toPath()))) throw new RuntimeException("MIME type van bestand is geen text/html, maar: " + Files.probeContentType(fIn.toPath()));

        String index = readFile(fIn, StandardCharsets.UTF_8);
        Document doc = Jsoup.parse(index);
        Elements elements = doc.select("link");
        for (Element e : elements) {
            if ("stylesheet".equals(e.attributes().get("rel"))) {
                File fSub = new File(fIn.getParent() + "\\" + e.attributes().get("href"));
                if (!fSub.exists()) throw new RuntimeException("Bestand: [" + fSub.getName() + "] bestaat niet");
                if (!fSub.isFile()) throw new RuntimeException("Bestand: [" + fSub.getName() + "] is geen file");
                String sub = readFile(fSub, StandardCharsets.UTF_8);
                e.remove();
                doc.head().append("<style>" + sub + "</style>");
            } else throw new RuntimeException("Link element niet van het type stylesheet");
        }

        elements = doc.select("script");
        for (Element e : elements) {
            if (e.attributes().get("src")!=null) {
                File fSub = new File(fIn.getParent() + "\\" + e.attributes().get("src"));
                if (!fSub.exists()) throw new RuntimeException("Bestand: [" + fSub.getName() + "] bestaat niet");
                if (!fSub.isFile()) throw new RuntimeException("Bestand: [" + fSub.getName() + "] is geen file");
                String sub = readFile(fSub, StandardCharsets.UTF_8);
                e.remove();
                doc.head().append("<script type=\"application/javascript\">" + sub + "</script>");
            }
        }

        elements = doc.select("img");
        for (Element e : elements) {
            if (e.attributes().get("src")!=null) {
                e.attributes().put("src", "Dit is een test - " + e.attributes().get("src"));
                System.out.println(e.outerHtml());
            }
        }

        File fOut = new File(fIn.getParent() + "\\compiled - " + fIn.getName());
        FileUtils.writeStringToFile(fOut, doc.outerHtml(), StandardCharsets.UTF_8);
    }

    static String readFile(File file, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }
}