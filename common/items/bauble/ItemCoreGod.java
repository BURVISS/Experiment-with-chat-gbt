/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  javax.annotation.Nonnull
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.client.renderer.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.vector.Vector3f
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.PlayerEvent$PlayerLoggedOutEvent
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.client.fx.SparkleParticleData
 *  vazkii.botania.common.core.handler.EquipmentHandler
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.relic.ItemRelicBauble
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.client.fx.SparkleParticleData;
import vazkii.botania.common.core.handler.EquipmentHandler;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.relic.ItemRelicBauble;

public class ItemCoreGod
extends ItemRelicBauble
implements IManaUsingItem,
IAdvancementRequirement {
    private static final String TAG_VARIANT = "variant";
    private static final List<String> playersWithFlight = Collections.synchronizedList(new ArrayList());
    private static final int COST = 35;
    private static final int SUBTYPES = 4;

    public ItemCoreGod(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::updatePlayerFlyStatus);
        MinecraftForge.EVENT_BUS.addListener(this::playerLoggedOut);
    }

    public void func_150895_a(@Nonnull ItemGroup tab, @Nonnull NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            for (int i = 0; i < 4; ++i) {
                ItemStack stack = new ItemStack((IItemProvider)this);
                ItemNBTHelper.setInt((ItemStack)stack, (String)TAG_VARIANT, (int)i);
                list.add((Object)stack);
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.func_77624_a(stack, world, tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.wings" + ItemCoreGod.getVariant(stack)).func_240699_a_(TextFormatting.GRAY));
    }

    private void updatePlayerFlyStatus(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntityLiving();
            ItemStack tiara = EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)player);
            if (playersWithFlight.contains(ItemCoreGod.playerStr(player))) {
                if (this.shouldPlayerHaveFlight(player)) {
                    player.field_71075_bZ.field_75101_c = true;
                    if (player.field_71075_bZ.field_75100_b) {
                        if (!player.field_70170_p.field_72995_K) {
                            ManaItemHandler.instance().requestManaExact(tiara, player, 35, true);
                        } else if (Math.abs(player.func_213322_ci().func_82615_a()) > 0.1 || Math.abs(player.func_213322_ci().func_82616_c()) > 0.1) {
                            double x = event.getEntityLiving().func_226277_ct_() - 0.5;
                            double y = event.getEntityLiving().func_226278_cu_() - 0.5;
                            double z = event.getEntityLiving().func_226281_cx_() - 0.5;
                            float r = 1.0f;
                            float g = 1.0f;
                            float b = 1.0f;
                            int variant = ItemCoreGod.getVariant(tiara);
                            switch (variant) {
                                case 0: {
                                    r = 1.0f;
                                    g = 0.55f;
                                    b = 0.0f;
                                    break;
                                }
                                case 1: {
                                    r = (new float[]{0.4f, 0.98f, 0.98f, 0.98f, 0.6f, 0.0f, 0.15f})[player.field_70170_p.field_73012_v.nextInt(7)];
                                    g = (new float[]{0.82f, 0.84f, 0.52f, 0.12f, 0.21f, 0.4f, 0.98f})[player.field_70170_p.field_73012_v.nextInt(7)];
                                    b = (new float[]{0.0f, 0.18f, 0.18f, 0.0f, 0.98f, 0.81f, 0.82f})[player.field_70170_p.field_73012_v.nextInt(7)];
                                    break;
                                }
                                case 2: {
                                    r = 0.52f;
                                    g = 0.8f;
                                    b = 0.85f;
                                    break;
                                }
                                case 3: {
                                    r = 0.95f;
                                    g = 0.7f;
                                    b = 0.38f;
                                }
                            }
                            for (int i = 0; i < 2; ++i) {
                                SparkleParticleData data = SparkleParticleData.sparkle((float)(2.0f * (float)Math.random()), (float)r, (float)g, (float)b, (int)20);
                                player.field_70170_p.func_195594_a((IParticleData)data, x + Math.random() * (double)event.getEntityLiving().func_213311_cf(), y + Math.random() * 0.4, z + Math.random() * (double)event.getEntityLiving().func_213311_cf(), 0.0, 0.0, 0.0);
                            }
                        }
                    }
                } else {
                    if (!player.func_175149_v() && !player.field_71075_bZ.field_75098_d) {
                        player.field_71075_bZ.field_75101_c = false;
                        player.field_71075_bZ.field_75100_b = false;
                        player.field_71075_bZ.field_75102_a = false;
                    }
                    playersWithFlight.remove(ItemCoreGod.playerStr(player));
                }
            } else if (this.shouldPlayerHaveFlight(player)) {
                playersWithFlight.add(ItemCoreGod.playerStr(player));
                player.field_71075_bZ.field_75101_c = true;
            }
        }
    }

    private void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        String username = event.getPlayer().func_146103_bH().getName();
        playersWithFlight.remove(username + ":false");
        playersWithFlight.remove(username + ":true");
    }

    private static String playerStr(PlayerEntity player) {
        return player.func_146103_bH().getName() + ":" + player.field_70170_p.field_72995_K;
    }

    private boolean shouldPlayerHaveFlight(PlayerEntity player) {
        ItemStack armor = EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)player);
        if (!armor.func_190926_b()) {
            return ManaItemHandler.instance().requestManaExact(armor, player, 35, false);
        }
        return false;
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }

    public void onWornTick(ItemStack stack, LivingEntity player) {
        if (player instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity)player;
        }
    }

    public boolean hasRender(ItemStack stack, LivingEntity living) {
        return super.hasRender(stack, living) && living instanceof PlayerEntity;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void renderHerrscher(BipedModel<?> bipedModel, IBakedModel model, ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, float flap) {
        ms.func_227860_a_();
        bipedModel.field_78115_e.func_228307_a_(ms);
        ms.func_227861_a_(0.0, -0.2, 0.3);
        for (int i = 0; i < 3; ++i) {
            ms.func_227860_a_();
            ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(flap * 0.25f));
            ms.func_227863_a_(Vector3f.field_229183_f_.func_229187_a_(-35.0f * (float)i));
            IBakedModel model_ = MiscellaneousIcons.INSTANCE.coregodModel[0];
            ms.func_227861_a_(-1.2, (double)(-0.1f * (float)i), 0.0);
            ms.func_227862_a_(1.9f, -1.9f, -1.9f);
            Minecraft.func_71410_x().func_175599_af().func_229111_a_(stack, ItemCameraTransforms.TransformType.NONE, false, ms, buffers, 0xF000F0, OverlayTexture.field_229196_a_, model_);
            ms.func_227865_b_();
        }
        ms.func_227860_a_();
        ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(180.0f - flap * 0.25f));
        ms.func_227861_a_(-1.2, 0.0, 0.0);
        ms.func_227862_a_(1.7f, -1.7f, -1.7f);
        Minecraft.func_71410_x().func_175599_af().func_229111_a_(stack, ItemCameraTransforms.TransformType.NONE, false, ms, buffers, 0xF000F0, OverlayTexture.field_229196_a_, model);
        ms.func_227865_b_();
        ms.func_227865_b_();
    }

    @OnlyIn(value=Dist.CLIENT)
    private static void renderStarlight(BipedModel<?> bipedModel, IBakedModel model, ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, int light, float flap) {
        ms.func_227860_a_();
        ms.func_227865_b_();
    }

    @OnlyIn(value=Dist.CLIENT)
    private static void renderBasic(BipedModel<?> bipedModel, IBakedModel model, ItemStack stack, MatrixStack ms, IRenderTypeBuffer buffers, int light, float flap) {
        ms.func_227860_a_();
        bipedModel.field_78115_e.func_228307_a_(ms);
        ms.func_227861_a_(0.0, 0.2, 0.2);
        for (int i = 0; i < 2; ++i) {
            ms.func_227860_a_();
            ms.func_227863_a_(Vector3f.field_229181_d_.func_229187_a_(i == 0 ? flap : 180.0f - flap));
            ms.func_227861_a_(-1.0, 0.0, 0.0);
            ms.func_227862_a_(1.5f, -1.5f, -1.5f);
            Minecraft.func_71410_x().func_175599_af().func_229111_a_(stack, ItemCameraTransforms.TransformType.NONE, false, ms, buffers, light, OverlayTexture.field_229196_a_, model);
            ms.func_227865_b_();
        }
        ms.func_227865_b_();
    }

    @OnlyIn(value=Dist.CLIENT)
    public void doRender(BipedModel<?> bipedModel, ItemStack stack, LivingEntity living, MatrixStack ms, IRenderTypeBuffer buffers, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        int meta = ItemCoreGod.getVariant(stack);
        if (meta < 0 || meta >= MiscellaneousIcons.INSTANCE.coregodWingsModel.length + 1) {
            return;
        }
        IBakedModel model = MiscellaneousIcons.INSTANCE.coregodWingsModel[meta];
        boolean flying = living instanceof PlayerEntity && ((PlayerEntity)living).field_71075_bZ.field_75100_b;
        float flap = 12.0f + (float)((Math.sin((double)((float)living.field_70173_aa + partialTicks) * (double)(flying ? 0.2f : 0.12f)) + (double)0.4f) * (double)(flying ? 30.0f : 5.0f));
        switch (meta) {
            case 0: {
                ItemCoreGod.renderHerrscher(bipedModel, model, stack, ms, buffers, flap);
                break;
            }
            case 1: {
                ItemCoreGod.renderBasic(bipedModel, model, stack, ms, buffers, light, flap * 0.25f);
                break;
            }
            case 2: 
            case 3: {
                ItemCoreGod.renderBasic(bipedModel, model, stack, ms, buffers, light, flap);
            }
        }
    }

    public static int getVariant(ItemStack stack) {
        return ItemNBTHelper.getInt((ItemStack)stack, (String)TAG_VARIANT, (int)0);
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
