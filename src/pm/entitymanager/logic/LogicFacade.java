/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic;

import java.util.Collection;

/**
 *
 * @author ToNio
 */
public interface LogicFacade {
    public EntityInterface getRootEntity();
    
    public String getEntityName(EntityInterface entity);

    public String getEntitySize(EntityInterface entity);

    public String getEntityLastModified(EntityInterface entity);

    public boolean isEntityReadable(EntityInterface entity);

    public boolean isEntityWriteable(EntityInterface entity);

    public boolean isFolderish(EntityInterface entity);

    public Collection getAllChildren(EntityInterface entity);

    public void rename(EntityInterface entity);

    public void delete(EntityInterface entity);

    public void cut(EntityInterface entity);

    public void copy(EntityInterface entity);

    public void paste(EntityInterface entity, String newName);

    public void addEntityChangeListener(EntityChangedListener listener);

    public void removeEntityChangeListener(EntityChangedListener listener);   
}
