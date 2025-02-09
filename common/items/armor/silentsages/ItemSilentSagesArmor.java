/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.LazyValue
 *  net.minecraft.util.text.IFormattableTextComponent
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.common.items.armor.silentsages;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.client.model.armor.ModelShadowWarriorArmor;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.armor.miku.ItemMikuArmor;
import java.util.List;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemSilentSagesArmor
extends ItemMikuArmor {
    private static final LazyValue<ItemStack[]> armorSet = new LazyValue(() -> new ItemStack[]{new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_helm), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_chest), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_legs), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_boots)});

    public ItemSilentSagesArmor(EquipmentSlotType type, Item.Properties props) {
        super(type, ExtraBotanyAPI.INSTANCE.getSilentSagesArmorMaterial(), props);
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelShadowWarriorArmor(slot);
    }

    @Override
    public String getArmorTextureAfterInk(ItemStack stack, EquipmentSlotType slot) {
        return "extrabotany:textures/model/armor_silentsages.png";
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
                return stack.func_77973_b() == ModItems.armor_shadowwarrior_helm;
            }
            case CHEST: {
                return stack.func_77973_b() == ModItems.armor_shadowwarrior_chest;
            }
            case LEGS: {
                return stack.func_77973_b() == ModItems.armor_shadowwarrior_legs;
            }
            case FEET: {
                return stack.func_77973_b() == ModItems.armor_shadowwarrior_boots;
            }
        }
        return false;
    }

    @Override
    public IFormattableTextComponent getArmorSetName() {
        return new TranslationTextComponent("extrabotany.armorset.silentsages.name");
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public void addArmorSetDescription(ItemStack stack, List<ITextComponent> list) {
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.silentsages.desc").func_240699_a_(TextFormatting.GRAY));
    }
}
