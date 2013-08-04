package net.dcatcher.modjam.proxy;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.cow.RenderReplacedCow;
import net.dcatcher.modjam.entity.hostile.creeper.EntityReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.creeper.RenderReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.enderman.RenderReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.modjam.entity.hostile.spider.RenderReplacedSpider;
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
		EntityRegistry.registerModEntity(EntityReplacedSheep.class, "TamedSheep", 1, ModJam.instance, 80, 3, true);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedCow.class, new RenderReplacedCow(new ModelCow(), 0.7F));
		EntityRegistry.registerModEntity(EntityReplacedCow.class, "TamedCow", 2, ModJam.instance, 80, 3, true);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedEnderman.class, new RenderReplacedEnderman());
		EntityRegistry.registerModEntity(EntityReplacedEnderman.class, "TamedEnderman", 3, ModJam.instance, 80, 3, true);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSpider.class, new RenderReplacedSpider());
		EntityRegistry.registerModEntity(EntityReplacedSpider.class, "TamedSpider", 4, ModJam.instance, 80, 3, true);
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedCreeper.class, new RenderReplacedCreeper());
		EntityRegistry.registerModEntity(EntityReplacedCreeper.class, "TamedCreeper", 5, ModJam.instance, 80, 3, true);
		
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
