/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.Botania
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.Botania;

public class EntityMagicArrow
extends ThrowableEntity {
    private static final String TAG_DAMAGE = "damage";
    private static final String TAG_LIFE = "life";
    private static final DataParameter<Integer> DAMAGE = EntityDataManager.func_187226_a(EntityMagicArrow.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> LIFE = EntityDataManager.func_187226_a(EntityMagicArrow.class, (IDataSerializer)DataSerializers.field_187192_b);
    private LivingEntity thrower;

    public EntityMagicArrow(EntityType<? extends EntityMagicArrow> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityMagicArrow(World worldIn, LivingEntity thrower) {
        this(ModEntities.MAGICARROW, worldIn);
        this.thrower = thrower;
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(DAMAGE, (Object)0);
        this.field_70180_af.func_187214_a(LIFE, (Object)0);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (!(this.field_70170_p.field_72995_K || this.thrower != null && this.thrower instanceof PlayerEntity && !this.thrower.field_70128_L)) {
            this.func_70106_y();
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            WispParticleData data = WispParticleData.wisp((float)0.5f, (float)0.1f, (float)0.85f, (float)0.1f, (float)1.0f);
            Botania.proxy.addParticleForce(this.field_70170_p, (IParticleData)data, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
        }
        PlayerEntity player = (PlayerEntity)this.thrower;
        if (!this.field_70170_p.field_72995_K) {
            AxisAlignedBB axis = new AxisAlignedBB(this.func_226277_ct_() - 3.0, this.func_226278_cu_() - 3.0, this.func_226281_cx_() - 3.0, this.field_70142_S + 3.0, this.field_70137_T + 3.0, this.field_70136_U + 3.0);
            List entities = this.field_70170_p.func_217357_a(LivingEntity.class, axis);
            List<LivingEntity> livings = DamageHandler.INSTANCE.getFilteredEntities(entities, (Entity)player);
            for (LivingEntity living : livings) {
                if (living.field_70172_ad > 5) continue;
                DamageHandler.INSTANCE.dmg((Entity)living, (Entity)player, this.getDamage(), DamageHandler.INSTANCE.NETURAL_PIERCING);
            }
        }
        if (this.field_70173_aa > this.getLife()) {
            this.func_70106_y();
        }
    }

    public boolean func_180427_aV() {
        return true;
    }

    public float func_70185_h() {
        return 0.0f;
    }

    public void func_213281_b(CompoundNBT cmp) {
        cmp.func_74768_a(TAG_LIFE, this.getLife());
        cmp.func_74768_a(TAG_DAMAGE, this.getDamage());
    }

    public void func_70037_a(CompoundNBT cmp) {
        this.setLife(cmp.func_74762_e(TAG_LIFE));
        this.setDamage(cmp.func_74762_e(TAG_DAMAGE));
    }

    public int getLife() {
        return (Integer)this.field_70180_af.func_187225_a(LIFE);
    }

    public void setLife(int delay) {
        this.field_70180_af.func_187227_b(LIFE, (Object)delay);
    }

    public int getDamage() {
        return (Integer)this.field_70180_af.func_187225_a(DAMAGE);
    }

    public void setDamage(int delay) {
        this.field_70180_af.func_187227_b(DAMAGE, (Object)delay);
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public boolean func_70090_H() {
        return false;
    }

    public boolean func_96092_aw() {
        return false;
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
