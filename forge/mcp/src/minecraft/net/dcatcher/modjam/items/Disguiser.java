package net.dcatcher.modjam.items;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.dcatcher.modjam.ModJam;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
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
		EntityAIControlledByPlayer entityai = new EntityAIControlledByPlayer(eLiving, 1);
		eLiving.tasks.addTask(1, new EntityAIControlledByPlayer(eLiving, 0.34F));
		boolean steerable = eLiving.canBeSteered();
		player.mountEntity(eLiving);
	return true;
	}

}
