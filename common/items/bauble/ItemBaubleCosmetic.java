/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBaubleCosmetic
extends ItemBauble {
    private final Variant variant;
    public static final int SUBTYPES = Variant.values().length;

    public ItemBaubleCosmetic(Variant variant, Item.Properties props) {
        super(props);
        this.variant = variant;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.func_77624_a(stack, world, tooltip, flags);
        Variant variant = ((ItemBaubleCosmetic)stack.func_77973_b()).variant;
        if (variant == Variant.FOX_MASK) {
            tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.foxmaskinfo0").func_240699_a_(TextFormatting.ITALIC));
            tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.foxmaskinfo1").func_240699_a_(TextFormatting.ITALIC));
            tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.foxmaskinfo2").func_240699_a_(TextFormatting.ITALIC));
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void doRender(BipedModel<?> bipedModel, ItemStack stack, LivingEntity player, MatrixStack ms, IRenderTypeBuffer buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        Variant variant = ((ItemBaubleCosmetic)stack.func_77973_b()).variant;
        if (variant.isHead) {
            bipedModel.field_78116_c.func_228307_a_(ms);
            switch (variant) {
                case FOX_EAR: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.8, (double)-0.1f);
                    ms.func_227862_a_(0.8f, -0.8f, -0.8f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case FOX_MASK: {
                    ms.func_227860_a_();
                    ms.func_227861_a_((double)0.02f, -0.3, -0.3);
                    ms.func_227862_a_(0.66f, -0.65f, -0.65f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case MASK: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.3, -0.3);
                    ms.func_227862_a_(0.65f, -0.65f, -0.65f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case BLACK_GLASSES: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.2, -0.3);
                    ms.func_227862_a_(0.55f, 0.55f, -0.55f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case SUPER_CROWN: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.7, (double)-0.1f);
                    ms.func_227862_a_(0.65f, -0.65f, -0.65f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case PYLON: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.8, (double)-0.1f);
                    ms.func_227862_a_(0.5f, -0.5f, -0.5f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                    break;
                }
                case THUG_LIFE: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, -0.2, -0.3);
                    ms.func_227862_a_(0.7f, -0.7f, -0.7f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                }
            }
        } else {
            bipedModel.field_78115_e.func_228307_a_(ms);
            switch (variant) {
                case RED_SCARF: {
                    ms.func_227860_a_();
                    ms.func_227861_a_(0.0, 0.16, -0.15);
                    ms.func_227862_a_(0.55f, -0.55f, -0.55f);
                    ItemBaubleCosmetic.renderItem(stack, ms, buffers, light);
                    ms.func_227865_b_();
                }
            }
        }
    }

    public static void renderItem(ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        Minecraft.func_71410_x().func_175599_af().func_229110_a_(stack, ItemCameraTransforms.TransformType.NONE, light, OverlayTexture.field_229196_a_, ms, buffers);
    }

    public static enum Variant {
        FOX_EAR(true),
        FOX_MASK(true),
        PYLON(true),
        BLACK_GLASSES(true),
        RED_SCARF,
        SUPER_CROWN(true),
        THUG_LIFE(true),
        MASK(true);

        private final boolean isHead;

        private Variant(boolean isHead) {
            this.isHead = isHead;
        }

        private Variant() {
            this(false);
        }
    }
}
