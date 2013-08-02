package net.dcatcher.modjam;

import cpw.mods.fml.common.registry.GameRegistry;
import net.dcatcher.modjam.blocks.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DCRecipes {

	public static ItemStack stackEmerald1 = new ItemStack(Item.emerald, 1);
	public static ItemStack stackDiamond1 = new ItemStack(Item.diamond, 1);
	public static ItemStack stackStoneBricks1 = new ItemStack(Block.stoneBrick, 1);
	
	public static ItemStack stackInfusedBrick4 = new ItemStack(BlockHandler.blockInfusedBrick, 4);
	
	
	public static void registerRecipes(){
		GameRegistry.addShapedRecipe(stackInfusedBrick4, " b ", "beb", " b ", 'b', stackStoneBricks1, 'e', stackEmerald1);
	}
}
