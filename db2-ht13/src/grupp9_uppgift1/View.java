package grupp9_uppgift1;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.Timestamp;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
     *
     * @param controller Handles communication with database.
     */
    public View(Controller controller) {

        this.controller = controller;

        this.initComponents();

        this.setSelectedStudent(null);

        this.setSelectedCourse(null);

    }

    private void setSelectedStudent(String selectedStudent) {

        this.selectedStudent = selectedStudent;

        this.btnRegisterCourseResult.setEnabled(false);
        this.btnDeleteStudentFromCourse.setEnabled(false);

        if (selectedStudent != null) {

            this.setSelectedCourse(null);

            this.tabbedPane.setSelectedIndex(0);

            this.populateStudentsCurrentAndPastCourses(selectedStudent);

            this.populateComboBoxAddCourse(selectedStudent);

            this.populateCourseFlowTable();

            this.rbtnDeleteStudent.setEnabled(true);
            this.rbtnDeleteStudent.setSelected(true);

            TableModel tm = controller.getSingleStudent(selectedStudent);
            String firstName = (tm.getValueAt(0, 1).toString());
            String lastName = (tm.getValueAt(0, 2).toString());
            String phoneNbr = (tm.getValueAt(0, 3).toString());
            String email = (tm.getValueAt(0, 4).toString());
            String address = (tm.getValueAt(0, 5).toString());
            String postCode = (tm.getValueAt(0, 6).toString());
            String city = (tm.getValueAt(0, 7).toString());

            txtViewStudentPersonNbr.setText(selectedStudent);
            txtViewStudentFirstName.setText(firstName);
            txtViewStudentLastName.setText(lastName);
            txtViewStudentPhoneNbr.setText(phoneNbr);
            txtViewStudentEmail.setText(email);
            txtViewStudentAdress.setText(address);
            txtViewStudentPostCode.setText(postCode);
            txtViewStudentCity.setText(city);

            this.txtViewStudentPersonNbr.setEditable(false);
            this.txtViewStudentFirstName.setEditable(false);
            this.txtViewStudentLastName.setEditable(false);
            this.txtViewStudentPhoneNbr.setEditable(false);
            this.txtViewStudentEmail.setEditable(false);
            this.txtViewStudentAdress.setEditable(false);
            this.txtViewStudentPostCode.setEditable(false);
            this.txtViewStudentCity.setEditable(false);

        } else {

            this.populateStudentTable();

            this.clearStudentInformation();

        }
    }

    private void clearStudentInformation() {
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

        this.rbtnRegisterStudent.setSelected(true);
        DefaultTableModel tm = new DefaultTableModel();
        this.tblSelectedStudentsUnfinishedCourses.setModel(tm);
        this.tblStudentsFinishedCourses.setModel(tm);

        this.rbtnDeleteStudent.setEnabled(false);
        this.lblResponsFindStudent.setText("");
        this.lblResponsStudentInformation.setText("");

    }

    private void setSelectedCourse(String selectedCourse) {

        this.populateCoursesPastAndCurrentStudents(selectedCourse);

        if (selectedCourse != null) {

            this.setSelectedStudent(null);

            this.selectedCourse = selectedCourse;

            this.rbtnDeleteCourse.setSelected(true);
            this.rbtnDeleteCourse.setEnabled(true);

            this.txtViewCourseCode.setEditable(false);
            this.txtViewCourseName.setEditable(false);
            this.txtViewCourseCredits.setEditable(false);

        } else {

            this.rbtnDeleteCourse.setEnabled(false);
            this.rbtnRegisterCourse.setSelected(true);

            this.lblResponsFindCourse.setText("");
            this.lblResponsRegisterCourse.setText("");

            this.txtViewCourseCode.setEditable(true);
            this.txtViewCourseName.setEditable(true);
            this.txtViewCourseCredits.setEditable(true);

            this.txtViewCourseCode.setText("");
            this.txtViewCourseName.setText("");
            this.txtViewCourseCredits.setText("");

            this.populateCourseTable();
            this.populateCourseFlowTable();

        }

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

        if (selectedStudent != null) {

            TableModel tm1;
            TableModel tm2;
            tm1 = this.controller.getStudentsCurrentCourses(selectedStudent);
            tm2 = this.controller.getStudentsFinnishedCourses(selectedStudent);
            this.tblSelectedStudentsUnfinishedCourses.setModel(tm1);
            this.tblStudentsFinishedCourses.setModel(tm2);

        } else {

            this.tblSelectedStudentsUnfinishedCourses.setModel(new DefaultTableModel());
            this.tblStudentsFinishedCourses.setModel(new DefaultTableModel());

        }

    }

    private void populateCoursesPastAndCurrentStudents(String selectedCourse) {

        TableModel tm1;
        TableModel tm2;
        tm1 = this.controller.getPastStudentsOnCourse(selectedCourse);
        tm2 = this.controller.getCurrentStudentsOnCourse(selectedCourse);
        this.tblFinishedStudentsOnCourse.setModel(tm1);
        this.tblNotFinishedStudentsOnCourse.setModel(tm2);

    }

    private void populateComboBoxAddCourse(String selectedStudent) {

        String[] comboBoxList = new String[0];

        if (selectedStudent != null) {

            comboBoxList = controller.getCoursesThatCanBeAddedToStudent(selectedStudent);

        }

        this.comboBoxViewStudentAddCourse.setModel(new DefaultComboBoxModel(comboBoxList));

        if (comboBoxList.length > 0) {
            this.btnViewStudentAddCourse.setEnabled(true);
        } else {
            this.btnViewStudentAddCourse.setEnabled(false);
        }
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
        checkShowAllAttributes = new javax.swing.JCheckBox();
        lblResponsFindStudent = new javax.swing.JLabel();
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
        lblResponsStudentInformation = new javax.swing.JLabel();
        btnDeleteStudentFromCourse = new javax.swing.JButton();
        lblDeleteStudentFromCourse = new javax.swing.JLabel();
        pnlCourse = new javax.swing.JPanel();
        pnlFindCourse = new javax.swing.JPanel();
        txtFindCourseInput = new javax.swing.JTextField();
        lblFindCourseInput = new javax.swing.JLabel();
        btnFindCourse = new javax.swing.JButton();
        scrollPaneFindCourse = new javax.swing.JScrollPane();
        tableFindCourse = new javax.swing.JTable();
        lblResponsFindCourse = new javax.swing.JLabel();
        pnlShowCourse = new javax.swing.JPanel();
        lblViewCourseCourseCode = new javax.swing.JLabel();
        txtViewCourseCode = new javax.swing.JTextField();
        txtViewCourseName = new javax.swing.JTextField();
        txtViewCourseCredits = new javax.swing.JTextField();
        lblViewCourseCourseName = new javax.swing.JLabel();
        lblViewCourseCredits = new javax.swing.JLabel();
        pnlCourseResults = new javax.swing.JPanel();
        lblViewCoursePassedStudents = new javax.swing.JLabel();
        lblViewCourseNonPassedStudents = new javax.swing.JLabel();
        scrollPaneStudentsOnCourse = new javax.swing.JScrollPane();
        tblFinishedStudentsOnCourse = new javax.swing.JTable();
        scrollPaneNotFInishedStudentsOnCourse = new javax.swing.JScrollPane();
        tblNotFinishedStudentsOnCourse = new javax.swing.JTable();
        rbtnRegisterCourse = new javax.swing.JRadioButton();
        rbtnDeleteCourse = new javax.swing.JRadioButton();
        btnDeleteRegisterCourse = new javax.swing.JButton();
        lblResponsRegisterCourse = new javax.swing.JLabel();
        lblViewCourseStudentsWithA = new javax.swing.JLabel();
        txtViewCourseStudentsWithA = new javax.swing.JTextField();
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

        checkShowAllAttributes.setText("visa fullständig information i sökresultatet");

        lblResponsFindStudent.setForeground(new java.awt.Color(255, 0, 0));
        lblResponsFindStudent.setText("jLabel1");

        javax.swing.GroupLayout pnlFindStudentsLayout = new javax.swing.GroupLayout(pnlFindStudents);
        pnlFindStudents.setLayout(pnlFindStudentsLayout);
        pnlFindStudentsLayout.setHorizontalGroup(
            pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFindStudentsLayout.createSequentialGroup()
                .addComponent(scrollPaneFindStudent)
                .addContainerGap())
            .addGroup(pnlFindStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFindStudent)
                .addGap(6, 6, 6)
                .addGroup(pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkShowAllAttributes)
                    .addGroup(pnlFindStudentsLayout.createSequentialGroup()
                        .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnFindStudent)
                        .addGap(18, 18, 18)
                        .addComponent(lblResponsFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFindStudentsLayout.setVerticalGroup(
            pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindStudentsLayout.createSequentialGroup()
                .addGroup(pnlFindStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFindStudent)
                    .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindStudent)
                    .addComponent(lblResponsFindStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkShowAllAttributes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
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

        lblViewStudentPassedCourses.setText("Avslutade kurser:");

        lblViewStudentNonPassedCourses.setText("Nuvarande kurser");

        lblViewStudentAddCourse.setText("Lägg till kurs");

        btnViewStudentAddCourse.setText("Lägg till");
        btnViewStudentAddCourse.setEnabled(false);
        btnViewStudentAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentAddCourseActionPerformed(evt);
            }
        });

        scrollPanePassedCourses.setPreferredSize(new java.awt.Dimension(450, 600));

        tblStudentsFinishedCourses.setAutoCreateRowSorter(true);
        tblStudentsFinishedCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblStudentsFinishedCourses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        scrollPanePassedCourses.setViewportView(tblStudentsFinishedCourses);

        scrollPanesFinishedCourses.setPreferredSize(new java.awt.Dimension(100, 100));
        scrollPanesFinishedCourses.setVerifyInputWhenFocusTarget(false);

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
        scrollPanesFinishedCourses.setViewportView(tblSelectedStudentsUnfinishedCourses);

        buttonGroupStudent.add(rbtnDeleteStudent);
        rbtnDeleteStudent.setText("Avregistrera student");

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

        lblResponsStudentInformation.setForeground(new java.awt.Color(255, 0, 0));
        lblResponsStudentInformation.setText("jLabel1");

        btnDeleteStudentFromCourse.setText("OK");
        btnDeleteStudentFromCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentFromCourseActionPerformed(evt);
            }
        });

        lblDeleteStudentFromCourse.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDeleteStudentFromCourse.setText("Avregistrera student från kurs");

        javax.swing.GroupLayout pnlViewStudentLayout = new javax.swing.GroupLayout(pnlViewStudent);
        pnlViewStudent.setLayout(pnlViewStudentLayout);
        pnlViewStudentLayout.setHorizontalGroup(
            pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addComponent(btnDeleteRegisterStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblResponsStudentInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanePassedCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPanesFinishedCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblViewStudentPassedCourses)
                                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                                        .addComponent(lblViewStudentAddCourse)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnViewStudentAddCourse))
                                    .addComponent(lblViewStudentNonPassedCourses)
                                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                                        .addComponent(lblRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRegisterCourseResult)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblDeleteStudentFromCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeleteStudentFromCourse)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResponsStudentInformation)
                .addGap(27, 27, 27)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewStudentAddCourse)
                    .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewStudentAddCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblViewStudentNonPassedCourses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanesFinishedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxRegisterCourseResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRegisterCourseResult)
                    .addComponent(btnRegisterCourseResult)
                    .addComponent(lblDeleteStudentFromCourse)
                    .addComponent(btnDeleteStudentFromCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblViewStudentPassedCourses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlStudentsLayout = new javax.swing.GroupLayout(pnlStudents);
        pnlStudents.setLayout(pnlStudentsLayout);
        pnlStudentsLayout.setHorizontalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlFindStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlViewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStudentsLayout.setVerticalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFindStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlViewStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        lblResponsFindCourse.setForeground(new java.awt.Color(255, 0, 0));
        lblResponsFindCourse.setText("jLabel1");

        javax.swing.GroupLayout pnlFindCourseLayout = new javax.swing.GroupLayout(pnlFindCourse);
        pnlFindCourse.setLayout(pnlFindCourseLayout);
        pnlFindCourseLayout.setHorizontalGroup(
            pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindCourseLayout.createSequentialGroup()
                .addGroup(pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlFindCourseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblResponsFindCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFindCourseLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFindCourseInput)
                        .addGap(6, 6, 6)
                        .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnFindCourse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlFindCourseLayout.setVerticalGroup(
            pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFindCourseLayout.createSequentialGroup()
                .addGroup(pnlFindCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCourse)
                    .addComponent(lblFindCourseInput))
                .addGap(4, 4, 4)
                .addComponent(lblResponsFindCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        pnlShowCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Visa/registrera kurs"));

        lblViewCourseCourseCode.setText("Kurskod");

        lblViewCourseCourseName.setText("Benämning");

        lblViewCourseCredits.setText("HP");

        pnlCourseResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Kursresultat"));

        lblViewCoursePassedStudents.setText("Studenter med avslutad kurs");

        lblViewCourseNonPassedStudents.setText("Studenter med ej avslutad kurs");

        scrollPaneStudentsOnCourse.setPreferredSize(new java.awt.Dimension(450, 400));

        tblFinishedStudentsOnCourse.setAutoCreateRowSorter(true);
        tblFinishedStudentsOnCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFinishedStudentsOnCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblFinishedStudentsOnCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFinishedStudentsOnCourseMouseClicked(evt);
            }
        });
        scrollPaneStudentsOnCourse.setViewportView(tblFinishedStudentsOnCourse);

        scrollPaneNotFInishedStudentsOnCourse.setPreferredSize(new java.awt.Dimension(450, 400));

        tblNotFinishedStudentsOnCourse.setAutoCreateRowSorter(true);
        tblNotFinishedStudentsOnCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNotFinishedStudentsOnCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblNotFinishedStudentsOnCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotFinishedStudentsOnCourseMouseClicked(evt);
            }
        });
        scrollPaneNotFInishedStudentsOnCourse.setViewportView(tblNotFinishedStudentsOnCourse);

        javax.swing.GroupLayout pnlCourseResultsLayout = new javax.swing.GroupLayout(pnlCourseResults);
        pnlCourseResults.setLayout(pnlCourseResultsLayout);
        pnlCourseResultsLayout.setHorizontalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addComponent(lblViewCourseNonPassedStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblViewCoursePassedStudents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addComponent(scrollPaneNotFInishedStudentsOnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneStudentsOnCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pnlCourseResultsLayout.setVerticalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCoursePassedStudents)
                    .addComponent(lblViewCourseNonPassedStudents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneNotFInishedStudentsOnCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(scrollPaneStudentsOnCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        rbtnDeleteCourse.setText("Ta bort kurs");
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

        lblResponsRegisterCourse.setForeground(new java.awt.Color(255, 0, 0));
        lblResponsRegisterCourse.setText("jLabel1");

        lblViewCourseStudentsWithA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewCourseStudentsWithA.setText("Andel studenter med betyg A:");

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
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnDeleteRegisterCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnRegisterCourse)
                                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                        .addComponent(rbtnDeleteCourse)
                                        .addGap(35, 35, 35)
                                        .addComponent(lblResponsRegisterCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 160, Short.MAX_VALUE))))
                    .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(pnlCourseResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlShowCourseLayout.setVerticalGroup(
            pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViewCourseCourseCode)
                    .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnDeleteCourse)
                        .addComponent(lblResponsRegisterCourse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseCourseName)
                    .addComponent(rbtnRegisterCourse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblViewCourseStudentsWithA))
                    .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblViewCourseCredits)
                        .addComponent(btnDeleteRegisterCourse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCourseResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHighestPassedCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Kurser med högst genomströmning"));

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
                .addContainerGap()
                .addComponent(scrollPaneCourseFlow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCourseLayout = new javax.swing.GroupLayout(pnlCourse);
        pnlCourse.setLayout(pnlCourseLayout);
        pnlCourseLayout.setHorizontalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHighestPassedCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFindCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlShowCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCourseLayout.setVerticalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlShowCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(pnlFindCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlHighestPassedCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="GUI event handling auto generated methods">
    private void btnFindStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindStudentActionPerformed
        boolean showAllAttributes = this.checkShowAllAttributes.isSelected();
        String searchString = this.txtFindStudentQuery.getText();
        this.clearStudentInformation();

        if (searchString.contains("'")) {
            this.lblResponsFindStudent.setForeground(Color.red);
            this.lblResponsFindStudent.setText("Söktermen får inte innehålla: [ ' ]");
        } else {

            TableModel tm = controller.findStudents(showAllAttributes, searchString);
            this.tblFindStudent.setModel(tm);
            this.lblResponsFindStudent.setForeground(Color.black);
            this.lblResponsFindStudent.setText("Följande studenters information matchade söktermen: ");

            this.getEventResponseTime(evt);
        }


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
        float percentageWithGradeAOnCourse = controller.percentageWithGradeAOnCourse(ccode);
        String percent = Float.toString(percentageWithGradeAOnCourse);

        if (percent.length() >= 5) {
            txtViewCourseStudentsWithA.setText(percent.substring(0, 5) + "%");
        } else if (percent.length() >= 4) {
            txtViewCourseStudentsWithA.setText(percent.substring(0, 4) + "%");
        } else {
            txtViewCourseStudentsWithA.setText("0,00 %");
        }


    }//GEN-LAST:event_tableFindCourseMouseClicked

    private void btnFindCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCourseActionPerformed

        this.lblResponsRegisterCourse.setText("");
        this.lblResponsFindCourse.setText("");

        String searchString = this.txtFindCourseInput.getText();
        if (searchString.contains("'")) {
            this.lblResponsFindCourse.setText("Söktermen får inte innehålla: [ ' ]");
        } else {
            TableModel tm = controller.findCourses(searchString);
            this.tableFindCourse.setModel(tm);
        }
    }//GEN-LAST:event_btnFindCourseActionPerformed

    private void tblFindStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFindStudentMouseClicked

        int row = tblFindStudent.getSelectedRow();
        String pnr = (tblFindStudent.getModel().getValueAt(row, 0).toString());
        this.clearStudentInformation();
        this.setSelectedStudent(pnr);

    }//GEN-LAST:event_tblFindStudentMouseClicked

    private void rbtnRegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRegisterCourseActionPerformed

        this.setSelectedCourse(null);

    }//GEN-LAST:event_rbtnRegisterCourseActionPerformed

    private void rbtnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDeleteCourseActionPerformed


    }//GEN-LAST:event_rbtnDeleteCourseActionPerformed

    private void btnDeleteRegisterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRegisterCourseActionPerformed

        this.lblResponsRegisterCourse.setText("");
        this.lblResponsFindCourse.setText("");

        if (this.rbtnRegisterCourse.isSelected()) {

            String[] courseData = new String[3];

            courseData[0] = this.txtViewCourseCode.getText();
            courseData[1] = this.txtViewCourseName.getText();
            courseData[2] = this.txtViewCourseCredits.getText();

            if (this.controller.stringContainsIllegalCharacters(courseData)) {

                this.lblResponsRegisterCourse.setText("[ ' ] är inte ett tillåtet tecken");

            } else if (this.controller.checkIfCourseExists(courseData[0])) {

                JOptionPane.showMessageDialog(this,
                        "Kurs existerar redan. Kurskod " + courseData[0] + " finns redan i databasen.",
                        "Kan inte skapa kurs.",
                        JOptionPane.ERROR_MESSAGE);

            } else if (courseData[0].length() != 6) {

                this.lblResponsRegisterCourse.setText("Kurskod måste bestå av exakt sex tacken.");

            } else if (!courseData[2].matches("[0-9]+")) {

                this.lblResponsRegisterCourse.setText("Poäng anges med siffror");

            } else {

                this.controller.registerNewCourse(courseData);
                this.populateCourseTable();
                this.populateCourseFlowTable();
            }

        }
        if (this.rbtnDeleteCourse.isSelected()) {

            String courseCode = this.selectedCourse;
            this.controller.deleteCourse(courseCode);

            JOptionPane.showMessageDialog(this,
                    "Kurs " + courseCode + " är nu borttagen ur systemet.",
                    "Kurs borttagen",
                    JOptionPane.INFORMATION_MESSAGE);

            this.setSelectedCourse(null);
            this.setSelectedStudent(null);
        }

    }//GEN-LAST:event_btnDeleteRegisterCourseActionPerformed

    private void btnDeleteRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRegisterStudentActionPerformed

        if (this.rbtnRegisterStudent.isSelected()) {

            this.lblResponsStudentInformation.setText("");
            this.lblResponsFindStudent.setText("");

            String[] studentData = new String[8];

            studentData[0] = this.txtViewStudentPersonNbr.getText();
            studentData[1] = this.txtViewStudentFirstName.getText();
            studentData[2] = this.txtViewStudentLastName.getText();
            studentData[3] = this.txtViewStudentPhoneNbr.getText();
            studentData[4] = this.txtViewStudentEmail.getText();
            studentData[5] = this.txtViewStudentAdress.getText();
            studentData[6] = this.txtViewStudentPostCode.getText();
            studentData[7] = this.txtViewStudentCity.getText();

            int length = studentData[0].length();

            if (controller.stringContainsIllegalCharacters(studentData)) {

                this.lblResponsStudentInformation.setForeground(Color.red);
                this.lblResponsStudentInformation.setText("Följande tecken får inte användas [ ' ]");

            } else if (!(studentData[0].matches("[0-9]+") && length == 10)) {

                this.lblResponsStudentInformation.setForeground(Color.red);
                this.lblResponsStudentInformation.setText("Personnummer anges med 10 siffror");

            } else if (controller.checkIfStudentExists(studentData[0])) {

                JOptionPane.showMessageDialog(this,
                        "Student existerar redan. Personummer " + studentData[0] + " är inte unikt.",
                        "Kan inte registrera student",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                this.controller.registerNewStudent(studentData);
                this.populateStudentTable();
                this.lblResponsStudentInformation.setForeground(Color.black);
                this.lblResponsStudentInformation.setText("Student med personnummer: " + studentData[0] + " är registrerad");

            }

        }

        if (this.rbtnDeleteStudent.isSelected()) {

            String personNbr = this.txtViewStudentPersonNbr.getText();
            String firstName = this.txtViewStudentFirstName.getText();
            String lastName = this.txtViewStudentLastName.getText();
            this.controller.deleteStudent(personNbr);

            JOptionPane.showMessageDialog(this,
                    "Studenten " + firstName + " " + lastName + " med personnummer " + personNbr + " är nu borttagen ur systemet.",
                    "Student avregistrerad",
                    JOptionPane.INFORMATION_MESSAGE);

            this.setSelectedStudent(null);
        }

    }//GEN-LAST:event_btnDeleteRegisterStudentActionPerformed

    private void rbtnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRegisterStudentActionPerformed

        this.setSelectedStudent(null);

    }//GEN-LAST:event_rbtnRegisterStudentActionPerformed

    private void btnRegisterCourseResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCourseResultActionPerformed

        String grade = this.comboBoxRegisterCourseResult.getSelectedItem().toString();
        int row = this.tblSelectedStudentsUnfinishedCourses.getSelectedRow();
        String courseToGrade = (tblSelectedStudentsUnfinishedCourses.getModel().getValueAt(row, 1).toString());

        controller.registerCourseResult(courseToGrade, this.selectedStudent, grade);

        this.setSelectedStudent(selectedStudent);


    }//GEN-LAST:event_btnRegisterCourseResultActionPerformed

    private void tblSelectedStudentsUnfinishedCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelectedStudentsUnfinishedCoursesMouseClicked

        this.btnRegisterCourseResult.setEnabled(true);
        this.btnDeleteStudentFromCourse.setEnabled(true);

    }//GEN-LAST:event_tblSelectedStudentsUnfinishedCoursesMouseClicked

    private void btnViewStudentAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentAddCourseActionPerformed

        String courseId = this.comboBoxViewStudentAddCourse.getSelectedItem().toString();
        courseId = courseId.substring(0, 6);

        if (controller.checkIfCourseCanBeAddedToStudent(courseId, this.selectedStudent)) {

            controller.registerStudentOnCourse(selectedStudent, courseId);
            this.setSelectedStudent(selectedStudent);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Studententen kan inte registreras på fler kurser. Max 45 poäng per student.",
                    "Registrering misslyckades.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewStudentAddCourseActionPerformed

    private void tblFinishedStudentsOnCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFinishedStudentsOnCourseMouseClicked

        int row = tblFinishedStudentsOnCourse.getSelectedRow();
        String personNbr = (tblFinishedStudentsOnCourse.getModel().getValueAt(row, 0).toString());
        this.setSelectedStudent(personNbr);

    }//GEN-LAST:event_tblFinishedStudentsOnCourseMouseClicked

    private void btnDeleteStudentFromCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentFromCourseActionPerformed
        // TODO add your handling code here:

        String selectedStudent = this.txtViewStudentPersonNbr.getText();
        int row = this.tblSelectedStudentsUnfinishedCourses.getSelectedRow();
        String selectedCcode = (tblSelectedStudentsUnfinishedCourses.getModel().getValueAt(row, 1).toString());
        this.controller.deleteStudentFromCourse(selectedStudent, selectedCcode);
        this.populateStudentsCurrentAndPastCourses(selectedStudent);
        this.populateComboBoxAddCourse(selectedStudent);
        this.populateCourseFlowTable();

    }//GEN-LAST:event_btnDeleteStudentFromCourseActionPerformed

    private void tblNotFinishedStudentsOnCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotFinishedStudentsOnCourseMouseClicked
        // TODO add your handling code here:

        int row = tblNotFinishedStudentsOnCourse.getSelectedRow();
        String personNbr = (tblNotFinishedStudentsOnCourse.getModel().getValueAt(row, 0).toString());
        this.setSelectedStudent(personNbr);

    }//GEN-LAST:event_tblNotFinishedStudentsOnCourseMouseClicked
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GUI variable declarations auto generated code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRegisterCourse;
    private javax.swing.JButton btnDeleteRegisterStudent;
    private javax.swing.JButton btnDeleteStudentFromCourse;
    private javax.swing.JButton btnFindCourse;
    private javax.swing.JButton btnFindStudent;
    private javax.swing.JButton btnRegisterCourseResult;
    private javax.swing.JButton btnViewStudentAddCourse;
    private javax.swing.ButtonGroup buttonGroupCourse;
    private javax.swing.ButtonGroup buttonGroupStudent;
    private javax.swing.JCheckBox checkShowAllAttributes;
    private javax.swing.JComboBox comboBoxRegisterCourseResult;
    private javax.swing.JComboBox comboBoxViewStudentAddCourse;
    private javax.swing.JLabel lblDeleteStudentFromCourse;
    private javax.swing.JLabel lblFindCourseInput;
    private javax.swing.JLabel lblFindStudent;
    private javax.swing.JLabel lblRegisterCourseResult;
    private javax.swing.JLabel lblResponsFindCourse;
    private javax.swing.JLabel lblResponsFindStudent;
    private javax.swing.JLabel lblResponsRegisterCourse;
    private javax.swing.JLabel lblResponsStudentInformation;
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

    private void getEventResponseTime(ActionEvent evt) {

        long eventTimeStamp = evt.getWhen();

        java.util.Date date = new java.util.Date();

        long currentTimeStamp = new Timestamp(date.getTime()).getTime();

        Component c = (Component) evt.getSource();

        System.out.println(currentTimeStamp - eventTimeStamp);
    }

}
