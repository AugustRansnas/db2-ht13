/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 * This class handles communication between the GUI and the data access layer.
 *
 * @author Viktor Voigt
 * @author Jonas Ahrne
 * @author Joel Pennegård
 * @author August Ransnäs
 */
public class Controller {

    private DataAccessLayer dataAccessLayer;

    Controller(DataAccessLayer dataAccessLayer) {

        this.dataAccessLayer = dataAccessLayer;

    }

    //<editor-fold desc="Student operations" defaultstate="collapsed">
    /**
     * Calls the data access layer to register a new student.
     */
    protected void registerNewStudent(String[] studentData) {

        System.out.println("Creating student: " + studentData[0] + " " + studentData[1] + " "
                + studentData[2]);

        this.dataAccessLayer.registerNewStudent(studentData);

    }

    /**
     * Calls the data access layer to delete a student.
     */
    protected void deleteStudent(String personNbr) {

        this.dataAccessLayer.deleteStudent(personNbr);

    }

    /**
     * Calls the data access layer to check if the personal number of the
     * student already exists in the database.
     *
     * @return true if student exists
     */
    protected boolean checkIfStudentExists(String string) {

        if (this.dataAccessLayer.checkIfStudentExists(string)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calls data access layer to get a table model with all student
     *
     * @return contains all students
     */
    protected TableModel getAllStudents() {

        TableModel dtm;

        dtm = this.dataAccessLayer.getAllStudents();

        return dtm;

    }

    /**
     * Calls data access layer to get a table model with all students with data
     * partially matching the search string.
     *
     * @param searchString string used in query to find students
     * @return contains all found students
     */
    protected TableModel findStudents(String searchString) {

        TableModel tm = this.dataAccessLayer.findStudents(searchString);

        return tm;
    }

    protected TableModel getStudentsCurrentCourses(String pnr) {

        TableModel tm = this.dataAccessLayer.getStudentsCurrentCourses(pnr);
        return tm;
    }

    protected TableModel getStudentsFinnishedCourses(String pnr) {

        TableModel tm = this.dataAccessLayer.getStudentsFinnishedCourses(pnr);
        return tm;
    }

    //</editor-fold>
    //<editor-fold desc="Course operations" defaultstate="collapsed"> 
    /**
     * Calls the data access layer to find courses with fields matching the
     * parameter.
     *
     * @return TableModel with the courses from an SQL query
     */
    protected TableModel findCourses(String searchString) {

        TableModel tm = this.dataAccessLayer.findCourses(searchString);

        return tm;
    }

    /**
     * Calls the data access layer to register a new course.
     */
    protected void registerNewCourse(String[] courseData) {

        this.dataAccessLayer.registerNewCourse(courseData);
    }

    /**
     * Calls the data access layer to delete a course
     *
     * @param courseCode course code of course to delete
     */
    protected void deleteCourse(String courseCode) {

        this.dataAccessLayer.deleteCourse(courseCode);
    }

    /**
     * Calls data access layer to see if course exists.
     *
     * @param courseCode course code of course to check
     * @return true if course exists
     */
    protected boolean checkIfCourseExists(String courseCode) {

        if (this.dataAccessLayer.checkIfCourseExists(courseCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calls data access layer to get percentage of students with a specific
     * grade on a specific course.
     *
     * @param courseCode code of course to check
     * @param grade can be strings "A", "B", "C", "D", "E", "U"
     * @return percentage with grade
     */
    protected float percentageOfStudentsWithGrade(String courseCode, String grade) {

        float percentageWithGrade = this.dataAccessLayer.percentageOfStudentsWithGrade(courseCode, grade);
        return percentageWithGrade;

    }

    /**
     * Calls data access layer to get percentage of students passing the course.
     *
     * @param courseCode code of course to check
     * @return percentage of students passing the course
     */
    protected float percentagePassingCourse(String courseCode) {

        float percentagePassingCourse = this.dataAccessLayer.percentagePassingCourse(courseCode);
        return percentagePassingCourse;

    }

    /**
     * Calls data access layer to get a table model showing how many students
     * flowing through each course.
     *
     * @return table model of course flow
     */
    protected TableModel getCourseFlow() {

        TableModel dtm;
        dtm = this.dataAccessLayer.getCourseFlow();
        return dtm;

    }

    /**
     * Calls data access layer to get a table model with all courses
     *
     * @return table model with all courses
     */
    protected TableModel getAllCourses() {

        TableModel tm;

        tm = this.dataAccessLayer.getAllCourses();

        return tm;

    }

    /**
     * Calls data access layer to get a table model with all students that have
     * finished a specific course
     *
     * @return table model with all students that have finished the course
     */
    protected TableModel getPastStudentsOnCourse(String courseCode) {
        TableModel tm;
        tm = this.dataAccessLayer.getPastStudentsOnCourse(courseCode);
        return tm;
    }

    /**
     * Calls data access layer to get a table model with all students that are
     * currently enlisted on a specific course
     *
     * @return table model with all current students on the course
     */
    protected TableModel getCurrentStudentsOnCourse(String courseCode) {
        TableModel tm;
        tm = this.dataAccessLayer.getCurrentStudentsOnCourse(courseCode);
        return tm;
    }

    //</editor-fold>
    //<editor-fold desc="Course + Student operations" defaultstate="collapsed">
    protected void registerCourseResult(String courseCode, String pNr, String grade) {

        this.dataAccessLayer.registerCourseResult(courseCode, pNr, grade);

    }

    protected Object[] getCoursesThatCanBeAddedToStudent(String pNr) {

        return this.dataAccessLayer.getCoursesThatCanBeAddedToStudent(pNr);

    }

    void registerStudentOnCourse(String selectedStudent, String courseId) {

        this.dataAccessLayer.registerStudentOnCourse(selectedStudent, courseId);
        
    }
    
    protected int getStudentsRegisteredPointsTotal(String pNr){
        
        return this.dataAccessLayer.getStudentsRegisteredPointTotal(pNr);
        
    }

//</editor-fold>
}
