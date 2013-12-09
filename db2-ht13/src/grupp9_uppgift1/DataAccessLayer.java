/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package grupp9_uppgift1;
import java.sql.*;
/**
 *
 * @author Joel
 */
public class DataAccessLayer {
    
    Connection connection;
    String sqlString = "";
    
    DataAccessLayer(Connection connection){
        this.connection = connection;
    }
    
    private void executeUpdate(String sqlString) throws SQLException{
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sqlString);
        connection.close();    
    }
    
    private ResultSet executeQuery(String sqlString) throws SQLException{
        Statement stmt = connection.createStatement();
        ResultSet rst = stmt.executeQuery(sqlString);
        connection.close();
        return rst;
    }

    void registerNewStudent(String[] studentData) throws SQLException{
        sqlString = "INSERT INTO Student VALUES (" + "'" + studentData[0] + "'";
        for(int i=1;i<studentData.length;i++){
            sqlString += ",'" + studentData[i] +"'";
            System.out.println(sqlString);
        }
        sqlString += ")";
        executeUpdate(sqlString);
    }

    void updateStudent(String[] studentData) throws SQLException {
        String sqlString = "UPDATE student SET";
        sqlString += "pnr =" + studentData[0];
        sqlString += "firstname =" + studentData[1];
        sqlString += "lastname =" + studentData[2];
        sqlString += "phonenr =" + studentData[3];
        sqlString += "email =" + studentData[4];
        sqlString += "address =" + studentData[5];
        sqlString += "postcode =" + studentData[6];
        sqlString += "city =" + studentData[7];
        executeUpdate(sqlString);
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
       
}
