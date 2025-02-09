/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.IRendersAsItem
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.nbt.INBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Util
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.EntityRayTraceResult
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.api.brew.IBrewItem
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.entities.ModEntities;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.api.brew.IBrewItem;

@OnlyIn(value=Dist.CLIENT, _interface=IRendersAsItem.class)
public class EntitySplashGrenade
extends ThrowableEntity
implements IRendersAsItem {
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.func_187226_a(EntitySplashGrenade.class, (IDataSerializer)DataSerializers.field_187196_f);
    private PlayerEntity thrower;

    public EntitySplashGrenade(EntityType<? extends ThrowableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntitySplashGrenade(World worldIn, PlayerEntity thrower) {
        super(ModEntities.SPLASHGRENADE, worldIn);
        this.thrower = thrower;
    }

    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && (this.thrower == null || this.thrower.field_70128_L)) {
            this.func_70106_y();
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            AxisAlignedBB axis = new AxisAlignedBB(this.func_226277_ct_() - (double)0.2f, this.func_226278_cu_() - (double)0.2f, this.func_226281_cx_() - (double)0.2f, this.field_70142_S + (double)0.2f, this.field_70137_T + (double)0.2f, this.field_70136_U + (double)0.2f);
            List entities = this.field_70170_p.func_217357_a(LivingEntity.class, axis);
            for (LivingEntity living : entities) {
                if (living == this.thrower) continue;
                this.onImpact();
                break;
            }
        }
        super.func_70071_h_();
    }

    public void onImpact() {
        if (this.getPotion().func_77973_b() instanceof IBrewItem) {
            IBrewItem bi = (IBrewItem)this.getPotion().func_77973_b();
            Brew brew = bi.getBrew(this.getPotion());
            double range = 5.0;
            AxisAlignedBB bounds = new AxisAlignedBB(this.func_226277_ct_() - range, this.func_226278_cu_() - range, this.func_226281_cx_() - range, this.func_226277_ct_() + range, this.func_226278_cu_() + range, this.func_226281_cx_() + range);
            List entitiess = this.field_70170_p.func_217357_a(LivingEntity.class, bounds);
            for (LivingEntity living2 : entitiess) {
                if (!(living2 instanceof PlayerEntity)) {
                    living2.func_70097_a(DamageSource.field_76376_m, 10.0f);
                }
                for (EffectInstance effect : brew.getPotionEffects(this.getPotion())) {
                    EffectInstance newEffect = new EffectInstance(effect.func_188419_a(), (int)((float)effect.func_76459_b() * 0.6f), effect.func_76458_c(), true, true);
                    if (!(living2 instanceof PlayerEntity) && !effect.func_188419_a().func_188408_i()) {
                        if (effect.func_188419_a().func_76403_b()) {
                            effect.func_188419_a().func_180793_a((Entity)living2, (Entity)living2, living2, newEffect.func_76458_c(), 1.0);
                        } else {
                            living2.func_195064_c(newEffect);
                        }
                    } else if (living2 instanceof PlayerEntity && effect.func_188419_a().func_188408_i()) {
                        if (effect.func_188419_a().func_76403_b()) {
                            effect.func_188419_a().func_180793_a((Entity)living2, (Entity)living2, living2, newEffect.func_76458_c(), 1.0);
                        } else {
                            living2.func_195064_c(newEffect);
                        }
                    }
                    int i = effect.func_188419_a().func_76403_b() ? 2007 : 2002;
                    this.field_70170_p.func_217379_c(i, this.func_233580_cy_(), brew.getColor(this.getPotion()));
                }
            }
        }
        this.func_70106_y();
    }

    protected void func_213868_a(EntityRayTraceResult result) {
        super.func_213868_a(result);
        result.func_216348_a().func_70097_a(DamageSource.func_76356_a((Entity)this, (Entity)this.thrower), 5.0f);
    }

    protected void func_70227_a(RayTraceResult result) {
        super.func_70227_a(result);
        if (!this.field_70170_p.field_72995_K) {
            this.onImpact();
        }
    }

    public float func_70185_h() {
        return 0.02f;
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(ITEM, (Object)ItemStack.field_190927_a);
    }

    public void setItem(ItemStack stack) {
        this.func_184212_Q().func_187227_b(ITEM, Util.func_200696_a((Object)stack.func_77946_l(), p_213883_0_ -> p_213883_0_.func_190920_e(1)));
    }

    public ItemStack getPotion() {
        ItemStack itemstack = (ItemStack)this.func_184212_Q().func_187225_a(ITEM);
        return itemstack;
    }

    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        ItemStack itemstack = this.getPotion();
        if (!itemstack.func_190926_b()) {
            cmp.func_218657_a("Potion", (INBT)itemstack.func_77955_b(new CompoundNBT()));
        }
    }

    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        ItemStack itemstack = ItemStack.func_199557_a((CompoundNBT)cmp.func_74775_l("Potion"));
        this.setItem(itemstack);
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    public ItemStack func_184543_l() {
        return this.getPotion();
    }
}
