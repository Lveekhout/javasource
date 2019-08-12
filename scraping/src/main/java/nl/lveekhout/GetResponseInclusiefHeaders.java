package nl.lveekhout;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetResponseInclusiefHeaders {
    public static void main(String[] args) throws IOException {
        Connection.Response res = Jsoup.connect("https://www.klm.com/travel/nl_nl/apps/ebt/calendar.htm?application=EBT7&trip=AMS%3ECUR-CUR%3EAMS&flightsSource=TRIPPLANNER&flightPreference=LOWEST_PRICE&flightProductFilter=LOWEST_PRICE&destinationType=AIRPORT&WT.seg_3=HPN_letsgo_May19_CUR")
                .method(Connection.Method.GET)
                .execute();

        for (String s : res.headers().keySet()) {
            System.out.printf("%s: %s\n", s, StringUtils.join(res.headers(s), ", "));
        }

        Document doc = res.parse();
        System.out.println(doc.toString());
//        Elements elements = doc.select("a");
//        for (Element e : elements) {
//            System.out.println(e.attributes().get("href"));
//        }
    }
}