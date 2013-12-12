/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.sql.SQLException;

/**
 *
 * @author Viktor Voigt
 * @author Jonas Ahrne
 * @author Joel Pennegård
 * @author August Ransnäs
 *
 */
public class Controller {

    DataAccessLayer dataAccessLayer;

    Controller(DataAccessLayer dataAccessLayer) {

        this.dataAccessLayer = dataAccessLayer;

    }

    protected void registerNewStudent(String[] studentData) throws SQLException {

        System.out.println("Creating student: " + studentData[0] + " " + studentData[1] + " "
                + studentData[2]);

        this.dataAccessLayer.registerNewStudent(studentData);

    }

    void updateStudent(String[] studentData) throws SQLException {
        
        this.dataAccessLayer.updateStudent(studentData);
        
    }

    void deleteStudent(String personNbr) {
        
        this.dataAccessLayer.deleteStudent(personNbr);
        
    }

    void registerNewCourse(String[] courseData) {     
        
        this.dataAccessLayer.registerNewCourse(courseData);
    }

    void updateCourse(String[] courseData) {
        
        this.dataAccessLayer.updateCourse(courseData);
        
    }

    void deleteCourse(String courseCode) {
        
        this.dataAccessLayer.deleteCourse(courseCode);
    }

    boolean checkIfStudentExists(String string) throws SQLException{
        
        if (this.dataAccessLayer.checkIfStudentExists(string)) {
            return true;
        } else {
            return false;
        }        
    }

    boolean checkIfCourseExists(String string) {
 
        return true;
        
    }
}
