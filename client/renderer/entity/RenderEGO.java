/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.cache.Cache
 *  com.google.common.cache.CacheBuilder
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.minecraft.MinecraftProfileTexture
 *  com.mojang.authlib.minecraft.MinecraftProfileTexture$Type
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  javax.annotation.Nonnull
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.IRenderTypeBuffer
 *  net.minecraft.client.renderer.entity.BipedRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererManager
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.renderer.entity.model.PlayerModel
 *  net.minecraft.client.resources.DefaultPlayerSkin
 *  net.minecraft.entity.MobEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.tileentity.SkullTileEntity
 *  net.minecraft.util.ResourceLocation
 */
package com.meteor.extrabotany.client.renderer.entity;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.meteor.extrabotany.client.renderer.entity.layers.HeldFakeItemLayer;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.SkullTileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderEGO
extends BipedRenderer<MobEntity, BipedModel<MobEntity>> {
    private static final Cache<String, GameProfile> GAME_PROFILE_CACHE = CacheBuilder.newBuilder().expireAfterAccess(30L, TimeUnit.MINUTES).build();
    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    private static final GameProfile EMPTY_GAME_PROFILE = new GameProfile(null, "EMPTY");
    private static final ResourceLocation TEXTURE_ALEX = new ResourceLocation("textures/entity/alex.png");

    public RenderEGO(EntityRendererManager renderManager) {
        super(renderManager, (BipedModel)new PlayerModel(0.0f, false), 0.0f);
        this.func_177094_a(new HeldFakeItemLayer(this));
    }

    public void func_225623_a_(@Nonnull MobEntity mob, float yaw, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffers, int light) {
        super.func_225623_a_(mob, yaw, partialTicks, ms, buffers, light);
    }

    @Nonnull
    public ResourceLocation func_110775_a(@Nonnull MobEntity entity) {
        if (entity.func_200201_e() != null) {
            return RenderEGO.getPlayerSkin(entity.func_200201_e().getString());
        }
        return RenderEGO.getPlayerSkin("ExtraMeteorP");
    }

    public static ResourceLocation getPlayerSkin(String name) {
        GameProfile newProfile = null;
        Minecraft minecraft = Minecraft.func_71410_x();
        try {
            newProfile = (GameProfile)GAME_PROFILE_CACHE.get((Object)name, () -> {
                THREAD_POOL.submit(() -> {
                    GameProfile profile = new GameProfile(null, name);
                    GameProfile profileNew = SkullTileEntity.func_174884_b((GameProfile)profile);
                    minecraft.func_212871_a_(() -> {
                        if (profileNew != null) {
                            GAME_PROFILE_CACHE.put((Object)name, (Object)profileNew);
                        }
                    });
                });
                return EMPTY_GAME_PROFILE;
            });
        }
        catch (ExecutionException executionException) {
            // empty catch block
        }
        if (newProfile != null) {
            Map map = minecraft.func_152342_ad().func_152788_a(newProfile);
            if (map.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                return minecraft.func_152342_ad().func_152792_a((MinecraftProfileTexture)map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
            }
            UUID uuid = PlayerEntity.func_146094_a((GameProfile)newProfile);
            return DefaultPlayerSkin.func_177334_a((UUID)uuid);
        }
        return TEXTURE_ALEX;
    }
}
