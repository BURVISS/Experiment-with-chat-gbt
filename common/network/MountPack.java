/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.PacketBuffer
 *  net.minecraftforge.fml.network.NetworkDirection
 *  net.minecraftforge.fml.network.NetworkEvent$Context
 */
package com.meteor.extrabotany.common.network;

import com.meteor.extrabotany.api.items.IMountableAccessory;
import com.meteor.extrabotany.common.entities.mountable.EntityMountable;
import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

public class MountPack {
    private ItemStack stack;

    public MountPack(PacketBuffer buffer) {
        this.stack = buffer.func_150791_c();
    }

    public MountPack(ItemStack stack) {
        this.stack = stack;
    }

    public void toBytes(PacketBuffer buf) {
        buf.func_150788_a(this.stack);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (((NetworkEvent.Context)ctx.get()).getDirection() == NetworkDirection.PLAY_TO_SERVER) {
                ServerPlayerEntity player = ((NetworkEvent.Context)ctx.get()).getSender();
                if (this.stack.func_77973_b() instanceof IMountableAccessory) {
                    IMountableAccessory mountable = (IMountableAccessory)this.stack.func_77973_b();
                    EntityMountable mount = (EntityMountable)mountable.getMountableEntity(player.field_70170_p);
                    mount.setOwnerId(player.func_110124_au());
                    mount.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 0.5, player.func_226281_cx_());
                    mount.field_70177_z = player.field_70177_z;
                    if (player.field_70170_p.func_217376_c((Entity)mount)) {
                        player.func_184220_m((Entity)mount);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
