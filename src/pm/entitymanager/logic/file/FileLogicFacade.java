/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import pm.entitymanager.logic.EntityChangedListener;
import pm.entitymanager.logic.EntityInterface;
import pm.entitymanager.logic.LogicFacade;


/**
 *
 * @author user
 */
public class FileLogicFacade  implements  LogicFacade{
    private static AbstractFile fileSystemsRoot;
    private static AbstractFile currentDir;
    private static String currentPath;
    private static String fullPath;
    private static List<String> cFullPath; //Storing the full path that the user is currebtly in including the root folder
    public FileLogicFacade() throws IOException {
        initialize();
    }
    public static void initialize() throws IOException {
        fileSystemsRoot = new FileSystemsRoot();
        currentDir = fileSystemsRoot;
        currentPath = Paths.get(currentDir.getName()).toString();
        fullPath = new String();
        System.out.println("CurrentPath: " + currentPath);
        System.out.println("CurrentPath alias: " + currentDir.getAlias());
        cFullPath = new ArrayList<>();        
    }

    
    public EntityInterface getRootEntity() {
       return(fileSystemsRoot);
    }

    @Override
    public String getEntitySize(EntityInterface entity) {
        if(entity instanceof FileSystemsRoot) throw new UnsupportedOperationException("Not supported yet.");
        if((entity instanceof DirectoryFile) || (entity instanceof RegularFile) || )
    }

    @Override
    public String getEntityLastModified(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEntityReadable(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEntityWriteable(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFolderish(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection getAllChildren(EntityInterface entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setAccessible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
    
   

