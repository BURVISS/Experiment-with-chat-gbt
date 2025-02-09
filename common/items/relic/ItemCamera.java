/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.entity.projectile.ProjectileEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.eventbus.api.EventPriority
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemCamera
extends ItemRelic
implements IManaUsingItem,
IAdvancementRequirement {
    public static final int MANA_PER_DAMAGE = 1500;
    public static final int RANGE = 20;
    public static final String TAG_FREEZETIME = "freezeTime";
    public static final String TAG_TIMES = "freezeTimes";

    public ItemCamera(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::onLivingUpdate);
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof LivingEntity && !(event.getEntityLiving() instanceof PlayerEntity) && event.getEntityLiving().getPersistentData().func_74762_e(TAG_FREEZETIME) > 0) {
            event.getEntityLiving().getPersistentData().func_74768_a(TAG_FREEZETIME, event.getEntityLiving().getPersistentData().func_74762_e(TAG_FREEZETIME) - 1);
            event.setCanceled(true);
        }
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (this.isRightPlayer(player, stack) && ManaItemHandler.instance().requestManaExactForTool(stack, player, 1500, true) && !world.field_72995_K) {
            for (LivingEntity living : player.func_130014_f_().func_217357_a(LivingEntity.class, new AxisAlignedBB(player.func_233580_cy_().func_177982_a(-20, -20, -20), player.func_233580_cy_().func_177982_a(21, 21, 21)))) {
                if (living == player || !living.func_174827_a((ServerPlayerEntity)player)) continue;
                living.func_195064_c(new EffectInstance(Effects.field_76421_d, 100, 5));
                int time = 200;
                if (!living.func_184222_aU()) {
                    time = 40;
                }
                if (living.getPersistentData().func_74762_e(TAG_TIMES) > 10) {
                    time = 0;
                }
                living.getPersistentData().func_74768_a(TAG_FREEZETIME, time);
                living.getPersistentData().func_74768_a(TAG_TIMES, living.getPersistentData().func_74762_e(TAG_TIMES) + 1);
            }
            for (Entity e : player.func_130014_f_().func_217357_a(Entity.class, new AxisAlignedBB(player.func_233580_cy_().func_177982_a(-20, -20, -20), player.func_233580_cy_().func_177982_a(21, 21, 21)))) {
                if (!(e instanceof ProjectileEntity)) continue;
                e.func_70106_y();
            }
            player.func_184811_cZ().func_185145_a(stack.func_77973_b(), 200);
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
