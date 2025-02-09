/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemUseContext
 *  net.minecraft.item.Items
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.play.server.SRemoveEntityEffectPacket
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectType
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraft.world.server.ServerWorld
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SRemoveEntityEffectPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class ItemNatureOrb
extends ItemBauble {
    public static final String TAG_XP = "xp";
    public static final int MAX_XP = 500000;

    public ItemNatureOrb(Item.Properties props) {
        super(props);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.func_77624_a(stack, world, tooltip, flags);
        tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.natureorb", new Object[]{this.getXP(stack), this.getMaxXP(stack)}).func_240699_a_(TextFormatting.GRAY));
        tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.natureorbeffect1").func_240699_a_(this.getXP(stack) >= 100000 ? TextFormatting.AQUA : TextFormatting.GRAY));
        tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.natureorbeffect2").func_240699_a_(this.getXP(stack) >= 300000 ? TextFormatting.DARK_RED : TextFormatting.GRAY));
        tooltip.add((ITextComponent)new TranslationTextComponent("extrabotany.natureorbeffect3").func_240699_a_(this.getXP(stack) >= 400000 ? TextFormatting.DARK_GREEN : TextFormatting.GRAY));
    }

    @Nonnull
    public ActionResultType func_195939_a(ItemUseContext ctx) {
        ItemStack stack = ctx.func_195996_i();
        return EntityEGO.spawn(ctx.func_195999_j(), stack, ctx.func_195991_k(), ctx.func_195995_a()) ? ActionResultType.SUCCESS : ActionResultType.FAIL;
    }

    public void func_150895_a(@Nonnull ItemGroup tab, @Nonnull NonNullList<ItemStack> stacks) {
        if (this.func_194125_a(tab)) {
            stacks.add((Object)new ItemStack((IItemProvider)this));
            ItemStack full = new ItemStack((IItemProvider)this);
            this.setXP(full, this.getMaxXP(full));
            stacks.add((Object)full);
        }
    }

    public void onWornTick(ItemStack stack, LivingEntity entity) {
        super.onWornTick(stack, entity);
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)entity;
            if (!player.field_70170_p.field_72995_K) {
                if (this.getXP(stack) > 100000 && player.field_70173_aa % 5 == 0) {
                    ManaItemHandler.instance().dispatchManaExact(stack, player, 5, true);
                }
                if (this.getXP(stack) > 200000 && player.field_70173_aa % 5 == 0) {
                    ManaItemHandler.instance().dispatchManaExact(stack, player, 5, true);
                }
                if (this.getXP(stack) > 300000 && player.field_70173_aa % 5 == 0) {
                    ManaItemHandler.instance().dispatchManaExact(stack, player, 5, true);
                    if (player.field_70173_aa % 60 == 0) {
                        player.func_70691_i(1.0f);
                    }
                }
                if (this.getXP(stack) > 400000 && player.field_70173_aa % 40 == 0) {
                    this.clearPotions(stack, player);
                }
            }
        }
    }

    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        return 1.0 - (double)((float)this.getXP(stack) / (float)this.getMaxXP(stack));
    }

    public boolean addXP(ItemStack stack, int xp) {
        if (this.getXP(stack) >= this.getMaxXP(stack)) {
            return false;
        }
        this.setXP(stack, Math.min(Math.max(this.getXP(stack) + xp, 0), this.getMaxXP(stack)));
        return true;
    }

    public void setXP(ItemStack stack, int xp) {
        ItemNBTHelper.setInt((ItemStack)stack, (String)TAG_XP, (int)xp);
    }

    public int getXP(ItemStack stack) {
        return ItemNBTHelper.getInt((ItemStack)stack, (String)TAG_XP, (int)0);
    }

    public int getMaxXP(ItemStack stack) {
        return 500000;
    }

    public void clearPotions(ItemStack stack, PlayerEntity player) {
        List<Effect> potionsToRemove = player.func_70651_bq().stream().filter(effect -> effect.func_188419_a().func_220303_e() == EffectType.HARMFUL && effect.getCurativeItems().stream().anyMatch(e -> e.func_77969_a(new ItemStack((IItemProvider)Items.field_151117_aB)))).map(EffectInstance::func_188419_a).distinct().collect(Collectors.toList());
        potionsToRemove.forEach(potion -> {
            player.func_195063_d(potion);
            this.addXP(stack, -50);
            ((ServerWorld)player.field_70170_p).func_72863_F().func_217216_a((Entity)player, (IPacket)new SRemoveEntityEffectPacket(player.func_145782_y(), potion));
        });
    }
}
