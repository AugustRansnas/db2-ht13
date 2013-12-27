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
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author svalan
 */
public class OfficeExtractor {
    
    
    protected String getWordString(){
            FileInputStream fis = null;
        try {
            
            File wordFile = new File("C:\\Reports\\Wordreport.docx");
            fis = new FileInputStream(wordFile.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            return extractor.getText();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
        
    }
    
}
