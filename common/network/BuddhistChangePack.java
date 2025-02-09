/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.Hand
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.items.relic.ItemBuddhistrelics;
import java.util.function.Supplier;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class BuddhistChangePack {
    public BuddhistChangePack(PacketBuffer buffer) {
    }

    public BuddhistChangePack() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player;
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER && !ItemBuddhistrelics.relicShift((player = ((NetworkEvent.Context)ctx.get()).getSender()).func_184614_ca()).func_190926_b()) {
                ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> player.func_184611_a(Hand.MAIN_HAND, ItemBuddhistrelics.relicShift(player.func_184614_ca())));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
