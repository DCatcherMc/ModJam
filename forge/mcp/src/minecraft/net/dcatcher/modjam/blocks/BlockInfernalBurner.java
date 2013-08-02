package net.dcatcher.modjam.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dcatcher.modjam.ModJam;
import net.dcatcher.modjam.tileentities.TileEntityInfernalBurner;
import net.dcatcher.modjam.utils.DCModInfo;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockInfernalBurner extends BlockContainer {
	
	private Icon top, blockIconLit;
	
	TileEntityInfernalBurner te = new TileEntityInfernalBurner();
	
	public BlockInfernalBurner(int par1) {
		super(par1, Material.rock);
		setCreativeTab(ModJam.tabJam);
		setUnlocalizedName(DCModInfo.BLOCK_INFERNAL_BURNER_UNLOCALIZED);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return te;
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
		if(side == 1 || side == 0)
			return top;
			
		if(meta == 1)
			return blockIconLit;
		
		return blockIcon;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y,
			int z, EntityPlayer player, int par6, float par7,
			float par8, float par9) {
		if(te != null && te.checkValidity(world, x, y, z)){
			System.out.println("VALID");
		}
		
		return true;
	}
		
		
	
}
