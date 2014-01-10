/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift3;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles comunication with filesystem and operatin system.
 */
public class FileHandler {
    
    /**
     * Opens the file on the specified path with the default program.
     * 
     * @param the name of the file.
     */
    protected void openOfficeFile(String fileName) {

        String fullPath = this.getFullFilePath(fileName);

        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + fullPath);
        } catch (IOException ex) {
            Logger.getLogger(ICEHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        /**
     * Returns the full file path of a file in the java package
     *
     * @param fileName name of file without path
     * @return full file path
     */
    protected String getFullFilePath(String fileName) {

        String workingDirectory = System.getProperty("user.dir");

        String packageFolder = "/src/grupp9_uppgift3/"; //Path to our package

        String fullPath = workingDirectory + packageFolder + fileName;

        System.out.println("Returning path " + fullPath);

        return fullPath;

    }

}
