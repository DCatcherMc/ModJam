package net.dcatcher.modjam.items;

import net.dcatcher.modjam.utils.DCConfig;
import net.minecraft.item.Item;

public class ItemHandler {

	public static Item diamondShard, ballOfCrushedDiamond;
	
	public static Item teleporterShard;
	public static Item disguiseTag;
	public static Item disguiser;
	
	public static void registerItems(){
		diamondShard = new ItemDiamondShard(DCConfig.idDiamondShard -256);
		ballOfCrushedDiamond = new ItemBallCrushedDiamond(DCConfig.idCrushedDiamond -256);
		
		teleporterShard = new ItemTeleporterShard(DCConfig.idTeleporterShard -256);
		
		disguiseTag = new ItemDisguiseTag(DCConfig.idDisguiserTag);
		disguiser = new Disguiser(DCConfig.idDisguiser);
		
	}

}
