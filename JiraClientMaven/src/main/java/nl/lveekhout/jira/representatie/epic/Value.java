package nl.lveekhout.jira.representatie.epic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 27-2-2017.
 * class Value
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    public String key;
    public Color color;
}
