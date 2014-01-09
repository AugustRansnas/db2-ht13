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
 * This class handles the ICE tools and contact with the file system.
 *
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */
public class ICEHandler {

    SwingController swingController;
    SwingViewBuilder swingViewBuilder;

    /**
     * Intializes the ICEHandler starting up the needed ICE tools.
     */
    protected ICEHandler() {

        swingController = new SwingController(); //Starts the built in controller of icePDF  

        //Build in ICEproperties manager
        PropertiesManager properties = new PropertiesManager(System.getProperties(), ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));

        properties.setBoolean(PropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, false);
        properties.setBoolean(PropertiesManager.PROPERTY_SHOW_TOOLBAR_UTILITY, false);

        //Built in API that builds swing components
        swingViewBuilder = new SwingViewBuilder(swingController, properties);

    }

    /**
     * Method that returns a JPanel used to view PDF documents.
     *
     * @return document viewer
     */
    protected JPanel getViewerPanel() {

        JPanel panel = this.swingViewBuilder.buildViewerPanel();

        return panel;

    }

    /**
     * Load a file in the ICE controller. It assumes files are in the java
     * package
     *
     * @param fileName name of file without path
     */
    protected void loadFile(String fileName) {

        String filePath = this.getFullFilePath(fileName);

        swingController.openDocument(filePath);

    }

    /**
     * Returns the full file path of a file in the java package
     *
     * @param fileName name of file without path
     * @return full file path
     */
    private String getFullFilePath(String fileName) {

        String workingDirectory = System.getProperty("user.dir");

        String packageFolder = "/src/grupp9_uppgift3/"; //Path to our package

        String fullPath = workingDirectory + packageFolder + fileName;

        System.out.println("Returning path " + fullPath);

        return fullPath;

    }

}
