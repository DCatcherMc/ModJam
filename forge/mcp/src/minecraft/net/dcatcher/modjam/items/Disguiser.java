package net.dcatcher.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Disguiser extends Item {

	public Disguiser(int par1) {
		super(par1);
		setUnlocalizedName("disguiser");
		setMaxStackSize(1);
		setCreativeTab(ModJam.tabJam);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mystic_saddle");
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
			double xCoord = entity.posX;
			double yCoord = entity.posY;
			double zCoord = entity.posZ;
			float yaw = entity.rotationYaw;
			float pitch = entity.rotationPitch;
			

			World world = entity.worldObj;
			if(entity instanceof EntitySheep ){
				entity.setDead();
				Entity e = new EntityReplacedSheep(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
				
				
				EntityLiving replacedMob = (EntityLiving)e;
				
				replacedMob.tasks.addTask(1, new EntityAIControlledByPlayer(replacedMob, 1F));
				}
			
			
			if(entity instanceof EntityCow ){
				entity.setDead();
				Entity e = new EntityReplacedCow(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
				
				
				EntityLiving replacedMob = (EntityLiving)e;
				
				replacedMob.tasks.addTask(1, new EntityAIControlledByPlayer(replacedMob, 1F));
				}
			
			if(entity instanceof EntityEnderman ){
				entity.setDead();
				Entity e = new EntityReplacedEnderman(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
				
				
				EntityLiving replacedMob = (EntityLiving)e;
				
				replacedMob.tasks.addTask(1, new EntityAIControlledByPlayer(replacedMob, 1F));
				}
		
			
			if(entity instanceof EntitySpider ){
				entity.setDead();
				Entity e = new EntityReplacedSpider(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
				
				
				EntityLiving replacedMob = (EntityLiving)e;
				
				replacedMob.tasks.addTask(1, new EntityAIControlledByPlayer(replacedMob, 1F));
				}
			player.clearItemInUse();
			
			return true;
	}
	
	

}
