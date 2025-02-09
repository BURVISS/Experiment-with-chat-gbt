/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.item.BoatEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package com.meteor.extrabotany.common.entities.mountable;

import java.util.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public abstract class EntityMountable
extends BoatEntity {
    private static final String TAG_PITCH = "pitch";
    private static final String TAG_ROTATION = "rotation";
    private static final String TAG_MOUNTABLE = "mountable";
    private static final String TAG_OWNERUUID = "owneruuid";
    private static final DataParameter<Float> PITCH = EntityDataManager.func_187226_a(EntityMountable.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> ROTATION = EntityDataManager.func_187226_a(EntityMountable.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Boolean> MOUNTABLE = EntityDataManager.func_187226_a(EntityMountable.class, (IDataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Optional<UUID>> OWNER_UUID = EntityDataManager.func_187226_a(EntityMountable.class, (IDataSerializer)DataSerializers.field_187203_m);
    public boolean ctrlInputDown = false;
    public boolean spaceInputDown = false;

    public EntityMountable(EntityType<? extends BoatEntity> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.field_70156_m = true;
    }

    public void func_70071_h_() {
        if (this.field_70173_aa <= 3) {
            return;
        }
        if (this.getMountable() && (this.func_184188_bt().isEmpty() || !this.func_184188_bt().isEmpty() && !((Entity)this.func_184188_bt().get(0)).func_110124_au().equals(this.getOwnerId()))) {
            this.func_70106_y();
            return;
        }
        super.func_70071_h_();
    }

    protected SoundEvent func_193047_k() {
        return null;
    }

    protected boolean func_225502_at_() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(PITCH, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(MOUNTABLE, (Object)false);
        this.field_70180_af.func_187214_a(OWNER_UUID, Optional.empty());
    }

    public boolean func_180427_aV() {
        return true;
    }

    public Item func_184455_j() {
        return null;
    }

    public ItemStack getItemStack() {
        return this.getMountable() ? ItemStack.field_190927_a : new ItemStack((IItemProvider)this.func_184455_j());
    }

    public void updateInput(boolean ctrlInputDown, boolean spaceInputDown) {
        this.ctrlInputDown = ctrlInputDown;
        this.spaceInputDown = spaceInputDown;
    }

    protected void func_70037_a(CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setRotation(compound.func_74760_g(TAG_ROTATION));
        this.setPitch(compound.func_74760_g(TAG_PITCH));
        this.setMountable(compound.func_74767_n(TAG_MOUNTABLE));
        this.setOwnerId(compound.func_186857_a(TAG_OWNERUUID));
    }

    protected void func_213281_b(CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74776_a(TAG_ROTATION, this.getRotation());
        compound.func_74776_a(TAG_PITCH, this.getPitch());
        compound.func_74757_a(TAG_MOUNTABLE, this.getMountable());
        if (this.getOwnerId() != null) {
            compound.func_186854_a(TAG_OWNERUUID, this.getOwnerId());
        }
    }

    @Nullable
    public UUID getOwnerId() {
        return ((Optional)this.field_70180_af.func_187225_a(OWNER_UUID)).orElse(null);
    }

    public void setOwnerId(@Nullable UUID p_184754_1_) {
        this.field_70180_af.func_187227_b(OWNER_UUID, Optional.ofNullable(p_184754_1_));
    }

    public void setMountable(boolean b) {
        this.field_70180_af.func_187227_b(MOUNTABLE, (Object)b);
    }

    public boolean getMountable() {
        return (Boolean)this.field_70180_af.func_187225_a(MOUNTABLE);
    }

    public float getRotation() {
        return ((Float)this.field_70180_af.func_187225_a(ROTATION)).floatValue();
    }

    public void setRotation(float rot) {
        this.field_70180_af.func_187227_b(ROTATION, (Object)Float.valueOf(rot));
    }

    public float getPitch() {
        return ((Float)this.field_70180_af.func_187225_a(PITCH)).floatValue();
    }

    public void setPitch(float rot) {
        this.field_70180_af.func_187227_b(PITCH, (Object)Float.valueOf(rot));
    }
}
