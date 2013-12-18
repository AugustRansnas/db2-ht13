/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grupp9_uppgift2;

/**
 *
 * @author Joel
 */
public class Controller {
    DataAccessLayer dataAccessLayer;
    
    protected Controller(DataAccessLayer dataAccessLayer){
        this.dataAccessLayer = dataAccessLayer;
    }
}
