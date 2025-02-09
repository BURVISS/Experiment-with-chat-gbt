/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.IItemProvider
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.items.ModItems;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class PotatoChipsPack {
    public PotatoChipsPack(PacketBuffer buffer) {
    }

    public PotatoChipsPack() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
                ClientPlayerEntity player = Minecraft.func_71410_x().field_71439_g;
                Minecraft.func_71410_x().field_71460_t.func_190565_a(new ItemStack((IItemProvider)ModItems.potatochips));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
