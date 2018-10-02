package nl.lveekhout.jira.rest.sprintquery;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import nl.lveekhout.jira.representatie.sprintquery.Sprint;
import nl.lveekhout.jira.representatie.sprintquery.SprintQueryObject;
import nl.lveekhout.jira.rest.JerseyClientConfig;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eekhout.l on 02-12-2015.
 * class RapidviewsList
 */
public class SprintQuery {

    private String username;
    private String password;

    public SprintQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SprintQueryObject call(long scrumbordId) {
        byte[] pwd = DatatypeConverter.parseBase64Binary(password);
        HTTPBasicAuthFilter basicAuth = new HTTPBasicAuthFilter(username, new String(pwd));

        Client client = Client.create(JerseyClientConfig.getClientConfig());
        client.addFilter(basicAuth);
        ClientResponse clientResponse = client
                .resource("https://jira.intra.tkppensioen.nl/rest/greenhopper/latest/sprintquery/" + scrumbordId + "?includeHistoricSprints=true&includeFutureSprints=true")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            return clientResponse.getEntity(SprintQueryObject.class);
        } else {
            throw new RuntimeException("Ongeldige status: " + clientResponse.getStatus());
        }
    }

    public Long[] zoekSprintId(long scrumbordId, String naam) {
        List<Long> sprints = new ArrayList<>();
        SprintQueryObject sprintQueryObject = call(scrumbordId);
        for (Sprint sprint : sprintQueryObject.sprints) {
            if (sprint.name.matches(naam)) sprints.add(sprint.id);
        }
        return sprints.toArray(new Long[sprints.size()]);
    }
}
