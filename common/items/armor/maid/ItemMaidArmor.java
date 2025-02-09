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
package com.meteor.extrabotany.common.items.armor.maid;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.client.model.armor.ModelMaidArmor;
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

public class ItemMaidArmor
extends ItemMikuArmor {
    private static final LazyValue<ItemStack[]> armorSet = new LazyValue(() -> new ItemStack[]{new ItemStack((IItemProvider)ModItems.armor_maid_helm), new ItemStack((IItemProvider)ModItems.armor_maid_chest), new ItemStack((IItemProvider)ModItems.armor_maid_legs), new ItemStack((IItemProvider)ModItems.armor_maid_boots)});

    public ItemMaidArmor(EquipmentSlotType type, Item.Properties props) {
        super(type, ExtraBotanyAPI.INSTANCE.getMaidArmorMaterial(), props);
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(@Nonnull EquipmentSlotType slot, ItemStack stack) {
        Multimap ret = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(Registry.field_212630_s.func_177774_c((Object)this).hashCode() + slot.toString().hashCode(), 0L);
        if (slot == this.func_185083_B_()) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233818_a_, (Object)new AttributeModifier(uuid, "Maid modifier " + this.type, 5.0, AttributeModifier.Operation.ADDITION));
            ret.put((Object)Attributes.field_233820_c_, (Object)new AttributeModifier(uuid, "Maid modifier " + this.type, (double)(this.type.func_188454_b() / 20), AttributeModifier.Operation.ADDITION));
        }
        return ret;
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelMaidArmor(slot);
    }

    @Override
    public String getArmorTextureAfterInk(ItemStack stack, EquipmentSlotType slot) {
        return "extrabotany:textures/model/armor_maid.png";
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
                return stack.func_77973_b() == ModItems.armor_maid_helm;
            }
            case CHEST: {
                return stack.func_77973_b() == ModItems.armor_maid_chest;
            }
            case LEGS: {
                return stack.func_77973_b() == ModItems.armor_maid_legs;
            }
            case FEET: {
                return stack.func_77973_b() == ModItems.armor_maid_boots;
            }
        }
        return false;
    }

    @Override
    public IFormattableTextComponent getArmorSetName() {
        return new TranslationTextComponent("extrabotany.armorset.maid.name");
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public void addArmorSetDescription(ItemStack stack, List<ITextComponent> list) {
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.maid.desc0").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.maid.desc1").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.maid.desc2").func_240699_a_(TextFormatting.GRAY));
    }
}
