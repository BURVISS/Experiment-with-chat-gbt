/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.world.World
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.entities.EntityJudahOath;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemJudahOath
extends ItemRelic
implements IManaUsingItem,
IAdvancementRequirement {
    public ItemJudahOath(Item.Properties props) {
        super(props);
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (this.isRightPlayer(player, stack) && ManaItemHandler.instance().requestManaExactForTool(stack, player, 2500, true)) {
            player.func_184811_cZ().func_185145_a((Item)this, 80);
            EntityJudahOath judah = new EntityJudahOath(world, (LivingEntity)player);
            judah.func_234612_a_((Entity)player, player.field_70125_A, player.field_70177_z, 0.0f, 0.5f, 0.0f);
            judah.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 1.0, player.func_226281_cx_());
            judah.setRotation(MathHelper.func_76142_g((float)(-player.field_70177_z + 180.0f)));
            if (!world.field_72995_K) {
                world.func_217376_c((Entity)judah);
            }
        }
        return ActionResult.func_226250_c_((Object)stack);
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
