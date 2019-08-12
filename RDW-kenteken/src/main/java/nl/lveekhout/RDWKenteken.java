package nl.lveekhout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Date;

/*
20-06-2019 Lveekhout
- https://stackoverflow.com/questions/6908948/java-sun-security-provider-certpath-suncertpathbuilderexception-unable-to-find
- Acties
    1. Download .cer file via Chrome browser en noem het rdw.cer
    2. keytool -importcert -keystore rdw -file D:\Dev\github.com\javasource\RDW-kenteken\src\main\resources\rdw.cer
    3. Voeg de VM option toe: -Djavax.net.ssl.trustStore=G:\Temp\sqlplus\rdw óf set de System.setProperty zoals hieronder
*/
public class RDWKenteken {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/rdw"); // zetten trusted certificate store

        while (true) {
            Document res = Jsoup.connect("https://ovi.rdw.nl/default.aspx")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .requestBody("ovipplate=07hln6")
                    .post();

            System.out.println(new Date() + " -=> " + res.getElementById("VervaldatumApkKeuring").text());
            Thread.sleep(1000);
        }
    }

}