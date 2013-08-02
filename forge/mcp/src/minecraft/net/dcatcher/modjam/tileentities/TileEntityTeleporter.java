package net.dcatcher.modjam.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTeleporter extends TileEntity implements IInventory{
	
	public ItemStack[] slot = new ItemStack[1];

	public TileEntityTeleporter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slot[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		 if (this.slot[i] != null)
	        {
	            ItemStack itemstack;

	            if (this.slot[i].stackSize <= j)
	            {
	                itemstack = this.slot[i];
	                this.slot[i] = null;
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.slot[i].splitStack(j);

	                if (this.slot[i].stackSize == 0)
	                {
	                    this.slot[i] = null;
	                }

	                return itemstack;
	            }
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slot[i] != null)
        {
            ItemStack itemstack = this.slot[i];
            this.slot[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slot[i] = itemstack;
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "container.teleporter";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

}
