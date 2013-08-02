package net.dcatcher.modjam.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemBallCrushedDiamond extends Item {

	public ItemBallCrushedDiamond(int par1) {
		super(par1);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		itemIcon = ir.registerIcon("dcmodjam:ball_crushed_diamond");
	}
}
