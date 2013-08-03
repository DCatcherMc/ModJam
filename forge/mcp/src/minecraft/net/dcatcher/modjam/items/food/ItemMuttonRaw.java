package net.dcatcher.modjam.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemMuttonRaw extends ItemFood{

	public ItemMuttonRaw(int par1) {
		super(par1, 4, 0.5f, true);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.FOOD_MUTTONRAW_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mutton_raw");
	}


}
