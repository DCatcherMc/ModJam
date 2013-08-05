package net.dcatcher.modjam;

import cpw.mods.fml.common.registry.GameRegistry;
import net.dcatcher.modjam.blocks.BlockHandler;
import net.dcatcher.modjam.items.ItemHandler;
import net.dcatcher.modjam.utils.DCConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DCRecipes {

	public static ItemStack stackEmerald1 = new ItemStack(Item.emerald, 1);
	public static ItemStack stackDiamond1 = new ItemStack(Item.diamond, 1);
	public static ItemStack stackStoneBricks1 = new ItemStack(Block.stoneBrick, 1);
	
	public static ItemStack stackInfusedBrick4 = new ItemStack(BlockHandler.blockInfusedBrick, 4);
	public static ItemStack stackDiamondShard9 = new ItemStack(ItemHandler.diamondShard, 9);
	
	public static void registerRecipes(){
		GameRegistry.addShapedRecipe(stackInfusedBrick4, " b ", "beb", " b ", 'b', stackStoneBricks1, 'e', stackDiamondShard9);
	
		GameRegistry.addShapelessRecipe(stackDiamondShard9, stackDiamond1);
		GameRegistry.addShapedRecipe(stackDiamond1, "ddd","ddd", "ddd", 'd', stackDiamondShard9);
		
		//Adding a saddle recipe
		if(DCConfig.saddleRecipe){
			GameRegistry.addShapedRecipe(new ItemStack(Item.saddle, 1), "lll","l l","i i", 'i', new ItemStack(Item.ingotIron, 1), 'l', new ItemStack(Item.leather, 1));
		}
		
		//Adding Mystic Saddle recipe!
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.disguiser, 1), new ItemStack(Item.saddle, 1), new ItemStack(ItemHandler.infusionDust, 1));
		
		//Adding the food recipes:
		GameRegistry.addSmelting(ItemHandler.itemMuttonRaw.itemID, new ItemStack(ItemHandler.itemMuttonCooked, 1), 2f);
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.itemAppleInfused, 1), new ItemStack(Item.appleRed, 1), new ItemStack(ItemHandler.infusionDust, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.itemBeefInfused, 1), new ItemStack(Item.beefCooked, 1), new ItemStack(ItemHandler.infusionDust, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.itemPorkInfused, 1), new ItemStack(Item.porkRaw, 1), new ItemStack(ItemHandler.infusionDust, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.itemMuttonInfused, 1), new ItemStack(ItemHandler.itemMuttonCooked, 1), new ItemStack(ItemHandler.infusionDust, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.itemBreadInfused, 1), new ItemStack(Item.bread, 1), new ItemStack(ItemHandler.infusionDust, 1));

		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemHandler.infusionDust, 2), new ItemStack(Item.redstone, 1), new ItemStack(Item.sugar, 1));

		
	}
}
