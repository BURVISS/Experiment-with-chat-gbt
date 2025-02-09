/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network.flamescion;

import com.meteor.extrabotany.common.items.ItemFlamescionWeapon;
import com.meteor.extrabotany.common.items.ModItems;
import java.util.function.Supplier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class FlamescionStrengthenPack {
    public FlamescionStrengthenPack(PacketBuffer buffer) {
    }

    public FlamescionStrengthenPack() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> ((ItemFlamescionWeapon)ModItems.flamescionweapon).tryStrengthenAttack((PlayerEntity)player));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
