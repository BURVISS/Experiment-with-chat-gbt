/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.DamageSource
 */
package com.meteor.extrabotany.common.handler;

import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.ModItems;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;

public final class DamageHandler {
    public static final DamageHandler INSTANCE = new DamageHandler();
    public final int NETURAL = 0;
    public final int MAGIC = 1;
    public final int NETURAL_PIERCING = 2;
    public final int MAGIC_PIERCING = 3;
    public final int LIFE_LOSING = 4;

    public boolean checkPassable(Entity target, Entity source) {
        if (target == source) {
            return false;
        }
        if (source instanceof PlayerEntity) {
            boolean sourceEquipped;
            PlayerEntity sourcePlayer = (PlayerEntity)source;
            boolean bl = sourceEquipped = !EquipmentHandler.findOrEmpty(ModItems.peaceamulet, (LivingEntity)sourcePlayer).func_190926_b();
            if (target instanceof PlayerEntity) {
                PlayerEntity targetPlayer = (PlayerEntity)target;
                return !sourceEquipped && EquipmentHandler.findOrEmpty(ModItems.peaceamulet, (LivingEntity)targetPlayer).func_190926_b();
            }
            if (sourceEquipped && !(target instanceof IMob) && target.func_184222_aU()) {
                return false;
            }
        }
        if (source instanceof IMob) {
            return target instanceof PlayerEntity;
        }
        return true;
    }

    public List<LivingEntity> getFilteredEntities(List<LivingEntity> entities, Entity source) {
        List<LivingEntity> list = entities.stream().filter(living -> this.checkPassable((Entity)living, source) && !living.field_70128_L).collect(Collectors.toList());
        return list;
    }

    public static float calcDamage(float orig, PlayerEntity player) {
        if (player == null) {
            return orig;
        }
        double value = 0.0;
        return (float)((double)orig + value);
    }

    public boolean dmg(Entity target, Entity source, float amount, int type) {
        if (target == null || !this.checkPassable(target, source)) {
            return false;
        }
        switch (type) {
            case 0: {
                if (source instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity)source;
                    DamageSource s = DamageSource.func_76365_a((PlayerEntity)player);
                    return target.func_70097_a(s, amount);
                }
                if (source instanceof LivingEntity) {
                    LivingEntity living = (LivingEntity)source;
                    DamageSource s = DamageSource.func_76358_a((LivingEntity)living);
                    return target.func_70097_a(s, amount);
                }
                return target.func_70097_a(DamageSource.field_76377_j, amount);
            }
            case 1: {
                if (source == null) {
                    DamageSource s = DamageSource.field_76376_m;
                    return target.func_70097_a(s, amount);
                }
                DamageSource s = DamageSource.func_76354_b((Entity)source, (Entity)source);
                return target.func_70097_a(s, amount);
            }
            case 2: {
                target.field_70172_ad = 0;
                if (source instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity)source;
                    DamageSource s = DamageSource.func_76365_a((PlayerEntity)player).func_76348_h().func_151518_m();
                    return target.func_70097_a(s, amount);
                }
                if (source instanceof LivingEntity) {
                    LivingEntity living = (LivingEntity)source;
                    DamageSource s = DamageSource.func_76358_a((LivingEntity)living).func_76348_h().func_151518_m();
                    return target.func_70097_a(s, amount);
                }
                return target.func_70097_a(DamageSource.field_76377_j, amount);
            }
            case 3: {
                target.field_70172_ad = 0;
                if (source == null) {
                    DamageSource s = DamageSource.field_76376_m.func_76348_h().func_151518_m();
                    return target.func_70097_a(s, amount);
                }
                DamageSource s = DamageSource.func_76354_b((Entity)source, (Entity)source).func_76348_h().func_151518_m();
                return target.func_70097_a(s, amount);
            }
            case 4: {
                if (!(target instanceof LivingEntity)) {
                    return false;
                }
                LivingEntity living = (LivingEntity)target;
                float currentHealth = living.func_110143_aJ();
                float trueHealth = Math.max(1.0f, currentHealth - amount);
                living.func_70606_j(trueHealth);
                return this.dmg(target, source, 0.01f, 0);
            }
        }
        return false;
    }
}
