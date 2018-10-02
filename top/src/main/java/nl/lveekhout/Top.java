package nl.lveekhout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Top {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@pps-oradbs01.dev.tkp:1521/ppsdev", "pas", "pas")) {
            List<Long> base = haal_sids(connection);
            while (true) {
                Thread.sleep(500);
                List<Long> curr = haal_sids(connection);
                vergelijk(connection, base, curr);
                base = curr;
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }

    public static String zoek_program(Connection connection, long sid) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery("select program from v$session where sid="+sid)) {
                if (rs.next()) return rs.getString(1);
            }
        }
        return null;
    }

    public static List<Long> haal_sids(Connection connection) throws SQLException {
        List<Long> sids = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery("select sid from v$session where status = 'ACTIVE' order by sid")) {
                while (rs.next()) {
                    sids.add(rs.getLong(1));
                }
            }
        }
        return sids;
    }

    public static void vergelijk(Connection connection, List<Long> l1, List<Long> l2) throws SQLException {
        List<Long> deleted = new ArrayList<>(l1); deleted.removeAll(l2);
        List<Long> added   = new ArrayList<>(l2);   added.removeAll(l1);

        for (Long l : deleted) System.out.println("[" + new SimpleDateFormat("hh:mm:ss").format(new Date()) + "] deleted: " + l + " - " + zoek_program(connection, l));
        for (Long l : added) System.out.println("[" + new SimpleDateFormat("hh:mm:ss").format(new Date()) + "] added: " + l + " - " + zoek_program(connection, l));
    }
}
