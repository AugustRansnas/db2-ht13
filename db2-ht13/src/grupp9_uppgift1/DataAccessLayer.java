
package grupp9_uppgift1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Joel Pennegård
 * @author Viktor Voigt
 * @author August Ransnäs
 * @author Jonas Ahrne
 */
public class DataAccessLayer {

    private final Connection connection;

    /**
     * Initalizes with the odbc connection we are going to use
     *
     * @param connection connection to database
     */
    protected DataAccessLayer(Connection connection) {

        this.connection = connection;

    }

    //<editor-fold desc="Execution of SQL statements" defaultstate="collapsed">
    /**
     * This method takes an SQL string and executes the update.
     */
    private void executeUpdate(String sqlString) {

        System.out.println("executeUpdate(" + sqlString + ")");

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method takes an SQL query string and returns a resultset.
     */
    private ResultSet executeQuery(String sqlString) {

        System.out.println("executeQuery(" + sqlString + ")");

        ResultSet rst = null;

        try {
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rst = stmt.executeQuery(sqlString);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rst;
    }
    //</editor-fold>
    //<editor-fold desc="Private helper methods" defaultstate="collapsed">
    /**
     * This method takes a ResultSet and returns TableModel.
     */
    private TableModel getResultSetAsDefaultTableModel(ResultSet rset) {

        try {

            String[] columnHeadings = new String[0];
            String[][] dataArray = new String[0][0];

            ResultSetMetaData md = rset.getMetaData();
            int columnCount = md.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = md.getColumnName(i);
                columnName = stringTranslator(columnName);
                columnHeadings = Arrays.copyOf(columnHeadings, columnHeadings.length + 1);
                columnHeadings[i - 1] = columnName;
            }

            int r = 0;

            while (rset.next()) {

                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rset.getString(i);
                }

                dataArray = Arrays.copyOf(dataArray, dataArray.length + 1);
                dataArray[r] = row;

                r++;
            }

            DefaultTableModel dtm = new DefaultTableModel(dataArray, columnHeadings) {
                @Override
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

    private String[] getResultSetAsStringArray(ResultSet rs) {

        String[] stringArray = new String[0];

        try {

            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            while (rs.next()) {
                String newString = "";
                for (int i = 1; i <= columnCount; i++) {
                    newString += rs.getString(i);

                    newString += " ";
                }

                stringArray = Arrays.copyOf(stringArray, stringArray.length + 1);
                stringArray[stringArray.length - 1] = newString;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stringArray;
    }

    private String[] getRowAsStringArray(ResultSet rset, int rowNr) {

        String[] rowArray = null;

        try {

            ResultSetMetaData md = rset.getMetaData();
            int columnCount = md.getColumnCount();
            rset.absolute(rowNr);

            rowArray = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowArray[i - 1] = rset.getString(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rowArray;

    }

    private boolean checkIfResultSetHasContent(ResultSet rset) {

        boolean hasContent = false;

        {
            try {
                hasContent = rset.isBeforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return hasContent;
    }

    private String stringTranslator(String stringIn) {

        String stringOut;

        switch (stringIn) {
            case "ccode":
                stringOut = "Kurskod";
                break;
            case "cname":
                stringOut = "Kursnamn";
                break;
            case "points":
                stringOut = "Högskolepoäng";
                break;
            case "pnr":
                stringOut = "Personnummer";
                break;
            case "firstname":
                stringOut = "Förnamn";
                break;
            case "lastname":
                stringOut = "Efternamn";
                break;
            case "phonenr":
                stringOut = "Telefonnummer";
                break;
            case "email":
                stringOut = "E-post";
                break;
            case "adress":
                stringOut = "Adress";
                break;
            case "postcode":
                stringOut = "Postnummer";
                break;
            case "city":
                stringOut = "Ort";
                break;
            case "grade":
                stringOut = "Betyg";
                break;
            default:
                stringOut = stringIn;
                break;
        }

        return stringOut;
    }

    /**
     * Printing out a table model. Used for debugging.
     *
     * @param tm
     */
    private void systemOutPrintTableModel(TableModel tm) {

        int columnCount = tm.getColumnCount();
        int rowCount = tm.getRowCount();
        System.out.println("\n dataAccessLayer.systemOutPrintTableModel:  \n");
        for (int i2 = 0; i2 < rowCount; i2++) {
            for (int i = 0; i < columnCount; i++) {
                System.out.print(" " + tm.getValueAt(i2, i));
            }
            System.out.println("");
        }

    }

    private int getFirstCellInResultSetAsInt(ResultSet rset) {

        boolean hasContents = this.checkIfResultSetHasContent(rset);

        if (hasContents) {
            try {

                rset.next();
                return rset.getInt(1);

            } catch (SQLException ex) {
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return 0;

    }

    //</editor-fold>
    //<editor-fold desc="Student queries" defaultstate="collapsed">
    /**
     * Registers a new student
     *
     * @param studentData holds data of student
     */
    protected void registerNewStudent(String[] studentData) {

        String sqlString = "INSERT INTO Student VALUES (" + "'" + studentData[0] + "'";

        for (int i = 1; i < studentData.length; i++) {
            sqlString += ",'" + studentData[i] + "'";
        }
        sqlString += ")";

        executeUpdate(sqlString);
    }

    /**
     * Checks if a student exists
     *
     * @param personNbr personal number of student
     * @return true if student exists
     */
    protected boolean checkIfStudentExists(String personNbr) {

        String sqlString = "SELECT COUNT(*) FROM Student WHERE pnr = '" + personNbr + "';";

        ResultSet rset = executeQuery(sqlString);

        return this.getFirstCellInResultSetAsInt(rset) != 0;

    }

    /**
     * Method that gets a TableModel filled with student found with a search
     * string.
     *
     * @param showAllAttributes selects if we want many of few attributes returned
     * @param searchString string to search with
     * @return found students
     */
    protected TableModel findStudents(boolean showAllAttributes, String searchString) {
        String sqlString;
        if (showAllAttributes) {
            sqlString = "SELECT * FROM Student ";
        } else {
            sqlString = "SELECT pnr, firstname, lastname FROM Student ";
        }
        sqlString += "WHERE pnr LIKE '%" + searchString + "%' "
                + "OR firstname LIKE '%" + searchString + "%' "
                + "OR lastname LIKE '%" + searchString + "%' "
                + "OR phonenr LIKE '%" + searchString + "%' "
                + "OR email LIKE '%" + searchString + "%' "
                + "OR adress LIKE '%" + searchString + "%' "
                + "OR postcode LIKE '%" + searchString + "%' "
                + "OR city LIKE '%" + searchString + "%'";

        ResultSet rs = this.executeQuery(sqlString);

        TableModel tm = this.getResultSetAsDefaultTableModel(rs);

        return tm;

    }

    /**
     * Counts number of students studying a specific course
     * 
     * @param courseCode code of course
     * @return number of students
     */
    protected int getNumberOfStudents(String courseCode) {

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

    /**
     * Gets number of students with a specific grade on a specific course
     * 
     * @param courseCode code of course
     * @param grade grade
     * @return number of students
     */
    protected int getNumberOfStudentsWithGrade(String courseCode, String grade) {

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

    /**
     * Deletes a student from database.
     * 
     * @param personNbr personal number of student
     */
    protected void deleteStudent(String personNbr) {
        String sqlString = "DELETE Student WHERE pnr = '" + personNbr + "'";
        executeUpdate(sqlString);
    }

    /**
     * Gets pnr, firstname and lastname from all students in the database.
     * @return all the students
     */
    protected TableModel getAllStudents() {
        String sqlString = "SELECT pnr, firstname, lastname FROM Student";
        ResultSet rs = this.executeQuery(sqlString);

        TableModel tm = this.getResultSetAsDefaultTableModel(rs);

        return tm;

    }
    /**
     * Gets number of total students.
     *  
     * @return the number of students or 0
     */
    protected int getNumberOfStudents() {

        try {

            String sqlString = "SELECT COUNT(*) FROM Student";
            ResultSet rs = this.executeQuery(sqlString);
            rs.next();
            int studentCount = Integer.parseInt(rs.getString(1));
            return studentCount;

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    /**
     * Gets the code, name and points of all courses that a student is currently registered on. 
     *  @param personNbr personal number of student
     *  @return the courses a student currently is studying
     */
    protected TableModel getStudentsCurrentCourses(String personNbr) {
        TableModel tm;
        String sqlString = "SELECT c.cname, c.ccode, c.points"
                + " FROM Course c"
                + " WHERE c.ccode IN (SELECT s.ccode "
                + " FROM Studies s"
                + " WHERE s.pnr = '" + personNbr + "')";
        ResultSet rs = this.executeQuery(sqlString);
        tm = this.getResultSetAsDefaultTableModel(rs);
        this.systemOutPrintTableModel(tm);
        return tm;
    }
    /**
     * Gets the name, code, points and grade of all courses that a student has finnished. 
     * 
     * @param personNbr personal number of student
     * @return a students finished courses
     */
    protected TableModel getStudentsFinnishedCourses(String personNbr) {
        TableModel tm;
        String sqlString = "SELECT c.cname, h.ccode, c.points, h.grade"
                + " FROM Hasstudied h, Course c"
                + " WHERE h.pnr = '" + personNbr + "'"
                + " AND h.ccode = c.ccode";

        ResultSet rs = this.executeQuery(sqlString);
        tm = this.getResultSetAsDefaultTableModel(rs);
        this.systemOutPrintTableModel(tm);
        return tm;
    }

    //</editor-fold>
    //<editor-fold desc="Course queries" defaultstate="collapsed">
    /**
     * Checks if a course exists.
     * 
     * @param courseCode identifying code of a course.
     * @return true if the course exists and false if the course does not exists
     */
    public boolean checkIfCourseExists(String courseCode) {

        String sqlString = "SELECT c.ccode FROM Course c WHERE (c.ccode = '" + courseCode + "')";
        ResultSet rset = executeQuery(sqlString);

        boolean courseExists = this.checkIfResultSetHasContent(rset);

        if (courseExists) {
            System.out.println("Kursen " + courseCode + " existerar redan");
        } else {
            System.out.println("Det finns ingen kurs med följande kurskod: " + courseCode);
        }

        return courseExists;
    }
    /**
     * Gets all the the information for a specific course
     * 
     * @param courseCode identifying code of a course.
     * @return information about a selected course
     */
    protected String[] getCourseData(String courseCode) {

        String sqlQuery = "SELECT * FROM Course WHERE ccode = '" + courseCode + "'";

        ResultSet rset = this.executeQuery(sqlQuery);

        String[] stringsToReturn = this.getRowAsStringArray(rset, 1);

        return stringsToReturn;

    }
    /**
     * Registers a new Course.
     * 
     * @param courseData an array of the specified course information.
     */
    protected void registerNewCourse(String[] courseData) {

        String sqlString = "INSERT INTO Course VALUES ('" + courseData[0] + "', '"
                + courseData[1] + "', " + courseData[2] + ")";

        executeUpdate(sqlString);

    }
    /**
     * Deletes a specific course.
     * 
     * @param courseCode identifying code of a course.
     */
    protected void deleteCourse(String courseCode) {
        String sqlString = "DELETE Course WHERE ccode = '" + courseCode + "'";
        executeUpdate(sqlString);

    }
    /**
     * Gets all courses that matches the searchterm.
     * 
     * @param searchString the specified searchterm.
     * @return all courses that matches the searchString and their information
     */
    protected TableModel findCourses(String searchString) {

        String sqlString = "SELECT * FROM Course "
                + "WHERE ccode LIKE '%" + searchString + "%' "
                + "OR cname LIKE '%" + searchString + "%'";

        ResultSet rs = this.executeQuery(sqlString);

        TableModel tm = this.getResultSetAsDefaultTableModel(rs);

        return tm;

    }
    /**
     * Gets all courses.
     * 
     * @return all courses and their information
     */
    protected TableModel getAllCourses() {

        String sqlString = "SELECT * FROM Course";

        ResultSet rs = this.executeQuery(sqlString);

        TableModel dtm = this.getResultSetAsDefaultTableModel(rs);

        return dtm;

    }
    /**
     * gets the number of courses.
     *    
     * @return the number of courses that exists or 0 if no courses exists
     */
    protected int getNumberOfCourses() {

        try {

            String sqlString = "SELECT COUNT(*) FROM Course";
            ResultSet rs = this.executeQuery(sqlString);
            rs.next();
            int courseCount = Integer.parseInt(rs.getString(1));
            return courseCount;

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    /**
     * Gets all the students that has finnished the specified course.
     * 
     * @param courseCode identifying code of a course.
     * @return inforamtion about a student that has finished a specific course
     */
    protected TableModel getPastStudentsOnCourse(String courseCode) {
        String SQLString = "SELECT s.pnr, s.firstname, s.lastname, h.grade"
                + " FROM Student s, Hasstudied h"
                + " WHERE h.ccode = '" + courseCode + "'"
                + " AND s.pnr = h.pnr";
        ResultSet rs = this.executeQuery(SQLString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        this.systemOutPrintTableModel(tm);
        return tm;
    }
    /**
     * Gets all the students that are currently registered on the specified course
     * 
     * @param courseCode identifying code of a course.
     * @return information about a student that is currently studying a specific course
     */
    protected TableModel getCurrentStudentsOnCourse(String courseCode) {
        String SQLString = "SELECT s.pnr, s.firstname, s.lastname, s.email"
                + " FROM Student s, Studies s2"
                + " WHERE s2.ccode = '" + courseCode + "'"
                + " AND s.pnr = s2.pnr";
        ResultSet rs = this.executeQuery(SQLString);
        TableModel tm = this.getResultSetAsDefaultTableModel(rs);
        this.systemOutPrintTableModel(tm);
        return tm;
    }

    //</editor-fold>
    //<editor-fold desc="Student + course queries" defaultstate="collapsed">
    /**
     * Gets the grade of a specified students on a specifiec course. 
     * 
     * @param personNbr personal number of a student.
     * @param courseCode identifying code of a course.
     * @return a students grade for a specific course or null if no grade exists
     */
    protected String getStudentGradeAtCourse(String personNbr, String courseCode) {

        String grade = null;
        String sqlString = "SELECT h.grade ";
        sqlString += "FROM Student c, Hasstudied h ";
        sqlString += "WHERE c.pnr = h.pnr ";
        sqlString += "AND h.pnr = '" + personNbr + "' ";
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
    /**
     * Gets a students.
     * 
     * @param personNbr personal number of a student.
     * @return a specific students information
     */
    protected TableModel getSingleStudent(String personNbr) {
        TableModel tm;
        String sqlString = "SELECT * ";
        sqlString += "FROM Student ";
        sqlString += "WHERE pnr = '" + personNbr + "'";
        ResultSet rs = this.executeQuery(sqlString);
        tm = this.getResultSetAsDefaultTableModel(rs);
        return tm;

    }
    /**
     * Calculates the percentage of students that has passed the specified course.
     * 
     * @param courseCode identifying code of a course.
     * @return the percentage of students that passes a specific course
     */
    protected float percentagePassingCourse(String courseCode) {

        //den här metoden delar potentiellt med noll, men java verkar kunna hantera det        
        int nbrOfStudents = this.getNumberOfStudents(courseCode);
        int nbrOfFails = this.getNumberOfStudentsWithGrade(courseCode, "U");
        int nbrOfSuccesses = nbrOfStudents - nbrOfFails;
        float percentagePassingCourse = (float) nbrOfSuccesses / (float) nbrOfStudents * (float) 100;

        //System.out.println(percentagePassingCourse + "% av studenterna klarade kursen " + courseCode);
        return percentagePassingCourse;
    }
    /**
     * Calculates the percentage of finnished students with the grade A on a specified course
     * 
     * @param courseCode identifying code of a course.
     * @return a percentage of students that has grade A on a specific course
     */
    protected float percentageWithGradeAOnCourse(String courseCode) {

        //den här metoden delar potentiellt med noll, men java verkar kunna hantera det        
        int nbrOfStudents = this.getNumberOfStudents(courseCode);
        int nbrOfA = this.getNumberOfStudentsWithGrade(courseCode, "A");
        //int nbrOfSuccesses = nbrOfStudents - nbrOfFails;
        float percentageWithGradeAOnCourse = (float) nbrOfA / (float) nbrOfStudents * (float) 100;

        System.out.println(percentageWithGradeAOnCourse + "% av fick betyget A på kursen " + courseCode);

        return percentageWithGradeAOnCourse;
    }
    /**
     * Calculates the percentage of students with a specified grade on a specified course.
     * 
     * @param courseCode identifying code of a course.
     * @param grade the grade name
     * @return the percentage of students with a specific grade 
     */
    protected float percentageOfStudentsWithGrade(String courseCode, String grade) {

        //den här metoden delar potentiellt med noll, men java verkar kunna hantera det
        int numberOfStudents = getNumberOfStudents(courseCode);
        int numberOfStudentsWithGrade = getNumberOfStudentsWithGrade(courseCode, grade);
        float percentageOfStudentsWithGrade;
        percentageOfStudentsWithGrade = ((float) numberOfStudentsWithGrade / (float) numberOfStudents) * (float) 100;

        return percentageOfStudentsWithGrade;
    }
    /**
     * Gets all courses and the percentage of students that has succesfully finnished them.
     * @return a table which contains all courses and the percentage of passing students for each course
     */
    protected TableModel getCourseFlow() {
        try {

            String sqlQuery = "SELECT ccode FROM Course";
            ArrayList<String> courseNames = new ArrayList<>();

            int courseCount = getNumberOfCourses();

            DefaultTableModel returnTable = new DefaultTableModel();
            returnTable.addColumn("Kurskod");
            returnTable.addColumn("Andel godkända studenter");
            returnTable.setRowCount(courseCount);
            ResultSet rset = executeQuery(sqlQuery);

            for (int i = 0; i < courseCount; i++) {
                rset.next();
                String courseCode = rset.getString(1);
                courseNames.add(courseCode);
                returnTable.setValueAt(courseCode, i, 0);
            }
            for (int i = 0; i < courseCount; i++) {
                rset.next();
                String courseCode = courseNames.get(i);
                float courseFlow = percentagePassingCourse(courseCode);
                String percent = String.format("%.1f", courseFlow);
                percent += "%";
                if (percent.contentEquals("NaN%")) {
                    percent = "-";
                }
                returnTable.setValueAt(percent, i, 1);

            }
            /*
             *System.out.println("dataAccessLayer.courseFlow:         kurser och eventuellt genomflöde i % ");
             *for (int i = 0; i < courseCount; i++){
             *System.out.println("dataAccessLayer.courseFlow:         " + returnTable.getValueAt(i, 0) + "    " + returnTable.getValueAt(i, 1));
             *}
             */
            return returnTable;

        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * Changes the course from studies to hasstudied and registers a grade.
     * 
     * @param courseCode identifying code of a course.
     * @param personNbr personal number of a student.
     * @param grade the grade name
     */
    protected void registerCourseResult(String courseCode, String personNbr, String grade) {

        String sqlString = "DELETE FROM Studies WHERE pnr = '" + personNbr + "' AND ccode = '" + courseCode + "'";

        this.executeUpdate(sqlString);

        sqlString = "INSERT INTO Hasstudied VALUES ('" + personNbr + "', '" + courseCode + "', '" + grade + "')";

        this.executeUpdate(sqlString);

    }
    /**
     * Gets the courses that the specified student isn't registered on and haven't been registered on. 
     * 
     * @param personNbr personal number of a student.
     * @return a list of courses that is possible to add to a student
     */
    protected String[] getCoursesThatCanBeAddedToStudent(String personNbr) {

        ResultSet rset = this.executeQuery("SELECT * FROM Course c "
                + "WHERE c.ccode NOT IN "
                + "(SELECT h.ccode FROM Hasstudied h "
                + "WHERE h.pnr = '" + personNbr + "') "
                + "AND c.ccode NOT IN "
                + "(Select s.ccode FROM Studies s "
                + "WHERE s.pnr = '" + personNbr + "')");

        String[] stringArray = this.getResultSetAsStringArray(rset);

        return stringArray;

    }
    /**
     * Registers the specified student on the specified course
     * 
     * @param personNbr personal number of a student.
     * @param courseCode identifying code of a course.
     */
    protected void registerStudentOnCourse(String personNbr, String courseCode) {

        String sqlString = "INSERT INTO Studies VALUES ('" + personNbr + "', '" + courseCode + "')";

        this.executeUpdate(sqlString);

    }
    /**
     * Gets the total sum of points from the courses a specified student is registered on.
     * 
     * @param personNbr personal number of a student.
     * @return the total amount of points which a student currently is studying
     */
    protected int getStudentsRegisteredPointTotal(String personNbr) {

        String sqlString = "SELECT SUM(c.points) FROM Course c JOIN Studies s ON c.ccode = s.ccode WHERE s.pnr = '" + personNbr + "' GROUP BY s.pnr";
        ResultSet rset = this.executeQuery(sqlString);
        int intToReturn = this.getFirstCellInResultSetAsInt(rset);
        return intToReturn;

    }
    /**
     * Deletes a student from a course before examination
     * 
     * @param selectedStudent is a selected student from the student list
     * @param selectedCcode is the selected course from the not finished courses table*/
    
    protected void deleteStudentFromCourse(String selectedStudent, String selectedCcode){
        String sqlString = "DELETE FROM Studies WHERE pnr = '" + selectedStudent + "' AND ccode = '" + selectedCcode +"'";
        this.executeUpdate(sqlString);
    }

    //</editor-fold>
}
