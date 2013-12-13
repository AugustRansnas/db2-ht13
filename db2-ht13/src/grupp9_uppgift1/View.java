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

        tabbedPane = new javax.swing.JTabbedPane();
        pnlStudents = new javax.swing.JPanel();
        pnlFinsStudents = new javax.swing.JPanel();
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
        btnRegisterStudentSave = new javax.swing.JButton();
        btnViewStudentDeleteStudent = new javax.swing.JButton();
        lblViewStudentPersonNbr = new javax.swing.JLabel();
        lblViewStudentPassedCourses = new javax.swing.JLabel();
        lblViewStudentNonPassedCourses = new javax.swing.JLabel();
        lblViewStudentAddCourse = new javax.swing.JLabel();
        comboBoxViewStudentAddCourse = new javax.swing.JComboBox();
        btnViewStudentAddCourse = new javax.swing.JButton();
        scrollPanePassedCourses = new javax.swing.JScrollPane();
        tblPassedCourses = new javax.swing.JTable();
        scrollPanesFinishedCourses = new javax.swing.JScrollPane();
        tblFinishedCourses = new javax.swing.JTable();
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
        btnViewCourseDeleteCourse = new javax.swing.JButton();
        btnRegisterCourseSave = new javax.swing.JButton();
        pnlCourseResults = new javax.swing.JPanel();
        lblViewCoursePassedStudents = new javax.swing.JLabel();
        lblViewCourseStudentsWithA = new javax.swing.JLabel();
        lblViewCourseNonPassedStudents = new javax.swing.JLabel();
        txtViewCourseStudentsWithA = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFinishedCourse = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNotFinishedCourse = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        rbtnDeleteCourse = new javax.swing.JRadioButton();
        btnDeleteRegisterCourse = new javax.swing.JButton();
        pnlHighestPassedCourse = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourseFlow = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlFinsStudents.setBorder(javax.swing.BorderFactory.createTitledBorder("Sök studenter"));

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
        scrollPaneFindStudent.setViewportView(tblFindStudent);

        javax.swing.GroupLayout pnlFinsStudentsLayout = new javax.swing.GroupLayout(pnlFinsStudents);
        pnlFinsStudents.setLayout(pnlFinsStudentsLayout);
        pnlFinsStudentsLayout.setHorizontalGroup(
            pnlFinsStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFinsStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFindStudent)
                .addGap(6, 6, 6)
                .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnFindStudent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFinsStudentsLayout.createSequentialGroup()
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFinsStudentsLayout.setVerticalGroup(
            pnlFinsStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFinsStudentsLayout.createSequentialGroup()
                .addGroup(pnlFinsStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFindStudent)
                    .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlViewStudent.setBorder(javax.swing.BorderFactory.createTitledBorder("Studentinformation"));

        lblViewStudentFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentFirstName.setText("Förnamn:");

        lblViewStudentLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentLastName.setText("Efternamn:");

        txtViewStudentPersonNbr.setEditable(false);

        txtViewStudentFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewStudentFirstNameActionPerformed(evt);
            }
        });

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

        btnRegisterStudentSave.setText("Registrera");
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

        lblViewStudentPersonNbr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewStudentPersonNbr.setText("Personnummer:");

        lblViewStudentPassedCourses.setText("Godkända kurser:");

        lblViewStudentNonPassedCourses.setText("Ej avslutade kurser:");

        lblViewStudentAddCourse.setText("Lägg till kurs");

        comboBoxViewStudentAddCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnViewStudentAddCourse.setText("Lägg till");

        tblPassedCourses.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanePassedCourses.setViewportView(tblPassedCourses);

        tblFinishedCourses.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPanesFinishedCourses.setViewportView(tblFinishedCourses);

        javax.swing.GroupLayout pnlViewStudentLayout = new javax.swing.GroupLayout(pnlViewStudent);
        pnlViewStudent.setLayout(pnlViewStudentLayout);
        pnlViewStudentLayout.setHorizontalGroup(
            pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lblViewStudentAddCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnViewStudentAddCourse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addComponent(lblViewStudentPassedCourses)
                        .addGap(178, 178, 178)
                        .addComponent(lblViewStudentNonPassedCourses)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewStudentLayout.createSequentialGroup()
                                .addComponent(scrollPanePassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(scrollPanesFinishedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addGroup(pnlViewStudentLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
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
                                    .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                                        .addGap(228, 228, 228)
                                        .addComponent(btnRegisterStudentSave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnViewStudentDeleteStudent)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(lblViewStudentLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblViewStudentPhoneNbr)
                            .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail)
                            .addComponent(btnRegisterStudentSave)
                            .addComponent(btnViewStudentDeleteStudent)))
                    .addGroup(pnlViewStudentLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentCity))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblViewStudentPassedCourses)
                    .addComponent(lblViewStudentNonPassedCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanePassedCourses, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(scrollPanesFinishedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlViewStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblViewStudentAddCourse)
                    .addComponent(btnViewStudentAddCourse))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlStudentsLayout = new javax.swing.GroupLayout(pnlStudents);
        pnlStudents.setLayout(pnlStudentsLayout);
        pnlStudentsLayout.setHorizontalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlFinsStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlViewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlStudentsLayout.setVerticalGroup(
            pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFinsStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlViewStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 293, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Studenter", pnlStudents);

        pnlCourse.setPreferredSize(new java.awt.Dimension(500, 753));

        pnlFindCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Sök kurs"));
        pnlFindCourse.setToolTipText("");

        txtFindCourseInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFindCourseInputActionPerformed(evt);
            }
        });

        lblFindCourseInput.setText("Kursnamn/Kurskod:");
        lblFindCourseInput.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
        tableFindCourse.setName(""); // NOI18N
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

        txtViewCourseCode.setEditable(false);

        lblViewCourseCourseName.setText("Benämning");

        lblViewCourseCredits.setText("HP");

        btnViewCourseDeleteCourse.setText("Radera");
        btnViewCourseDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCourseDeleteCourseActionPerformed(evt);
            }
        });

        btnRegisterCourseSave.setText("Registrera");
        btnRegisterCourseSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCourseSaveActionPerformed(evt);
            }
        });

        pnlCourseResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Kursresultat"));

        lblViewCoursePassedStudents.setText("Studenter med avslutad kurs");

        lblViewCourseStudentsWithA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblViewCourseStudentsWithA.setText("Andel studenter med betyg A:");

        lblViewCourseNonPassedStudents.setText("Studenter med ej avslutad kurs");

        txtViewCourseStudentsWithA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewCourseStudentsWithAActionPerformed(evt);
            }
        });

        tblFinishedCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblFinishedCourse);

        tblNotFinishedCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblNotFinishedCourse);

        javax.swing.GroupLayout pnlCourseResultsLayout = new javax.swing.GroupLayout(pnlCourseResults);
        pnlCourseResults.setLayout(pnlCourseResultsLayout);
        pnlCourseResultsLayout.setHorizontalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addComponent(lblViewCoursePassedStudents)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblViewCourseNonPassedStudents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addComponent(lblViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        pnlCourseResultsLayout.setVerticalGroup(
            pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCourseResultsLayout.createSequentialGroup()
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCoursePassedStudents)
                    .addComponent(lblViewCourseNonPassedStudents))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCourseResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewCourseStudentsWithA)
                    .addComponent(txtViewCourseStudentsWithA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jRadioButton1.setText("Registrera kurs");

        rbtnDeleteCourse.setText("Radera kurs");

        btnDeleteRegisterCourse.setText("jButton1");

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
                        .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnDeleteCourse, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteRegisterCourse)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewCourseDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegisterCourseSave))
                .addGap(29, 29, 29))
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addComponent(pnlCourseResults, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlShowCourseLayout.setVerticalGroup(
            pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblViewCourseCourseCode)
                            .addComponent(txtViewCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewCourseCourseName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewCourseCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewCourseCredits)))
                    .addGroup(pnlShowCourseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addComponent(btnViewCourseDeleteCourse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegisterCourseSave))
                            .addGroup(pnlShowCourseLayout.createSequentialGroup()
                                .addGroup(pnlShowCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnDeleteCourse)
                                    .addComponent(btnDeleteRegisterCourse))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCourseResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlHighestPassedCourse.setBorder(javax.swing.BorderFactory.createTitledBorder("Kurser med höst genomströmning"));

        tblCourseFlow.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCourseFlow);

        javax.swing.GroupLayout pnlHighestPassedCourseLayout = new javax.swing.GroupLayout(pnlHighestPassedCourse);
        pnlHighestPassedCourse.setLayout(pnlHighestPassedCourseLayout);
        pnlHighestPassedCourseLayout.setHorizontalGroup(
            pnlHighestPassedCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnlHighestPassedCourseLayout.setVerticalGroup(
            pnlHighestPassedCourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHighestPassedCourseLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(pnlShowCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 92, Short.MAX_VALUE))
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
                .addContainerGap(189, Short.MAX_VALUE))
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

    private void btnFindCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCourseActionPerformed

        String searchString = this.txtFindCourseInput.getText();

        TableModel dtm = controller.findCourses(searchString);

        this.tableFindCourse.setModel(dtm);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFindCourseActionPerformed

    private void txtFindCourseInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFindCourseInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFindCourseInputActionPerformed

    private void txtViewCourseStudentsWithAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewCourseStudentsWithAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewCourseStudentsWithAActionPerformed

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

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRegisterCourse;
    private javax.swing.JButton btnFindCourse;
    private javax.swing.JButton btnFindStudent;
    private javax.swing.JButton btnRegisterCourseSave;
    private javax.swing.JButton btnRegisterStudentSave;
    private javax.swing.JButton btnViewCourseDeleteCourse;
    private javax.swing.JButton btnViewStudentAddCourse;
    private javax.swing.JButton btnViewStudentDeleteStudent;
    private javax.swing.JComboBox comboBoxViewStudentAddCourse;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFindCourseInput;
    private javax.swing.JLabel lblFindStudent;
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
    private javax.swing.JPanel pnlFinsStudents;
    private javax.swing.JPanel pnlHighestPassedCourse;
    private javax.swing.JPanel pnlShowCourse;
    private javax.swing.JPanel pnlStudents;
    private javax.swing.JPanel pnlViewStudent;
    private javax.swing.JRadioButton rbtnDeleteCourse;
    private javax.swing.JScrollPane scrollPaneFindCourse;
    private javax.swing.JScrollPane scrollPaneFindStudent;
    private javax.swing.JScrollPane scrollPanePassedCourses;
    private javax.swing.JScrollPane scrollPanesFinishedCourses;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableFindCourse;
    private javax.swing.JTable tblCourseFlow;
    private javax.swing.JTable tblFindStudent;
    private javax.swing.JTable tblFinishedCourse;
    private javax.swing.JTable tblFinishedCourses;
    private javax.swing.JTable tblNotFinishedCourse;
    private javax.swing.JTable tblPassedCourses;
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
}
