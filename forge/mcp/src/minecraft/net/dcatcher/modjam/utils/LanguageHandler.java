package net.dcatcher.modjam.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

	public static void registerLangs(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.DCatcher", "DCatcher's Tab!");
	}
	
}
