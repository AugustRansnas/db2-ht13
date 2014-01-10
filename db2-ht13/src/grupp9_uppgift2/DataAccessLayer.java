
package grupp9_uppgift2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Handles communication with database
 * 
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */
public class DataAccessLayer {

    private Connection connection;

    /**
     * Initializes class with proper connection.
     * 
     * @param connection connection to database
     */
    protected DataAccessLayer(Connection connection) {
        
        this.connection = connection;
        
    }
    /**
     * This method takes an SQL query string and returns a resultset.
     * 
     * @param the SQL query 
     * @return the resultset of the query
     */
    private ResultSet excecuteQuery(String sqlString) {

        System.out.println("executeQuery(" + sqlString + ")");

        ResultSet rs = null;

        try {
            Statement stmt = connection.createStatement();

            rs = stmt.executeQuery(sqlString);
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;

    }
    /**
     * This method takes an resultset and returns it as a tableModel.
     * 
     * @param a resultset 
     * @return a tableModel of the resultset
     */
    private TableModel getResultSetAsDefaultTableModel(ResultSet rs) {

        try {

            String[] columnHeadings = new String[0];
            String[][] dataArray = new String[0][0];

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = md.getColumnName(i);
                columnHeadings = Arrays.copyOf(columnHeadings, columnHeadings.length + 1);
                columnHeadings[i - 1] = columnName;
            }

            int r = 0;

            while (rs.next()) {

                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getString(i);
                }

                dataArray = Arrays.copyOf(dataArray, dataArray.length + 1);
                dataArray[r] = row;

                r++;
            }

            DefaultTableModel tm = new DefaultTableModel(dataArray, columnHeadings) {
                
                @Override
                public boolean isCellEditable(int row, int column) {

                    return false;
                }
            };

            return tm;

        } catch (SQLException ex) {

            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    
//Innehållet i tabellen CRONUS Sverige AB$Employee samt relaterade tabeller
    protected TableModel getCronusEmployees() {

        String sqlString = "SELECT table_name AS Tabellnamn FROM INFORMATION_SCHEMA.TABLES WHERE table_name LIKE '%AB$Employee%' ";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
//Metadata för CRONUS Sverige AB$Employee och relaterade tabeller.
    /**
     * Gets partial meta data for the Cronus employee table.
     * 
     * @return partial meta data 
     */
    protected TableModel getCronusEmployeeMetaData() {

        String sqlString = "select TABLE_SCHEMA AS 'schema', COLUMN_NAME AS 'kolumn namn', "
                + "ORDINAL_POSITION AS 'position', DATA_TYPE AS 'data typ', "
                + "CHARACTER_MAXIMUM_LENGTH AS 'max length', CHARACTER_SET_NAME AS 'Set name', "
                + "COLLATION_NAME AS 'kollationsnamn' from INFORMATION_SCHEMA.COLUMNS where TABLE_NAME "
                + "= 'CRONUS Sverige AB$Employee'";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets the columns of the Cronus employee table.
     * 
     * @return the column names
     */
    protected TableModel getCronusEmployeeColumns1() {

        String sqlString = "SELECT name AS 'Samtliga kolumner' \n"
                + "FROM sys.columns \n"
                + "WHERE OBJECT_ID = OBJECT_ID('dbo.[CRONUS Sverige AB$Employee]')\n"
                + "ORDER BY name";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }
    /**
     * Gets the columns of the Cronus employee table.
     * 
     * @return the column names
     */
    protected TableModel getCronusEmployeeColumns2() {

        String sqlString = "SELECT COLUMN_NAME AS 'Samtliga kolumner' \n"
                + "FROM INFORMATION_SCHEMA.COLUMNS \n"
                + "WHERE TABLE_NAME = 'CRONUS Sverige AB$Employee' \n"
                + "ORDER BY COLUMN_NAME";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets a system information table containing table names and their Keys from the Cronus database.
     * 
     * @return Keys from the Cronus database.
     */
    protected TableModel getCronusKeys() {
        String sqlString = "SELECT name AS Namn, type_desc AS 'Typ beskrivning' FROM sys.foreign_keys\n"
                + "UNION\n"
                + "SELECT name, type_desc FROM sys.key_constraints";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets a system information table containing indexes from the Cronus database
     * 
     * @return indexes from the Cronus database
     */
    protected TableModel getCronusIndexes() {
        String sqlString = "SELECT name AS Namn FROM sys.indexes";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets a system information table containing the table constraints from the Cronus database
     * 
     * @return table constraints from the Cronus database.
     */
    protected TableModel getCronusConstraints() {
        String sqlString = "SELECT name AS 'Namn på constraint',\n"
                + "type_desc AS ConstraintType\n"
                + "FROM sys.objects\n"
                + "WHERE type_desc LIKE '%CONSTRAINT'";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets a system information table containing the names of the tables in the Cronus database.
     * 
     * @return the names of the tables in the Cronus database
     */
    protected TableModel getCronusTables1() {
        String sqlString = "SELECT name AS Tabellnamn FROM sys.tables";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets a system information table containing the names of the tables in the Cronus database.
     * 
     * @return the names of the tables in the Cronus database
     */
    protected TableModel getCronusTables2() {
        String sqlString = "SELECT TABLE_NAME AS Tabellnamn FROM INFORMATION_SCHEMA.TABLES";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Gets the name and number of rows of the table with the most rows in the Cronus database.
     * 
     * @return the name of the table with most rows in the database
     */
    protected TableModel getCronusTableWithMostRows() {
        String sqlString = "SELECT TOP (1) so.name AS Namn, MAX(si.rows) AS 'Antal rader'\n"
                + "FROM sysobjects so, sysindexes si \n"
                + "WHERE so.xtype = 'U' AND si.id = OBJECT_ID(so.name) \n"
                + "GROUP BY so.name \n"
                + "ORDER BY 2 DESC";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
    }

}
