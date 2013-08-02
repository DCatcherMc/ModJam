package net.dcatcher.modjam.utils;

import net.dcatcher.modjam.items.ItemHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventHandler {

	@ForgeSubscribe
	public void entityInteractEvent(EntityInteractEvent e){
		EntityLiving entity = (EntityLiving)e.target;
		System.out.println("INTERACTING");
		if(e.entityPlayer.getCurrentEquippedItem().itemID == ItemHandler.disguiser.itemID){
		e.entityPlayer.mountEntity(e.target);
		entity.tasks.addTask(1, new EntityAIControlledByPlayer(entity, 0.34F));
		}
	}
}
