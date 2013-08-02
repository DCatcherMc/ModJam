package net.dcatcher.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBallCrushedDiamond extends Item {

	public ItemBallCrushedDiamond(int par1) {
		super(par1);
		setUnlocalizedName(DCModInfo.ITEM_BALL_OF_CRUSHED_DIAMOND_UNLOCALIZED);
		setCreativeTab(ModJam.tabJam);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:ball_crushed_diamond");
	}
}
