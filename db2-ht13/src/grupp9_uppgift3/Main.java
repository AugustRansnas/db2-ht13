/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

/**
 *
 * @author svalan
 */
public class Main {

    public static void main(String[] args) {
       

        OfficeExtractor officeExtractor = new OfficeExtractor();
        
           MainView mainView = new MainView(officeExtractor);
           
            mainView.setVisible(true);



    }
}
