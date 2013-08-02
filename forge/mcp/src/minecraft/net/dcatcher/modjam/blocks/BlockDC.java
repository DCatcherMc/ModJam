package net.dcatcher.modjam.blocks;

import net.dcatcher.modjam.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDC extends Block {

	public BlockDC(int id, Material material) {
		super(id, material);
		setCreativeTab(ModJam.tabJam);
	}

}

