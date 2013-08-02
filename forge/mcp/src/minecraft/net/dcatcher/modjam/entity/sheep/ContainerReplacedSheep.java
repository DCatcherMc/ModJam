package net.dcatcher.modjam.entity.sheep;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

class ContainerSheep extends Container
{
    final EntityReplacedSheep field_90034_a;

    ContainerSheep(EntityReplacedSheep par1EntitySheep)
    {
        this.field_90034_a = par1EntitySheep;
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return false;
    }
}
