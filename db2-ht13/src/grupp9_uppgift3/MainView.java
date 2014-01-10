
package grupp9_uppgift3;

/**
 * Main viewport that allows user to open and inspect documents
 *
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */

public class MainView extends javax.swing.JFrame {
    
    private FileHandler fileHandler;

    /**
     * This method takes one ICE handler per PDF viewport and a FleHandler for opening files.
     */
    MainView(ICEHandler ice[], FileHandler fileHandler) {
        
        this.fileHandler = fileHandler;
        
        initComponents();
 
        ice[0].loadFile("PDF Customer Report.pdf");     
        this.tabbedPanePdf.add(ice[0].getViewerPanel(), "Customer Report");
              
        ice[1].loadFile("PDF Employee Report.pdf");       
        this.tabbedPanePdf.add(ice[1].getViewerPanel(), "Employee Report");
        
        this.pack();
        
        this.setResizable(false);
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanePdf = new javax.swing.JTabbedPane();
        lblLicense = new javax.swing.JLabel();
        pnlEmployeeReport = new javax.swing.JPanel();
        btnEmpWord = new javax.swing.JButton();
        btnEmpExcel = new javax.swing.JButton();
        btnEmpAccess = new javax.swing.JButton();
        pnlCustomerReport = new javax.swing.JPanel();
        btnCustWord = new javax.swing.JButton();
        btnCustExcel = new javax.swing.JButton();
        btnCustAccess = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report Viewer");
        setName("MainFrame"); // NOI18N

        lblLicense.setText("This program is using ICEpdf (icesoft.org) licensed under Apache 2.0.");

        pnlEmployeeReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Report"));

        btnEmpWord.setText("View in Word");
        btnEmpWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpWordActionPerformed(evt);
            }
        });

        btnEmpExcel.setText("View in Excel");
        btnEmpExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpExcelActionPerformed(evt);
            }
        });

        btnEmpAccess.setText("View in Access");
        btnEmpAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpAccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEmployeeReportLayout = new javax.swing.GroupLayout(pnlEmployeeReport);
        pnlEmployeeReport.setLayout(pnlEmployeeReportLayout);
        pnlEmployeeReportLayout.setHorizontalGroup(
            pnlEmployeeReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmpWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmpAccess)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEmployeeReportLayout.setVerticalGroup(
            pnlEmployeeReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmployeeReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEmployeeReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpWord)
                    .addComponent(btnEmpExcel)
                    .addComponent(btnEmpAccess))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCustomerReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer Report"));

        btnCustWord.setText("View in Word");
        btnCustWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustWordActionPerformed(evt);
            }
        });

        btnCustExcel.setText("View in Excel");
        btnCustExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustExcelActionPerformed(evt);
            }
        });

        btnCustAccess.setText("View in Access");
        btnCustAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustAccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomerReportLayout = new javax.swing.GroupLayout(pnlCustomerReport);
        pnlCustomerReport.setLayout(pnlCustomerReportLayout);
        pnlCustomerReportLayout.setHorizontalGroup(
            pnlCustomerReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCustWord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustAccess)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCustomerReportLayout.setVerticalGroup(
            pnlCustomerReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCustWord)
                    .addComponent(btnCustExcel)
                    .addComponent(btnCustAccess))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanePdf)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlEmployeeReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCustomerReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(328, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLicense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPanePdf, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlEmployeeReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCustomerReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLicense)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpWordActionPerformed
        
        this.fileHandler.openOfficeFile("Word Employee Report.docx");
        
    }//GEN-LAST:event_btnEmpWordActionPerformed

    private void btnEmpExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpExcelActionPerformed
        
        this.fileHandler.openOfficeFile("Excel Employee Report.xlsx");
        
    }//GEN-LAST:event_btnEmpExcelActionPerformed

    private void btnEmpAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpAccessActionPerformed
        
        this.fileHandler.openOfficeFile("Access Employee Report.accdb");
        
    }//GEN-LAST:event_btnEmpAccessActionPerformed

    private void btnCustWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustWordActionPerformed
        
        this.fileHandler.openOfficeFile("Word Customer Report.docx");
        
    }//GEN-LAST:event_btnCustWordActionPerformed

    private void btnCustExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustExcelActionPerformed
       
        this.fileHandler.openOfficeFile("Excel Customer Report.xlsx");
        
    }//GEN-LAST:event_btnCustExcelActionPerformed

    private void btnCustAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustAccessActionPerformed
        
        this.fileHandler.openOfficeFile("Access Employee Report.accdb");
        
    }//GEN-LAST:event_btnCustAccessActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustAccess;
    private javax.swing.JButton btnCustExcel;
    private javax.swing.JButton btnCustWord;
    private javax.swing.JButton btnEmpAccess;
    private javax.swing.JButton btnEmpExcel;
    private javax.swing.JButton btnEmpWord;
    private javax.swing.JLabel lblLicense;
    private javax.swing.JPanel pnlCustomerReport;
    private javax.swing.JPanel pnlEmployeeReport;
    private javax.swing.JTabbedPane tabbedPanePdf;
    // End of variables declaration//GEN-END:variables
}
