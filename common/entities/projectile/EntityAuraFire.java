/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.network.IPacket
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.util.math.EntityRayTraceResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.projectile;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.projectile.EntityProjectileBase;
import com.meteor.extrabotany.common.handler.DamageHandler;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityAuraFire
extends EntityProjectileBase {
    public EntityAuraFire(EntityType<? extends EntityProjectileBase> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityAuraFire(World worldIn, LivingEntity thrower) {
        super(ModEntities.AURAFIRE, worldIn, thrower);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa > 80) {
            this.func_241204_bJ_();
        }
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 5; ++i) {
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, this.func_226277_ct_() + Math.random() * (double)0.4f - (double)0.2f, this.func_226278_cu_() + Math.random() * (double)0.4f - (double)0.2f, this.func_226281_cx_() + Math.random() * (double)0.4f - (double)0.2f, 0.0, 0.0, 0.0);
            }
        }
    }

    public void func_213868_a(EntityRayTraceResult result) {
        if (this.getThrower() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)this.getThrower();
            if (result.func_216348_a() != player) {
                float dmg = ExtraBotanyAPI.calcDamage(5.0f, player);
                DamageHandler.INSTANCE.dmg(result.func_216348_a(), (Entity)player, dmg, DamageHandler.INSTANCE.NETURAL_PIERCING);
                player.func_110149_m(Math.min(10.0f, player.func_110139_bj() + 1.0f));
                this.func_70106_y();
            }
        }
    }

    @Override
    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
