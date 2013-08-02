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
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ModJam {
	
	 static int startEntityId = 300;

	
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
		ItemHandler.registerItems();		//registers items
		ClientProxy.registerRendering();
		LanguageHandler.registerLangs();	//Registers my language stuffs
		
		DCRecipes.registerRecipes();
		
		GameRegistry.registerTileEntity(TileEntityInfernalBurner.class, "tileEntityInfernalBurner");
	
		MinecraftForge.EVENT_BUS.register(net.dcatcher.modjam.utils.EventHandler.class);
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityReplacedSheep.class, new RenderReplacedSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
		EntityRegistry.registerModEntity(EntityReplacedSheep.class, "ReplacedSheep", 1, this, 80, 3, true);
		  registerEntityEgg(EntityReplacedSheep.class, 0xffffff, 0x000000);

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
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
