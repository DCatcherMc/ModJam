package net.dcatcher.modjam.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

	public static void registerLangs(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.DCatcher",
															"ModJam [DC]");
	
		//Blocks:
		LanguageRegistry.instance().addStringLocalization("tile.blockInfusedBrick.name",
															"Infused Bricks");
		
		//Items:
		LanguageRegistry.instance().addStringLocalization("item.shardDiamond.name", "Diamond Shard");
		LanguageRegistry.instance().addStringLocalization("item.ballOfCrushedDiamond.name", "Ball of Crushed Diamond");
		LanguageRegistry.instance().addStringLocalization("item.mobTamer.name", "Mystic Saddle");
		LanguageRegistry.instance().addStringLocalization("item.wandOfGrowth.name", "Wand Of Growth");
		LanguageRegistry.instance().addStringLocalization("item.wandOfRiding.name", "Wand Of Riding");
		LanguageRegistry.instance().addStringLocalization("item.itemInfusionDust.name", "Infusion Dust");
		
		
		//Foods:
		LanguageRegistry.instance().addStringLocalization("item.foodBeefInfused.name", "Infused Beed");
		LanguageRegistry.instance().addStringLocalization("item.foodPorkInfused.name", "Infused Porkchop");
		LanguageRegistry.instance().addStringLocalization("item.foodMuttonRaw.name", "Raw Mutton");
		LanguageRegistry.instance().addStringLocalization("item.foodMuttonCooked.name", "Cooked Mutton");
		LanguageRegistry.instance().addStringLocalization("item.foodMuttonInfused.name", "Infused Mutton");
		LanguageRegistry.instance().addStringLocalization("item.foodBreadInfused.name", "Infused Bread");
		LanguageRegistry.instance().addStringLocalization("item.foodAppleInfused.name", "Infused Apple");


		//MobNames:
		

	}
	
}
