package net.dcatcher.modjam.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemMuttonCooked extends ItemFood {

	public ItemMuttonCooked(int par1) {
		super(par1, 8, 0.8F, true);
		setUnlocalizedName(DCModInfo.FOOD_MUTTONCOOKED_NAME);
		setCreativeTab(ModJam.tabJam);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:mutton_cooked");
	}

	
}
