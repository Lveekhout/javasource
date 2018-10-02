package nl.lveekhout;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

//
// https://wiki.intra.tkppensioen.nl/pages/viewpage.action?pageId=108465043
//
public class ElasticSearch {
    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "elastic").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("elastic-api.tst.tkp"), 9300));
        GetResponse response = client.prepareGet("paspoort", "personen", "DTL-3590029").get();
        System.out.println(response);
    }
}
