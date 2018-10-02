package nl.lveekhout.jira.representatie.sprintreport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by eekhout.l on 03-12-2015.
 * class Statistic
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic {
    public Value statFieldValue;
}
