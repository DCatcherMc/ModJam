package net.dcatcher.modjam.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockInfernalBurner extends BlockContainer {
	
	private Icon top, blockIconLit;
	
	public BlockInfernalBurner(int par1, Material par2Material) {
		super(par1, par2Material);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.BLOCK_INFERNAL_FURNACE_UNLOCALIZED);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		top = ir.registerIcon("dcmodjam:infused_bricks");
		blockIconLit = ir.registerIcon("dcmodjam:infused_burner_on");
		blockIcon = ir.registerIcon("dcmodjam:infused_burner_off");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if(side == 1 || side == 0){
			return top;
			
		if(meta == 1)
			return blockIconLit;
		
		return blockIcon;
	}
		
		
	}
}
