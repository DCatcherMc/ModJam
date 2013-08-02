package net.dcatcher.modjam;

import net.dcatcher.modjam.blocks.BlockHandler;
import net.dcatcher.modjam.proxy.ClientProxy;
import net.dcatcher.modjam.proxy.CommonProxy;
import net.dcatcher.modjam.tileentities.TileEntityInfernalBurner;
import net.dcatcher.modjam.utils.DCConfig;
import net.dcatcher.modjam.utils.DCCreativeTab;
import net.dcatcher.modjam.utils.LanguageHandler;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid="DCatcherModJam", name="DCatcherModJam", version="p1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ModJam {
	
	@Instance
	public static ModJam instance = new ModJam();
	
	@SidedProxy(clientSide="net.dcatcher.modjam.proxy.ClientProxy", serverSide="net.dcatcher.modjam.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabJam = new DCCreativeTab(CreativeTabs.getNextID(), "DCatcher");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		DCConfig.registerConfig(e.getModConfigurationDirectory());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		BlockHandler.register(); 			//Registers ALL the blocks!
		ClientProxy.registerRendering();
		LanguageHandler.registerLangs();	//Registers my language stuffs
		
		GameRegistry.registerTileEntity(TileEntityInfernalBurner.class, "tileEntityInfernalBurner");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
