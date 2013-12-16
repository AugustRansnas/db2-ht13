/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
/**/

/**
 *
 * @author Viktor Voigt
 * @author Jonas Ahrne
 * @author Joel Pennegård
 * @author August Ransnäs
 *
 */

public class Main {

    public static void main(String[] args) throws SQLException {

        try {

            DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());

        } catch (SQLException e) {

            System.out.println("Cant find driver class: " + e);

        }

        Properties prop = new Properties();

        prop.put("charSet", "iso-8859-1");

        Connection connection = DriverManager.getConnection("JDBC:ODBC:grupp9;database=studentsystem;", prop);

        DatabaseMetaData dbmd = connection.getMetaData();

        System.out.println("Connected to: " + dbmd.getDatabaseProductName());

        DataAccessLayer dataAccessLayer = new DataAccessLayer(connection);

        Controller controller = new Controller(dataAccessLayer);
     
        View mainView = new View(controller);

        mainView.setVisible(true);
        
        System.out.println(controller.getStudentsRegisteredPointsTotal("8888888888"));
        System.out.println(controller.getStudentsRegisteredPointsTotal("8903109174"));
     
        


    }

}
