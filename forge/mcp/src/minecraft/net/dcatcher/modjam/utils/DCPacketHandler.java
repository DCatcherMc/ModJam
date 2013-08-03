package net.dcatcher.modjam.utils;

import java.io.DataInputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

public class DCPacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {

		if(packet.channel.equals("DCModJam")){
			handleDCPacket(packet);
		}
		
	}
	
	private void handleDCPacket(Packet250CustomPayload packet){
		DataInputStream
	}

}
