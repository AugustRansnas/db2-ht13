/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author svalan
 */
public class View extends javax.swing.JFrame {

    private final Controller controller;
    private String selectedStudent;
    private String selectedCourse;

    /**
     * Creates new form View.
     * @param controller Handles communication with database.
     */
    public View(Controller controller) {

        this.controller = controller;

        this.initComponents();

        this.populateStudentTable();
        this.populateCourseTable();
        this.populateCourseFlowTable();

    }

    private void setSelectedStudent(String selectedStudent) {

        System.out.println(selectedStudent);

        this.selectedStudent = selectedStudent;

        this.populateStudentsCurrentAndPastCourses(selectedStudent);

        this.rbtnDeleteStudent.setEnabled(true);

        this.btnRegisterCourseResult.setEnabled(false);
        
        Object[] comboBoxList = controller.getCoursesThatCanBeAddedToStudent(selectedStudent);
        this.comboBoxViewStudentAddCourse.setModel(new DefaultComboBoxModel(comboBoxList));

    }

    private void setSelectedCourse(String selectedCourse) {

        System.out.println(selectedCourse);

        this.selectedCourse = selectedCourse;

        this.populateCoursesPastAndCurrentStudents(selectedCourse);

        this.rbtnDeleteCourse.setSelected(true);
        this.txtViewCourseCode.setEditable(false);
        this.txtViewCourseName.setEditable(false);
        this.txtViewCourseCredits.setEditable(false);

    }

    private void populateCourseTable() {

        TableModel tm;
        tm = controller.getAllCourses();
        this.tableFindCourse.setModel(tm);

    }

    private void populateStudentTable() {

        TableModel tm;
        tm = controller.getAllStudents();
        this.tblFindStudent.setModel(tm);

    }

    private void populateCourseFlowTable() {

        TableModel tm;
        tm = controller.getCourseFlow();
        this.tblCourseFlow.setModel(tm);

    }

    private void populateStudentsCurrentAndPastCourses(String selectedStudent) {

        TableModel tm1;
        TableModel tm2;
        tm1 = this.controller.getStudentsCurrentCourses(selectedStudent);
        tm2 = this.controller.getStudentsFinnishedCourses(selectedStudent);
        this.tblSelectedStudentsUnfinishedCourses.setModel(tm1);
        this.tblStudentsFinishedCourses.setModel(tm2);

    }

    private void populateCoursesPastAndCurrentStudents(String selectedCourse) {

        TableModel tm1;
        TableModel tm2;
        tm1 = this.controller.getPastStudentsOnCourse(selectedCourse);
        tm2 = this.controller.getCurrentStudentsOnCourse(selectedCourse);
        this.tblFinishedStudentsOnCourse.setModel(tm1);
        this.tblNotFinishedStudentsOnCourse.setModel(tm2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCourse = new javax.swing.ButtonGroup();
        buttonGroupStudent = new javax.swing.ButtonGroup();
        tabbedPane = new javax.swing.JTabbedPane();
        pnlStudents = new javax.swing.JPanel();
        pnlFindStudents = new javax.swing.JPanel();
        txtFindStudentQuery = new javax.swing.JTextField();
        lblFindStudent = new javax.swing.JLabel();
        btnFindStudent = new javax.swing.JButton();
        scrollPaneFindStudent = new javax.swing.JScrollPane();
        tblFindStudent = new javax.swing.JTable();
        pnlViewStudent = new javax.swing.JPanel();
        lblViewStudentFirstName = new javax.swing.JLabel();
        lblViewStudentLastName = new javax.swing.JLabel();
        txtViewStudentPersonNbr = new javax.swing.JTextField();
        txtViewStudentFirstName = new javax.swing.JTextField();
        txtViewStudentAdress = new javax.swing.JTextField();
        txtViewStudentEmail = new javax.swing.JTextField();
        lblViewStudentEmail = new javax.swing.JLabel();
        lblViewStudentPhoneNbr = new javax.swing.JLabel();
        txtViewStudentPhoneNbr = new javax.swing.JTextField();
        txtViewStudentLastName = new javax.swing.JTextField();
        txtViewStudentPostCode = new javax.swing.JTextField();
        lblViewStudentPostCode = new javax.swing.JLabel();
        txtViewStudentCity = new javax.swing.JTextField();
        lblViewStudentCity = new javax.swing.JLabel();
        lblViewStudentAdress = new javax.swing.JLabel();
        lblViewStudentPersonNbr = new javax.swing.JLabel();
        lblViewStudentPassedCourses = new javax.swing.JLabel();
        lblViewStudentNonPassedCourses = new javax.swing.JLabel();
        lblViewStudentAddCourse = new javax.swing.JLabel();
        comboBoxViewStudentAddCourse = new javax.swing.JComboBox();
        btnViewStudentAddCourse = new javax.swing.JButton();
        scrollPanePassedCourses = new javax.swing.JScrollPane();
        tblStudentsFinishedCourses = new javax.swing.JTable();
        scrollPanesFinishedCourses = new javax.swing.JScrollPane();
        tblSelectedStudentsUnfinishedCourses = new javax.swing.JTable();
        rbtnDeleteStudent = new javax.swing.JRadioButton();
        rbtnRegisterStudent = new javax.swing.JRadioButton();
        btnDeleteRegisterStudent = new javax.swing.JButton();
        lblRegisterCourseResult = new javax.swing.JLabel();
        comboBoxRegisterCourseResult = new javax.swing.JComboBox();
        btnRegisterCourseResult = new javax.swing.JButton();
        pnlCourse = new javax.swing.JPanel();
        pnlFindCourse = new javax.swing.JPanel();
        txtFindCourseInput = new javax.swing.JTextField();
        lblFindCourseInput = new javax.swing.JLabel();
        btnFindCourse = new javax.swing.JButton();
        scrollPaneFindCourse = new javax.swing.JScrollPane();
        tableFindCourse = new javax.swing.JTable();
        pnlShowCourse = new javax.swing.JPanel();
        lblViewCourseCourseCode = new javax.swing.JLabel();
        txtViewCourseCode = new javax.swing.JTextField();
        txtViewCourseName = new javax.swing.JTextField();
        txtViewCourseCredits = new javax.swing.JTextField();
        lblViewCourseCourseName = new javax.swing.JLabel();
        lblViewCourseCredits = new javax.swing.JLabel();
        pnlCourseResults = new javax.swing.JPanel();
        lblViewCoursePassedStudents = new javax.swing.JLabel();
        lblViewCourseStudentsWithA = new javax.swing.JLabel();
        lblViewCourseNonPassedStudents = new javax.swing.JLabel();
        txtViewCourseStudentsWithA = new javax.swing.JTextField();
        scrollPaneStudentsOnCourse = new javax.swing.JScrollPane();
        tblFinishedStudentsOnCourse = new javax.swing.JTable();
        scrollPaneNotFInishedStudentsOnCourse = new javax.swing.JScrollPane();
        tblNotFinishedStudentsOnCourse = new javax.swing.JTable();
        rbtnRegisterCourse = new javax.swing.JRadioButton();
        rbtnDeleteCourse = new javax.swing.JRadioButton();
        btnDeleteRegisterCourse = new javax.swing.JButton();
        pnlHighestPassedCourse = new javax.swing.JPanel();
        scrollPaneCourseFlow = new javax.swing.JScrollPane();
        tblCourseFlow = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Studentsystem");

        pnlFindStudents.setBorder(javax.swing.BorderFactory.createTitledBorder("Sök studenter"));

        lblFindStudent.setText("Sökterm:");

        btnFindStudent.setText("Sök");
        btnFindStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindStudentActionPerformed(evt);
            }
        });

        tblFindStudent.setAutoCreateRowSorter(true);
        tblFindStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFindStudent.setName("Studenter"); // NOI18N
        tblFindStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblFindStudent.getTableHeader().setReorderingAllowed(false);
        tblFindStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFindStudentMouseClicked(evt);
            }
        });
        scrollPaneFindStudent.setViewportView(tblFindStudent);

        javax.swing.GroupLayout pnlFindStudentsLayout = new javax.swing.GroupLayout(pnlFindStudents);
        pnlFindStudents.setLayout(pnlFindStudentsLayout);
        pnlFindStudentsLayout.setHorizontalGroup(
            pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFindStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFindStudent)
                .addGap(6, 6, 6)
                .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnFindStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFindStudentsLayout.createSequentialGroup()
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFindStudentsLayout.setVerticalGroup(
            pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindStudentsLayout.createSequentialGroup()
                .addGroup(pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFindStudent)
                    .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlViewStudent.setBorder(javax.swing.BorderFactory.createTitledBorder("Studentinformation"));

        lblViewStudentFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentFirstName.setText("Förnamn:");

        lblViewStudentLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentLastName.setText("Efternamn:");

        lblViewStudentEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentEmail.setText("E-post:");

        lblViewStudentPhoneNbr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentPhoneNbr.setText("Telefonnummer:");

        lblViewStudentPostCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentPostCode.setText("Postnummer:");

        lblViewStudentCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentCity.setText("Ort:");

        lblViewStudentAdress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentAdress.setText("Adress:");

        lblViewStudentPersonNbr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentPersonNbr.setText("Personnummer:");

        lblViewStudentPassedCourses.setText("Godkända kurser:");

        lblViewStudentNonPassedCourses.setText("Ej avslutade kurser:");

        lblViewStudentAddCourse.setText("Lägg till kurs");

        comboBoxViewStudentAddCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnViewStudentAddCourse.setText("Lägg till");

        tblStudentsFinishedCourses.setAutoCreateRowSorter(true);
        tblStudentsFinishedCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblStudentsFinishedCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblStudentsFinishedCourses.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblStudentsFinishedCoursesFocusLost(evt);
            }
        });
        scrollPanePassedCourses.setViewportView(tblStudentsFinishedCourses);

        tblSelectedStudentsUnfinishedCourses.setAutoCreateRowSorter(true);
        tblSelectedStudentsUnfinishedCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSelectedStudentsUnfinishedCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSelectedStudentsUnfinishedCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelectedStudentsUnfinishedCoursesMouseClicked(evt);
            }
        });
        tblSelectedStudentsUnfinishedCourses.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblSelectedStudentsUnfinishedCoursesFocusLost(evt);
            }
        });
        scrollPanesFinishedCourses.setViewportView(tblSelectedStudentsUnfinishedCourses);

        buttonGroupStudent.add(rbtnDeleteStudent);
        rbtnDeleteStudent.setText("Radera student");
        rbtnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDeleteStudentActionPerformed(evt);
            }
        });

        buttonGroupStudent.add(rbtnRegisterStudent);
        rbtnRegisterStudent.setSelected(true);
        rbtnRegisterStudent.setText("Registrera student");
        rbtnRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRegisterStudentActionPerformed(evt);
            }
        });

        btnDeleteRegisterStudent.setText("OK");
        btnDeleteRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRegisterStudentActionPerformed(evt);
            }
        });

        lblRegisterCourseResult.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblRegisterCourseResult.setText("Registrera kursresultat");

        comboBoxRegisterCourseResult.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "U" }));

        btnRegisterCourseResult.setText("OK");
        btnRegisterCourseResult.setEnabled(false);
        btnRegisterCourseResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCourseResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlViewStudentLayout = new javax.swing.GroupLayout(pnlViewStudent);
        pnlViewStudent.setLayout(pnlViewStudentLayout);
        pnlViewStudentLayout.setHorizontalGroup(
            pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblViewStudentAddCourse, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addComponent(comboBoxViewStudentAddCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewStudentAddCourse))
                    .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlViewStudentLayout.createSequentialGroup()
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblViewStudentAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblViewStudentPostCode, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addComponent(lblViewStudentCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(15, 15, 15)
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtViewStudentAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewStudentPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewStudentLayout.createSequentialGroup()
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(73, 73, 73)
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rbtnDeleteStudent)
                                .addComponent(rbtnRegisterStudent))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDeleteRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewStudentLayout.createSequentialGroup()
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegisterCourseResult))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlViewStudentLayout.createSequentialGroup()
                        .addComponent(lblViewStudentNonPassedCourses)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPanesFinishedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViewStudentPassedCourses)
                    .addComponent(scrollPanePassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlViewStudentLayout.setVerticalGroup(
            pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPersonNbr)
                            .addComponent(lblViewStudentAdress)
                            .addComponent(txtViewStudentAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentFirstName)
                            .addComponent(lblViewStudentPostCode)
                            .addComponent(txtViewStudentPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentLastName)))
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentCity))))
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblViewStudentPhoneNbr)
                                .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnDeleteStudent, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail)
                            .addComponent(rbtnRegisterStudent)))
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnDeleteRegisterStudent)))
                .addGap(29, 29, 29)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewStudentAddCourse)
                    .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewStudentAddCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewStudentNonPassedCourses)
                    .addComponent(lblViewStudentPassedCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addComponent(scrollPanesFinishedCourses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegisterCourseResult)
                            .addComponent(comboBoxRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRegisterCourseResult)))
                    .addComponent(scrollPanePassedCourses))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlStudentsLayout = new javax.swing.GroupLayout(pnlStudents);
        pnlStudents.setLayout(pnlStudentsLayout);
        pnlStudentsLayout.setHorizontalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlFindStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlViewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStudentsLayout.setVerticalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFindStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlViewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Studenter", pnlStudents);

        pnlCourse.setPreferredSize(new java.awt.Dimension(500, 753));

        pnlFindCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Sök kurs"));
        pnlFindCourse.setToolTipText("");

        lblFindCourseInput.setText("Kursnamn/Kurskod:");
        lblFindCourseInput.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnFindCourse.setText("Sök");
        btnFindCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCourseActionPerformed(evt);
            }
        });

        tableFindCourse.setAutoCreateRowSorter(true);
        tableFindCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableFindCourse.setName(""); // NOI18N
        tableFindCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableFindCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFindCourseMouseClicked(evt);
            }
        });
        scrollPaneFindCourse.setViewportView(tableFindCourse);

        javax.swing.GroupLayout pnlFindCourseLayout = new javax.swing.GroupLayout(pnlFindCourse);
        pnlFindCourse.setLayout(pnlFindCourseLayout);
        pnlFindCourseLayout.setHorizontalGroup(
            pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindCourseLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFindCourseInput)
                .addGap(6, 6, 6)
                .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnFindCourse)
                .addGap(113, 142, Short.MAX_VALUE))
            .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlFindCourseLayout.setVerticalGroup(
            pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindCourseLayout.createSequentialGroup()
                .addGroup(pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCourse)
                    .addComponent(lblFindCourseInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pnlShowCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Visa/registrera kurs"));

        lblViewCourseCourseCode.setText("Kurskod");

        lblViewCourseCourseName.setText("Benämning");

        lblViewCourseCredits.setText("HP");

        pnlCourseResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Kursresultat"));

        lblViewCoursePassedStudents.setText("Studenter med avslutad kurs");

        lblViewCourseStudentsWithA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewCourseStudentsWithA.setText("Andel studenter med betyg A:");

        lblViewCourseNonPassedStudents.setText("Studenter med ej avslutad kurs");

        tblFinishedStudentsOnCourse.setAutoCreateRowSorter(true);
        tblFinishedStudentsOnCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFinishedStudentsOnCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPaneStudentsOnCourse.setViewportView(tblFinishedStudentsOnCourse);

        tblNotFinishedStudentsOnCourse.setAutoCreateRowSorter(true);
        tblNotFinishedStudentsOnCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNotFinishedStudentsOnCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPaneNotFInishedStudentsOnCourse.setViewportView(tblNotFinishedStudentsOnCourse);

        javax.swing.GroupLayout pnlCourseResultsLayout = new javax.swing.GroupLayout(pnlCourseResults);
        pnlCourseResults.setLayout(pnlCourseResultsLayout);
        pnlCourseResultsLayout.setHorizontalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addGap(0, 601, Short.MAX_VALUE)
                .addComponent(lblViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneNotFInishedStudentsOnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseNonPassedStudents))
                .addGap(6, 6, 6)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneStudentsOnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                        .addComponent(lblViewCoursePassedStudents)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlCourseResultsLayout.setVerticalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCoursePassedStudents)
                    .addComponent(lblViewCourseNonPassedStudents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneNotFInishedStudentsOnCourse)
                    .addComponent(scrollPaneStudentsOnCourse))
                .addGap(11, 11, 11)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseStudentsWithA)))
        );

        buttonGroupCourse.add(rbtnRegisterCourse);
        rbtnRegisterCourse.setSelected(true);
        rbtnRegisterCourse.setText("Registrera kurs");
        rbtnRegisterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRegisterCourseActionPerformed(evt);
            }
        });

        buttonGroupCourse.add(rbtnDeleteCourse);
        rbtnDeleteCourse.setText("Radera kurs");
        rbtnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDeleteCourseActionPerformed(evt);
            }
        });

        btnDeleteRegisterCourse.setText("OK");
        btnDeleteRegisterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRegisterCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlShowCourseLayout = new javax.swing.GroupLayout(pnlShowCourse);
        pnlShowCourse.setLayout(pnlShowCourseLayout);
        pnlShowCourseLayout.setHorizontalGroup(
            pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlShowCourseLayout.createSequentialGroup()
                            .addComponent(lblViewCourseCourseCode)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShowCourseLayout.createSequentialGroup()
                            .addComponent(lblViewCourseCourseName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addComponent(lblViewCourseCredits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnRegisterCourse)
                            .addComponent(rbtnDeleteCourse)
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnDeleteRegisterCourse)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addComponent(pnlCourseResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlShowCourseLayout.setVerticalGroup(
            pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViewCourseCourseCode)
                    .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnDeleteCourse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseCourseName)
                    .addComponent(rbtnRegisterCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseCredits)
                    .addComponent(btnDeleteRegisterCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCourseResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHighestPassedCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Kurser med höst genomströmning"));

        tblCourseFlow.setAutoCreateRowSorter(true);
        tblCourseFlow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCourseFlow.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPaneCourseFlow.setViewportView(tblCourseFlow);

        javax.swing.GroupLayout pnlHighestPassedCourseLayout = new javax.swing.GroupLayout(pnlHighestPassedCourse);
        pnlHighestPassedCourse.setLayout(pnlHighestPassedCourseLayout);
        pnlHighestPassedCourseLayout.setHorizontalGroup(
            pnlHighestPassedCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneCourseFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlHighestPassedCourseLayout.setVerticalGroup(
            pnlHighestPassedCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHighestPassedCourseLayout.createSequentialGroup()
                .addComponent(scrollPaneCourseFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCourseLayout = new javax.swing.GroupLayout(pnlCourse);
        pnlCourse.setLayout(pnlCourseLayout);
        pnlCourseLayout.setHorizontalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFindCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHighestPassedCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlShowCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCourseLayout.setVerticalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlShowCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(pnlFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlHighestPassedCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Kurser", pnlCourse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="GUI event handling auto generated methods">
    private void btnFindStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindStudentActionPerformed

        String searchString = this.txtFindStudentQuery.getText();
        TableModel dtm = controller.findStudents(searchString);
        this.tblFindStudent.setModel(dtm);

    }//GEN-LAST:event_btnFindStudentActionPerformed

    private void tableFindCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFindCourseMouseClicked

        int row = tableFindCourse.getSelectedRow();
        String ccode = (tableFindCourse.getModel().getValueAt(row, 0).toString());
        String cname = (tableFindCourse.getModel().getValueAt(row, 1).toString());
        String points = (tableFindCourse.getModel().getValueAt(row, 2).toString());
        txtViewCourseCode.setText(ccode);
        txtViewCourseName.setText(cname);
        txtViewCourseCredits.setText(points);
        this.setSelectedCourse(ccode);
        controller.percentageWithGradeAOnCourse(ccode);
        
        
     
        


    }//GEN-LAST:event_tableFindCourseMouseClicked

    private void btnFindCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCourseActionPerformed

        String searchString = this.txtFindCourseInput.getText();
        TableModel dtm = controller.findCourses(searchString);
        this.tableFindCourse.setModel(dtm);

    }//GEN-LAST:event_btnFindCourseActionPerformed

    private void tblFindStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFindStudentMouseClicked
        // TODO add your handling code here:

        int row = tblFindStudent.getSelectedRow();

        String pnr = (tblFindStudent.getModel().getValueAt(row, 0).toString());
        String firstname = (tblFindStudent.getModel().getValueAt(row, 1).toString());
        String lastname = (tblFindStudent.getModel().getValueAt(row, 2).toString());
        String phonenbr = (tblFindStudent.getModel().getValueAt(row, 3).toString());
        String email = (tblFindStudent.getModel().getValueAt(row, 4).toString());
        String address = (tblFindStudent.getModel().getValueAt(row, 5).toString());
        String postcode = (tblFindStudent.getModel().getValueAt(row, 6).toString());
        String city = (tblFindStudent.getModel().getValueAt(row, 7).toString());

        txtViewStudentPersonNbr.setText(pnr);
        txtViewStudentFirstName.setText(firstname);
        txtViewStudentLastName.setText(lastname);
        txtViewStudentPhoneNbr.setText(phonenbr);
        txtViewStudentEmail.setText(email);
        txtViewStudentAdress.setText(address);
        txtViewStudentPostCode.setText(postcode);
        txtViewStudentCity.setText(city);

        this.setSelectedStudent(pnr);

        this.rbtnDeleteStudent.doClick();

    }//GEN-LAST:event_tblFindStudentMouseClicked

    private void rbtnRegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRegisterCourseActionPerformed

        this.txtViewCourseCode.setEditable(true);
        this.txtViewCourseName.setEditable(true);
        this.txtViewCourseCredits.setEditable(true);

        this.txtViewCourseCode.setText("");
        this.txtViewCourseName.setText("");
        this.txtViewCourseCredits.setText("");

    }//GEN-LAST:event_rbtnRegisterCourseActionPerformed

    private void rbtnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDeleteCourseActionPerformed


    }//GEN-LAST:event_rbtnDeleteCourseActionPerformed

    private void btnDeleteRegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRegisterCourseActionPerformed

        if (this.rbtnRegisterCourse.isSelected()) {
            String[] courseData = new String[3];

            courseData[0] = this.txtViewCourseCode.getText();
            courseData[1] = this.txtViewCourseName.getText();
            courseData[2] = this.txtViewCourseCredits.getText();

            if (controller.checkIfCourseExists(courseData[0]) == false) {

                this.controller.registerNewCourse(courseData);

            } else {

                JOptionPane.showMessageDialog(this,
                        "Kurs existerar redan. Kurskod " + courseData[0] + " finns redan i databasen.",
                        "Kan inte skapa kurs.",
                        JOptionPane.ERROR_MESSAGE);

            }
        } else if (this.rbtnDeleteCourse.isSelected()) {

            String courseCode = this.txtViewCourseCode.getText();
            this.controller.deleteCourse(courseCode);

            JOptionPane.showMessageDialog(this,
                    "Kurs " + courseCode + " är nu borttagen ur systemet.",
                    "Kurs raderad",
                    JOptionPane.INFORMATION_MESSAGE);

            this.populateCourseTable();

        }


    }//GEN-LAST:event_btnDeleteRegisterCourseActionPerformed

    private void rbtnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDeleteStudentActionPerformed

        txtViewStudentPersonNbr.setEditable(false);
        txtViewStudentFirstName.setEditable(false);
        txtViewStudentLastName.setEditable(false);
        txtViewStudentPhoneNbr.setEditable(false);
        txtViewStudentEmail.setEditable(false);
        txtViewStudentAdress.setEditable(false);
        txtViewStudentPostCode.setEditable(false);
        txtViewStudentCity.setEditable(false);

    }//GEN-LAST:event_rbtnDeleteStudentActionPerformed

    private void btnDeleteRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRegisterStudentActionPerformed

        if (this.rbtnRegisterStudent.isSelected()) {
            String[] studentData = new String[8];

            studentData[0] = this.txtViewStudentPersonNbr.getText();
            studentData[1] = this.txtViewStudentFirstName.getText();
            studentData[2] = this.txtViewStudentLastName.getText();
            studentData[3] = this.txtViewStudentPhoneNbr.getText();
            studentData[4] = this.txtViewStudentEmail.getText();
            studentData[5] = this.txtViewStudentAdress.getText();
            studentData[6] = this.txtViewStudentPostCode.getText();
            studentData[7] = this.txtViewStudentCity.getText();

            if (controller.checkIfStudentExists(studentData[0]) == false) {

                this.controller.registerNewStudent(studentData);

            } else {

                JOptionPane.showMessageDialog(this,
                        "Student existerar redan. Personummer " + studentData[0] + " är inte unikt.",
                        "Kan inte registrera student",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (this.rbtnDeleteStudent.isSelected()) {

            String personNbr = this.txtViewStudentPersonNbr.getText();
            this.controller.deleteStudent(personNbr);

            JOptionPane.showMessageDialog(this,
                    "Student med " + personNbr + " är nu borttagen ur systemet.",
                    "Student raderad",
                    JOptionPane.INFORMATION_MESSAGE);
            this.populateStudentTable();
        }

    }//GEN-LAST:event_btnDeleteRegisterStudentActionPerformed

    private void rbtnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRegisterStudentActionPerformed

        txtViewStudentPersonNbr.setText("");
        txtViewStudentFirstName.setText("");
        txtViewStudentLastName.setText("");
        txtViewStudentPhoneNbr.setText("");
        txtViewStudentEmail.setText("");
        txtViewStudentAdress.setText("");
        txtViewStudentPostCode.setText("");
        txtViewStudentCity.setText("");

        txtViewStudentPersonNbr.setEditable(true);
        txtViewStudentFirstName.setEditable(true);
        txtViewStudentLastName.setEditable(true);
        txtViewStudentPhoneNbr.setEditable(true);
        txtViewStudentEmail.setEditable(true);
        txtViewStudentAdress.setEditable(true);
        txtViewStudentPostCode.setEditable(true);
        txtViewStudentCity.setEditable(true);

    }//GEN-LAST:event_rbtnRegisterStudentActionPerformed

    private void btnRegisterCourseResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCourseResultActionPerformed

        String grade = this.comboBoxRegisterCourseResult.getSelectedItem().toString();

        controller.registerCourseResult(this.selectedCourse, this.selectedStudent, grade);

        this.setSelectedStudent(selectedStudent);

    }//GEN-LAST:event_btnRegisterCourseResultActionPerformed

    private void tblSelectedStudentsUnfinishedCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelectedStudentsUnfinishedCoursesMouseClicked

        int row = this.tblSelectedStudentsUnfinishedCourses.getSelectedRow();
        String courseCode = (tblSelectedStudentsUnfinishedCourses.getModel().getValueAt(row, 1).toString());
        this.setSelectedCourse(courseCode);

        this.btnRegisterCourseResult.setEnabled(true);

    }//GEN-LAST:event_tblSelectedStudentsUnfinishedCoursesMouseClicked

    private void tblSelectedStudentsUnfinishedCoursesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblSelectedStudentsUnfinishedCoursesFocusLost

    }//GEN-LAST:event_tblSelectedStudentsUnfinishedCoursesFocusLost

    private void tblStudentsFinishedCoursesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblStudentsFinishedCoursesFocusLost

    }//GEN-LAST:event_tblStudentsFinishedCoursesFocusLost
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GUI variable declarations auto generated code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRegisterCourse;
    private javax.swing.JButton btnDeleteRegisterStudent;
    private javax.swing.JButton btnFindCourse;
    private javax.swing.JButton btnFindStudent;
    private javax.swing.JButton btnRegisterCourseResult;
    private javax.swing.JButton btnViewStudentAddCourse;
    private javax.swing.ButtonGroup buttonGroupCourse;
    private javax.swing.ButtonGroup buttonGroupStudent;
    private javax.swing.JComboBox comboBoxRegisterCourseResult;
    private javax.swing.JComboBox comboBoxViewStudentAddCourse;
    private javax.swing.JLabel lblFindCourseInput;
    private javax.swing.JLabel lblFindStudent;
    private javax.swing.JLabel lblRegisterCourseResult;
    private javax.swing.JLabel lblViewCourseCourseCode;
    private javax.swing.JLabel lblViewCourseCourseName;
    private javax.swing.JLabel lblViewCourseCredits;
    private javax.swing.JLabel lblViewCourseNonPassedStudents;
    private javax.swing.JLabel lblViewCoursePassedStudents;
    private javax.swing.JLabel lblViewCourseStudentsWithA;
    private javax.swing.JLabel lblViewStudentAddCourse;
    private javax.swing.JLabel lblViewStudentAdress;
    private javax.swing.JLabel lblViewStudentCity;
    private javax.swing.JLabel lblViewStudentEmail;
    private javax.swing.JLabel lblViewStudentFirstName;
    private javax.swing.JLabel lblViewStudentLastName;
    private javax.swing.JLabel lblViewStudentNonPassedCourses;
    private javax.swing.JLabel lblViewStudentPassedCourses;
    private javax.swing.JLabel lblViewStudentPersonNbr;
    private javax.swing.JLabel lblViewStudentPhoneNbr;
    private javax.swing.JLabel lblViewStudentPostCode;
    private javax.swing.JPanel pnlCourse;
    private javax.swing.JPanel pnlCourseResults;
    private javax.swing.JPanel pnlFindCourse;
    private javax.swing.JPanel pnlFindStudents;
    private javax.swing.JPanel pnlHighestPassedCourse;
    private javax.swing.JPanel pnlShowCourse;
    private javax.swing.JPanel pnlStudents;
    private javax.swing.JPanel pnlViewStudent;
    private javax.swing.JRadioButton rbtnDeleteCourse;
    private javax.swing.JRadioButton rbtnDeleteStudent;
    private javax.swing.JRadioButton rbtnRegisterCourse;
    private javax.swing.JRadioButton rbtnRegisterStudent;
    private javax.swing.JScrollPane scrollPaneCourseFlow;
    private javax.swing.JScrollPane scrollPaneFindCourse;
    private javax.swing.JScrollPane scrollPaneFindStudent;
    private javax.swing.JScrollPane scrollPaneNotFInishedStudentsOnCourse;
    private javax.swing.JScrollPane scrollPanePassedCourses;
    private javax.swing.JScrollPane scrollPaneStudentsOnCourse;
    private javax.swing.JScrollPane scrollPanesFinishedCourses;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableFindCourse;
    private javax.swing.JTable tblCourseFlow;
    private javax.swing.JTable tblFindStudent;
    private javax.swing.JTable tblFinishedStudentsOnCourse;
    private javax.swing.JTable tblNotFinishedStudentsOnCourse;
    private javax.swing.JTable tblSelectedStudentsUnfinishedCourses;
    private javax.swing.JTable tblStudentsFinishedCourses;
    private javax.swing.JTextField txtFindCourseInput;
    private javax.swing.JTextField txtFindStudentQuery;
    private javax.swing.JTextField txtViewCourseCode;
    private javax.swing.JTextField txtViewCourseCredits;
    private javax.swing.JTextField txtViewCourseName;
    private javax.swing.JTextField txtViewCourseStudentsWithA;
    private javax.swing.JTextField txtViewStudentAdress;
    private javax.swing.JTextField txtViewStudentCity;
    private javax.swing.JTextField txtViewStudentEmail;
    private javax.swing.JTextField txtViewStudentFirstName;
    private javax.swing.JTextField txtViewStudentLastName;
    private javax.swing.JTextField txtViewStudentPersonNbr;
    private javax.swing.JTextField txtViewStudentPhoneNbr;
    private javax.swing.JTextField txtViewStudentPostCode;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
