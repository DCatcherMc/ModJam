package net.dcatcher.modjam.items;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Disguiser extends Item {

	public Disguiser(int par1) {
		super(par1);
		setUnlocalizedName("disguiser");
		setCreativeTab(ModJam.tabJam);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		return itemstack;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		if(entity instanceof EntityFallingSand){
			return false;
		}
		if(entity instanceof EntitySheep){
			double xCoord = entity.posX;
			double yCoord = entity.posY;
			double zCoord = entity.posZ;
			float yaw = entity.rotationYaw;
			float pitch = entity.rotationPitch;
			
			
			World world = entity.worldObj;
			entity.setDead();
			Entity e = new EntityReplacedSheep(world);
			e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
			world.spawnEntityInWorld(e);
			
			world.updateEntities();
			EntityLiving replacedMob = (EntityLiving)e;
			replacedMob.tasks.addTask(1, new EntityAIControlledByPlayer(replacedMob, 1F));
			player.mountEntity(replacedMob);
		
		}
		
		
	return true;
	}

}
