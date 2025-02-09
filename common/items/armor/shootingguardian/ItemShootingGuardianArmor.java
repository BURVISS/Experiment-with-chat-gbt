/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  javax.annotation.Nonnull
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.LazyValue
 *  net.minecraft.util.registry.Registry
 *  net.minecraft.util.text.IFormattableTextComponent
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.common.items.armor.shootingguardian;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.client.model.armor.ModelShootingGuardianArmor;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.armor.miku.ItemMikuArmor;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemShootingGuardianArmor
extends ItemMikuArmor {
    private static final LazyValue<ItemStack[]> armorSet = new LazyValue(() -> new ItemStack[]{new ItemStack((IItemProvider)ModItems.armor_shootingguardian_helm), new ItemStack((IItemProvider)ModItems.armor_shootingguardian_chest), new ItemStack((IItemProvider)ModItems.armor_shootingguardian_legs), new ItemStack((IItemProvider)ModItems.armor_shootingguardian_boots)});

    public ItemShootingGuardianArmor(EquipmentSlotType type, Item.Properties props) {
        super(type, ExtraBotanyAPI.INSTANCE.getShootingGuardianArmorMaterial(), props);
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(@Nonnull EquipmentSlotType slot, ItemStack stack) {
        Multimap ret = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(Registry.field_212630_s.func_177774_c((Object)this).hashCode() + slot.toString().hashCode(), 0L);
        if (slot == this.func_185083_B_()) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233822_e_, (Object)new AttributeModifier(uuid, "Shooting Guardian modifier flying speed" + this.type, (double)0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
            ret.put((Object)Attributes.field_233821_d_, (Object)new AttributeModifier(uuid, "Shooting Guardian modifier speed" + this.type, (double)0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
            ret.put((Object)Attributes.field_233823_f_, (Object)new AttributeModifier(uuid, "Shooting Guardian modifier attack damage" + this.type, (double)0.1f, AttributeModifier.Operation.MULTIPLY_BASE));
            ret.put((Object)Attributes.field_233825_h_, (Object)new AttributeModifier(uuid, "Shooting Guardian modifier attack speed" + this.type, (double)0.03f, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return ret;
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelShootingGuardianArmor(slot);
    }

    @Override
    public String getArmorTextureAfterInk(ItemStack stack, EquipmentSlotType slot) {
        return slot == EquipmentSlotType.HEAD ? "extrabotany:textures/model/armor_shootingguardian_helmet.png" : "extrabotany:textures/model/armor_shootingguardian.png";
    }

    @Override
    public ItemStack[] getArmorSetStacks() {
        return (ItemStack[])armorSet.func_179281_c();
    }

    @Override
    public boolean hasArmorSetItem(PlayerEntity player, EquipmentSlotType slot) {
        if (player == null) {
            return false;
        }
        ItemStack stack = player.func_184582_a(slot);
        if (stack.func_190926_b()) {
            return false;
        }
        switch (slot) {
            case HEAD: {
                return stack.func_77973_b() == ModItems.armor_shootingguardian_helm;
            }
            case CHEST: {
                return stack.func_77973_b() == ModItems.armor_shootingguardian_chest;
            }
            case LEGS: {
                return stack.func_77973_b() == ModItems.armor_shootingguardian_legs;
            }
            case FEET: {
                return stack.func_77973_b() == ModItems.armor_shootingguardian_boots;
            }
        }
        return false;
    }

    @Override
    public IFormattableTextComponent getArmorSetName() {
        return new TranslationTextComponent("extrabotany.armorset.shootingguardian.name");
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public void addArmorSetDescription(ItemStack stack, List<ITextComponent> list) {
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shootingguardian.desc0").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shootingguardian.desc1").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shootingguardian.desc2").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shootingguardian.desc3").func_240699_a_(TextFormatting.GRAY));
    }
}
