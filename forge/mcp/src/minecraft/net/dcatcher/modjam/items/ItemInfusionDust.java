package net.dcatcher.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemInfusionDust extends Item {

	public ItemInfusionDust(int par1) {
		super(par1);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.ITEM_INFUSION_DUST);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:infusion_dust");
	}

}
