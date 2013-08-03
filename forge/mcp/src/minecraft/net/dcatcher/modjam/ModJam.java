package net.dcatcher.modjam;

import net.dcatcher.modjam.blocks.BlockHandler;
import net.dcatcher.modjam.entity.sheep.EntityReplacedSheep;
import net.dcatcher.modjam.entity.sheep.ModelSheep1;
import net.dcatcher.modjam.entity.sheep.ModelSheep2;
import net.dcatcher.modjam.entity.sheep.RenderReplacedSheep;
import net.dcatcher.modjam.items.ItemHandler;
import net.dcatcher.modjam.proxy.ClientProxy;
import net.dcatcher.modjam.proxy.CommonProxy;
import net.dcatcher.modjam.tileentities.TileEntityInfernalBurner;
import net.dcatcher.modjam.utils.DCConfig;
import net.dcatcher.modjam.utils.DCCreativeTab;
import net.dcatcher.modjam.utils.DCPacketHandler;
import net.dcatcher.modjam.utils.LanguageHandler;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid="DCatcherModJam", name="DCatcherModJam", version="p1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"DCModJam"}, packetHandler	= DCPacketHandler.class)
public class ModJam {
	

	
	@Instance
	public static ModJam instance = new ModJam();
	
	@SidedProxy(clientSide="net.dcatcher.modjam.proxy.ClientProxy", serverSide="net.dcatcher.modjam.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabJam = new DCCreativeTab(CreativeTabs.getNextID(), "DCatcher");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		DCConfig.registerConfig(e.getModConfigurationDirectory());
		MinecraftForge.EVENT_BUS.register(net.dcatcher.modjam.utils.EventHandler.class);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		BlockHandler.register(); 			//Registers ALL the blocks!
		ItemHandler.registerItems();		//registers items
		ClientProxy.registerRendering();
		LanguageHandler.registerLangs();	//Registers my language stuffs
		
		DCRecipes.registerRecipes();
		
		GameRegistry.registerTileEntity(TileEntityInfernalBurner.class, "tileEntityInfernalBurner");
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
	
	
}
