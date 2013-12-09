/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_uppgift1;

import java.sql.Connection;

/**
 *
 * @author Viktor Voigt
 * @author Jonas Ahrne
 * @author Joel Pennegård
 * @author August Ransnäs
 *
 */
public class Controller {

    DataAccessLayer dataAccessLayer;

    Controller(DataAccessLayer dataAccessLayer) {

        this.dataAccessLayer = dataAccessLayer;

    }

    protected void registerNewStudent(String[] studentData) {

        System.out.println("Creating student: " + studentData[0] + " " + studentData[1] + " " +
        studentData[2]);
        
        this.dataAccessLayer.registerNewStudent(studentData);

    }
}
