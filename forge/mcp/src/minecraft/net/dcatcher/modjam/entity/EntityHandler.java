package net.dcatcher.modjam.entity;

import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.entity.cow.EntityReplacedCow;
import net.dcatcher.modjam.entity.hostile.creeper.EntityReplacedCreeper;
import net.dcatcher.modjam.entity.hostile.enderman.EntityReplacedEnderman;
import net.dcatcher.modjam.entity.hostile.skeleton.EntityReplacedSkeleton;
import net.dcatcher.modjam.entity.hostile.slime.EntityReplacedSlime;
import net.dcatcher.modjam.entity.hostile.spider.EntityReplacedSpider;
import net.dcatcher.modjam.entity.hostile.zombie.EntityReplacedZombie;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

	public static void register(){
		EntityRegistry.registerModEntity(EntityReplacedSheep.class, "TamedSheep", 1, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedCow.class, "TamedCow", 2, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedEnderman.class, "TamedEnderman", 3, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedSpider.class, "TamedSpider", 4, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedCreeper.class, "TamedCreeper", 5, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedZombie.class, "TamedZombie", 6, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedSlime.class, "TamedSlime", 7, ModJam.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityReplacedSkeleton.class, "TamedSkeleton", 8, ModJam.instance, 80, 3, true);

	}
	
}
