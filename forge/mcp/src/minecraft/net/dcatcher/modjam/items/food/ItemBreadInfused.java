package net.dcatcher.modjam.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemBreadInfused extends ItemFood {

	public ItemBreadInfused(int id){
		super(id, 7, 0.9F, false);
		setUnlocalizedName(DCModInfo.FOOD_BREAD_I_NAME);
		setCreativeTab(ModJam.tabJam);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		ir.registerIcon("dcmodjam:bread_infused");
	}
}
