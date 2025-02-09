/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.IArmorMaterial
 *  net.minecraft.item.Item
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.SoundEvents
 */
package com.meteor.extrabotany.api;

import com.meteor.extrabotany.common.items.ModItems;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ExtraBotanyAPI {
    public static ExtraBotanyAPI INSTANCE = new ExtraBotanyAPI();

    public IArmorMaterial getMaidArmorMaterial() {
        return ArmorMaterial.MAID;
    }

    public IArmorMaterial getMikuArmorMaterial() {
        return ArmorMaterial.MIKU;
    }

    public IArmorMaterial getGoblinSlayerArmorMaterial() {
        return ArmorMaterial.GOBLINSLAYER;
    }

    public IArmorMaterial getShadowWarriorArmorMaterial() {
        return ArmorMaterial.SHADOWWARRIOR;
    }

    public IArmorMaterial getShootingGuardianArmorMaterial() {
        return ArmorMaterial.SHOOTINGGUARDIAN;
    }

    public IArmorMaterial getSilentSagesArmorMaterial() {
        return ArmorMaterial.SILENTSAGES;
    }

    public static void addPotionEffect(LivingEntity entity, Effect potion, int time, int max, boolean multi) {
        if (!entity.func_70644_a(potion)) {
            entity.func_195064_c(new EffectInstance(potion, time, 0));
        } else {
            int amp = entity.func_70660_b(potion).func_76458_c();
            int t = multi ? time + 200 * amp : time;
            entity.func_195064_c(new EffectInstance(potion, t, Math.min(max, amp + 1)));
        }
    }

    public static void addPotionEffect(LivingEntity entity, Effect potion, int max) {
        ExtraBotanyAPI.addPotionEffect(entity, potion, 100, max, false);
    }

    public static float calcDamage(float orig, PlayerEntity player) {
        if (player == null) {
            return orig;
        }
        double value = player.func_233637_b_(Attributes.field_233823_f_);
        return (float)((double)orig + value);
    }

    private static enum ArmorMaterial implements IArmorMaterial
    {
        MIKU("miku", 5, new int[]{2, 4, 5, 1}, 22, () -> SoundEvents.field_187728_s, () -> ModItems.manadrink, 0.0f),
        MAID("maid", 40, new int[]{4, 7, 9, 4}, 32, () -> SoundEvents.field_187716_o, () -> ModItems.goldcloth, 3.0f),
        GOBLINSLAYER("goblinslayer", 27, new int[]{3, 5, 7, 2}, 30, () -> SoundEvents.field_187725_r, () -> ModItems.photonium, 1.0f),
        SHADOWWARRIOR("shadowwarrior", 24, new int[]{2, 5, 6, 2}, 26, () -> SoundEvents.field_187725_r, () -> ModItems.shadowium, 1.0f),
        SHOOTINGGUARDIAN("shootingguardian", 34, new int[]{3, 7, 8, 4}, 34, () -> SoundEvents.field_187725_r, () -> ModItems.orichalcos, 2.0f),
        SILENTSAGES("silentsages", 50, new int[]{4, 8, 9, 5}, 40, () -> SoundEvents.field_187725_r, () -> ModItems.orichalcos, 3.0f);

        private final String name;
        private final int durabilityMultiplier;
        private final int[] damageReduction;
        private final int enchantability;
        private final Supplier<SoundEvent> equipSound;
        private final Supplier<Item> repairItem;
        private final float toughness;
        private static final int[] MAX_DAMAGE_ARRAY;

        private ArmorMaterial(String name, int durabilityMultiplier, int[] damageReduction, int enchantability, Supplier<SoundEvent> equipSound, Supplier<Item> repairItem, float toughness) {
            this.name = name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.damageReduction = damageReduction;
            this.enchantability = enchantability;
            this.equipSound = equipSound;
            this.repairItem = repairItem;
            this.toughness = toughness;
        }

        public int func_200896_a(EquipmentSlotType slot) {
            return this.durabilityMultiplier * MAX_DAMAGE_ARRAY[slot.func_188454_b()];
        }

        public int func_200902_b(EquipmentSlotType slot) {
            return this.damageReduction[slot.func_188454_b()];
        }

        public int func_200900_a() {
            return this.enchantability;
        }

        @Nonnull
        public SoundEvent func_200899_b() {
            return this.equipSound.get();
        }

        @Nonnull
        public Ingredient func_200898_c() {
            return Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{(IItemProvider)this.repairItem.get()});
        }

        @Nonnull
        public String func_200897_d() {
            return this.name;
        }

        public float func_200901_e() {
            return this.toughness;
        }

        public float func_230304_f_() {
            return 0.0f;
        }

        static {
            MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
        }
    }
}
