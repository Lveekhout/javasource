package nl.lveekhout.jira.representatie.sprintreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by eekhout.l on 01-12-2015.
 * class Content
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    public List<Issue> completedIssues;
    public List<Issue> issuesNotCompletedInCurrentSprint;
    public List<Issue> puntedIssues;
    public List<Issue> issuesCompletedInAnotherSprint;
}
