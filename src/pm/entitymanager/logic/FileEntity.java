/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FileEntity implements EntityInterface {

    
    private FileLogicFacade logic;
    public FileLogicFacade FileLogicFacade() {
        try {
            logic = new FileLogicFacade();
        } catch (IOException ex) {
            Logger.getLogger(FileEntity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(logic);
    }
    
}
