package net.dcatcher.modjam.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockInfusedBrick extends BlockDC {

	public BlockInfusedBrick(int id) {
		super(id, Material.rock);
		setUnlocalizedName(DCModInfo.BLOCK_INFUSED_BRICK_UNLOCALIZED);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		ir.registerIcon("dcmodjam:infused_bricks");
	}

}
