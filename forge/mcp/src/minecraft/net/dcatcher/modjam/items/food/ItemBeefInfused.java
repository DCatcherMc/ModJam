package net.dcatcher.modjam.items.food;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class ItemBeefInfused extends ItemFood {

	public ItemBeefInfused(int id) {
		super(id, 10, 0.8F, false);
		setUnlocalizedName(DCModInfo.FOOD_BEEF_I_NAME);
		setCreativeTab(ModJam.tabJam);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:infused_beef");
	}

}
