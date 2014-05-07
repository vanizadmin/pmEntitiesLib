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
public class EntityCopyCutFailedException extends Exception
{
    private EntityInterface entity;
    private String reason;
    
    public EntityCopyCutFailedException( EntityInterface entity, String reason)
    {
        
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
