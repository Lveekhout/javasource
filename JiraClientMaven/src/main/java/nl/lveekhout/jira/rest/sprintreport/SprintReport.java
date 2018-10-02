package nl.lveekhout.jira.rest.sprintreport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import nl.lveekhout.jira.representatie.sprintreport.Issue;
import nl.lveekhout.jira.representatie.sprintreport.SprintReportObject;
import nl.lveekhout.jira.rest.JerseyClientConfig;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eekhout.l on 02-12-2015.
 * class SprintReport
 */
public class SprintReport {

    private String username;
    private String password;

    public SprintReport(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SprintReportObject call(long scrumbordId, long sprintId) {
        byte[] pwd = DatatypeConverter.parseBase64Binary(password);
        HTTPBasicAuthFilter basicAuth = new HTTPBasicAuthFilter(username, new String(pwd));

        Client client = Client.create(JerseyClientConfig.getClientConfig());
        client.addFilter(basicAuth);
        ClientResponse clientResponse = client
                .resource("https://jira.intra.tkppensioen.nl/rest/greenhopper/latest/rapid/charts/sprintreport?rapidViewId=" + scrumbordId + "&sprintId=" + sprintId)
                .accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
        if (clientResponse.getStatus() == 200) {
            return clientResponse.getEntity(SprintReportObject.class);
        } else {
            throw new RuntimeException("Ongeldige status: " + clientResponse.getStatus());
        }
    }

    public Map<String, List<Issue>> zoekStories(long scrumbordId, Long[] sprintIds) {
        Map<String, List<Issue>> map = new HashMap<>();

        for (long sprintId : sprintIds) {

            SprintReportObject sprintReport = call(scrumbordId, sprintId);

            if (sprintReport.contents != null && sprintReport.contents.completedIssues != null) {
                for (Issue issue : sprintReport.contents.completedIssues) {
                    if (!map.containsKey(issue.epic)) {
                        map.put(issue.epic, new ArrayList<Issue>());
                    }
                    map.get(issue.epic).add(issue);
                }
            }

            if (sprintReport.contents != null && sprintReport.contents.issuesNotCompletedInCurrentSprint != null) {
                for (Issue issue : sprintReport.contents.issuesNotCompletedInCurrentSprint) {
                    if (!map.containsKey(issue.epic)) {
                        map.put(issue.epic, new ArrayList<Issue>());
                    }
                    map.get(issue.epic).add(issue);
                }
            }

            if (sprintReport.contents != null && sprintReport.contents.puntedIssues != null) {
                for (Issue issue : sprintReport.contents.puntedIssues) {
                    if (!map.containsKey(issue.epic)) {
                        map.put(issue.epic, new ArrayList<Issue>());
                    }
                    map.get(issue.epic).add(issue);
                }
            }

            if (sprintReport.contents != null && sprintReport.contents.issuesCompletedInAnotherSprint != null) {
                for (Issue issue : sprintReport.contents.issuesCompletedInAnotherSprint) {
                    if (!map.containsKey(issue.epic)) {
                        map.put(issue.epic, new ArrayList<Issue>());
                    }
                    map.get(issue.epic).add(issue);
                }
            }
        }

        return map;
    }
}
