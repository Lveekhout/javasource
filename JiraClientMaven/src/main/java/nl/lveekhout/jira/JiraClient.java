package nl.lveekhout.jira;

import nl.lveekhout.jira.representatie.sprintreport.Issue;
import nl.lveekhout.jira.rest.epic.EpicMap;
import nl.lveekhout.jira.rest.rapidviewslist.RapidviewsList;
import nl.lveekhout.jira.rest.sprintquery.SprintQuery;
import nl.lveekhout.jira.rest.sprintreport.SprintReport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eekhout.l on 01-12-2015.
 * class Jira
 * https://docs.atlassian.com/jira/REST/7.0.10/
 */
public class JiraClient {

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.printf("usage: jira-client.jar <username> <password> <scrumbord> <sprintnaam>");
            return;
        }

        String scrumbordNaam = args[2];
        Long scrumbordId = new RapidviewsList(args[0], args[1]).zoekScrumbordId(scrumbordNaam);
        if (scrumbordId == null) {
            throw new RuntimeException(String.format("Scrumbord niet gevonden: [%s]", scrumbordNaam));
        } else {
            System.out.printf("Gevonden scrumbordId: [%s]\r\n", scrumbordId);
        }

        Map<String, String> colors = new HashMap<>();
        vulColors(colors);

        Map<String, String> epics = new EpicMap(args[0], args[1]).zoekEpic(scrumbordId);
//        if (epics!=null) {
//            for (String epic : epics.keySet()) {
//                System.out.printf("Epic: %-12s %-12s %s\r\n", epic, epics.get(epic), colors.get(epics.get(epic)));
//            }
//        }

        String sprintNaam = args[3];
        Long[] sprintIds = new SprintQuery(args[0], args[1]).zoekSprintId(scrumbordId, sprintNaam);
        if (sprintIds.length == 0) {
            throw new RuntimeException(String.format("Sprint niet gevonden: [%s]", sprintNaam));
        } else {
            for (Long id : sprintIds) System.out.printf("Gevonden sprintIds: [%s]\r\n", id);
        }

        StringBuilder htmlStories = new StringBuilder();
        Map<String, List<Issue>> map = new SprintReport(args[0], args[1]).zoekStories(scrumbordId, sprintIds);
        for (String s : map.keySet()) {
            System.out.printf("\r\n[%s] %s\r\n", s, new nl.lveekhout.jira.rest.issue.Issue(args[0], args[1]).zoekIssueSummary(s));
            for (Issue issue : map.get(s)) {
                String storypoints = "&nbsp;";
                if (issue.estimateStatistic!=null&&issue.estimateStatistic.statFieldValue.value!=null) {
                    String[] decimal = issue.estimateStatistic.statFieldValue.value.split("\\.");
                    if (decimal.length==2) {
                        storypoints = "";
                        if (Long.parseLong(decimal[0])>0) storypoints = decimal[0];
                        if (decimal[1].equals("5")) storypoints += "&frac12;";
                    } else throw new RuntimeException(String.format("Verkeerder waarde storypoints: [%s]", issue.estimateStatistic.statFieldValue.value));
                }

                if (colors.get(epics.get(issue.epic))==null) htmlStories.append("<div class=\"userstory\">");
                else htmlStories.append(String.format("<div class=\"userstory\" style=\"background-color: %s;\">", colors.get(epics.get(issue.epic))));

                htmlStories.append(String.format("<span class=\"storypoints\">%s</span>", storypoints));
                htmlStories.append(String.format("<span class=\"storynummer\">%s</span>", issue.key));
                htmlStories.append(String.format("<span class=\"omschrijving\">%s</span>", issue.summary));
                htmlStories.append("</div>");
                System.out.printf("\t[%s][%s] %s\r\n", storypoints, issue.key, issue.summary);
            }
        }

        createFile(args[3].replace("*", "_") + ".html", htmlStories.toString());
    }

    private static void createFile(String filename, String stories) throws IOException {
        OutputStream stream = new FileOutputStream(".\\" + filename.replace("/", "_"), false);
        stream.write(String.format("<!DOCTYPE html><html><head><title>%s</title><style>body {margin: 0;border: 0;padding: 0;-webkit-print-color-adjust: exact;}div.userstory {float: left;margin-right: 1cm;margin-bottom: 0.4cm;background-color: #ffc;width: 12.5cm;height: 5.0cm;overflow: hidden;border: solid black 1px;}div.userstory span.storypoints {padding-left: 0.3cm;display: inline-block;text-align: left;font-size: 36pt;width: 1.7cm;color: blue;}div.userstory span.storynummer {display: inline-block;text-align: center;font-size: 36pt;font-weight: bold;color: black;}div.userstory span.omschrijving {padding: 0.1cm 0.3cm 0 0.3cm;display: inline-block;text-align: left;font-size: 21pt;color: forestgreen;}</style></head><body>", filename).getBytes());
        stream.write(stories.getBytes());
        stream.write("</body></html>".getBytes());
        stream.close();
    }

    private static void vulColors(Map<String, String> colors) {
//        https://answers.atlassian.com/questions/281921/what-values-are-used-to-query-epic-color
        colors.put("color_1", "Bisque");
        colors.put("color_2", "Aquamarine");
        colors.put("color_3", "GreenYellow");
        colors.put("color_4", "Khaki");
        colors.put("color_5", "LightBlue");
        colors.put("color_6", "LightPink");
        colors.put("color_7", "LightSteelBlue");
        colors.put("color_8", "MediumTurquoise");
        colors.put("color_9", "Tomato");    }
}
