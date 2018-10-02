package nl.lveekhout.jira.representatie.epic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by eekhout.l on 27-2-2017.
 * class EpicMapObject
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EpicMapObject {
    public List<Value> values;
}
