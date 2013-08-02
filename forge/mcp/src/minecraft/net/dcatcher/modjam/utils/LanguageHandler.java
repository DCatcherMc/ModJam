package net.dcatcher.modjam.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

	public static void registerLangs(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.DCatcher",
															"DCatcher's Tab!");
	
		//Blocks:
		LanguageRegistry.instance().addStringLocalization("tile.blockInfusedBrick.name",
															"Infused Bricks");
		LanguageRegistry.instance().addStringLocalization("tile.blockInfernalFurnace.name",
															"Infernal Furnace Core");
		
		//TileEntities:
		LanguageRegistry.instance().addStringLocalization("container.burner", "Infernal Burner");

	}
	
}
