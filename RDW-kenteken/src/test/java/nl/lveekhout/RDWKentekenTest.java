package nl.lveekhout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RDWKentekenTest {
    @Test
    public void test() throws ParseException {
        Document doc = Jsoup.parse("\t\t\t<table id=\"gridTable\" class=\"retour-pricegrid\" data-tui-direction=\"retour\">\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"flight-to\">\n" +
                "\t\t\t\t\t\t\t\t<span class=\"date-left\"><span class=\"flight\">Heenvlucht</span><br />vrijdag<br />03 jan 2020</span>\n" +
                "\t\t\t\t\t\t\t\t<span class=\"date-left\"><span class=\"flight\">Heenvlucht</span><br />zaterdag<br />04 jan 2020</span>\n" +
                "\t\t\t\t\t\t\t\t<span class=\"date-left\"><span class=\"flight\">Heenvlucht</span><br />zondag<br />05 jan 2020</span>\n" +
                "\t\t\t\t\t\t\t\t<span class=\"date-left\"><span class=\"flight\">Heenvlucht</span><br />maandag<br />06 jan 2020</span>\n" +
                "\t\t\t\t\t\t\t\t<span class=\"date-left\"><span class=\"flight\">Heenvlucht</span><br />dinsdag<br />07 jan 2020</span>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t<table id=\"gridTablePrices\">\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;vr 03-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;za 25-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136064000000000$637155072000000000$24$dagen$001$Economy$001$Economy$OR  367$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;vr 03-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;zo 26-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136064000000000$637155936000000000$25$dagen$001$Economy$001$Economy$OR  367$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;vr 03-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;ma 27-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136064000000000$637156800000000000$26$dagen$001$Economy$001$Economy$OR  367$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;vr 03-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;di 28-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136064000000000$637157664000000000$27$dagen$001$Economy$001$Economy$OR  367$OR  366\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;vr 03-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;wo 29-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136064000000000$637158528000000000$28$dagen$001$Economy$001$Economy$OR  367$OR  362\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;za 04-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;za 25-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136928000000000$637155072000000000$23$dagen$001$Economy$001$Economy$OR  357$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;za 04-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;zo 26-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136928000000000$637155936000000000$24$dagen$001$Economy$001$Economy$OR  357$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;za 04-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;ma 27-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136928000000000$637156800000000000$25$dagen$001$Economy$001$Economy$OR  357$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;za 04-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;di 28-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136928000000000$637157664000000000$26$dagen$001$Economy$001$Economy$OR  357$OR  366\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;za 04-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;wo 29-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637136928000000000$637158528000000000$27$dagen$001$Economy$001$Economy$OR  357$OR  362\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;zo 05-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;za 25-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637137792000000000$637155072000000000$22$dagen$001$Economy$001$Economy$OR  363$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;zo 05-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;zo 26-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637137792000000000$637155936000000000$23$dagen$001$Economy$001$Economy$OR  363$OR  364\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back selected\" data-tui-to=\"Economy;zo 05-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;ma 27-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637137792000000000$637156800000000000$24$dagen$001$Economy$001$Economy$OR  363$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\" checked=&quot;checked&quot; /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;zo 05-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;di 28-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637137792000000000$637157664000000000$25$dagen$001$Economy$001$Economy$OR  363$OR  366\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;zo 05-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;wo 29-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637137792000000000$637158528000000000$26$dagen$001$Economy$001$Economy$OR  363$OR  362\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;ma 06-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;za 25-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637138656000000000$637155072000000000$21$dagen$001$Economy$001$Economy$OR  369$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;ma 06-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;zo 26-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637138656000000000$637155936000000000$22$dagen$001$Economy$001$Economy$OR  369$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;ma 06-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;ma 27-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637138656000000000$637156800000000000$23$dagen$001$Economy$001$Economy$OR  369$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;ma 06-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;di 28-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637138656000000000$637157664000000000$24$dagen$001$Economy$001$Economy$OR  369$OR  366\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;ma 06-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;wo 29-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637138656000000000$637158528000000000$25$dagen$001$Economy$001$Economy$OR  369$OR  362\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;di 07-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;za 25-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637139520000000000$637155072000000000$20$dagen$001$Economy$001$Economy$OR  365$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;di 07-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;zo 26-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637139520000000000$637155936000000000$21$dagen$001$Economy$001$Economy$OR  365$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;di 07-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;ma 27-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637139520000000000$637156800000000000$22$dagen$001$Economy$001$Economy$OR  365$OR  370\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;di 07-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;di 28-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637139520000000000$637157664000000000$23$dagen$001$Economy$001$Economy$OR  365$OR  366\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose-back\" data-tui-to=\"Economy;di 07-01-2020;TimeUnknown;TimeUnknown;;\" data-tui-from=\"Economy;wo 29-01-2020;TimeUnknown;TimeUnknown;;receipt-timenextday\" data-tui-pricegrid-id=\"SO00X2CUR8542483$10836$637139520000000000$637158528000000000$24$dagen$001$Economy$001$Economy$OR  365$OR  362\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"choose\"><input type=\"radio\" name=\"pricegridTrip\"  /></span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label>€ 499</label>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n");
        Element e = doc.getElementById("gridTable");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        List<Date> date = new ArrayList<>();

        for (Element x : e.getElementsByClass("date-left")) {
            date.add(simpleDateFormat.parse(x.childNodes().get(4).toString()));
        }
        System.out.println(date.toString());
        for (Element tr : e.getElementById("gridTablePrices").getElementsByTag("tr")) {
            for (Element td : tr.getElementsByTag("td")) {
                System.out.println(td.getElementsByTag("span").get(0).attributes().get("data-tui-to").split(";")[1] + " t/m " +
                        td.getElementsByTag("span").get(0).attributes().get("data-tui-from").split(";")[1] + " = " +
                        td.text()
                );
            }
        }
    }
}