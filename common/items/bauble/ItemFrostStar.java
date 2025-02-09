/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.enchantment.FrostWalkerEnchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.handler.DamageHandler;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemFrostStar
extends ItemBauble
implements IManaUsingItem {
    private static final int RANGE = 6;
    private static final int MANA_PER_DAMAGE = 30;

    public ItemFrostStar(Item.Properties props) {
        super(props);
    }

    public void onWornTick(ItemStack stack, LivingEntity entity) {
        super.onWornTick(stack, entity);
        if (entity instanceof PlayerEntity && !entity.field_70170_p.field_72995_K) {
            boolean lastOnGround = entity.func_233570_aj_();
            entity.func_230245_c_(true);
            FrostWalkerEnchantment.func_185266_a((LivingEntity)entity, (World)entity.field_70170_p, (BlockPos)entity.func_233580_cy_(), (int)8);
            entity.func_230245_c_(lastOnGround);
            for (LivingEntity living : entity.func_130014_f_().func_217357_a(LivingEntity.class, new AxisAlignedBB(entity.func_233580_cy_().func_177982_a(-6, -6, -6), entity.func_233580_cy_().func_177982_a(7, 7, 7)))) {
                if (!living.func_174827_a((ServerPlayerEntity)entity) || living == entity || !DamageHandler.INSTANCE.checkPassable((Entity)living, (Entity)entity) || entity.field_70173_aa % 20 != 0 || !ManaItemHandler.instance().requestManaExactForTool(stack, (PlayerEntity)entity, 30, true)) continue;
                living.func_195064_c(new EffectInstance(Effects.field_76421_d, 60, 4));
            }
        }
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
