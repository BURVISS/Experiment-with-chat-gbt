/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.api.items.IItemWithLeftClick;
import java.util.function.Supplier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class LeftClickPack {
    private ItemStack stack;

    public LeftClickPack(PacketBuffer buffer) {
        this.stack = buffer.func_150791_c();
    }

    public LeftClickPack(ItemStack stack) {
        this.stack = stack;
    }

    public void toBytes(PacketBuffer buf) {
        buf.func_150788_a(this.stack);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                if (this.stack.func_77973_b() instanceof IItemWithLeftClick) {
                    IItemWithLeftClick item = (IItemWithLeftClick)this.stack.func_77973_b();
                    ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> item.onLeftClick((PlayerEntity)player, null));
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
