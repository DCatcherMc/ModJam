package net.dcatcher.modjam.utils;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class DCConfig {

	public static int idInfusedBrick;
	public static int idInfernalBurner;
	public static int idDiamondShard;
	
	public static int idDisguiser;
	public static int idBeefInfused, idPorkInfused, idMutton, idMuttonInfused, idBreadInfused, idAppleInfused;
	
	public static void registerConfig(File directory){
		File configFile = new File(directory + "/DCatcher.cfg");
		try{
			configFile.createNewFile();
		}catch(IOException ex){
			System.out.println("Cannot make DCatcher's ModJam configuration. OH NOES");
			ex.printStackTrace();
		}
		
		Configuration c = new Configuration(configFile);
		
		
		//Load config:
		c.load();
		idInfusedBrick = c.getBlock("InfusedBrick", 500).getInt();
		idInfernalBurner = c.getBlock("InfernalBurner", 501).getInt();
		
		idDiamondShard = c.getItem("DiamondShard", 5000).getInt();
		
		idDisguiser = c.getItem("MobTamer", 5005).getInt();
		
		//Foods:
		idBeefInfused = c.getItem("InfusedBeef", 5010).getInt();
		idPorkInfused = c.getItem("InfusedPork", 5011).getInt();
		idMutton = c.getItem("Mutton", 5012).getInt();
		idMuttonInfused = c.getItem("InfusedMutton", 5013).getInt();
		idBreadInfused = c.getItem("InfusedBread", 5014).getInt();
		idAppleInfused = c.getItem("InfusedApple", 5015).getInt();
		
		
		
		//Save config:
		c.save();
	}
	
}
