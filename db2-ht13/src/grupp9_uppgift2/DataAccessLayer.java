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

    protected DataAccessLayer(Connection connection) {
        this.connection = connection;
    }

    private ResultSet excecuteQuery(String sqlString) {

        System.out.println("executeQuery(" + sqlString + ")");

        ResultSet rst = null;

        try {
            Statement stmt = connection.createStatement();

            rst = stmt.executeQuery(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;

    }

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

    }

    protected TableModel getCronusEmployees() {

        String sqlString = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_name LIKE '%AB$Employee%' ";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

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

    protected TableModel getCronusEmployeeColumns() {

        String sqlString = "SELECT name AS 'Samtliga kolumner' \n"
                + "FROM sys.columns \n"
                + "WHERE OBJECT_ID = OBJECT_ID('dbo.[CRONUS Sverige AB$Employee]')\n"
                + "ORDER BY name";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getCronusKeys() {
        String sqlString = "SELECT name, type_desc FROM sys.foreign_keys\n"
                + "UNION\n"
                + "SELECT name, type_desc FROM sys.key_constraints";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getCronusIndexes() {
        String sqlString = "SELECT * FROM sys.indexes";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getCronusConstraints() {
        String sqlString = "SELECT name AS NameOfConstraint,\n"
                + "type_desc AS ConstraintType\n"
                + "FROM sys.objects\n"
                + "WHERE type_desc LIKE '%CONSTRAINT'";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getCronusTables() {
        String sqlString = "SELECT * FROM sys.tables";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getAllKeys() {
        String sqlString = "SELECT name FROM sys.foreign_keys\n"
                + "UNION\n"
                + "SELECT name FROM sys.key_constraints";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }

    protected TableModel getCronusTableWithMostRows() {
        String sqlString = "SELECT TOP (1) so.name, MAX(si.rows) \n"
                + "FROM sysobjects so, sysindexes si \n"
                + "WHERE so.xtype = 'U' AND si.id = OBJECT_ID(so.name) \n"
                + "GROUP BY so.name \n"
                + "ORDER BY 2 DESC";
        ResultSet rs = this.excecuteQuery(sqlString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;
    }

}
