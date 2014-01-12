
package grupp9_uppgift2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class initializes connection to database, DataAcessLayer, Controller and
 * Viewer.
 *
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */
public class Main {

    /**
     * This class initializes connection to database, DataAcessLayer, Controller
     * and Viewer.
     *
     * @param args arguments from system
     * @throws java.sql.SQLException May throw SQL exception if driver fails to load
     */
    public static void main(String[] args) throws SQLException {

        try {

            DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());

        } catch (SQLException e) {

            System.out.println("Cant find driver class: " + e);

        }

        Properties prop = new Properties();

        prop.put("charSet", "iso-8859-1");

        Connection connection = DriverManager.getConnection("JDBC:ODBC:grupp9;database=Demo Database NAV (5-0);", prop);

        DatabaseMetaData dbmd = connection.getMetaData();

        System.out.println("Connected to: " + dbmd.getDatabaseProductName());

        DataAccessLayer dataAccessLayer = new DataAccessLayer(connection);

        Controller controller = new Controller(dataAccessLayer);

        MainView mainView = new MainView(controller);
        
        mainView.setLocationRelativeTo(null); //Centers view

        mainView.setVisible(true); // Makes the Main View show up

    }

}
