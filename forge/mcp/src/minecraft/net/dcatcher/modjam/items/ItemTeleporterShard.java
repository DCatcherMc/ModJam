package net.dcatcher.modjam.items;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.item.Item;

public class ItemTeleporterShard extends Item {

	public ItemTeleporterShard(int par1) {
		super(par1);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.ITEM_TELEPORTER_SHARD);
	}

}
