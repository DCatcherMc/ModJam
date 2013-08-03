package net.dcatcher.modjam.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemMuttonInfused extends ItemFood {

	public ItemMuttonInfused(int par1){
		super(par1, 10, 0.9F, true);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.FOOD_MUTTON_I_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:infused_mutton");
	}
	
	

}
