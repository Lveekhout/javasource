package nl.lveekhout.jira.representatie.issue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 03-12-2015.
 * class Field
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Field {
    public String summary;
}
