package net.dcatcher.modjam.proxy;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.bat.EntityReplacedBat;
import net.dcatcher.modjam.entity.bat.RenderReplacedBat;
import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.cow.RenderReplacedCow;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.dcatcher.modjam.entity.sheep.ModelSheep1;
import net.dcatcher.modjam.entity.sheep.ModelSheep2;
import net.dcatcher.modjam.entity.sheep.RenderReplacedSheep;
import net.minecraft.client.model.ModelCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;


public class ClientProxy extends CommonProxy{
	 
	static int startEntityId = 300;

	public static void registerRendering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSheep.class, new RenderReplacedSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
		EntityRegistry.registerModEntity(EntityReplacedSheep.class, "ReplacedSheep", 1, ModJam.instance, 80, 3, true);
		registerEntityEgg(EntityReplacedSheep.class, 0xffffff, 0x000000);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedCow.class, new RenderReplacedCow(new ModelCow(), 0.7F));
		EntityRegistry.registerModEntity(EntityReplacedCow.class, "ReplacedCow", 2, ModJam.instance, 80, 3, true);
		registerEntityEgg(EntityReplacedCow.class, 0x545454, 0x111111);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedBat.class, new RenderReplacedBat());
		EntityRegistry.registerModEntity(EntityReplacedBat.class, "ReplacedBat", 3, ModJam.instance, 80, 3, true);
		registerEntityEgg(EntityReplacedBat.class, 0x111111, 0x222222);
	
	}
	
	public static int getUniqueEntityId() 
	 {
	  do 
	  {
	   startEntityId++;
	  } 
	  while (EntityList.getStringFromID(startEntityId) != null);

	   return startEntityId;
	 }
	 
	 public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	 {
	  int id = getUniqueEntityId();
	  EntityList.IDtoClassMapping.put(id, entity);
	  EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	 }
	 


}
