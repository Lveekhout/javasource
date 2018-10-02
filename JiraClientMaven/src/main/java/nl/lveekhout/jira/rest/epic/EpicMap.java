package nl.lveekhout.jira.rest.epic;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import nl.lveekhout.jira.representatie.epic.EpicMapObject;
import nl.lveekhout.jira.representatie.epic.Value;
import nl.lveekhout.jira.representatie.issue.IssueObject;
import nl.lveekhout.jira.rest.JerseyClientConfig;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by eekhout.l on 27-2-2017.
 * class EpicMap
 */
public class EpicMap {
    private String username;
    private String password;

    public EpicMap(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Map<String, String> zoekEpic(long scrumboardId) {
        Map<String, String> result = new HashMap<>();
        byte[] pwd = DatatypeConverter.parseBase64Binary(password);
        HTTPBasicAuthFilter basicAuth = new HTTPBasicAuthFilter(username, new String(pwd));

        Client client = Client.create(JerseyClientConfig.getClientConfig());
        client.addFilter(basicAuth);
        ClientResponse clientResponse = client
                .resource(String.format("https://jira.intra.tkppensioen.nl/rest/agile/latest/board/%s/epic", scrumboardId))
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            EpicMapObject epics = clientResponse.getEntity(EpicMapObject.class);
            for (Value v : epics.values) {
                result.put(v.key, v.color.key);
            }
            return result;
        } else {
            throw new RuntimeException("Ongeldige status: " + clientResponse.getStatus());
        }
    }
}
