package nl.lveekhout.jira;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Created by eekhout.l on 01-12-2015.
 * class JiraClientTest
 */
@Ignore
public class JiraClientTest {
    private ClientConfig jerseyClientConfig = null;

    protected synchronized ClientConfig getClientConfig() {
        if (jerseyClientConfig == null) {
            jerseyClientConfig = new DefaultClientConfig();
            jerseyClientConfig.getClasses().add(JacksonJsonProvider.class);
        }
        return jerseyClientConfig;
    }


    @Test
    public void clientTest() throws InterruptedException {
        Client client = Client.create(getClientConfig());
        ClientResponse clientResponse = client
                .resource("http://w7vm39:1024")
                .get(ClientResponse.class);
        System.out.println("Status: " + clientResponse.getStatus());
        System.out.println("Entity: " + clientResponse.getEntity(String.class));
        Thread.sleep(5000);
    }

    @Test
    public void jiraClientTest() {
    }
}