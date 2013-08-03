package net.dcatcher.modjam.items;

import net.dcatcher.modjam.utils.DCConfig;
import net.minecraft.item.Item;
import net.dcatcher.modjam.items.food.*;

public class ItemHandler {

	public static Item diamondShard;
	
	public static Item disguiser;
	
	public static Item itemBeefInfused, itemPorkInfused, itemMutton, itemMuttonInfused,
						itemBreadInfused, itemAppleInfused;
	
	public static void registerItems(){
		diamondShard = new ItemDiamondShard(DCConfig.idDiamondShard -256);
		
		disguiser = new ItemMobTamer(DCConfig.idDisguiser -256);
		
		itemBeefInfused = new ItemBeefInfused(DCConfig.idBeefInfused - 256);
		itemPorkInfused = new ItemPorkInfused(DCConfig.idPorkInfused - 256);
		itemMutton = new ItemMutton(DCConfig.idMutton - 256);
		itemMuttonInfused = new ItemMuttonInfused(DCConfig.idMuttonInfused - 256);
		itemBreadInfused = new ItemBreadInfused(DCConfig.idBreadInfused - 256);
		itemAppleInfused = new ItemAppleInfused(DCConfig.idAppleInfused - 256);
		
	}

}
