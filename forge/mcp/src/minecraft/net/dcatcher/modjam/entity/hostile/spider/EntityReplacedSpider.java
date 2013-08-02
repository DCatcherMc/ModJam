package net.dcatcher.modjam.entity.hostile.spider;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityReplacedSpider extends EntityAnimal
{

	public EntityReplacedSpider(World par1World)
    {
        super(par1World);
        this.setSize(1.4F, 0.9F);
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));

    }

	 public boolean isAIEnabled()
	    {
	        return false;
	    }
	 
	protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
    }
	
	protected String getLivingSound()
    {
        return "mob.spider.say";
    }
	
	protected String getHurtSound()
    {
        return "mob.spider.hurt";
    }
	
	 protected void playStepSound(int par1, int par2, int par3, int par4)
	    {
	        this.playSound("mob.spider.step", 0.15F, 1.0F);
	    }
	 
	 
	 protected float getSoundVolume()
	    {
	        return 0.4F;
	    }
	 
	 @Override
	    public boolean canBeSteered() {
	    	return true;
	    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

   
}
