package nl.lveekhout.jira.representatie.rapidviewslist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by eekhout.l on 02-12-2015.
 * class RapidviewsListObject
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RapidviewsListObject {
    public List<View> views;
}
