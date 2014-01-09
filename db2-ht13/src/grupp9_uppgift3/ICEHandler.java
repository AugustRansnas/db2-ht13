/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

import java.util.ResourceBundle;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;

/**
 *
 * @author Admin
 */
public class ICEHandler {

    SwingController swingController;
    SwingViewBuilder swingViewBuilder;

    protected ICEHandler() {

        swingController = new SwingController(); //Starts the built in controller of icePDF  
        
        PropertiesManager properties = new PropertiesManager(System.getProperties(), ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));
        
        properties.setBoolean(PropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, false);
        properties.setBoolean(PropertiesManager.PROPERTY_SHOW_TOOLBAR_UTILITY, false);
        
        swingViewBuilder = new SwingViewBuilder(swingController, properties);

    }

    protected JPanel getViewerPanel() {

        JPanel panel = this.swingViewBuilder.buildViewerPanel();

        return panel;

    }

    protected void loadFile(String fileName) {
        
        String filePath = this.getFullFilePath(fileName);

        swingController.openDocument(filePath);

    }

    private String getFullFilePath(String fileName) {

        String workingDirectory = System.getProperty("user.dir");

        String packageFolder = "/src/grupp9_uppgift3/";

        String fullPath = workingDirectory + packageFolder + fileName;

        System.out.println("Returning path " + fullPath);

        return fullPath;

    }

}
