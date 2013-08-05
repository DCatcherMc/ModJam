package net.dcatcher.modjam.items;

import net.dcatcher.modjam.utils.DCConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.dcatcher.modjam.items.food.*;

public class ItemHandler {

	public static Item diamondShard;
	
	public static Item disguiser, wandOfGrowth, wandOfRiding;
	
	public static Item itemBeefInfused, itemPorkInfused, itemMuttonRaw, itemMuttonCooked, itemMuttonInfused,
						itemBreadInfused, itemAppleInfused;

	public static Item infusionDust;
	
	public static void registerItems(){
		diamondShard = new ItemDiamondShard(DCConfig.idDiamondShard -256);
		
		disguiser = new ItemMobTamer(DCConfig.idDisguiser -256);
		//wandOfGrowth = new ItemWandOfGrowth(DCConfig.idWandofGrowth -256);
		wandOfRiding = new ItemWandOfRiding(DCConfig.idWandofRiding -256);
		
		infusionDust = new ItemInfusionDust(DCConfig.idInfusionDust -256);
		
		
		
		itemBeefInfused = new ItemBeefInfused(DCConfig.idBeefInfused - 256);
		itemPorkInfused = new ItemPorkInfused(DCConfig.idPorkInfused - 256);
		itemMuttonRaw = new ItemMuttonRaw(DCConfig.idMuttonRaw - 256);
		itemMuttonCooked = new ItemMuttonCooked(DCConfig.idMuttonCooked - 256);
		itemMuttonInfused = new ItemMuttonInfused(DCConfig.idMuttonInfused - 256);
		itemBreadInfused = new ItemBreadInfused(DCConfig.idBreadInfused - 256);
		itemAppleInfused = new ItemAppleInfused(DCConfig.idAppleInfused - 256);
		
	}

}
