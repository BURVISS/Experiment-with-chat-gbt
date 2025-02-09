/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraftforge.common.util.LazyOptional
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network.flamescion;

import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.entities.EntityFlamescionUlt;
import com.meteor.extrabotany.common.potions.ModPotions;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class FlamescionQPack {
    public FlamescionQPack(PacketBuffer buffer) {
    }

    public FlamescionQPack() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                LazyOptional cap = player.getCapability(CapabilityHandler.FLAMESCION_CAPABILITY);
                cap.ifPresent(c -> {
                    c.setEnergy(600);
                    c.setOverloaded(true);
                });
                EntityFlamescionUlt ult = new EntityFlamescionUlt(player.field_70170_p, (PlayerEntity)player);
                Vector3d lookVec = player.func_70040_Z().func_72432_b().func_186678_a(5.0);
                Vector3d spawnPoint = player.func_213303_ch().func_72441_c(lookVec.field_72450_a, 0.25, lookVec.field_72449_c);
                ult.func_70107_b(spawnPoint.field_72450_a, spawnPoint.field_72448_b, spawnPoint.field_72449_c);
                player.field_70170_p.func_217376_c((Entity)ult);
                player.func_195064_c(new EffectInstance(ModPotions.timelock, 40));
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
