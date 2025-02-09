/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 */
package com.meteor.extrabotany.common.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;

public class ItemWalkingCane
extends Item {
    public ItemWalkingCane(Item.Properties properties) {
        super(properties);
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> func_111205_h(@Nonnull EquipmentSlotType slot) {
        Multimap ret = super.func_111205_h(slot);
        if (slot == EquipmentSlotType.MAINHAND) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233821_d_, (Object)new AttributeModifier(UUID.fromString("995829fa-94c0-41bd-b046-0468c509a488"), "Cane modifier", 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return ret;
    }
}
