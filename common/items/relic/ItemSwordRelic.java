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
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickBlock
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickEmpty
 *  vazkii.botania.api.item.IRelic
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.advancements.RelicBindTrigger
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.api.items.IItemWithLeftClick;
import com.meteor.extrabotany.common.network.LeftClickPack;
import com.meteor.extrabotany.common.network.NetworkHandler;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.advancements.RelicBindTrigger;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemSwordRelic
extends SwordItem
implements IRelic,
IItemWithLeftClick {
    private static final String TAG_SOULBIND_UUID = "soulbindUUID";
    private static final int MANA_PER_DAMAGE = 120;

    public ItemSwordRelic(IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
        MinecraftForge.EVENT_BUS.addListener(this::leftClick);
        MinecraftForge.EVENT_BUS.addListener(this::leftClickBlock);
        MinecraftForge.EVENT_BUS.addListener(this::attackEntity);
    }

    public void attackEntity(AttackEntityEvent evt) {
        if (!evt.getPlayer().field_70170_p.field_72995_K) {
            this.onLeftClick(evt.getPlayer(), evt.getTarget());
        }
    }

    public void leftClick(PlayerInteractEvent.LeftClickEmpty evt) {
        if (!evt.getItemStack().func_190926_b() && evt.getItemStack().func_77973_b() == this) {
            NetworkHandler.INSTANCE.sendToServer((Object)new LeftClickPack(evt.getItemStack()));
        }
    }

    public void leftClickBlock(PlayerInteractEvent.LeftClickBlock evt) {
        if (evt.getPlayer().field_70170_p.field_72995_K && !evt.getItemStack().func_190926_b() && evt.getItemStack().func_77973_b() == this) {
            NetworkHandler.INSTANCE.sendToServer((Object)new LeftClickPack(evt.getItemStack()));
        }
    }

    public void func_77663_a(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.field_72995_K && entity instanceof PlayerEntity) {
            this.updateRelic(stack, (PlayerEntity)entity);
        }
    }

    @Override
    public void onLeftClick(PlayerEntity living, Entity target) {
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        if (!this.hasUUID(stack)) {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.relicUnbound"));
        } else if (!this.getSoulbindUUID(stack).equals(Minecraft.func_71410_x().field_71439_g.func_110124_au())) {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.notYourSagittarius"));
        } else {
            tooltip.add((ITextComponent)new TranslationTextComponent("botaniamisc.relicSoulbound", new Object[]{Minecraft.func_71410_x().field_71439_g.func_200200_C_()}));
        }
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
        if (!player.field_70170_p.field_72995_K && stack.func_77952_i() > 0 && ManaItemHandler.instance().requestManaExact(stack, player, 240, true)) {
            stack.func_196085_b(stack.func_77952_i() - 1);
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
            player.func_70097_a(ItemSwordRelic.damageSource(), 2.0f);
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

    public static BlockRayTraceResult raytraceFromEntity(Entity e, double distance, boolean fluids) {
        return (BlockRayTraceResult)e.func_213324_a(distance, 1.0f, fluids);
    }
}
