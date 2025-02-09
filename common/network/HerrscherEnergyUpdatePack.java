/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class HerrscherEnergyUpdatePack {
    private int energy;

    public HerrscherEnergyUpdatePack(PacketBuffer buffer) {
        this.energy = buffer.readInt();
    }

    public HerrscherEnergyUpdatePack(int energy) {
        this.energy = energy;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.energy);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
                ClientPlayerEntity player = Minecraft.func_71410_x().field_71439_g;
                LazyOptional cap = player.getCapability(CapabilityHandler.HERRSCHERENERGY_CAPABILITY);
                cap.ifPresent(c -> c.setEnergy(this.energy));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
