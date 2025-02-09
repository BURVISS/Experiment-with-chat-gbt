/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.client.renderer.entity.model.EntityModel
 *  net.minecraft.client.renderer.entity.model.IHasArm
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.HandSide
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.client.renderer.entity.layers;

import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.entities.ego.EntityEGOMinion;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
public class HeldFakeItemLayer<T extends LivingEntity, M extends EntityModel<T>>
extends LayerRenderer<T, M> {
    public HeldFakeItemLayer(IEntityRenderer<T, M> p_i50926_1_) {
        super(p_i50926_1_);
    }

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, T p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        ItemStack lvt_13_1_;
        Object minion;
        boolean lvt_11_1_ = p_225628_4_.func_184591_cq() == HandSide.RIGHT;
        ItemStack mainHand = ItemStack.field_190927_a;
        ItemStack offHand = ItemStack.field_190927_a;
        if (p_225628_4_ instanceof EntityEGOMinion) {
            minion = (EntityEGOMinion)((Object)p_225628_4_);
            mainHand = ((EntityEGOMinion)((Object)minion)).getWeapon();
        }
        if (p_225628_4_ instanceof EntityEGO) {
            minion = (EntityEGO)((Object)p_225628_4_);
            mainHand = ((EntityEGO)((Object)minion)).getWeapon();
        }
        ItemStack lvt_12_1_ = lvt_11_1_ ? offHand : mainHand;
        ItemStack itemStack = lvt_13_1_ = lvt_11_1_ ? mainHand : offHand;
        if (!lvt_12_1_.func_190926_b() || !lvt_13_1_.func_190926_b()) {
            p_225628_1_.func_227860_a_();
            if (this.func_215332_c().field_217114_e) {
                float lvt_14_1_ = 0.5f;
                p_225628_1_.func_227861_a_(0.0, 0.75, 0.0);
                p_225628_1_.func_227862_a_(0.5f, 0.5f, 0.5f);
            }
            this.func_229135_a_((LivingEntity)p_225628_4_, lvt_13_1_, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT, p_225628_1_, p_225628_2_, p_225628_3_);
            this.func_229135_a_((LivingEntity)p_225628_4_, lvt_12_1_, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT, p_225628_1_, p_225628_2_, p_225628_3_);
            p_225628_1_.func_227865_b_();
        }
    }

    private void func_229135_a_(LivingEntity p_229135_1_, ItemStack p_229135_2_, ItemCameraTransforms.TransformType p_229135_3_, HandSide p_229135_4_, MatrixStack p_229135_5_, IRenderTypeBuffer p_229135_6_, int p_229135_7_) {
        if (!p_229135_2_.func_190926_b()) {
            p_229135_5_.func_227860_a_();
            ((IHasArm)this.func_215332_c()).func_225599_a_(p_229135_4_, p_229135_5_);
            p_229135_5_.func_227863_a_(Vector3f.field_229179_b_.func_229187_a_(-90.0f));
            p_229135_5_.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f));
            boolean lvt_8_1_ = p_229135_4_ == HandSide.LEFT;
            p_229135_5_.func_227861_a_((double)((float)(lvt_8_1_ ? -1 : 1) / 16.0f), 0.125, -0.625);
            Minecraft.func_71410_x().func_175597_ag().func_228397_a_(p_229135_1_, p_229135_2_, p_229135_3_, lvt_8_1_, p_229135_5_, p_229135_6_, p_229135_7_);
            p_229135_5_.func_227865_b_();
        }
    }
}
