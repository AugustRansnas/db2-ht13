
package grupp9_uppgift1;

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

    private final DataAccessLayer dataAccessLayer;

    Controller(DataAccessLayer dataAccessLayer) {

        this.dataAccessLayer = dataAccessLayer;

    }

    //<editor-fold desc="Student operations" defaultstate="collapsed">
    /**
     * Calls the data access layer to register a new student.
     *
     * @param studentData array of strings holding the data needed to register a
     * student
     */
    protected void registerNewStudent(String[] studentData) {

        System.out.println("Creating student: " + studentData[0] + " " + studentData[1] + " "
                + studentData[2]);

        this.dataAccessLayer.registerNewStudent(studentData);

    }

    /**
     * Calls the data access layer to delete a student.
     *
     * @param personNbr the personal number of the student
     */
    protected void deleteStudent(String personNbr) {

        this.dataAccessLayer.deleteStudent(personNbr);

    }

    /**
     * Calls the data access layer to check if the personal number of the
     * student already exists in the database.
     *
     * @param personNbr number of student used to find it
     * @return true if student exists
     */
    protected boolean checkIfStudentExists(String personNbr) {

        return this.dataAccessLayer.checkIfStudentExists(personNbr);

    }

    /**
     * Calls data access layer to get a table model with all student
     *
     * @return contains all students
     */
    protected TableModel getAllStudents() {

        TableModel tm;

        tm = this.dataAccessLayer.getAllStudents();

        return tm;

    }

    /**
     * Calls data access layer to get a table model with all students with data
     * partially matching the search string.
     *
     * @param showAllAttributes sets if the return is a table model with all or
     * just a few attributes
     * @param searchString string used in query to find students
     * @return contains all found students
     */
    protected TableModel findStudents(boolean showAllAttributes, String searchString) {

        TableModel tm = this.dataAccessLayer.findStudents(showAllAttributes, searchString);

        return tm;
    }

    /**
     * Method that gets a TableModel with all courses a student is currently attending.
     *
     * @param personNbr personal number of student
     * @return all courses a student is currently attending
     */
    protected TableModel getStudentsCurrentCourses(String personNbr) {

        TableModel tm = this.dataAccessLayer.getStudentsCurrentCourses(personNbr);
        return tm;
    }

    /**
     * Method that gets a TableModel with all courses a student is currently attending.
     * 
     * @param personNbr personal number of student
     * @return all courses a student has finished
     */
    protected TableModel getStudentsFinnishedCourses(String personNbr) {

        TableModel tm = this.dataAccessLayer.getStudentsFinnishedCourses(personNbr);
        return tm;
    }

    /**
     * Method that returns data for a single student
     * 
     * @param personNbr personal number of student
     * @return single student
     */
    protected TableModel getSingleStudent(String personNbr) {
        
        TableModel tm = this.dataAccessLayer.getSingleStudent(personNbr);
        return tm;
        
    }

    //</editor-fold>
    //<editor-fold desc="Course operations" defaultstate="collapsed"> 
    /**
     * Calls the data access layer to find courses with fields matching the
     * parameter.
     *
     * @param searchString string that will be matched with data in database
     * @return TableModel with the courses from an SQL query
     */
    protected TableModel findCourses(String searchString) {

        TableModel tm = this.dataAccessLayer.findCourses(searchString);

        return tm;
    }

    /**
     * Method that returns data for a specific course.
     * 
     * @param courseCode code of a course
     * @return array containing the data of a course
     */
    protected String[] getCourseData(String courseCode) {

        return this.dataAccessLayer.getCourseData(courseCode);

    }

    /**
     * Calls the data access layer to register a new course.
     *
     * @param courseData contains the data that will fill the fields in the
     * table row
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

        return this.dataAccessLayer.checkIfCourseExists(courseCode);
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
     * Returns a String with the percentage of student who got A on a course
     *
     * @param courseCode code of the course
     * @return the percentage of students who got A
     */
    protected float percentageWithGradeAOnCourse(String courseCode) {

        float percentageWithGradeAOnCourse = this.dataAccessLayer.percentageWithGradeAOnCourse(courseCode);
        return percentageWithGradeAOnCourse; //Autocast float -> String
        
    }

    /**
     * Calls data access layer to get a table model showing how many students
     * flowing through each course.
     *
     * @return table model of course flow
     */
    protected TableModel getCourseFlow() {

        TableModel tm;
        tm = this.dataAccessLayer.getCourseFlow();
        return tm;

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
     * @param courseCode code of course
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
     * @param courseCode code of course
     * @return table model with all current students on the course
     */
    protected TableModel getCurrentStudentsOnCourse(String courseCode) {
        TableModel tm;
        tm = this.dataAccessLayer.getCurrentStudentsOnCourse(courseCode);
        return tm;
    }

    //</editor-fold>
    //<editor-fold desc="Course + Student operations" defaultstate="collapsed">
    
    /**
     * Registers a student result on a course.
     * 
     * @param courseCode code of course
     * @param personNbr personal number of student
     * @param grade the grade to register
     */
    protected void registerCourseResult(String courseCode, String personNbr, String grade) {

        this.dataAccessLayer.registerCourseResult(courseCode, personNbr, grade);

    }
    
    /**
     * Returns array of strings with courses that can be added to a student.
     * 
     * @param personNbr personal number of student
     * @return array of strings with courses that can be added to a student
     */
    protected String[] getCoursesThatCanBeAddedToStudent(String personNbr) {

        return this.dataAccessLayer.getCoursesThatCanBeAddedToStudent(personNbr);

    }

    /**
     * Registers a student on a course
     * 
     * @param personNbr personal number of the student
     * @param courseCode code of course
     */
    void registerStudentOnCourse(String personNbr, String courseCode) {

        this.dataAccessLayer.registerStudentOnCourse(personNbr, courseCode);

    }
    
    /**
     * Get the total amount of course credits a student is registered on.
     * 
     * @param personNbr personal number of the student
     * @return total amount of course credits
     */
    protected int getStudentsRegisteredPointsTotal(String personNbr) {

        return this.dataAccessLayer.getStudentsRegisteredPointTotal(personNbr);

    }

    /**
     * Checks if a course can be added to the students active courses
     * 
     * @param courseCode code of course
     * @param personNbr personal number of student
     * @return true if course can be added to student
     */
    protected boolean checkIfCourseCanBeAddedToStudent(String courseCode, String personNbr) {

        int oldTotalCredits = this.getStudentsRegisteredPointsTotal(personNbr);

        String[] courseData = this.getCourseData(courseCode);

        String creditsToAddString = courseData[2];

        int creditsToAdd = Integer.parseInt(creditsToAddString);

        return oldTotalCredits + creditsToAdd <= 45;

    }
    /**
     * Deletes a student from a course before examination
     * 
     * @param selectedStudent is a selected student from the student list
     * @param selectedCcode is the selected course from the not finished courses table*/
    protected void deleteStudentFromCourse(String selectedStudent, String selectedCcode){
        this.dataAccessLayer.deleteStudentFromCourse(selectedStudent,selectedCcode);
    }

//</editor-fold>
}
