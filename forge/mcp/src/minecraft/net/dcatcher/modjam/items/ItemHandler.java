package net.dcatcher.modjam.items;

import net.dcatcher.modjam.utils.DCConfig;
import net.minecraft.item.Item;

public class ItemHandler {

	public static Item diamondShard, ballOfCrushedDiamond;
	
	public static void registerItems(){
		diamondShard = new ItemDiamondShard(DCConfig.idDiamondShard);
		ballOfCrushedDiamond = new ItemBallCrushedDiamond(DCConfig.idCrushedDiamond);
		
	}

}
