package nl.lveekhout.jira.representatie.sprintreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 01-12-2015.
 * class SprintReport
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SprintReportObject {
    public Content contents;
}
