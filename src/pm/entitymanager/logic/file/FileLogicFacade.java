/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import pm.entitymanager.logic.EntityChangedListener;
import pm.entitymanager.logic.EntityInterface;
import pm.entitymanager.logic.EntityNotFolderishException;
import pm.entitymanager.logic.LogicFacade;


/**
 *
 * @author user
 */
public class FileLogicFacade  implements  LogicFacade{
    private static AbstractFile fileSystemsRoot;
    private static AbstractFile currentDir;
    private static String currentPath;
    private static Path cPath;
    private static String fullPath;
    private static List<String> cFullPath; //Storing the full path that the user is currebtly in including the root folder
    public FileLogicFacade() throws IOException {
        initialize();
    }
    public static void initialize() throws IOException {
        fileSystemsRoot = new FileSystemsRoot();
        currentDir = fileSystemsRoot;
        currentPath = Paths.get(currentDir.getName()).toString();
        cPath = Paths.get(currentDir.getName());
        fullPath = new String();
        System.out.println("CurrentPath: " + currentPath);
        System.out.println("CurrentPath alias: " + currentDir.getAlias());
        cFullPath = new ArrayList<>();        
    }

    
    public EntityInterface getRootEntity() {
       return(fileSystemsRoot);
    }
    public String getEntityName(EntityInterface entity) {
        if(isValidEntity(entity)) {
            if(entity instanceof FileSystemsRoot) return(currentDir.getAlias());
            else if((entity instanceof DirectoryFile) || (entity instanceof RegularFile) || (entity instanceof RootChild)) return (currentDir.getName());
            
            }
        return ("");
    }
    
    
    private boolean isValidEntity(EntityInterface entity) {
         if(entity instanceof FileSystemsRoot) return(true);
        else if((entity instanceof DirectoryFile) || (entity instanceof RegularFile) || (entity instanceof RootChild)) return(true);
        else return (false);
    }
    @Override
    public String getEntitySize(EntityInterface entity) {
        if(entity instanceof FileSystemsRoot) return("");
        else if(isFolderish(entity)) {
           // currentDir.setSize(Paths.get(currentDir.getName()));
            return(Objects.toString(currentDir.getSize(), null));        
        }        
        else return("");       
    }

    @Override
    public String getEntityLastModified(EntityInterface entity) {
        if ((!(entity instanceof FileSystemsRoot)) && isValidEntity(entity)) return (Objects.toString(currentDir.getLastModified(), null));
         else return ("");        
    }

    @Override
    public boolean isEntityReadable(EntityInterface entity) {
        if ((!(entity instanceof FileSystemsRoot)) || isValidEntity(entity)) return (currentDir.isReadable());
         else return (true);   
    }

    @Override
    public boolean isEntityWriteable(EntityInterface entity) {
        if ((!(entity instanceof FileSystemsRoot)) || isValidEntity(entity)) return (currentDir.isWritable());
         else return (true);  
    }

    @Override
    public boolean isFolderish(EntityInterface entity) {              
        if((entity instanceof FileSystemsRoot) || (entity instanceof DirectoryFile) || (entity instanceof RootChild)) return(true);
        else return (false);
    }

    @Override
    public Collection getAllChildren(EntityInterface entity) {
        List<AbstractFile> contents = Collections.EMPTY_LIST;
        if(isFolderish(entity)) try {
            contents = currentDir.getAllChildren();            
        } catch (EntityNotFolderishException ex) {
            Logger.getLogger(FileLogicFacade.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return(contents);
    }

    @Override
    public void rename(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cut(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void copy(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paste(EntityInterface entity, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEntityChangeListener(EntityChangedListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeEntityChangeListener(EntityChangedListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
    
   

