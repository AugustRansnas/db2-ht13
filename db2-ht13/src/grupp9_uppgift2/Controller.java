
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
    
    protected Controller(DataAccessLayer dataAccessLayer){
        this.dataAccessLayer = dataAccessLayer;
    }
    
    protected TableModel getCronusEmployees(){
        
        TableModel tm = dataAccessLayer.getCronusEmployees();
        return tm;
        
    }
    
    protected TableModel getCronusEmployeeMetaData(){
        
        TableModel tm = dataAccessLayer.getCronusEmployeeMetaData();
        return tm;
        
    }
    
    protected TableModel getCronusEmployeeColumns(){
        
        TableModel tm = dataAccessLayer.getCronusEmployeeColumns();
        return tm;
        
    }
    
    protected TableModel getCronusKeys(){
        
        TableModel tm = dataAccessLayer.getCronusKeys();
        return tm;
        
    }
    
    protected TableModel getCronusIndexes(){
        
        TableModel tm = dataAccessLayer.getCronusIndexes();
        return tm;
        
    }
    
    protected TableModel getCronusConstraints(){
        
        TableModel tm = dataAccessLayer.getCronusConstraints();
        return tm;
        
    }
    
    protected TableModel getCronusTables(){
        
        TableModel tm = dataAccessLayer.getCronusTables();
        return tm;
        
    }

    protected TableModel getCronusTableWithMostRows() {
        
       TableModel tm = dataAccessLayer.getCronusTableWithMostRows();
        return tm;
    }
}
