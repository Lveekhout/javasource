package nl.lveekhout.jira.representatie.sprintreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 01-12-2015.
 * class Issue
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    public String key;
    public String summary;
    public String color;
    public String epic;
    public Statistic estimateStatistic;
}
