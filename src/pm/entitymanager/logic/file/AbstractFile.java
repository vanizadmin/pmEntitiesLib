/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ToNio
 */
abstract public class AbstractFile implements pm.entitymanager.logic.EntityInterface
{
    protected AbstractFile parent;
    protected String name;
    protected String alias;
    protected long size;
    protected Date lastModified;
    protected boolean readable;
    protected boolean writable;
    private Path file;
    protected void setWritability(boolean writable) {
        this.writable = writable;
    }
    protected void setReadability(boolean readable) {
        this.readable = readable;
    }    
    protected AbstractFile(String name, AbstractFile parent)
    {
        this.name=null;
        this.name=name;
        this.parent=parent;
    }    
    protected AbstractFile getParent()
    {
        return parent;
    }    
    protected String getName()
    {
        return name;
    }    
    protected long getSize()
    {
        return size;
    }
    protected void setSize(Path file) {
        try {
            size = (Files.size(file));
        } catch (IOException ex) {
            size = 0;
        }   
    } 
    protected Date getLastModified()
    {
        return lastModified;
    }
    protected void setLastModifiedTime(Path file) {
        try {
            lastModified = new Date(Files.getLastModifiedTime(file).toMillis());         
        } catch (IOException ex) {
             lastModified = new Date(0,0,0);
        }
    }  
    protected boolean isReadable()
    {
        return readable;
    }    
    protected boolean isWritable()
    {
        return writable;
    }    
    protected void setName(String name)
    {
        this.name=name;
    }
    protected String getAlias() {
        return alias;
    }
    protected void setAlias(String alias) {
        this.alias = alias;
    }
    protected List<AbstractFile> getContents(Path container) {
        List<AbstractFile> children = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(container)) {
            for (Path rfile : stream) {
                if(!Files.isRegularFile(rfile)) {
                children.add(new DirectoryFile(rfile, this));                
                }
                else children.add(new RegularFile(rfile, this));
            }
            return(children);
        }   catch (IOException | DirectoryIteratorException x) {
                System.err.println(x);
                return(children);
            }
    }
    abstract protected boolean isFolderish();
    abstract protected String getCharNameOnly();
    abstract protected String getFullName();
    abstract protected List<AbstractFile> getAllChildren() throws pm.entitymanager.logic.EntityNotFolderishException;    
}
