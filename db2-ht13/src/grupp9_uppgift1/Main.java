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

        Connection connection = DriverManager.getConnection("JDBC:ODBC:grupp9;database=studentsystem;");
        
        DatabaseMetaData dbmd = connection.getMetaData();
        
        System.out.println("Connected to: " + dbmd.getDatabaseProductName());
        
        DataAccessLayer dataAccessLayer = new DataAccessLayer(connection);
        
        Controller controller = new Controller(dataAccessLayer);

        MainView mainView = new MainView(controller);

        mainView.setVisible(true);
       

    }

}
