
package grupp9_uppgift2;

import javax.swing.table.TableModel;

/**
 * Handles communication with database
 * 
 * @author Jonas Ahrne
 * @author August Ransnäs
 * @author Viktor Voigt
 * @author Joel Pennegård
 */
public class Controller {
    
    private final DataAccessLayer dataAccessLayer;
    
    /**
     * Recieves and stores the dataAccessLayer.
     * 
     * @param dataAccessLayer the class responsible for communicating with the database.
     */
    protected Controller(DataAccessLayer dataAccessLayer){
        this.dataAccessLayer = dataAccessLayer;
    }
    /**
     * Gets the Cronus employee table.
     * 
     * @return the Cronus employee table
     */
    protected TableModel getCronusEmployees(){
        
        TableModel tm = dataAccessLayer.getCronusEmployees();
        return tm;
        
    }
    /**
     * Gets meta data for the Cronus employee table.
     * 
     * @return meta data for the employee table
     */
    protected TableModel getCronusEmployeeMetaData(){
        
        TableModel tm = dataAccessLayer.getCronusEmployeeMetaData();
        return tm;
        
    }
    /**
     * Gets the columns of the Cronus employee table.
     * 
     * @return the columns of the employee table
     */
    protected TableModel getCronusEmployeeColumns1(){
        
        TableModel tm = dataAccessLayer.getCronusEmployeeColumns1();
        return tm;
        
    }
    /**
     * Gets the columns of the Cronus employee table.
     * 
     * @return the columns of the employee table
     */
    protected TableModel getCronusEmployeeColumns2(){
        
        TableModel tm = dataAccessLayer.getCronusEmployeeColumns2();
        return tm;
        
    }
    /**
     * Gets a system information table containing table names and their Keys from the Cronus database.
     * 
     * @return keys from the Cronus database. 
     */
    
    protected TableModel getCronusKeys(){
        
        TableModel tm = dataAccessLayer.getCronusKeys();
        return tm;
        
    }
    /**
     * Gets a system information table containing indexes from the Cronus database
     * 
     * @return indexes from the Cronus database
     */
    protected TableModel getCronusIndexes(){
        
        TableModel tm = dataAccessLayer.getCronusIndexes();
        return tm;
        
    }
    /**
     * Gets a system information table containing the table constraints from the Cronus database
     * 
     * @return table constraints from the Cronus database.
     */
    
    protected TableModel getCronusConstraints(){
        
        TableModel tm = dataAccessLayer.getCronusConstraints();
        return tm;
        
    }
    /**
     * Gets a system information table containing the names of the tables in the Cronus database.
     * 
     * @return the names of the tables in the Cronus database
     */
    
    protected TableModel getCronusTables1(){
        
        TableModel tm = dataAccessLayer.getCronusTables1();
        return tm;
        
    }
    /**
     * Gets a system information table containing the names of the tables in the Cronus database.
     * 
     * @return the names of the tables in the Cronus database
     */
    protected TableModel getCronusTables2(){
        
        TableModel tm = dataAccessLayer.getCronusTables2();
        return tm;
        
    }/**
     * Gets the name and amount of rows for the table with the most rows in the Cronus database.
     * 
     * @return the name and amount of rows for the table with most rows
     */

    protected TableModel getCronusTableWithMostRows() {
        
       TableModel tm = dataAccessLayer.getCronusTableWithMostRows();
        return tm;
    }
}
