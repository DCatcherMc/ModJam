package net.dcatcher.modjam.tileentities;

import net.dcatcher.modjam.blocks.BlockHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityInfernalBurner extends TileEntity implements ISidedInventory{

	public int burnerBurnTime;
	
    public int currentItemBurnTime;
    
    public int furnaceCookTime;
	
    
    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};

    
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
		
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "container.burner";
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
		//TODO -> THIS PART
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
        return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
        return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
        return j != 0 || i != 1 || itemstack.itemID == Item.bucketEmpty.itemID;
	}
	
    
    public boolean checkValidity(World world, int x, int y, int z){
    	if(checkSquare(world, x, y-1, z)){
    		return true;
    	}
    	return false;
    }
    
    public boolean checkSquare(World world, int x, int y, int z){
    	int goodId = BlockHandler.blockInfusedBrick.blockID;
    	
    	//Worst coding - will improve.
    	
    	if(world.getBlockId(x-1, y, z-1) == goodId
    			&& world.getBlockId(x, y, z-1) == goodId
    			&& world.getBlockId(x+1, y, z-1) == goodId
    			
    			&& world.getBlockId(x-1, y, z) == goodId
    			&& world.getBlockId(x, y, z) == goodId
    			&& world.getBlockId(x+1, y, z) == goodId
    			
    			&& world.getBlockId(x-1, y, z+1) == goodId
    			&& world.getBlockId(x, y, z+1) == goodId
    			&& world.getBlockId(x+1, y, z+1) == goodId
    			){
    		return true;
    	}
    	
    	
    	return false;
    }


}
