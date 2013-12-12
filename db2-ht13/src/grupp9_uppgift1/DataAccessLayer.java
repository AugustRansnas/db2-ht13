/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package grupp9_uppgift1;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public boolean checkIfStudentExists(String pnr) throws SQLException {

        Boolean studentExists;

        String sqlString = "SELECT s.pnr FROM Student s WHERE (s.pnr = '" + pnr + "')";
        ResultSet rset = executeQuery(sqlString);

        studentExists = rset.next();

        if (studentExists) {
            System.out.println("studenten " + pnr + " är redan registrerad i databasen");
        } else {
            System.out.println("Det finns ingen student med följande personnr: " + pnr);
        }

        return studentExists;

    }

    public boolean checkIfCourseExists(String courseCode) throws SQLException {

        Boolean courseExists;

        String sqlString = "SELECT c.ccode FROM Course c WHERE (c.ccode = '" + courseCode + "')";
        ResultSet rset = executeQuery(sqlString);

        courseExists = rset.next();

        if (courseExists) {
            System.out.println("Kursen " + courseCode + " existerar redan");
        } else {
            System.out.println("Det finns ingen kurs med följande kurskod: " + courseCode);
        }

        return courseExists;
    }
    
    public int getNumberOfStudents(String courseCode) throws SQLException {
        int numberOfStudents;
        String sqlString = "SELECT count(*) FROM Hasstudied WHERE ccode = '" + courseCode + "'";
        ResultSet rset = executeQuery(sqlString);
        numberOfStudents = rset.getInt(0);

        return numberOfStudents;
    }

    public int getNumberOfStudentsWithGrade(String courseCode, String grade) throws SQLException {
        int numberOfStudentsWithGrade;
        String sqlString = "SElECT count(*) FROM Hasstudied WHERE ccode = '" + courseCode + "' AND grade = " + grade + "'";
        ResultSet rset = executeQuery(sqlString);
        numberOfStudentsWithGrade = rset.getInt(0);

        return numberOfStudentsWithGrade;
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
