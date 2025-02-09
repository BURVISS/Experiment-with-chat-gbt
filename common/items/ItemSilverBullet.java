/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.world.World
 *  vazkii.botania.api.mana.BurstProperties
 *  vazkii.botania.api.mana.ILens
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.ItemManaGun
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.armor.shootingguardian.ItemShootingGuardianArmor;
import javax.annotation.Nonnull;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.api.mana.ILens;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.ItemManaGun;

public class ItemSilverBullet
extends ItemManaGun {
    public ItemSilverBullet(Item.Properties props) {
        super(props);
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity player, @Nonnull Hand hand) {
        ItemStack stack = player.func_184586_b(hand);
        ItemNBTHelper.setBoolean((ItemStack)stack, (String)"usemana", (!((ItemShootingGuardianArmor)ModItems.armor_shootingguardian_helm).hasArmorSet(player) ? 1 : 0) != 0);
        return super.func_77659_a(world, player, hand);
    }

    @Nonnull
    public BurstProperties getBurstProps(PlayerEntity player, ItemStack stack, boolean request, Hand hand) {
        int maxMana = 240;
        int color = 8900346;
        int ticksBeforeManaLoss = 80;
        float manaLossPerTick = 3.0f;
        float motionModifier = 7.5f;
        float gravity = 0.0f;
        BurstProperties props = new BurstProperties(maxMana, ticksBeforeManaLoss, manaLossPerTick, gravity, motionModifier, color);
        ItemStack lens = ItemSilverBullet.getLens((ItemStack)stack);
        if (!lens.func_190926_b()) {
            ((ILens)lens.func_77973_b()).apply(lens, props);
        }
        return props;
    }

    public boolean usesMana(ItemStack stack) {
        return ItemNBTHelper.getBoolean((ItemStack)stack, (String)"usemana", (boolean)true);
    }
}
