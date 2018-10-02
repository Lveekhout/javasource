package nl.tkp.pas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Finscan {
    public static void main(String[] args) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("Oracle JDBC Driver Registered!");
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@rapgenp-oradbs01.prd.tkp:1521/rapgenp12", "snijderw", "pensioen")) {
            System.out.println("You made it, take control your database now!");
            try (Statement statement = connection.createStatement()) {
                try (ResultSet rs = statement.executeQuery("select * from kooip.mv_psn_npn2 order by psn_id")) {
                    System.out.println("Begin: " + new Date());
                    List<NatuurlijkPersoon> list = new ArrayList<>();
                    while (rs.next()) {
                        list.add(new NatuurlijkPersoon(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8),
                                rs.getString(9),
                                rs.getString(10),
                                rs.getString(11),
                                rs.getString(12)
                        ));
                    }
                    System.out.println("aantal: " + list.size());
                    System.out.println("Einde: " + new Date());
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
}
