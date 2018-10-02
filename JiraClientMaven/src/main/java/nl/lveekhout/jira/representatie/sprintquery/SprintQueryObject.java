package nl.lveekhout.jira.representatie.sprintquery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by eekhout.l on 02-12-2015.
 * class SprintQueryObject
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SprintQueryObject {
    public List<Sprint> sprints;
}
