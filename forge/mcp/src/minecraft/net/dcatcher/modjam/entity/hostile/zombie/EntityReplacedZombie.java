package net.dcatcher.modjam.entity.hostile.zombie;

import java.util.Calendar;
import java.util.UUID;

import net.dcatcher.modjam.entity.EntityAIFollowRider;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityReplacedZombie extends EntityAnimal
{
    protected static final Attribute field_110186_bp = (new RangedAttribute("zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).func_111117_a("Spawn Reinforcements Chance");
    private static final UUID field_110187_bq = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier field_110188_br = new AttributeModifier(field_110187_bq, "Baby speed boost", 0.5D, 1);

    /**
     * Ticker used to determine the time remaining for this zombie to convert into a villager when cured.
     */
    
    private EntityPlayer lastRidden;
    
    private int conversionTime;

    public EntityReplacedZombie(World par1World)
    {
        super(par1World);
        this.setSize(0.8f, 2.5f);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(1, new EntityAIControlledByPlayer(this, 0.7F));
        this.tasks.addTask(2, new EntityAIFollowRider(this, lastRidden, 0.6D));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    
    protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.23000000417232513D);
        this.func_110140_aT().func_111150_b(field_110186_bp).func_111128_a(this.rand.nextDouble() * 0.10000000149011612D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(29, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(30, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(31, Byte.valueOf((byte)0));
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        int i = super.getTotalArmorValue() + 2;

        if (i > 20)
        {
            i = 20;
        }

        return i;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * If Animal, checks if the age timer is negative
     */
    public boolean isChild()
    {
        return this.getDataWatcher().getWatchableObjectByte(29) == 1;
    }

    /**
     * Set whether this zombie is a child.
     */
    public void setChild(boolean par1)
    {
        this.getDataWatcher().updateObject(29, Byte.valueOf((byte)(par1 ? 1 : 0)));

        if (this.worldObj != null && !this.worldObj.isRemote)
        {
            AttributeInstance attributeinstance = this.func_110148_a(SharedMonsterAttributes.field_111263_d);
            attributeinstance.func_111124_b(field_110188_br);

            if (par1)
            {
                attributeinstance.func_111121_a(field_110188_br);
            }
        }
    }

    /**
     * Return whether this zombie is a villager.
     */
    public boolean isVillager()
    {
        return this.getDataWatcher().getWatchableObjectByte(30) == 1;
    }

    /**
     * Set whether this zombie is a villager.
     */
    public void setVillager(boolean par1)
    {
        this.getDataWatcher().updateObject(30, Byte.valueOf((byte)(par1 ? 1 : 0)));
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                boolean flag = true;
                ItemStack itemstack = this.getCurrentItemOrArmor(4);

                if (itemstack != null)
                {
                    if (itemstack.isItemStackDamageable())
                    {
                        itemstack.setItemDamage(itemstack.getItemDamageForDisplay() + this.rand.nextInt(2));

                        if (itemstack.getItemDamageForDisplay() >= itemstack.getMaxDamage())
                        {
                            this.renderBrokenItemStack(itemstack);
                            this.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }

                    flag = false;
                }

                if (flag)
                {
                    this.setFire(8);
                }
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (!super.attackEntityFrom(par1DamageSource, par2))
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.getAttackTarget();

            if (entitylivingbase == null && this.getEntityToAttack() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)this.getEntityToAttack();
            }

            if (entitylivingbase == null && par1DamageSource.getEntity() instanceof EntityLivingBase)
            {
                entitylivingbase = (EntityLivingBase)par1DamageSource.getEntity();
            }

            if (entitylivingbase != null && this.worldObj.difficultySetting >= 3 && (double)this.rand.nextFloat() < this.func_110148_a(field_110186_bp).func_111126_e())
            {
                int i = MathHelper.floor_double(this.posX);
                int j = MathHelper.floor_double(this.posY);
                int k = MathHelper.floor_double(this.posZ);
                EntityReplacedZombie entityzombie = new EntityReplacedZombie(this.worldObj);

                for (int l = 0; l < 50; ++l)
                {
                    int i1 = i + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    int j1 = j + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);
                    int k1 = k + MathHelper.getRandomIntegerInRange(this.rand, 7, 40) * MathHelper.getRandomIntegerInRange(this.rand, -1, 1);

                    if (this.worldObj.doesBlockHaveSolidTopSurface(i1, j1 - 1, k1) && this.worldObj.getBlockLightValue(i1, j1, k1) < 10)
                    {
                        entityzombie.setPosition((double)i1, (double)j1, (double)k1);

                        if (this.worldObj.checkNoEntityCollision(entityzombie.boundingBox) && this.worldObj.getCollidingBoundingBoxes(entityzombie, entityzombie.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(entityzombie.boundingBox))
                        {
                            this.worldObj.spawnEntityInWorld(entityzombie);
                            entityzombie.setAttackTarget(entitylivingbase);
                            entityzombie.func_110161_a((EntityLivingData)null);
                            this.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                            entityzombie.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                            break;
                        }
                    }
                }
            }

            return true;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (!this.worldObj.isRemote && this.isConverting())
        {
            int i = this.getConversionTimeBoost();
            this.conversionTime -= i;

            if (this.conversionTime <= 0)
            {
                this.convertToVillager();
            }
        }

        super.onUpdate();
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        boolean flag = super.attackEntityAsMob(par1Entity);

        if (flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3F)
        {
            par1Entity.setFire(2 * this.worldObj.difficultySetting);
        }

        return flag;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombie.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombie.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombie.death";
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.zombie.step", 0.15F, 1.0F);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.rottenFlesh.itemID;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Item.ingotIron.itemID, 1);
                break;
            case 1:
                this.dropItem(Item.carrot.itemID, 1);
                break;
            case 2:
                this.dropItem(Item.potato.itemID, 1);
        }
    }

    /**
     * Makes entity wear random armor based on difficulty
     */
    protected void addRandomArmor()
    {
        super.addRandomArmor();

        if (this.rand.nextFloat() < (this.worldObj.difficultySetting == 3 ? 0.05F : 0.01F))
        {
            int i = this.rand.nextInt(3);

            if (i == 0)
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.swordIron));
            }
            else
            {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.shovelIron));
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);

        if (this.isChild())
        {
            par1NBTTagCompound.setBoolean("IsBaby", true);
        }

        if (this.isVillager())
        {
            par1NBTTagCompound.setBoolean("IsVillager", true);
        }

        par1NBTTagCompound.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.getBoolean("IsBaby"))
        {
            this.setChild(true);
        }

        if (par1NBTTagCompound.getBoolean("IsVillager"))
        {
            this.setVillager(true);
        }

        if (par1NBTTagCompound.hasKey("ConversionTime") && par1NBTTagCompound.getInteger("ConversionTime") > -1)
        {
            this.startConversion(par1NBTTagCompound.getInteger("ConversionTime"));
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLivingBase par1EntityLivingBase)
    {
        super.onKillEntity(par1EntityLivingBase);

        if (this.worldObj.difficultySetting >= 2 && par1EntityLivingBase instanceof EntityVillager)
        {
            if (this.worldObj.difficultySetting == 2 && this.rand.nextBoolean())
            {
                return;
            }

            EntityReplacedZombie entityzombie = new EntityReplacedZombie(this.worldObj);
            entityzombie.copyLocationAndAnglesFrom(par1EntityLivingBase);
            this.worldObj.removeEntity(par1EntityLivingBase);
            entityzombie.func_110161_a((EntityLivingData)null);
            entityzombie.setVillager(true);

            if (par1EntityLivingBase.isChild())
            {
                entityzombie.setChild(true);
            }

            this.worldObj.spawnEntityInWorld(entityzombie);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        }
    }

    public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
    {
        Object par1EntityLivingData1 = super.func_110161_a(par1EntityLivingData);
        float f = this.worldObj.func_110746_b(this.posX, this.posY, this.posZ);
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

        this.addRandomArmor();
        this.enchantEquipment();

        if (this.getCurrentItemOrArmor(4) == null)
        {
            Calendar calendar = this.worldObj.getCurrentDate();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern : Block.pumpkin));
                this.equipmentDropChances[4] = 0.0F;
            }
        }

        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111121_a(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random zombie-spawn bonus", this.rand.nextDouble() * 1.5D, 2));

        if (this.rand.nextFloat() < f * 0.05F)
        {
            this.func_110148_a(field_110186_bp).func_111121_a(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
            this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111121_a(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
        }

        return (EntityLivingData)par1EntityLivingData1;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
    	par1EntityPlayer.mountEntity(this);
    	lastRidden = par1EntityPlayer;
        return true;
    }

    /**
     * Starts converting this zombie into a villager. The zombie converts into a villager after the specified time in
     * ticks.
     */
    protected void startConversion(int par1)
    {
        this.conversionTime = par1;
        this.getDataWatcher().updateObject(31, Byte.valueOf((byte)1));
        this.removePotionEffect(Potion.weakness.id);
        this.addPotionEffect(new PotionEffect(Potion.damageBoost.id, par1, Math.min(this.worldObj.difficultySetting - 1, 0)));
        this.worldObj.setEntityState(this, (byte)16);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 16)
        {
            this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "mob.zombie.remedy", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public boolean isBeingRidden(){
    	if(this.riddenByEntity != null){
    		return true;
    	}
    	return false;
    }
    
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isConverting();
    }

    /**
     * Returns whether this zombie is in the process of converting to a villager
     */
    public boolean isConverting()
    {
        return this.getDataWatcher().getWatchableObjectByte(31) == 1;
    }

    /**
     * Convert this zombie into a villager.
     */
    protected void convertToVillager()
    {
        EntityVillager entityvillager = new EntityVillager(this.worldObj);
        entityvillager.copyLocationAndAnglesFrom(this);
        entityvillager.func_110161_a((EntityLivingData)null);
        entityvillager.func_82187_q();

        if (this.isChild())
        {
            entityvillager.setGrowingAge(-24000);
        }

        this.worldObj.removeEntity(this);
        this.worldObj.spawnEntityInWorld(entityvillager);
        entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
        this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
    }

    /**
     * Return the amount of time decremented from conversionTime every tick.
     */
    protected int getConversionTimeBoost()
    {
        int i = 1;

        if (this.rand.nextFloat() < 0.01F)
        {
            int j = 0;

            for (int k = (int)this.posX - 4; k < (int)this.posX + 4 && j < 14; ++k)
            {
                for (int l = (int)this.posY - 4; l < (int)this.posY + 4 && j < 14; ++l)
                {
                    for (int i1 = (int)this.posZ - 4; i1 < (int)this.posZ + 4 && j < 14; ++i1)
                    {
                        int j1 = this.worldObj.getBlockId(k, l, i1);

                        if (j1 == Block.fenceIron.blockID || j1 == Block.bed.blockID)
                        {
                            if (this.rand.nextFloat() < 0.3F)
                            {
                                ++i;
                            }

                            ++j;
                        }
                    }
                }
            }
        }

        return i;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
	
	@Override
	public boolean canBeSteered() {
		return true;
	}
}
