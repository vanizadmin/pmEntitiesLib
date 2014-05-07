/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic.file;

import pm.entitymanager.logic.EntityNotFolderishException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ToNio
 */
public class RegularFile extends AbstractFile
{
    private Path file;
    private Date date;
    protected RegularFile(Path file, AbstractFile parent)
    {
        super(file.getFileName().toString(),parent);
        this.file=file;
        setAlias("File");
        setLastModifiedTime(file);
        setSize(file);
    }
    @Override
    protected boolean isFolderish()
    {
        return (Files.isRegularFile(file));
    }
    @Override
    protected List<AbstractFile> getAllChildren() throws EntityNotFolderishException
    {
        throw new EntityNotFolderishException();
    }
    @Override
    protected String getCharNameOnly() {
        return(getName());
    }
    @Override
    protected String getFullName() {
        return(getName());
    }    
}
