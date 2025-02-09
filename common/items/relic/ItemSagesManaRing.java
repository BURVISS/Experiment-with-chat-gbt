/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  vazkii.botania.api.mana.IManaItem
 *  vazkii.botania.api.mana.IManaTooltipDisplay
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.relic.ItemRelicBauble
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import javax.annotation.Nonnull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaItem;
import vazkii.botania.api.mana.IManaTooltipDisplay;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.relic.ItemRelicBauble;

public class ItemSagesManaRing
extends ItemRelicBauble
implements IManaItem,
IManaTooltipDisplay,
IAdvancementRequirement {
    protected static final int MAX_MANA = 0x7FFFFFFE;
    private static final String TAG_MANA = "mana";

    public ItemSagesManaRing(Item.Properties props) {
        super(props);
    }

    public void func_150895_a(@Nonnull ItemGroup tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (this.func_194125_a(tab)) {
            stacks.add((Object)new ItemStack((IItemProvider)this));
            ItemStack full = new ItemStack((IItemProvider)this);
            ItemSagesManaRing.setMana(full, this.getMaxMana(full));
            stacks.add((Object)full);
        }
    }

    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }

    public static void setMana(ItemStack stack, int mana) {
        ItemNBTHelper.setInt((ItemStack)stack, (String)TAG_MANA, (int)mana);
    }

    public int getMana(ItemStack stack) {
        return ItemNBTHelper.getInt((ItemStack)stack, (String)TAG_MANA, (int)0) * stack.func_190916_E();
    }

    public int getMaxMana(ItemStack stack) {
        return 0x7FFFFFFE * stack.func_190916_E();
    }

    public void addMana(ItemStack stack, int mana) {
        int space = Math.max(this.getMaxMana(stack) - this.getMana(stack), 0);
        int manaToTransfer = Math.min(space, mana);
        ItemSagesManaRing.setMana(stack, Math.min(this.getMana(stack) + manaToTransfer, this.getMaxMana(stack)) / stack.func_190916_E());
    }

    public boolean canReceiveManaFromPool(ItemStack stack, TileEntity pool) {
        return true;
    }

    public boolean canReceiveManaFromItem(ItemStack stack, ItemStack otherStack) {
        return true;
    }

    public boolean canExportManaToPool(ItemStack stack, TileEntity pool) {
        return true;
    }

    public boolean canExportManaToItem(ItemStack stack, ItemStack otherStack) {
        return true;
    }

    public boolean isNoExport(ItemStack stack) {
        return false;
    }

    public float getManaFractionForDisplay(ItemStack stack) {
        return (float)this.getMana(stack) / (float)this.getMaxMana(stack);
    }

    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - (double)this.getManaFractionForDisplay(stack);
    }

    public int getRGBDurabilityForDisplay(ItemStack stack) {
        return MathHelper.func_181758_c((float)Math.max(0.0f, this.getManaFractionForDisplay(stack) / 3.0f), (float)1.0f, (float)1.0f);
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
