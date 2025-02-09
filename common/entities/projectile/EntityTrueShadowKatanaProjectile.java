/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.network.IPacket
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.Botania
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import com.meteor.extrabotany.common.handler.DamageHandler;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.Botania;

public class EntityTrueShadowKatanaProjectile
extends EntityProjectileBase {
    public static final int LIVE_TICKS = 40;

    public EntityTrueShadowKatanaProjectile(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityTrueShadowKatanaProjectile(World worldIn, LivingEntity thrower) {
        super(ModEntities.TRUESHADOWKATANA, worldIn, thrower);
    }

    public void func_70071_h_() {
        block7: {
            AxisAlignedBB axis;
            List entities;
            List<LivingEntity> list;
            Iterator<LivingEntity> iterator;
            if (this.field_70173_aa >= 40) {
                this.func_70106_y();
            }
            if (!this.field_70170_p.field_72995_K && (this.getThrower() == null || this.getThrower().field_70128_L)) {
                this.func_70106_y();
                return;
            }
            if (this.field_70173_aa <= 3) {
                return;
            }
            if (this.field_70170_p.field_72995_K && this.field_70173_aa % 2 == 0) {
                WispParticleData data = WispParticleData.wisp((float)0.15f, (float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                Botania.proxy.addParticleForce(this.field_70170_p, (IParticleData)data, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 0.0, 0.0, 0.0);
            }
            super.func_70071_h_();
            if (this.field_70170_p.field_72995_K || !(iterator = (list = DamageHandler.INSTANCE.getFilteredEntities(entities = this.field_70170_p.func_217357_a(LivingEntity.class, axis = new AxisAlignedBB(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), this.field_70142_S, this.field_70137_T, this.field_70136_U).func_186662_g(2.0)), (Entity)this.getThrower())).iterator()).hasNext()) break block7;
            LivingEntity living = iterator.next();
            living.field_70172_ad = 0;
            if (this.getThrower() instanceof PlayerEntity) {
                DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 5.0f, DamageHandler.INSTANCE.NETURAL);
            } else {
                if (living.field_70172_ad == 0) {
                    DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 2.0f, DamageHandler.INSTANCE.LIFE_LOSING);
                }
                DamageHandler.INSTANCE.dmg((Entity)living, (Entity)this.getThrower(), 5.5f, DamageHandler.INSTANCE.MAGIC);
            }
            this.func_70106_y();
        }
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public IBakedModel getIcon() {
        return MiscellaneousIcons.INSTANCE.trueshadowkatanaprojectileModel[0];
    }
}
