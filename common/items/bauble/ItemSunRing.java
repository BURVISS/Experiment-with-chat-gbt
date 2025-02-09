/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraftforge.common.ForgeMod
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.core.handler.PixieHandler
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.equipment.bauble.ItemAuraRing
 *  vazkii.botania.common.item.equipment.bauble.ItemMiningRing
 *  vazkii.botania.common.item.equipment.bauble.ItemSwapRing
 *  vazkii.botania.common.item.relic.ItemRelicBauble
 */
package com.meteor.extrabotany.common.items.bauble;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemDeathRing;
import com.meteor.extrabotany.common.items.bauble.ItemFrostStar;
import com.meteor.extrabotany.common.items.bauble.ItemManaDriveRing;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeMod;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.handler.PixieHandler;
import vazkii.botania.common.item.equipment.bauble.ItemAuraRing;
import vazkii.botania.common.item.equipment.bauble.ItemMiningRing;
import vazkii.botania.common.item.equipment.bauble.ItemSwapRing;
import vazkii.botania.common.item.relic.ItemRelicBauble;

public class ItemSunRing
extends ItemRelicBauble
implements IManaUsingItem,
IAdvancementRequirement {
    private static final int COST = 3;

    public ItemSunRing(Item.Properties props) {
        super(props);
    }

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return EquipmentHandler.findOrEmpty((Item)this, entity).func_190926_b();
    }

    public void onWornTick(ItemStack stack, LivingEntity player) {
        super.onWornTick(stack, player);
        ((ItemMiningRing)vazkii.botania.common.item.ModItems.miningRing).onWornTick(stack, player);
        ((ItemAuraRing)vazkii.botania.common.item.ModItems.auraRingGreater).onWornTick(stack, player);
        ((ItemSwapRing)vazkii.botania.common.item.ModItems.swapRing).onWornTick(stack, player);
        ((ItemDeathRing)ModItems.deathring).onWornTick(stack, player);
        ((ItemFrostStar)ModItems.froststar).onWornTick(stack, player);
        ((ItemManaDriveRing)ModItems.manadrivering).onWornTick(stack, player);
        if (player.func_203005_aq()) {
            ItemStack result = EquipmentHandler.findOrEmpty(ModItems.sunring, player);
            if (result != stack) {
                return;
            }
            if (!(player.field_70170_p.field_72995_K || player instanceof PlayerEntity && !ManaItemHandler.instance().requestManaExact(stack, (PlayerEntity)player, 3, true))) {
                ItemSunRing.addEffect(player, Effects.field_205136_C);
                ItemSunRing.addEffect(player, Effects.field_206827_D);
            }
        }
    }

    public void onUnequipped(ItemStack stack, LivingEntity player) {
        super.onUnequipped(stack, player);
        ((ItemMiningRing)vazkii.botania.common.item.ModItems.miningRing).onUnequipped(stack, player);
    }

    public Multimap<Attribute, AttributeModifier> getEquippedAttributeModifiers(ItemStack stack) {
        HashMultimap attributes = HashMultimap.create();
        attributes.put((Object)ForgeMod.REACH_DISTANCE.get(), (Object)new AttributeModifier(ItemSunRing.getBaubleUUID((ItemStack)stack), "Sun Ring", 3.5, AttributeModifier.Operation.ADDITION));
        attributes.put((Object)PixieHandler.PIXIE_SPAWN_CHANCE, (Object)new AttributeModifier(ItemSunRing.getBaubleUUID((ItemStack)stack), "Ring modifier", 0.25, AttributeModifier.Operation.ADDITION));
        return attributes;
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }

    private static void addEffect(LivingEntity living, Effect effect) {
        EffectInstance inst = living.func_70660_b(effect);
        if (inst == null || inst.func_76458_c() == 0 && inst.func_76459_b() == 1) {
            EffectInstance neweffect = new EffectInstance(effect, 100, 0, true, true);
            living.func_195064_c(neweffect);
        }
    }
}
