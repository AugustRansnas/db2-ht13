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

    private void executeUpdate(String sqlString) {
        
        try {
            
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sqlString);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    private ResultSet executeQuery(String sqlString) {

        ResultSet rst = null;

        try {

            Statement stmt = connection.createStatement();

            rst = stmt.executeQuery(sqlString);

        } catch (SQLException ex) {

            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);

        }

        return rst;
    }

    void registerNewStudent(String[] studentData) throws SQLException {
        String sqlString = "INSERT INTO Student VALUES (" + "'" + studentData[0] + "'";
        for (int i = 1; i < studentData.length; i++) {
            sqlString += ",'" + studentData[i] + "'";
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

    public int getNumberOfStudents(String courseCode){

        int numberOfStudents = 0;
        String sqlString = "SELECT count(*) FROM Hasstudied WHERE ccode = '" + courseCode + "'";
        ResultSet rs = executeQuery(sqlString);
        try {
            while (rs.next()) {
                numberOfStudents = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfStudents;
    }

    public int getNumberOfStudentsWithGrade(String courseCode, String grade){

        int numberOfStudentsWithGrade = 0;
        String sqlString = "SELECT count(*) FROM Hasstudied WHERE ccode = '" + courseCode + "' AND grade = '" + grade + "'";
        ResultSet rs = executeQuery(sqlString);
        try {
            while (rs.next()) {
                numberOfStudentsWithGrade = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numberOfStudentsWithGrade;
    }

    public String getStudentGradeAtCourse(String pnr, String courseCode) {
        String grade = null;
        String sqlString = "SELECT h.grade ";
        sqlString += "FROM student c, hasstudied h ";
        sqlString += "WHERE c.pnr = h.pnr ";
        sqlString += "AND h.pnr = '" + pnr + "' ";
        sqlString += "AND h.ccode = '" + courseCode + "'";

        try {
            ResultSet rset = executeQuery(sqlString);
            while (rset.next()) {
                grade = rset.getString(1);
            }
            return grade;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // se över namnkonventioner i db. Vet ej om dessa stämmer överallt

    void updateStudent(String[] studentData) throws SQLException {
        String sqlString = "UPDATE student SET";
        sqlString += "pnr = '" + studentData[0] + "'";
        sqlString += "firstname = '" + studentData[1] + "'";
        sqlString += "lastname = '" + studentData[2] + "'";
        sqlString += "phonenr = '" + studentData[3] + "'";
        sqlString += "email = '" + studentData[4] + "'";
        sqlString += "address = '" + studentData[5] + "'";
        sqlString += "postcode = '" + studentData[6] + "'";
        sqlString += "city = '" + studentData[7] + "'";
        executeUpdate(sqlString);
    }
// ska ta in en selectad student som inparameter också när den metoden finns

    void deleteStudent(String personNbr) {
        String sqlString = "DELETE Student WHERE pnr = '" + personNbr + "'";
        executeUpdate(sqlString);
    }

    void registerNewCourse(String[] courseData) {
        
        String sqlString = "INSERT INTO Course VALUES ('" + courseData[0] + "', '"
                + courseData[1] + "', " + courseData[2] + ")";
        
        executeUpdate(sqlString);
    }

    //ska ta in en selectad kurs
    void updateCourse(String[] courseData) {

        String sqlString = "UPDATE Course SET";
        sqlString += "ccode = '" + courseData[0] + "'";
        sqlString += "cname = '" + courseData[1] + "'";
        sqlString += "points = '" + courseData[2] + "'";
        executeUpdate(sqlString);
    }
// ska ta in en selectad kurs

    void deleteCourse(String courseCode) {
        String sqlString = "DELETE course WHERE ccode = '" + courseCode + "'";
        executeUpdate(sqlString);

    }

    protected DefaultTableModel findCourses(String searchString) {

        String sqlString = "SELECT * FROM Course "
                + "WHERE ccode LIKE '%" + searchString + "%' "
                + "OR cname LIKE '%" + searchString + "%'";

        ResultSet rs = this.executeQuery(sqlString);

        DefaultTableModel dtm = this.getResultSetAsDefaultTableModel(rs);

        return dtm;

    }

    protected DefaultTableModel getAllCourses() {

        String sqlString = "SELECT * FROM Course";

        ResultSet rs = this.executeQuery(sqlString);

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

    DefaultTableModel getAllStudents() {

        String sqlString = "SELECT * FROM Student";

        ResultSet rs = this.executeQuery(sqlString);

        DefaultTableModel dtm = this.getResultSetAsDefaultTableModel(rs);

        return dtm;



    }

    protected DefaultTableModel findStudents(String searchString) {

        String sqlString = "SELECT * FROM Student "
                + "WHERE pnr LIKE '%" + searchString + "%' "
                + "OR firstname LIKE '%" + searchString + "%' "
                + "OR lastname LIKE '%" + searchString + "%' "
                + "OR phonenr LIKE '%" + searchString + "%' "
                + "OR email LIKE '%" + searchString + "%' "
                + "OR adress LIKE '%" + searchString + "%' "
                + "OR postcode LIKE '%" + searchString + "%' "
                + "OR city LIKE '%" + searchString + "%'";

        ResultSet rs = this.executeQuery(sqlString);

        DefaultTableModel dtm = this.getResultSetAsDefaultTableModel(rs);

        return dtm;



    }
}
