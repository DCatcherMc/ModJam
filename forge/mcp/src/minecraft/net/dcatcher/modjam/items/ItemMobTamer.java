package net.dcatcher.modjam.items;

import net.dcatcher.modjam.ModJam;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobTamer extends Item {

	public ItemMobTamer(int par1) {
		super(par1);
		setUnlocalizedName("mobTamer");
		setMaxStackSize(1);
		setCreativeTab(ModJam.tabJam);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mystic_saddle");
	}
	

}
