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

import com.meteor.extrabotany.common.entities.mountable.EntityMountable;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class MountableUpdatePack {
    private boolean ctrlInputDown;
    private boolean upInputDown;

    public MountableUpdatePack(PacketBuffer buffer) {
        this.ctrlInputDown = buffer.readBoolean();
        this.upInputDown = buffer.readBoolean();
    }

    public MountableUpdatePack(boolean ctrlInputDown, boolean upInputDown) {
        this.ctrlInputDown = ctrlInputDown;
        this.upInputDown = upInputDown;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeBoolean(this.ctrlInputDown);
        buf.writeBoolean(this.upInputDown);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player;
            Entity riding;
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER && (riding = (player = ((NetworkEvent.Context)ctx.get()).getSender()).func_184187_bx()) != null && riding instanceof EntityMountable) {
                EntityMountable motor = (EntityMountable)riding;
                motor.updateInput(this.ctrlInputDown, this.upInputDown);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
