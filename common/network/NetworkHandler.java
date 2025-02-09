/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.world.World
 *  net.minecraft.world.server.ServerWorld
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkRegistry
 *  net.minecraftforge.fml.network.PacketDistributor
 *  net.minecraftforge.fml.network.simple.SimpleChannel
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.network.BuddhistChangePack;
import com.meteor.extrabotany.common.network.HerrscherEnergyUpdatePack;
import com.meteor.extrabotany.common.network.HerrscherSkillPack;
import com.meteor.extrabotany.common.network.LeftClickPack;
import com.meteor.extrabotany.common.network.MountPack;
import com.meteor.extrabotany.common.network.MountableUpdatePack;
import com.meteor.extrabotany.common.network.PotatoChipsPack;
import com.meteor.extrabotany.common.network.UfoCatchPack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionQPack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionShiftPack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionStateUpdatePack;
import com.meteor.extrabotany.common.network.flamescion.FlamescionStrengthenPack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel INSTANCE;
    private static int ID;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel((ResourceLocation)new ResourceLocation("extrabotany:networking"), () -> "1.0", s -> true, s -> true);
        INSTANCE.registerMessage(NetworkHandler.nextID(), HerrscherEnergyUpdatePack.class, HerrscherEnergyUpdatePack::toBytes, HerrscherEnergyUpdatePack::new, HerrscherEnergyUpdatePack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), HerrscherSkillPack.class, HerrscherSkillPack::toBytes, HerrscherSkillPack::new, HerrscherSkillPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), MountableUpdatePack.class, MountableUpdatePack::toBytes, MountableUpdatePack::new, MountableUpdatePack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), UfoCatchPack.class, UfoCatchPack::toBytes, UfoCatchPack::new, UfoCatchPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), FlamescionStateUpdatePack.class, FlamescionStateUpdatePack::toBytes, FlamescionStateUpdatePack::new, FlamescionStateUpdatePack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), FlamescionShiftPack.class, FlamescionShiftPack::toBytes, FlamescionShiftPack::new, FlamescionShiftPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), FlamescionQPack.class, FlamescionQPack::toBytes, FlamescionQPack::new, FlamescionQPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), FlamescionStrengthenPack.class, FlamescionStrengthenPack::toBytes, FlamescionStrengthenPack::new, FlamescionStrengthenPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), LeftClickPack.class, LeftClickPack::toBytes, LeftClickPack::new, LeftClickPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), BuddhistChangePack.class, BuddhistChangePack::toBytes, BuddhistChangePack::new, BuddhistChangePack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), MountPack.class, MountPack::toBytes, MountPack::new, MountPack::handler);
        INSTANCE.registerMessage(NetworkHandler.nextID(), PotatoChipsPack.class, PotatoChipsPack::toBytes, PotatoChipsPack::new, PotatoChipsPack::handler);
    }

    public static void sendToNearby(World world, BlockPos pos, Object toSend) {
        if (world instanceof ServerWorld) {
            ServerWorld ws = (ServerWorld)world;
            ws.func_72863_F().field_217237_a.func_219097_a(new ChunkPos(pos), false).filter(p -> p.func_70092_e((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p()) < 4096.0).forEach(p -> INSTANCE.send(PacketDistributor.PLAYER.with(() -> p), toSend));
        }
    }

    public static void sendToNearby(World world, Entity e, Object toSend) {
        NetworkHandler.sendToNearby(world, new BlockPos(e.func_226277_ct_(), e.func_226278_cu_(), e.func_226281_cx_()), toSend);
    }

    public static void sendTo(ServerPlayerEntity playerMP, Object toSend) {
        INSTANCE.sendTo(toSend, playerMP.field_71135_a.func_147298_b(), NetworkDirection.PLAY_TO_CLIENT);
    }

    static {
        ID = 0;
    }
}
