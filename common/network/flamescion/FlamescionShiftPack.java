/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network.flamescion;

import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import com.meteor.extrabotany.common.potions.ModPotions;
import java.util.function.Supplier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class FlamescionShiftPack {
    public FlamescionShiftPack(PacketBuffer buffer) {
    }

    public FlamescionShiftPack() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                Vector3d lookvec = player.func_70040_Z().func_186678_a(4.0);
                Vector3d playervec = player.func_213303_ch();
                Vector3d newvec = playervec.func_178787_e(lookvec);
                player.func_70634_a(newvec.field_72450_a, newvec.field_72448_b, newvec.field_72449_c);
                boolean flag = false;
                for (LivingEntity living : EntityMotor.getEntitiesAround(new BlockPos(newvec), 8.0f, player.field_70170_p)) {
                    boolean hit;
                    if (living == player || !(hit = living.func_174813_aQ().func_186662_g(4.0).func_216365_b(playervec.func_178788_d(lookvec), newvec.func_178787_e(lookvec)).isPresent())) continue;
                    living.func_195064_c(new EffectInstance(ModPotions.timelock, 40));
                    living.field_70172_ad = 0;
                    living.func_70097_a(FlamescionHandler.flameSource(), 6.0f);
                    flag = true;
                }
                if (flag) {
                    player.func_195064_c(new EffectInstance(ModPotions.incandescence, 80));
                    player.func_195064_c(new EffectInstance(ModPotions.flamescion, 200));
                }
                player.func_184811_cZ().func_185145_a(FlamescionHandler.getFlamescionWeapon(), 20);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
