package net.dcatcher.modjam.entity.cow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderReplacedCow extends RenderLiving
{
    private static final ResourceLocation field_110833_a = new ResourceLocation("dcmodjam:textures/entity/cow/cow.png");

    public RenderReplacedCow(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation func_110832_a(EntityReplacedCow par1EntityCow)
    {
        return field_110833_a;
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110832_a((EntityReplacedCow)par1Entity);
        
    }
}
