package net.dcatcher.modjam.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.dcatcher.modjam.utils.DCConfig;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.block.Block;

public class BlockHandler {
	
	public static Block blockInfusedBrick;
	
	public static BlockInfernalBurner blockInfernalBurner;

	public static void register(){
		blockInfusedBrick = new BlockInfusedBrick(DCConfig.idInfusedBrick);
		GameRegistry.registerBlock(blockInfusedBrick, DCModInfo.BLOCK_INFUSED_BRICK_UNLOCALIZED);
		
		blockInfernalBurner = new BlockInfernalBurner(DCConfig.idInfernalBurner);
		GameRegistry.registerBlock(blockInfernalBurner, DCModInfo.BLOCK_INFERNAL_BURNER_UNLOCALIZED);
		
		
	}
}
