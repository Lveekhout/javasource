package nl.lveekhout.jira.representatie.sprintreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 03-12-2015.
 * class Value
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    public String value;
}
