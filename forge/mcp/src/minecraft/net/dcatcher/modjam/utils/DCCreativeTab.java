package net.dcatcher.modjam.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.items.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class DCCreativeTab extends CreativeTabs{

	public DCCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		return ItemHandler.disguiser;
	}
	
}
