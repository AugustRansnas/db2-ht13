/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class DataAccessLayer {

    Connection connection;

    DataAccessLayer(Connection connection) {
        this.connection = connection;
    }

    void registerNewStudent(String[] studentData) throws SQLException {
        String sqlString = "INSERT INTO Student VALUES (" + "'" + studentData[0] + "'";
        for (int i = 1; i < studentData.length; i++) {
            sqlString += ",'" + studentData[i] + "'";
            System.out.println(sqlString);
        }
        sqlString += ")";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sqlString);
        connection.commit();
        connection.close();
    }

    void updateStudent(String[] studentData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteStudent(String personNbr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void registerNewCourse(String[] courseData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void updateCourse(String[] courseData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteCourse(String courseCode) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    protected DefaultTableModel getAllCourses() throws SQLException{
        
        String sqlString = "SELECT * FROM Course";
        
        Statement stmt = connection.createStatement();
  
        ResultSet rs = stmt.executeQuery(sqlString);
        
        DefaultTableModel dtm = this.getResultSetAsDefaultTableModel(rs);
                
        return dtm;
        
    }

    private DefaultTableModel getResultSetAsDefaultTableModel(ResultSet rs) {

        try {

            Vector columnNames = new Vector();

            Vector data = new Vector();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                
                String columnName = md.getColumnName(i);

                columnNames.addElement(columnName);
                
                System.out.println("Adding column name: " + columnName);

            }

            while (rs.next()) {
                
                Vector row = new Vector(columnCount);

                for (int i = 1; i <= columnCount; i++) {

                    row.addElement(rs.getObject(i));

                }

                data.addElement(row);
            }

            DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
            
            return dtm;

        } catch (SQLException ex) {
            
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
        



    }
}
