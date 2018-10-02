package nl.lveekhout.jira.representatie.rapidviewslist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 02-12-2015.
 * class View
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class View {
    public long id;
    public String name;
}
