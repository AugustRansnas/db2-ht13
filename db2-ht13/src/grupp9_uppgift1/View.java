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
        initComponents();
        this.populateStudentTable();
    }

    /*
   private void populateCourseTable() {

        TableModel tm;

        tm = controller.getAllCourses();

        System.out.println(tm.getColumnCount());

        this.tableFindCourse.setModel(tm);

    }
*/
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
        jPanel1 = new javax.swing.JPanel();
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
        jPanel2 = new javax.swing.JPanel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblViewStudentPersonNbr)
                                    .addComponent(lblViewStudentPhoneNbr)
                                    .addComponent(lblViewStudentEmail)
                                    .addComponent(lblViewStudentFirstName)
                                    .addComponent(lblViewStudentLastName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtViewStudentFirstName)
                                        .addComponent(txtViewStudentPhoneNbr)
                                        .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblViewStudentAdress)
                                            .addComponent(lblViewStudentCity)))
                                    .addComponent(lblViewStudentPostCode, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnRegisterStudentSave)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnViewStudentDeleteStudent))
                                    .addComponent(txtViewStudentAdress)
                                    .addComponent(txtViewStudentPostCode)
                                    .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFindStudent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFindStudent))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewStudentAddCourse)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPaneViewStudentPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewStudentPassedCourses)
                                    .addComponent(lblViewStudentAddCourse))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPaneViewStudentNonPassedCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblViewStudentNonPassedCourses)))
                            .addComponent(comboBoxViewStudentAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(separatorFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFindStudentQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFindStudent)
                    .addComponent(btnFindStudent))
                .addGap(34, 34, 34)
                .addComponent(scrollPaneFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(separatorFindStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentPersonNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPersonNbr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblViewStudentPhoneNbr)
                            .addComponent(txtViewStudentPhoneNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentEmail)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentAdress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentPostCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewStudentCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblViewStudentCity))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewStudentDeleteStudent)
                            .addComponent(btnRegisterStudentSave))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewStudentPassedCourses)
                    .addComponent(lblViewStudentNonPassedCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jTabbedPane1.addTab("Student", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 753, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kurser", jPanel2);

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

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindStudent;
    private javax.swing.JButton btnRegisterStudentSave;
    private javax.swing.JButton btnViewStudentAddCourse;
    private javax.swing.JButton btnViewStudentDeleteStudent;
    private javax.swing.JComboBox comboBoxViewStudentAddCourse;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFindStudent;
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
    private javax.swing.JScrollPane scrollPaneFindStudent;
    private javax.swing.JScrollPane scrollPaneViewStudentNonPassedCourses;
    private javax.swing.JScrollPane scrollPaneViewStudentPassedCourses;
    private javax.swing.JSeparator separatorFindStudent;
    private javax.swing.JTable tblFindStudent;
    private javax.swing.JTextField txtFindStudentQuery;
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
