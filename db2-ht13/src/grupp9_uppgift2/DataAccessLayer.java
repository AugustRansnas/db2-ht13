/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author Joel
 */
public class DataAccessLayer {
    Connection connection;
    
    protected DataAccessLayer(Connection connection){
        this.connection = connection;
    }
    private ResultSet excecuteQuery(String sqlString){
        System.out.println("executeQuery(" + sqlString + ")");

        ResultSet rst = null;

        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stmt.executeQuery(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
        
    }
    
    /*private String[][] getResultSetAsString(ResultSet rs){
        try {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            rs.last();
            int rowCount = rs.getRow();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } */
    private String stringTranslator(String stringIn) {

        String stringOut;

        if (stringIn.equals("ccode")) {

            stringOut = "Kurskod";

        } else if (stringIn.equals("cname")) {

            stringOut = "Kursnamn";

        } else if (stringIn.equals("points")) {

            stringOut = "Högskolepoäng";

        } else if (stringIn.equals("pnr")) {

            stringOut = "Personnummer";

        } else if (stringIn.equals("firstname")) {

            stringOut = "Förnamn";

        } else if (stringIn.equals("lastname")) {

            stringOut = "Efternamn";

        } else if (stringIn.equals("phonenr")) {

            stringOut = "Telefonnummer";

        } else if (stringIn.equals("email")) {

            stringOut = "E-post";

        } else if (stringIn.equals("adress")) {

            stringOut = "Adress";

        } else if (stringIn.equals("postcode")) {

            stringOut = "Postnummer";

        } else if (stringIn.equals("city")) {

            stringOut = "Ort";

        } else if (stringIn.equals("grade")) {

            stringOut = "Betyg";

        } else {

            stringOut = stringIn;

        }

        return stringOut;
    }
    private TableModel getResultSetAsDefaultTableModel(ResultSet rs) {

        try {

            String[] columnHeadings = new String[0];
            Object[][] dataArray = new Object[0][0];

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = md.getColumnName(i);
                columnName = stringTranslator(columnName);
                columnHeadings = Arrays.copyOf(columnHeadings, columnHeadings.length + 1);
                columnHeadings[i - 1] = columnName;
            }

            int r = 0;

            while (rs.next()) {

                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }

                dataArray = Arrays.copyOf(dataArray, dataArray.length + 1);
                dataArray[r] = row;

                r++;
            }

            DefaultTableModel dtm = new DefaultTableModel(dataArray, columnHeadings) {
                public boolean isCellEditable(int row, int column) {

                    return false;
                }
            };

            return dtm;

        } catch (SQLException ex) {

            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }protected TableModel getCronusEmployees(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusEmployeeMetaData(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusEmployeeColumns(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusKeys(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusIndexes(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusConstraints(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }protected TableModel getCronusTables(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }
    protected TableModel getAllKeys(){
        String sqlString = "";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
        
    }
}
