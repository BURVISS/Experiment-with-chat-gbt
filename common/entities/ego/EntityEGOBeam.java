/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.fx.WispParticleData
 */
package com.meteor.extrabotany.common.entities.ego;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.fx.WispParticleData;

public class EntityEGOBeam
extends Entity {
    private PlayerEntity target;
    public EntityEGO summoner;
    private static final String TAG_COLOR_R = "colorr";
    private static final String TAG_COLOR_G = "colorg";
    private static final String TAG_COLOR_B = "colorb";
    private static final String TAG_SPEED_MODIFIER = "speedmodifier";
    private static final String TAG_DAMAGE = "damage";
    private static final DataParameter<Float> COLOR_R = EntityDataManager.func_187226_a(EntityEGOBeam.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> COLOR_G = EntityDataManager.func_187226_a(EntityEGOBeam.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> COLOR_B = EntityDataManager.func_187226_a(EntityEGOBeam.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> SPEED_MODIFIER = EntityDataManager.func_187226_a(EntityEGOBeam.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> DAMAGE = EntityDataManager.func_187226_a(EntityEGOBeam.class, (IDataSerializer)DataSerializers.field_187193_c);

    public EntityEGOBeam(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
    }

    public EntityEGOBeam(World worldIn) {
        super(ModEntities.EGOBEAM, worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa >= 460 || this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            this.func_70106_y();
        }
        float RANGE = 16.0f;
        AxisAlignedBB axis = new AxisAlignedBB(this.func_213303_ch().func_72441_c((double)(-RANGE), (double)(-RANGE), (double)(-RANGE)), this.func_213303_ch().func_72441_c((double)(RANGE + 1.0f), (double)(RANGE + 1.0f), (double)(RANGE + 1.0f)));
        if (this.target == null || this.target.field_70128_L) {
            List players = this.field_70170_p.func_217357_a(PlayerEntity.class, axis);
            if (players.size() > 0) {
                this.target = (PlayerEntity)players.get(0);
            }
        } else {
            Vector3d vecMotion = this.target.func_213303_ch().func_178788_d(this.func_213303_ch()).func_72432_b().func_186678_a(0.1).func_186678_a((double)this.getSpeedModifier());
            Vector3d newVec = this.func_213303_ch().func_178787_e(vecMotion);
            this.func_70634_a(newVec.field_72450_a, this.func_226278_cu_(), newVec.field_72449_c);
            float m = 0.35f;
            for (int i = 0; i < 2; ++i) {
                WispParticleData data = WispParticleData.wisp((float)0.5f, (float)1.0f, (float)1.0f, (float)1.0f);
                this.field_70170_p.func_195594_a((IParticleData)data, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), (double)((float)(Math.random() - 0.5) * m), (double)((float)(Math.random() - 0.5) * m), (double)((float)(Math.random() - 0.5) * m));
            }
            List players = this.field_70170_p.func_217357_a(PlayerEntity.class, this.func_174813_aQ().func_72314_b(0.0, 12.0, 0.0));
            for (PlayerEntity player : players) {
                if (player.field_70172_ad > 5) continue;
                DamageHandler.INSTANCE.dmg((Entity)player, (Entity)this.summoner, this.getBeamDamage(), DamageHandler.INSTANCE.MAGIC_PIERCING);
            }
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(COLOR_R, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(COLOR_G, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(COLOR_B, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(SPEED_MODIFIER, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(DAMAGE, (Object)Float.valueOf(0.0f));
    }

    protected void func_70037_a(CompoundNBT compound) {
        this.setColor(compound.func_74760_g(TAG_COLOR_R), compound.func_74760_g(TAG_COLOR_G), compound.func_74760_g(TAG_COLOR_B));
        this.setSpeedModifier(compound.func_74760_g(TAG_SPEED_MODIFIER));
        this.setBeamDamage(compound.func_74760_g(TAG_DAMAGE));
    }

    protected void func_213281_b(CompoundNBT compound) {
        compound.func_74776_a(TAG_COLOR_R, this.getColorR());
        compound.func_74776_a(TAG_COLOR_G, this.getColorG());
        compound.func_74776_a(TAG_COLOR_B, this.getColorB());
        compound.func_74776_a(TAG_SPEED_MODIFIER, this.getSpeedModifier());
        compound.func_74776_a(TAG_DAMAGE, this.getBeamDamage());
    }

    public float getColorR() {
        return ((Float)this.field_70180_af.func_187225_a(COLOR_R)).floatValue();
    }

    public float getColorG() {
        return ((Float)this.field_70180_af.func_187225_a(COLOR_G)).floatValue();
    }

    public float getColorB() {
        return ((Float)this.field_70180_af.func_187225_a(COLOR_B)).floatValue();
    }

    public float getSpeedModifier() {
        return ((Float)this.field_70180_af.func_187225_a(SPEED_MODIFIER)).floatValue();
    }

    public float getBeamDamage() {
        return ((Float)this.field_70180_af.func_187225_a(DAMAGE)).floatValue();
    }

    public void setColorR(float f) {
        this.field_70180_af.func_187227_b(COLOR_R, (Object)Float.valueOf(f));
    }

    public void setColorG(float f) {
        this.field_70180_af.func_187227_b(COLOR_G, (Object)Float.valueOf(f));
    }

    public void setColorB(float f) {
        this.field_70180_af.func_187227_b(COLOR_B, (Object)Float.valueOf(f));
    }

    public void setSpeedModifier(float f) {
        this.field_70180_af.func_187227_b(SPEED_MODIFIER, (Object)Float.valueOf(f));
    }

    public void setBeamDamage(float f) {
        this.field_70180_af.func_187227_b(DAMAGE, (Object)Float.valueOf(f));
    }

    public void setColor(float r, float g, float b) {
        this.setColorR(r);
        this.setColorG(g);
        this.setColorB(b);
    }

    public float[] getBeamColor() {
        return new float[]{this.getColorR(), this.getColorG(), this.getColorB()};
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
