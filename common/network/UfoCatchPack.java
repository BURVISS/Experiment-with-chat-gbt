/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.entities.mountable.EntityUfo;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class UfoCatchPack {
    private int id;

    public UfoCatchPack(PacketBuffer buffer) {
        this.id = buffer.readInt();
    }

    public UfoCatchPack(int id) {
        this.id = id;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.id);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player;
            Entity riding;
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER && (riding = (player = ((NetworkEvent.Context)ctx.get()).getSender()).func_184187_bx()) != null && riding instanceof EntityUfo) {
                EntityUfo motor = (EntityUfo)riding;
                motor.setCatchedID(this.id);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
