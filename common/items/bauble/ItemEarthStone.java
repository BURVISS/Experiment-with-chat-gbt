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
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 */
package com.meteor.extrabotany.common.items.bauble;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEarthStone
extends ItemBauble {
    public ItemEarthStone(Item.Properties props) {
        super(props);
    }

    public Multimap<Attribute, AttributeModifier> getEquippedAttributeModifiers(ItemStack stack) {
        HashMultimap attributes = HashMultimap.create();
        attributes.put((Object)Attributes.field_233826_i_, (Object)new AttributeModifier(ItemEarthStone.getBaubleUUID((ItemStack)stack), "Earth Stone", 4.0, AttributeModifier.Operation.ADDITION));
        return attributes;
    }

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return EquipmentHandler.findOrEmpty((Item)this, entity).func_190926_b() && EquipmentHandler.findOrEmpty(ModItems.thecommunity, entity).func_190926_b();
    }
}
