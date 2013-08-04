package net.dcatcher.modjam.entity.sheep;

import net.minecraft.entity.Entity;

import com.google.common.base.Function;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.EntitySpawnPacket;
import cpw.mods.fml.relauncher.Side;

public class SpawnEntitySheep implements Function<EntitySpawnPacket, Entity>{

	@Override
	public Entity apply(EntitySpawnPacket input) {
		if(FMLCommonHandler.instance().getEffectiveSide().equals(Side.CLIENT)){
			return new EntityReplacedSheep(FMLClientHandler.instance().getClient().theWorld);
		}
		return null;
	}

}
