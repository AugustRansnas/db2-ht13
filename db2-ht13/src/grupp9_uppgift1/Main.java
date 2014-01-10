
package grupp9_uppgift1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    

    /**
     * Starts the View, Controller; databasAcessLayer and connects them with each other
     * 
     * @param args arguments to the program
     * @throws SQLException error that may be caused if drive didn't load
     */
    public static void main(String[] args) throws SQLException {

        try {
            
            DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());

        } catch (SQLException e) {

            System.out.println("Couldn't load driver: " + e);

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
        mainView.setResizable(false);
        
    }

}
