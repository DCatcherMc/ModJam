package net.dcatcher.modjam.utils;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class DCConfig {

	public static int idInfusedBrick;
	public static int idInfernalBurner;
	public static int idDiamondShard;
	public static int idCrushedDiamond;
	
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
		idCrushedDiamond = c.getItem("BallOfCrushedDiamond", 5001).getInt();
		
		//Save config:
		c.save();
	}
	
}
