/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_labb1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        try {
            DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // också ok
        } catch (SQLException e) {
            System.out.println("Kan inte hitta database driver class: " + e);
        }

        Connection con = DriverManager.getConnection("JDBC:ODBC:grupp9;database=patientsystem;");
        
        DatabaseMetaData md = con.getMetaData();
        
        System.out.println(md.getDatabaseProductName());
        
        Controller controller = new Controller(con);
        
        GUI myGUI = new GUI(controller);
        
        myGUI.setVisible(true);



    }
}
