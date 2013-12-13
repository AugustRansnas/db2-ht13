/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author svalan
 */
public class View extends javax.swing.JFrame {
    
    Controller controller;

    /**
     * Creates new form View
     */
    public View(Controller controller) {
        this.controller = controller;
        this.initComponents();
        this.populateStudentTable();
        this.populateCourseTable();
    }

 
   private void populateCourseTable() {

        TableModel tm;

        tm = controller.getAllCourses();

        System.out.println(tm.getColumnCount());

        this.tableFindCourse.setModel(tm);

    }

    private void populateStudentTable() {

        TableModel dtm;

        dtm = controller.getAllStudents();

        System.out.println(dtm.getColumnCount());

        this.tblFindStudent.setModel(dtm);
        
    
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlStudents = new javax.swing.JPanel();
        lblFindStudent = new javax.swing.JLabel();
        txtFindStudentQuery = new javax.swing.JTextField();
        btnFindStudent = new javax.swing.JButton();
        scrollPaneFindStudent = new javax.swing.JScrollPane();
        tblFindStudent = new javax.swing.JTable();
        separatorFindStudent = new javax.swing.JSeparator();
        lblViewStudentPersonNbr = new javax.swing.JLabel();
        txtViewStudentPersonNbr = new javax.swing.JTextField();
        txtViewStudentFirstName = new javax.swing.JTextField();
        lblViewStudentFirstName = new javax.swing.JLabel();
        lblViewStudentLastName = new javax.swing.JLabel();
        txtViewStudentLastName = new javax.swing.JTextField();
        txtViewStudentPhoneNbr = new javax.swing.JTextField();
        lblViewStudentPhoneNbr = new javax.swing.JLabel();
        lblViewStudentEmail = new javax.swing.JLabel();
        txtViewStudentEmail = new javax.swing.JTextField();
        txtViewStudentAdress = new javax.swing.JTextField();
        txtViewStudentPostCode = new javax.swing.JTextField();
        txtViewStudentCity = new javax.swing.JTextField();
        lblViewStudentPostCode = new javax.swing.JLabel();
        lblViewStudentAdress = new javax.swing.JLabel();
        lblViewStudentCity = new javax.swing.JLabel();
        btnRegisterStudentSave = new javax.swing.JButton();
        btnViewStudentDeleteStudent = new javax.swing.JButton();
        lblViewStudentPassedCourses = new javax.swing.JLabel();
        lblViewStudentNonPassedCourses = new javax.swing.JLabel();
        scrollPaneViewStudentPassedCourses = new javax.swing.JScrollPane();
        txtViewStudentPassedCourses = new javax.swing.JTextArea();
        scrollPaneViewStudentNonPassedCourses = new javax.swing.JScrollPane();
        txtViewStudentNonAreaPassedCourses = new javax.swing.JTextArea();
        comboBoxViewStudentAddCourse = new javax.swing.JComboBox();
        lblViewStudentAddCourse = new javax.swing.JLabel();
        btnViewStudentAddCourse = new javax.swing.JButton();
        pnlCourse = new javax.swing.JPanel();
        lblFindCourseInput = new javax.swing.JLabel();
        txtFindCourseInput = new javax.swing.JTextField();
        btnFindCourse = new javax.swing.JButton();
        scrollPaneFindCourse = new javax.swing.JScrollPane();
        tableFindCourse = new javax.swing.JTable();
        lblViewCourseCourseCode = new javax.swing.JLabel();
        txtViewCourseCode = new javax.swing.JTextField();
        lblViewCourseCourseName = new javax.swing.JLabel();
        txtViewCourseName = new javax.swing.JTextField();
        lblViewCourseCredits = new javax.swing.JLabel();
        txtViewCourseCredits = new javax.swing.JTextField();
        btnViewCourseDeleteCourse = new javax.swing.JButton();
        lblViewCoursePassedStudents = new javax.swing.JLabel();
        scrollPaneViewCoursePassedStudents = new javax.swing.JScrollPane();
        txtAreaViewCoursePassedStudents = new javax.swing.JTextArea();
        lblViewCourseNonPassedStudents = new javax.swing.JLabel();
        scrollPaneViewCourseNonPassedStudents = new javax.swing.JScrollPane();
        txtAreaViewCourseNonPassedStudents = new javax.swing.JTextArea();
        lblViewCourseStudentsWithA = new javax.swing.JLabel();
        txtViewCourseStudentsWithA = new javax.swing.JTextField();
        lblViewCourseHighestPassedCourses = new javax.swing.JLabel();
        scrollPaneViewCourseHighestPassedCourses = new javax.swing.JScrollPane();
        txtViewCourseHighestPassedCourses = new javax.swing.JTextArea();
        btnRegisterCourseSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFindStudent.setText("Sökterm:");

        btnFindStudent.setText("Sök");
        btnFindStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindStudentActionPerformed(evt);
            }
        });

        tblFindStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFindStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFindStudentMouseClicked(evt);
            }
        });
        scrollPaneFindStudent.setViewportView(tblFindStudent);

        lblViewStudentPersonNbr.setText("Personnummer:");

        txtViewStudentPersonNbr.setEditable(false);

        txtViewStudentFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewStudentFirstNameActionPerformed(evt);
            }
        });

        lblViewStudentFirstName.setText("Förnamn:");

        lblViewStudentLastName.setText("Efternamn:");

        lblViewStudentPhoneNbr.setText("Telefonnummer:");

        lblViewStudentEmail.setText("E-post:");

        lblViewStudentPostCode.setText("Postnummer:");

        lblViewStudentAdress.setText("Adress:");

        lblViewStudentCity.setText("Ort:");

        btnRegisterStudentSave.setText("Spara");
        btnRegisterStudentSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStudentSaveActionPerformed(evt);
            }
        });

        btnViewStudentDeleteStudent.setText("Radera");
        btnViewStudentDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentDeleteStudentActionPerformed(evt);
            }
        });

        lblViewStudentPassedCourses.setText("Godkända kurser:");

        lblViewStudentNonPassedCourses.setText("Ej avslutade kurser:");

        txtViewStudentPassedCourses.setColumns(20);
        txtViewStudentPassedCourses.setRows(5);
        scrollPaneViewStudentPassedCourses.setViewportView(txtViewStudentPassedCourses);

        txtViewStudentNonAreaPassedCourses.setColumns(20);
        txtViewStudentNonAreaPassedCourses.setRows(5);
        scrollPaneViewStudentNonPassedCourses.setViewportView(txtViewStudentNonAreaPassedCourses);

        comboBoxViewStudentAddCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblViewStudentAddCourse.setText("Lägg till kurs");

        btnViewStudentAddCourse.setText("Lägg till");

        javax.swing.GroupLayout pnlStudentsLayout = new javax.swing.GroupLayout(pnlStudents);
        pnlStudents.setLayout(pnlStudentsLayout);
        pnlStudentsLayout.setHorizontalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStudentsLayout.createSequentialGroup()
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblViewStudentPersonNbr)
                                    .addComponent(lblViewStudentPhoneNbr)
                                    .addComponent(lblViewStudentEmail)
                                    .addComponent(lblViewStudentFirstName)
                                    .addComponent(lblViewStudentLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtViewStudentFirstName)
                                        .addComponent(txtViewStudentPhoneNbr)
                                        .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblViewStudentAdress)
                                            .addComponent(lblViewStudentCity)))
                                    .addComponent(lblViewStudentPostCode, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                                        .addComponent(btnRegisterStudentSave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnViewStudentDeleteStudent))
                                    .addComponent(txtViewStudentAdress)
                                    .addComponent(txtViewStudentPostCode)
                                    .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlStudentsLayout.createSequentialGroup()
                                .addComponent(lblFindStudent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFindStudent))))
                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewStudentAddCourse)
                            .addGroup(pnlStudentsLayout.createSequentialGroup()
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPaneViewStudentPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewStudentPassedCourses)
                                    .addComponent(lblViewStudentAddCourse))
                                .addGap(33, 33, 33)
                                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPaneViewStudentNonPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewStudentNonPassedCourses)))
                            .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separatorFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStudentsLayout.setVerticalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFindStudent)
                    .addComponent(btnFindStudent))
                .addGap(34, 34, 34)
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(separatorFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPersonNbr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblViewStudentPhoneNbr)
                            .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail)))
                    .addGroup(pnlStudentsLayout.createSequentialGroup()
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentAdress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPostCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentCity))
                        .addGap(32, 32, 32)
                        .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewStudentDeleteStudent)
                            .addComponent(btnRegisterStudentSave))))
                .addGap(18, 18, 18)
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewStudentPassedCourses)
                    .addComponent(lblViewStudentNonPassedCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneViewStudentNonPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneViewStudentPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblViewStudentAddCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewStudentAddCourse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Studenter", pnlStudents);

        pnlCourse.setPreferredSize(new java.awt.Dimension(500, 753));

        lblFindCourseInput.setText("Kursnamn/Kurskod:");
        lblFindCourseInput.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtFindCourseInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindCourseInputActionPerformed(evt);
            }
        });

        btnFindCourse.setText("Sök");
        btnFindCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCourseActionPerformed(evt);
            }
        });

        tableFindCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableFindCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFindCourseMouseClicked(evt);
            }
        });
        scrollPaneFindCourse.setViewportView(tableFindCourse);

        lblViewCourseCourseCode.setText("Kurskod");

        txtViewCourseCode.setEditable(false);

        lblViewCourseCourseName.setText("Benämning");

        lblViewCourseCredits.setText("HP");

        btnViewCourseDeleteCourse.setText("Radera");
        btnViewCourseDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCourseDeleteCourseActionPerformed(evt);
            }
        });

        lblViewCoursePassedStudents.setText("Studenter med avslutad kurs");

        txtAreaViewCoursePassedStudents.setColumns(20);
        txtAreaViewCoursePassedStudents.setRows(5);
        scrollPaneViewCoursePassedStudents.setViewportView(txtAreaViewCoursePassedStudents);

        lblViewCourseNonPassedStudents.setText("Studenter med ej avslutad kurs");

        txtAreaViewCourseNonPassedStudents.setColumns(20);
        txtAreaViewCourseNonPassedStudents.setRows(5);
        scrollPaneViewCourseNonPassedStudents.setViewportView(txtAreaViewCourseNonPassedStudents);

        lblViewCourseStudentsWithA.setText("Andel studenter med betyg A:");

        lblViewCourseHighestPassedCourses.setText("Kurser med högst genomströmning");

        txtViewCourseHighestPassedCourses.setColumns(20);
        txtViewCourseHighestPassedCourses.setRows(5);
        scrollPaneViewCourseHighestPassedCourses.setViewportView(txtViewCourseHighestPassedCourses);

        btnRegisterCourseSave.setText("Spara");
        btnRegisterCourseSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCourseSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCourseLayout = new javax.swing.GroupLayout(pnlCourse);
        pnlCourse.setLayout(pnlCourseLayout);
        pnlCourseLayout.setHorizontalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(lblFindCourseInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFindCourse))
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(scrollPaneViewCoursePassedStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneViewCourseNonPassedStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblViewCourseCourseName)
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(lblViewCourseCredits)
                        .addGap(64, 64, 64)
                        .addComponent(btnViewCourseDeleteCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegisterCourseSave))
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(lblViewCourseCourseCode)
                        .addGap(41, 41, 41)
                        .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCourseLayout.createSequentialGroup()
                        .addComponent(lblViewCoursePassedStudents)
                        .addGap(27, 27, 27)
                        .addComponent(lblViewCourseNonPassedStudents))
                    .addComponent(lblViewCourseHighestPassedCourses)
                    .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollPaneViewCourseHighestPassedCourses, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCourseLayout.createSequentialGroup()
                            .addComponent(lblViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(181, 282, Short.MAX_VALUE))
        );
        pnlCourseLayout.setVerticalGroup(
            pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFindCourseInput)
                    .addComponent(btnFindCourse)
                    .addComponent(txtFindCourseInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFindCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewCourseCourseCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCourseCourseName)
                    .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCourseCredits)
                    .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewCourseDeleteCourse)
                    .addComponent(btnRegisterCourseSave))
                .addGap(21, 21, 21)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCourseNonPassedStudents)
                    .addComponent(lblViewCoursePassedStudents))
                .addGap(35, 35, 35)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPaneViewCoursePassedStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneViewCourseNonPassedStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCourseStudentsWithA)
                    .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblViewCourseHighestPassedCourses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneViewCourseHighestPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kurser", pnlCourse);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindStudentActionPerformed

        String searchString = this.txtFindStudentQuery.getText();

        TableModel dtm = controller.findStudents(searchString);

        this.tblFindStudent.setModel(dtm);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindStudentActionPerformed

    private void txtViewStudentFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewStudentFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewStudentFirstNameActionPerformed

    private void btnRegisterStudentSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentSaveActionPerformed

        String[] studentData = new String[8];

        studentData[0] = this.txtViewStudentFirstName.getText();
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
    }//GEN-LAST:event_btnRegisterStudentSaveActionPerformed

    private void btnViewStudentDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentDeleteStudentActionPerformed

        String personNbr = this.txtViewStudentPersonNbr.getText();

        if (controller.checkIfStudentExists(personNbr) == true) {

            this.controller.deleteStudent(personNbr);

        } else {

            JOptionPane.showMessageDialog(this,
                "Kan inte radera student. Personnummer " + personNbr + " finns inte i databasen.",
                "Kan inte radera student.",
                JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnViewStudentDeleteStudentActionPerformed

    private void txtFindCourseInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindCourseInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindCourseInputActionPerformed

    private void btnFindCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCourseActionPerformed

        String searchString = this.txtFindCourseInput.getText();

        TableModel dtm = controller.findCourses(searchString);

        this.tableFindCourse.setModel(dtm);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindCourseActionPerformed

    private void tableFindCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFindCourseMouseClicked
        // TODO add your handling code here:
        int row = tableFindCourse.getSelectedRow();
        String ccode =(tableFindCourse.getModel().getValueAt(row, 0).toString());
        String cname =(tableFindCourse.getModel().getValueAt(row, 1).toString());
        String points =(tableFindCourse.getModel().getValueAt(row, 2).toString());
        txtViewCourseCode.setText(ccode);
        txtViewCourseName.setText(cname);
        txtViewCourseCredits.setText(points);
    }//GEN-LAST:event_tableFindCourseMouseClicked

    private void btnViewCourseDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCourseDeleteCourseActionPerformed

        String courseCode = this.txtViewCourseCode.getText();

        if (controller.checkIfCourseExists(courseCode) == true) {

            this.controller.deleteCourse(courseCode);

        } else {

            JOptionPane.showMessageDialog(this,
                "Kan inte radera kurs. Kurskod " + courseCode + " finns inte i databasen.",
                "Kan inte radera kurs.",
                JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnViewCourseDeleteCourseActionPerformed

    private void btnRegisterCourseSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCourseSaveActionPerformed

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
    }//GEN-LAST:event_btnRegisterCourseSaveActionPerformed

    private void tblFindStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFindStudentMouseClicked
        // TODO add your handling code here:
        int row = tblFindStudent.getSelectedRow();
        String pnr =(tblFindStudent.getModel().getValueAt(row, 0).toString());
        String firstname =(tblFindStudent.getModel().getValueAt(row, 1).toString());
        String lastname =(tblFindStudent.getModel().getValueAt(row, 2).toString());
        String phonenbr =(tblFindStudent.getModel().getValueAt(row, 3).toString());
        String email =(tblFindStudent.getModel().getValueAt(row, 4).toString());
        String address =(tblFindStudent.getModel().getValueAt(row, 5).toString());
        String postcode =(tblFindStudent.getModel().getValueAt(row, 6).toString());
        String city =(tblFindStudent.getModel().getValueAt(row, 7).toString());
        txtViewStudentPersonNbr.setText(pnr);
        txtViewStudentFirstName.setText(firstname);
        txtViewStudentLastName.setText(lastname);
        txtViewStudentPhoneNbr.setText(phonenbr);
        txtViewStudentEmail.setText(email);
        txtViewStudentAdress.setText(address);
        txtViewStudentPostCode.setText(postcode);
        txtViewStudentCity.setText(city); 
    }//GEN-LAST:event_tblFindStudentMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindCourse;
    private javax.swing.JButton btnFindStudent;
    private javax.swing.JButton btnRegisterCourseSave;
    private javax.swing.JButton btnRegisterStudentSave;
    private javax.swing.JButton btnViewCourseDeleteCourse;
    private javax.swing.JButton btnViewStudentAddCourse;
    private javax.swing.JButton btnViewStudentDeleteStudent;
    private javax.swing.JComboBox comboBoxViewStudentAddCourse;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFindCourseInput;
    private javax.swing.JLabel lblFindStudent;
    private javax.swing.JLabel lblViewCourseCourseCode;
    private javax.swing.JLabel lblViewCourseCourseName;
    private javax.swing.JLabel lblViewCourseCredits;
    private javax.swing.JLabel lblViewCourseHighestPassedCourses;
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
    private javax.swing.JPanel pnlStudents;
    private javax.swing.JScrollPane scrollPaneFindCourse;
    private javax.swing.JScrollPane scrollPaneFindStudent;
    private javax.swing.JScrollPane scrollPaneViewCourseHighestPassedCourses;
    private javax.swing.JScrollPane scrollPaneViewCourseNonPassedStudents;
    private javax.swing.JScrollPane scrollPaneViewCoursePassedStudents;
    private javax.swing.JScrollPane scrollPaneViewStudentNonPassedCourses;
    private javax.swing.JScrollPane scrollPaneViewStudentPassedCourses;
    private javax.swing.JSeparator separatorFindStudent;
    private javax.swing.JTable tableFindCourse;
    private javax.swing.JTable tblFindStudent;
    private javax.swing.JTextArea txtAreaViewCourseNonPassedStudents;
    private javax.swing.JTextArea txtAreaViewCoursePassedStudents;
    private javax.swing.JTextField txtFindCourseInput;
    private javax.swing.JTextField txtFindStudentQuery;
    private javax.swing.JTextField txtViewCourseCode;
    private javax.swing.JTextField txtViewCourseCredits;
    private javax.swing.JTextArea txtViewCourseHighestPassedCourses;
    private javax.swing.JTextField txtViewCourseName;
    private javax.swing.JTextField txtViewCourseStudentsWithA;
    private javax.swing.JTextField txtViewStudentAdress;
    private javax.swing.JTextField txtViewStudentCity;
    private javax.swing.JTextField txtViewStudentEmail;
    private javax.swing.JTextField txtViewStudentFirstName;
    private javax.swing.JTextField txtViewStudentLastName;
    private javax.swing.JTextArea txtViewStudentNonAreaPassedCourses;
    private javax.swing.JTextArea txtViewStudentPassedCourses;
    private javax.swing.JTextField txtViewStudentPersonNbr;
    private javax.swing.JTextField txtViewStudentPhoneNbr;
    private javax.swing.JTextField txtViewStudentPostCode;
    // End of variables declaration//GEN-END:variables
}
