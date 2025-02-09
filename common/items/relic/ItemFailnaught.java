/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.enchantment.Enchantments
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
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
 *  vazkii.botania.common.item.equipment.tool.ToolCommons
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.common.entities.projectile.EntityMagicArrow;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
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
import vazkii.botania.common.item.equipment.tool.ToolCommons;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemFailnaught
extends BowItem
implements IRelic,
IManaUsingItem,
IAdvancementRequirement {
    private static final String TAG_SOULBIND_UUID = "soulbindUUID";
    private static final int MANA_PER_DAMAGE = 160;

    public ItemFailnaught(Item.Properties builder) {
        super(builder);
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(@Nonnull World worldIn, PlayerEntity playerIn, @Nonnull Hand handIn) {
        ItemStack itemstack = playerIn.func_184586_b(handIn);
        playerIn.func_184598_c(handIn);
        return ActionResult.func_226248_a_((Object)itemstack);
    }

    public void func_77615_a(@Nonnull ItemStack stack, @Nonnull World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)entityLiving;
            int i = (int)((float)(this.func_77626_a(stack) - timeLeft) * 1.0f);
            if (i < 8) {
                return;
            }
            int rank = (i - 8) / 5;
            if (this.isRightPlayer(player, stack) && ManaItemHandler.instance().requestManaExactForTool(stack, player, Math.min(800, 350 + rank * 20), true)) {
                EntityMagicArrow arrow = new EntityMagicArrow(worldIn, (LivingEntity)player);
                arrow.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 1.1, player.func_226281_cx_());
                arrow.func_234612_a_((Entity)player, player.field_70125_A, player.field_70177_z, 0.0f, 3.0f, 1.0f);
                arrow.setDamage((int)Math.min(50.0f, ExtraBotanyAPI.calcDamage(10.0f + (float)rank * 1.0f, player)));
                arrow.field_70177_z = player.field_70177_z;
                int j = EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_185309_u, (ItemStack)stack);
                if (j > 0) {
                    arrow.setDamage(arrow.getDamage() + j);
                }
                arrow.setLife(Math.min(150, 5 + i * 4));
                if (!worldIn.field_72995_K) {
                    worldIn.func_217376_c((Entity)arrow);
                }
                worldIn.func_184148_a(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187737_v, SoundCategory.NEUTRAL, 1.0f, 0.5f);
            }
        }
    }

    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return ToolCommons.damageItemIfPossible((ItemStack)stack, (int)amount, entity, (int)160);
    }

    public void func_77663_a(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.field_72995_K && entity instanceof PlayerEntity) {
            this.updateRelic(stack, (PlayerEntity)entity);
            if (stack.func_77952_i() > 0 && ManaItemHandler.instance().requestManaExactForTool(stack, (PlayerEntity)entity, 320, true)) {
                stack.func_196085_b(stack.func_77952_i() - 1);
            }
        }
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
        if (!player.field_70170_p.field_72995_K && stack.func_77952_i() > 0 && ManaItemHandler.instance().requestManaExact(stack, player, 320, true)) {
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
            player.func_70097_a(ItemFailnaught.damageSource(), 2.0f);
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

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
