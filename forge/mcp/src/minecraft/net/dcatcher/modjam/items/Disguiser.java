package net.dcatcher.modjam.items;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.EntityReplacedSheep;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
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
		EntityLiving eLiving = (EntityLiving)entity;
		if(eLiving instanceof EntitySheep){
			int xCoord = eLiving.serverPosX;
			int yCoord = eLiving.serverPosY;
			int zCoord = eLiving.serverPosZ;
			
			World world = eLiving.worldObj;
			
			
		}
		player.mountEntity(eLiving);
	return true;
	}

}
