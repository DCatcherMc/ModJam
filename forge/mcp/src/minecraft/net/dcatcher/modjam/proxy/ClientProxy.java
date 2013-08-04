package net.dcatcher.modjam.proxy;

import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.cow.RenderReplacedCow;
import net.dcatcher.modjam.entity.hostile.creeper.EntityReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.creeper.RenderReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.enderman.RenderReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.slime.EntityReplacedSlime;
import net.dcatcher.modjam.entity.hostile.slime.RenderReplacedSlime;
import net.dcatcher.modjam.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.modjam.entity.hostile.spider.RenderReplacedSpider;
import net.dcatcher.modjam.entity.hostile.zombie.EntityReplacedZombie;
import net.dcatcher.modjam.entity.hostile.zombie.RenderReplacedZombie;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.dcatcher.modjam.entity.sheep.ModelSheep1;
import net.dcatcher.modjam.entity.sheep.ModelSheep2;
import net.dcatcher.modjam.entity.sheep.RenderReplacedSheep;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy{
	 
	static int startEntityId = 300;
	
	public void registerRendering() {
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSheep.class, new RenderReplacedSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedCow.class, new RenderReplacedCow(new ModelCow(), 0.7F));
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedEnderman.class, new RenderReplacedEnderman());
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSpider.class, new RenderReplacedSpider());
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedCreeper.class, new RenderReplacedCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedZombie.class, new RenderReplacedZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSlime.class, new RenderReplacedSlime(new ModelSlime(16), new ModelSlime(0), 0.25f));
		
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
