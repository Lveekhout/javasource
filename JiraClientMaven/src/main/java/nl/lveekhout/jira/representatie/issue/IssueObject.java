package nl.lveekhout.jira.representatie.issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 03-12-2015.
 * class IssueObject
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueObject {
    public Field fields;
}
