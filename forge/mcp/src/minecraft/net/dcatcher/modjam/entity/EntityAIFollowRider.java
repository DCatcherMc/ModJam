package net.dcatcher.modjam.entity;

import java.util.Iterator;
import java.util.List;

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
		
		 List list = this.tamedMob.worldObj.getEntitiesWithinAABB(this.tamedMob.getClass(), this.tamedMob.boundingBox.expand(8.0D, 4.0D, 8.0D));
         EntityPlayer player = null;
         double d0 = Double.MAX_VALUE;
         Iterator iterator = list.iterator();

         while (iterator.hasNext())
         {
        	 if(iterator.next() instanceof EntityPlayer){
             EntityPlayer entityplayer1 = (EntityPlayer)iterator.next();

                 double d1 = this.tamedMob.getDistanceSqToEntity(entityplayer1);

                 if (d1 <= d0)
                 {
                     d0 = d1;
                     player = entityplayer1;
             }
         }
         }
         if (player == null)
         {
             return false;
         }
         else if (d0 < 9.0D)
         {
             return false;
         }
         else
         {
             this.lastRider = player;
             return true;
         }
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
