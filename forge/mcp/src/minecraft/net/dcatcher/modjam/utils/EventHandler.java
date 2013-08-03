package net.dcatcher.modjam.utils;

import net.dcatcher.modjam.items.ItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

public class EventHandler {

	
	@ForgeSubscribe
	public void onMobDeath(LivingDeathEvent e){
		Entity entity = e.entity;
		DamageSource source = e.source;
		
		if(source == DamageSource.magic){
			if (entity instanceof EntityPig){
				entity.dropItem(par1, par2);
				//TODO Items!
			}
		}
	}
	
}
