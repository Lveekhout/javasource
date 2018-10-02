package nl.lveekhout.jira.representatie.sprintquery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 02-12-2015.
 * class Sprint
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprint {
    public Long id;
    public String name;
}
