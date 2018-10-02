package nl.lveekhout.jira.rest.rapidviewslist;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import nl.lveekhout.jira.representatie.rapidviewslist.RapidviewsListObject;
import nl.lveekhout.jira.representatie.rapidviewslist.View;
import nl.lveekhout.jira.rest.JerseyClientConfig;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

/**
 * Created by eekhout.l on 02-12-2015.
 * class RapidviewsList
 */
public class RapidviewsList {

    private String username;
    private String password;

    public RapidviewsList(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RapidviewsListObject call() {
        byte[] pwd = DatatypeConverter.parseBase64Binary(password);
        HTTPBasicAuthFilter basicAuth = new HTTPBasicAuthFilter(username, new String(pwd));

        Client client = Client.create(JerseyClientConfig.getClientConfig());
        client.addFilter(basicAuth);
        ClientResponse clientResponse = client
                .resource("https://jira.intra.tkppensioen.nl/rest/greenhopper/latest/rapidviews/list")
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            return clientResponse.getEntity(RapidviewsListObject.class);
        } else {
            throw new RuntimeException("Ongeldige status: " + clientResponse.getStatus());
        }
    }

    public Long zoekScrumbordId(String naam) throws UnsupportedEncodingException {
        RapidviewsListObject rapidviewsListObject = call();
        for (View view : rapidviewsListObject.views) {
            if (view.name.matches(naam)) return view.id;
        }
        return null;
    }
}
