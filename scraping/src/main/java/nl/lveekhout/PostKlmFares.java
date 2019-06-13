package nl.lveekhout;

import com.sun.deploy.util.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class PostKlmFares {
    public static void main(String[] args) throws IOException {
        Connection.Response res = Jsoup.connect("https://www.klm.com/ams/search-web/api/fares")
                .method(Connection.Method.POST)
                .ignoreContentType(true)
                .requestBody("{\"country\":\"NL\",\"language\":\"nl\",\"cabinClass\":\"ECONOMY\",\"passengerCount\":{\"ADULT\":1,\"CHILD\":0,\"INFANT\":0},\"type\":\"DAY\",\"requestedConnections\":[{\"minDaysOfStay\":32,\"maxDaysOfStay\":56,\"origin\":{\"airport\":{\"code\":\"AMS\"}},\"destination\":{\"airport\":{\"code\":\"CUR\"}},\"dateInterval\":\"2019-07-30/2019-08-10\"},{\"origin\":{\"airport\":{\"code\":\"CUR\"}},\"destination\":{\"airport\":{\"code\":\"AMS\"}}}],\"localeStringDateTime\":\"nl-NL\",\"localeStringNumber\":\"nl-NL\"}")
                .execute();

        for (String s : res.headers().keySet()) {
            System.out.printf("%s: %s\n", s, StringUtils.join(res.headers(s), ", "));
        }

        String body = res.body();
        System.out.printf("\n\n%s", body);
    }
}