/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ToNio
 */
public class FileSystemsRoot extends AbstractFile
{
    private List<AbstractFile> children;
    protected FileSystemsRoot() throws IOException
    {
        super("",null);
        super.setAlias("ParentOfRootDirs");
        this.children = new ArrayList<>();
        intializeChildren();
    }    
    @Override
    protected boolean isFolderish()
    {
        return true;
    }
    private void intializeChildren() throws IOException {        
        Iterable<Path> fileSystems = FileSystems.getDefault().getRootDirectories(); 
        for (Path fileSystem : fileSystems) children.add(new RootChild(fileSystem, this));
    }
    @Override
    protected List<AbstractFile> getAllChildren()
    {
        return children;
    }
    @Override
    protected String getCharNameOnly() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    protected String getFullName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
