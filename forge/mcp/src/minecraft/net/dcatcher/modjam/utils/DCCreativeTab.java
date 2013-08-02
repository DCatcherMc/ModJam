package net.dcatcher.modjam.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class DCCreativeTab extends CreativeTabs{

	public DCCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public int getItemIndex(){
		return 1;
	}
	
}
