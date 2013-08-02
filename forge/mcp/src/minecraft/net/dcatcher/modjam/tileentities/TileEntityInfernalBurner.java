package net.dcatcher.modjam.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfernalBurner extends TileEntity implements ISidedInventory{

	public int burnerBurnTime;
	
    public int currentItemBurnTime;
    
    public int furnaceCookTime;
	
    
    private ItemStack[] burnerItemStacks = new ItemStack[3];
	@Override
	public int getSizeInventory() {
		return burnerItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return burnerItemStacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		 if (this.burnerItemStacks[i] != null)
	        {
	            ItemStack itemstack;

	            if (this.burnerItemStacks[i].stackSize <= j)
	            {
	                itemstack = this.burnerItemStacks[i];
	                this.burnerItemStacks[i] = null;
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.burnerItemStacks[i].splitStack(j);

	                if (this.burnerItemStacks[i].stackSize == 0)
	                {
	                    this.burnerItemStacks[i] = null;
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
		if (this.burnerItemStacks[i] != null)
        {
            ItemStack itemstack = this.burnerItemStacks[i];
            this.burnerItemStacks[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.burnerItemStacks[i] = itemstack;
		
		if()
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		return false;
	}


}
