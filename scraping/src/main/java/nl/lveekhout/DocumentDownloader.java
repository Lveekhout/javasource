package nl.lveekhout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DocumentDownloader {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.telegraaf.nl").get();
        Elements elements = doc.select("a");
        for (Element e : elements) {
            System.out.println(e.attributes().get("href"));
        }
    }
}
