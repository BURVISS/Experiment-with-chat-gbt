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
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.LazyValue
 *  net.minecraft.util.registry.Registry
 *  net.minecraft.util.text.IFormattableTextComponent
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 */
package com.meteor.extrabotany.common.items.armor.shadowwarrior;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.client.model.armor.ModelShadowWarriorArmor;
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
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class ItemShadowWarriorArmor
extends ItemMikuArmor {
    public static final String TAG_NIGHT = "isnight";
    private static final LazyValue<ItemStack[]> armorSet = new LazyValue(() -> new ItemStack[]{new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_helm), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_chest), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_legs), new ItemStack((IItemProvider)ModItems.armor_shadowwarrior_boots)});

    public ItemShadowWarriorArmor(EquipmentSlotType type, Item.Properties props) {
        super(type, ExtraBotanyAPI.INSTANCE.getShadowWarriorArmorMaterial(), props);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if (this.hasArmorSet(player) && !world.func_72935_r()) {
            ItemNBTHelper.setBoolean((ItemStack)stack, (String)TAG_NIGHT, (boolean)true);
            player.func_195064_c(new EffectInstance(Effects.field_76439_r, 400, 1));
        } else {
            ItemNBTHelper.setBoolean((ItemStack)stack, (String)TAG_NIGHT, (boolean)false);
        }
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(@Nonnull EquipmentSlotType slot, ItemStack stack) {
        Multimap ret = super.getAttributeModifiers(slot, stack);
        UUID uuid = new UUID(Registry.field_212630_s.func_177774_c((Object)this).hashCode() + slot.toString().hashCode(), 0L);
        boolean night = ItemNBTHelper.getBoolean((ItemStack)stack, (String)TAG_NIGHT, (boolean)false);
        if (slot == this.func_185083_B_()) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233818_a_, (Object)new AttributeModifier(uuid, "ShadowWarrior modifier health" + this.type, night ? 0.25 : 0.0, AttributeModifier.Operation.MULTIPLY_BASE));
            ret.put((Object)Attributes.field_233825_h_, (Object)new AttributeModifier(uuid, "ShadowWarrior modifier attack speed" + this.type, night ? 0.125 : 0.0, AttributeModifier.Operation.MULTIPLY_BASE));
            ret.put((Object)Attributes.field_233823_f_, (Object)new AttributeModifier(uuid, "ShadowWarrior modifier attack damage" + this.type, night ? (double)0.05f : 0.0, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return ret;
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelShadowWarriorArmor(slot);
    }

    @Override
    public String getArmorTextureAfterInk(ItemStack stack, EquipmentSlotType slot) {
        return "extrabotany:textures/model/armor_shadowwarrior.png";
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
        return new TranslationTextComponent("extrabotany.armorset.shadowwarrior.name");
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public void addArmorSetDescription(ItemStack stack, List<ITextComponent> list) {
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shadowwarrior.desc0").func_240699_a_(TextFormatting.GRAY));
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.shadowwarrior.desc1").func_240699_a_(TextFormatting.GRAY));
    }
}
