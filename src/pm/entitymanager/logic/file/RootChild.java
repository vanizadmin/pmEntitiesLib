/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pm.entitymanager.logic.EntityNotFolderishException;

/**
 *
 * @author theweb
 */
public class RootChild extends AbstractFile {
    private PathNameSanitization childName;
    private List<AbstractFile> children;
    private Path file;
    private Date date;
 //   private File rootDir;
    protected RootChild(Path name, AbstractFile parent) throws IOException{
        super(name.toString(), parent);
        childName=  new PathNameSanitization(name.toString());
        setAlias(childName.getOnlyLetter() + " Drive");
        this.children = new ArrayList<>();
        this.file=name;
        initializeRootDirPermissions();
        setSize(file);
        setLastModifiedTime(file);
    }
    private void intializeChildren() throws IOException {       
        Iterable<Path> fileSystems = FileSystems.getDefault().getRootDirectories(); 
        for (Path fileSystem : fileSystems) children.add(new RootChild(fileSystem, this));
    }
    @Override
    protected String getCharNameOnly() {
        return(childName.getOnlyLetter());
    }
    @Override
    protected String getFullName() {
        return(childName.getDrive());
    }
    @Override
    protected boolean isFolderish(){
        return(!Files.isRegularFile(file));
    }
    private void isRootDirReadable() {        
        setReadability(Files.isReadable(file));
    }
    private void isRootDirWritable() { 
        setWritability(Files.isWritable(file));
    }
    private void initializeRootDirPermissions() {
        isRootDirReadable();
        isRootDirWritable();
    }
    @Override
    protected List<AbstractFile> getAllChildren() throws EntityNotFolderishException {
        children=getContents(file);
        return (children);
    }   
}
