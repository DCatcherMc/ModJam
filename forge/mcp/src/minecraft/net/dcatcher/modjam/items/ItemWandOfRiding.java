package net.dcatcher.modjam.items;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemWandOfRiding extends Item {

	public ItemWandOfRiding(int par1) {
		super(par1);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.WAND_OF_RIDING_NAME);
		setMaxDamage(100);
		setMaxStackSize(1);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		
		if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == ItemHandler.wandOfRiding.itemID){
			player.mountEntity(entity);
			player.getCurrentEquippedItem().damageItem(1, player);
		}
		
		return false;
	}
	

}
