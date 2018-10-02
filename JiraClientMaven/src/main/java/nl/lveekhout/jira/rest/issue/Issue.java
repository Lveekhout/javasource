package nl.lveekhout.jira.rest.issue;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import nl.lveekhout.jira.representatie.issue.IssueObject;
import nl.lveekhout.jira.rest.JerseyClientConfig;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by eekhout.l on 02-12-2015.
 * class Issue
 */
public class Issue {

    private String username;
    private String password;

    public Issue(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public IssueObject call(String issue) {
        byte[] pwd = DatatypeConverter.parseBase64Binary(password);
        HTTPBasicAuthFilter basicAuth = new HTTPBasicAuthFilter(username, new String(pwd));

        Client client = Client.create(JerseyClientConfig.getClientConfig());
        client.addFilter(basicAuth);
        ClientResponse clientResponse = client
                .resource("https://jira.intra.tkppensioen.nl/rest/api/latest/issue/" + issue)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            return clientResponse.getEntity(IssueObject.class);
        } else {
            throw new RuntimeException("Ongeldige status: " + clientResponse.getStatus());
        }
    }

    public String zoekIssueSummary(String key) {
        com.atlassian.jira.rest.client.api.domain.Issue issue;
        if (key!=null&&key.length()>0) {
            IssueObject object = call(key);
            return object.fields.summary;
        } else {
            return null;
        }
    }
}
