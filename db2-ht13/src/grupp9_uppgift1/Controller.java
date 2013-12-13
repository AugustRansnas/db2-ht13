/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import javax.swing.table.TableModel;

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

    protected void registerNewStudent(String[] studentData) {

        System.out.println("Creating student: " + studentData[0] + " " + studentData[1] + " "
                + studentData[2]);

        this.dataAccessLayer.registerNewStudent(studentData);

    }



    void deleteStudent(String personNbr) {
        
        this.dataAccessLayer.deleteStudent(personNbr);
        
    }

    void registerNewCourse(String[] courseData) {     
        
        this.dataAccessLayer.registerNewCourse(courseData);
    }



    void deleteCourse(String courseCode) {
        
        this.dataAccessLayer.deleteCourse(courseCode);
    }

    boolean checkIfStudentExists(String string) {
        
        if (this.dataAccessLayer.checkIfStudentExists(string)) {
            return true;
        } else {
            return false;
        }        
    }

    boolean checkIfCourseExists(String courseCode) {
 
        if (this.dataAccessLayer.checkIfCourseExists(courseCode)){
            return true;
        } else {
            return false;
        }
        
    }
    protected float percentageOfStudentsWithGrade(String courseCode, String grade) {
        float percentageWithGrade = this.dataAccessLayer.percentageOfStudentsWithGrade(courseCode, grade);
        return percentageWithGrade;
                
    }
    protected float percentagePassingCourse(String courseCode){
        float percentagePassingCourse = this.dataAccessLayer.percentagePassingCourse(courseCode);
        return percentagePassingCourse;
    }
    protected DefaultTableModel getCourseFlow() {
        DefaultTableModel dtm;
        dtm = this.dataAccessLayer.getCourseFlow();
        return dtm;
    }
    

    protected TableModel getAllCourses() {
        
       TableModel tm;
       
       tm = this.dataAccessLayer.getAllCourses();
       
       return tm;
               
    }
    
    protected TableModel getAllStudents() {
        
       TableModel dtm;
       
       dtm = this.dataAccessLayer.getAllStudents();
       
       return dtm;
               
    }
    
    protected TableModel findCourses(String searchString){
        
        TableModel tm = this.dataAccessLayer.findCourses(searchString);
        
        return tm;
    }

    protected TableModel findStudents(String searchString) {

        TableModel tm = this.dataAccessLayer.findStudents(searchString);
        
        return tm;
    }
            
            
            
}
