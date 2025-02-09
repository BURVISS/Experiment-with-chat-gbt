/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.capabilities.ICapabilityProvider
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.fml.InterModComms
 *  net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent
 *  net.minecraftforge.items.IItemHandlerModifiable
 *  org.apache.commons.lang3.tuple.ImmutableTriple
 *  top.theillusivec4.curios.api.CuriosApi
 *  top.theillusivec4.curios.api.CuriosCapability
 *  top.theillusivec4.curios.api.SlotTypeMessage$Builder
 *  top.theillusivec4.curios.api.SlotTypePreset
 *  top.theillusivec4.curios.api.type.capability.ICurio
 */
package com.meteor.extrabotany.common.core;

import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.capability.SimpleCapProvider;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.items.IItemHandlerModifiable;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

public class CurioIntegration
extends EquipmentHandler {
    public static void sendImc(InterModEnqueueEvent evt) {
        InterModComms.sendTo((String)"curios", (String)"register_type", () -> SlotTypePreset.CHARM.getMessageBuilder().size(2).build());
        InterModComms.sendTo((String)"curios", (String)"register_type", () -> SlotTypePreset.BODY.getMessageBuilder().build());
        InterModComms.sendTo((String)"curios", (String)"register_type", () -> SlotTypePreset.HEAD.getMessageBuilder().build());
        InterModComms.sendTo((String)"curios", (String)"register_type", () -> new SlotTypeMessage.Builder("mount").priority(30).build());
    }

    @Override
    protected LazyOptional<IItemHandlerModifiable> getAllWornItems(LivingEntity living) {
        return CuriosApi.getCuriosHelper().getEquippedCurios(living);
    }

    @Override
    protected ItemStack findItem(Item item, LivingEntity living) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(item, living).map(ImmutableTriple::getRight).orElse(ItemStack.field_190927_a);
    }

    @Override
    protected ItemStack findItem(Predicate<ItemStack> pred, LivingEntity living) {
        return CuriosApi.getCuriosHelper().findEquippedCurio(pred, living).map(ImmutableTriple::getRight).orElse(ItemStack.field_190927_a);
    }

    @Override
    protected ICapabilityProvider initCap(ItemStack stack) {
        return new SimpleCapProvider<Wrapper>(CuriosCapability.ITEM, new Wrapper(stack));
    }

    public static class Wrapper
    implements ICurio {
        private final ItemStack stack;

        Wrapper(ItemStack stack) {
            this.stack = stack;
        }

        private ItemBauble getItem() {
            return (ItemBauble)this.stack.func_77973_b();
        }

        public void curioTick(String identifier, int index, LivingEntity entity) {
            this.getItem().onWornTick(this.stack, entity);
        }

        public void onEquip(String identifier, int index, LivingEntity entity) {
            this.getItem().onEquipped(this.stack, entity);
        }

        public void onUnequip(String identifier, int index, LivingEntity entity) {
            this.getItem().onUnequipped(this.stack, entity);
        }

        public boolean canEquip(String identifier, LivingEntity entity) {
            return this.getItem().canEquip(this.stack, entity);
        }

        public Multimap<Attribute, AttributeModifier> getAttributeModifiers(String identifier) {
            return this.getItem().getEquippedAttributeModifiers(this.stack);
        }

        public boolean canSync(String identifier, int index, LivingEntity livingEntity) {
            return true;
        }

        public void playRightClickEquipSound(LivingEntity entity) {
        }

        public boolean canRightClickEquip() {
            return true;
        }

        public boolean canRender(String identifier, int index, LivingEntity entity) {
            return this.getItem().hasRender(this.stack, entity);
        }

        @OnlyIn(value=Dist.CLIENT)
        public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            EntityRenderer renderer = Minecraft.func_71410_x().func_175598_ae().func_78713_a((Entity)livingEntity);
            if (!(renderer instanceof IEntityRenderer)) {
                return;
            }
            EntityModel model = ((IEntityRenderer)renderer).func_217764_d();
            if (!(model instanceof BipedModel)) {
                return;
            }
            this.getItem().doRender((BipedModel)model, this.stack, livingEntity, matrixStack, renderTypeBuffer, light, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
        }
    }
}
