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
    
    DataAccessLayer(Connection connection){
        this.connection = connection;
    }

    void registerNewStudent(String[] studentData) throws SQLException{
        String sqlString = "INSERT INTO Student VALUES (" + "'" + studentData[0] + "'";
        for(int i=1;i<studentData.length;i++){
            sqlString += ",'" + studentData[i] +"'";
            System.out.println(sqlString);
        }
        sqlString += ")";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sqlString);
        connection.commit();
        connection.close();
    }
    
    public boolean checkIfStudentExists(String pnr){
        
        Boolean resultBoolean;
        try {
            
            String sqlString = "SELECT s.pnr FROM Student s WHERE (s.pnr = '" + pnr + "')";
            Statement stmt = connection.createStatement();
            ResultSet rset = stmt.executeQuery(sqlString);
            
            if(rset.next()){
            resultBoolean = true;
            System.out.println("studenten " + pnr + " finns redan");
            }else{
            resultBoolean = false;
            System.out.println("Studenten " + pnr + " finns ej");
            }
        
        return resultBoolean;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
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
       
}
