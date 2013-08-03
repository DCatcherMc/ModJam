package net.dcatcher.modjam.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class WOGEventHandler {

	
	@ForgeSubscribe
	public void onInteract(EntityInteractEvent event){
		EntityPlayer player = event.entityPlayer;
		if(event.entityLiving != null && event.entityLiving.isChild()){
		}
	
	}
}
