/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pm.entitymanager.logic;

/**
 *
 * @author ToNio
 */
public class EntityDeletionFailedException extends Exception
{
    private EntityInterface entity;
    private String reason;
    
    
    public EntityDeletionFailedException( EntityInterface entity, String reason)
    {
        this.entity=entity;
        this.reason=reason;
    }
    
    public EntityInterface getEntity()
    {
        return this.entity;
    }
    
    public String getReason()
    {
        return this.reason;
    }
}
