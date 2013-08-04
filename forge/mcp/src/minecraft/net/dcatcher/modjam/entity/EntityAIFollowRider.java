package net.dcatcher.modjam.entity;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIFollowRider extends EntityAIBase{
	
	EntityPlayer lastRider;
	EntityAnimal tamedMob;
	
	double speed;
    private int something;

	
	public EntityAIFollowRider(EntityAnimal entityAnimal, EntityPlayer rider, double par3){
		this.tamedMob = entityAnimal;
		this.lastRider = rider;
		this.speed = par3;
	}

	@Override
	public boolean shouldExecute() {
		return true;
	}
	
	public boolean continueExecuting()
    {
        if (!this.lastRider.isEntityAlive())
        {
            return false;
        }
        else
        {
            double d0 = this.tamedMob.getDistanceSqToEntity(this.lastRider);
            return d0 >= 9.0D && d0 <= 256.0D;
        }
    }
	 
	public void updateTask()
	    {
	        if (--this.something <= 0)
	        {
	            this.something = 10;
	            this.tamedMob.getNavigator().tryMoveToEntityLiving(this.lastRider, this.speed);
	        }
	    }

}
