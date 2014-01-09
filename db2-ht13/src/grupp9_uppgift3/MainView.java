/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

import java.awt.Color;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;

/**
 *
 * @author svalan
 */
public class MainView extends javax.swing.JFrame {

    private ICEHandler ice1;
    private ICEHandler ice2;

    MainView(ICEHandler ice1, ICEHandler ice2) {
        
        initComponents();
        
        this.ice1 = ice1;       
        this.ice2 = ice2;
        
        
        this.ice1.loadFile("Wordreport.pdf");     
        this.jTabbedPane1.add(ice1.getViewerPanel(), "Word Report");
        
        
        this.ice2.loadFile("Excelreport.pdf");       
        this.jTabbedPane1.add(ice2.getViewerPanel(), "Excel Report");
        
        this.pack();
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report Viewer");

        jLabel1.setText("This program is using ICEpdf (icesoft.org) licensed under Apache 2.0.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 689, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
