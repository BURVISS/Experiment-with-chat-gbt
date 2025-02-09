/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.api.item.IRelic
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.advancements.RelicBindTrigger
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.brew;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ItemBrewBase;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.advancements.RelicBindTrigger;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemInfiniteWine
extends ItemBrewBase
implements IRelic,
IManaUsingItem {
    private static final String TAG_SOULBIND_UUID = "soulbindUUID";
    private static final int MANA_PER_DAMAGE = 12000;

    public ItemInfiniteWine(Item.Properties builder) {
        super(builder, 12, 18, 1.5f, 1, () -> ModItems.heromedal);
    }

    public void func_77663_a(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.field_72995_K && entity instanceof PlayerEntity) {
            this.updateRelic(stack, (PlayerEntity)entity);
            if (world.func_82737_E() % 8000L == 0L && this.getSwigsLeft(stack) < 12 && ManaItemHandler.instance().requestManaExactForTool(stack, (PlayerEntity)entity, 12000, true)) {
                this.setSwigsLeft(stack, this.getSwigsLeft(stack) + 1);
            }
        }
    }

    @Override
    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        if (!this.hasUUID(stack)) {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.relicUnbound"));
        } else if (!this.getSoulbindUUID(stack).equals(Minecraft.func_71410_x().field_71439_g.func_110124_au())) {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.notYourSagittarius"));
        } else {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.relicSoulbound", new Object[]{Minecraft.func_71410_x().field_71439_g.func_200200_C_()}));
        }
        super.func_77624_a(stack, world, tooltip, flags);
    }

    public boolean shouldDamageWrongPlayer() {
        return true;
    }

    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }

    public void updateRelic(ItemStack stack, PlayerEntity player) {
        if (stack.func_190926_b() || !(stack.func_77973_b() instanceof IRelic)) {
            return;
        }
        boolean rightPlayer = true;
        if (!this.hasUUID(stack)) {
            this.bindToUUID(player.func_110124_au(), stack);
            if (player instanceof ServerPlayerEntity) {
                RelicBindTrigger.INSTANCE.trigger((ServerPlayerEntity)player, stack);
            }
        } else if (!this.getSoulbindUUID(stack).equals(player.func_110124_au())) {
            rightPlayer = false;
        }
        if (!(rightPlayer || player.field_70173_aa % 10 != 0 || stack.func_77973_b() instanceof ItemRelic && !((ItemRelic)stack.func_77973_b()).shouldDamageWrongPlayer())) {
            player.func_70097_a(ItemInfiniteWine.damageSource(), 2.0f);
        }
    }

    public boolean isRightPlayer(PlayerEntity player, ItemStack stack) {
        return this.hasUUID(stack) && this.getSoulbindUUID(stack).equals(player.func_110124_au());
    }

    public static DamageSource damageSource() {
        return new DamageSource("botania-relic");
    }

    public void bindToUUID(UUID uuid, ItemStack stack) {
        ItemNBTHelper.setString((ItemStack)stack, (String)TAG_SOULBIND_UUID, (String)uuid.toString());
    }

    public UUID getSoulbindUUID(ItemStack stack) {
        if (ItemNBTHelper.verifyExistance((ItemStack)stack, (String)TAG_SOULBIND_UUID)) {
            try {
                return UUID.fromString(ItemNBTHelper.getString((ItemStack)stack, (String)TAG_SOULBIND_UUID, (String)""));
            }
            catch (IllegalArgumentException ex) {
                ItemNBTHelper.removeEntry((ItemStack)stack, (String)TAG_SOULBIND_UUID);
            }
        }
        return null;
    }

    public boolean hasUUID(ItemStack stack) {
        return this.getSoulbindUUID(stack) != null;
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
