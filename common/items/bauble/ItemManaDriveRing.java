/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3i
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.api.subtile.TileEntityFunctionalFlower
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.api.subtile.TileEntityFunctionalFlower;

public class ItemManaDriveRing
extends ItemBauble
implements IManaUsingItem {
    private static final int RANGE = 7;

    public ItemManaDriveRing(Item.Properties props) {
        super(props);
    }

    public void onWornTick(ItemStack stack, LivingEntity entity) {
        super.onWornTick(stack, entity);
        if (!(entity instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity player = (PlayerEntity)entity;
        if (player.field_70173_aa % 20 == 0) {
            for (int x = -7; x <= 7; ++x) {
                for (int y = -7; y <= 7; ++y) {
                    for (int z = -7; z <= 7; ++z) {
                        TileEntity te = player.func_130014_f_().func_175625_s(new BlockPos((Vector3i)player.func_233580_cy_().func_177982_a(x, y, z)));
                        if (!(te instanceof TileEntityFunctionalFlower)) continue;
                        TileEntityFunctionalFlower f = (TileEntityFunctionalFlower)te;
                        int manaToUse = f.getMaxMana() - f.getMana();
                        if (!ManaItemHandler.instance().requestManaExact(stack, player, manaToUse, true)) continue;
                        f.addMana(manaToUse);
                    }
                }
            }
        }
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
