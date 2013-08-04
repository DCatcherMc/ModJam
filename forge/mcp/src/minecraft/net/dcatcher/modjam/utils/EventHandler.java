package net.dcatcher.modjam.utils;

import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.hostile.creeper.EntityReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.dcatcher.modjam.items.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventHandler {

	@ForgeSubscribe
	public void onDeath(LivingDeathEvent event){
		if(event.entityLiving instanceof EntitySheep && !event.entityLiving.isChild()){
			if(!event.entityLiving.worldObj.isRemote)
				event.entityLiving.dropItem(ItemHandler.itemMuttonRaw.itemID, 2);
		}
	}
	
	@ForgeSubscribe
	public void onInteract(EntityInteractEvent event){
		EntityLiving entity = (EntityLiving)event.target;
		EntityPlayer player = event.entityPlayer;
		World world = event.entity.worldObj;
		
		int xCoord = 0, yCoord = 0, zCoord = 0;
		float yaw = 0, pitch = 0;
		
		xCoord = (int)entity.posX;
		yCoord = (int)entity.posY;
		zCoord = (int)entity.posZ;
		yaw = entity.rotationYaw;
		pitch = entity.rotationPitch;
		
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ItemHandler.disguiser.itemID){
			if(entity instanceof EntitySheep && !entity.isChild()){
				int color = ((EntitySheep) entity).getFleeceColor();
				entity.setDead();
				EntityReplacedSheep e = new EntityReplacedSheep(world);
				if(!world.isRemote){
					e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
					e.setFleeceColor(color);
					world.spawnEntityInWorld(e);
				}
			}
			
			
			if(entity instanceof EntityCow && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedCow(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
			}
				
			if(entity instanceof EntityEnderman && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedEnderman(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
			}
			
			if(entity instanceof EntitySpider && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedSpider(world);
				e.setLocationAndAngles(xCoord, yCoord, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
			}
			
			if(entity instanceof EntityCreeper && !entity.isChild()){
				entity.setDead();
				Entity e = new EntityReplacedCreeper(world);
				e.setLocationAndAngles(xCoord, yCoord + 1, zCoord, yaw, pitch);
				if(!world.isRemote){
					world.spawnEntityInWorld(e);
				}
			}
			
			
			if(entity instanceof EntityPig && !entity.isChild()){
				((EntityPig) entity).setSaddled(true);
				}
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
		}
	}
}
