/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.common.entities.EntitySlash;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class HerrscherSkillPack {
    private BlockPos pos;

    public HerrscherSkillPack(PacketBuffer buffer) {
        this.pos = BlockPos.func_218283_e((long)buffer.readLong());
    }

    public HerrscherSkillPack(BlockPos pos) {
        this.pos = pos;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeLong(this.pos.func_218275_a());
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                EntitySlash slash = new EntitySlash(player.field_70170_p, (PlayerEntity)player);
                slash.func_70107_b(this.pos.func_177958_n(), this.pos.func_177956_o(), this.pos.func_177952_p());
                player.field_70170_p.func_217376_c((Entity)slash);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
