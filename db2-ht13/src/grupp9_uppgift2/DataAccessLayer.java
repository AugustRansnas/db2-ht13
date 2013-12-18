/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grupp9_uppgift2;

import java.sql.Connection;



/**
 *
 * @author Joel
 */
public class DataAccessLayer {
    Connection connection;
    
    protected DataAccessLayer(Connection connection){
        this.connection = connection;
    }
    
}
