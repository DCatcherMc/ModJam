package net.dcatcher.modjam.entity;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityReplacedSheep extends EntitySheep{

	public EntityReplacedSheep(World par1World) {
		super(par1World);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	 public boolean canBeSteered()
    {
       return true;
    }

	

}
