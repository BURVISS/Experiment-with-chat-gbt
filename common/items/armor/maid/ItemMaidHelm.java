/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.play.server.SRemoveEntityEffectPacket
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectType
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.world.World
 *  net.minecraft.world.server.ServerWorld
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.eventbus.api.EventPriority
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items.armor.maid;

import com.meteor.extrabotany.common.items.armor.maid.ItemMaidArmor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SRemoveEntityEffectPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemMaidHelm
extends ItemMaidArmor {
    public List<DamageSource> source = new ArrayList<DamageSource>();

    public ItemMaidHelm(Item.Properties props) {
        super(EquipmentSlotType.HEAD, props);
        MinecraftForge.EVENT_BUS.addListener(this::onEntityAttacked);
        MinecraftForge.EVENT_BUS.addListener(this::onPlayerAttacked);
        this.source.add(DamageSource.field_82728_o);
        this.source.add(DamageSource.field_76367_g);
        this.source.add(DamageSource.field_76369_e);
        this.source.add(DamageSource.field_76379_h);
        this.source.add(DamageSource.field_82729_p);
        this.source.add(DamageSource.field_76372_a);
        this.source.add(DamageSource.field_76371_c);
        this.source.add(DamageSource.field_76370_b);
        this.source.add(DamageSource.field_180137_b);
        this.source.add(DamageSource.field_188406_j);
        this.source.add(DamageSource.field_190095_e);
        this.source.add(DamageSource.field_220302_v);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if (this.hasArmorSet(player) && !player.field_70170_p.field_72995_K) {
            ManaItemHandler.instance().dispatchManaExact(stack, player, 1, true);
            if (player.func_70996_bM() && player.field_70173_aa % 40 == 0 && ManaItemHandler.instance().requestManaExactForTool(stack, player, 20, true)) {
                player.func_70691_i(1.0f);
            }
            if (player.field_70173_aa % 40 == 0) {
                this.clearPotions(stack, player);
            }
        }
    }

    @SubscribeEvent
    public void onEntityAttacked(LivingHurtEvent event) {
        PlayerEntity player;
        Entity attacker = event.getSource().func_76364_f();
        LivingEntity target = event.getEntityLiving();
        if (attacker instanceof PlayerEntity && target != null && target != attacker && this.hasArmorSet(player = (PlayerEntity)attacker)) {
            if (player.func_184614_ca().func_190926_b() && player.func_184592_cb().func_190926_b() && ManaItemHandler.instance().requestManaExactForTool(new ItemStack((IItemProvider)this), player, 200, true)) {
                event.setAmount(event.getAmount() + 8.0f);
            }
            if (player.func_70996_bM() && ManaItemHandler.instance().requestManaExactForTool(new ItemStack((IItemProvider)this), player, 80, true)) {
                player.func_70691_i(event.getAmount() / 10.0f);
            }
        }
    }

    @SubscribeEvent(priority=EventPriority.LOW)
    public void onPlayerAttacked(LivingHurtEvent event) {
        PlayerEntity player;
        LivingEntity target = event.getEntityLiving();
        if (target instanceof PlayerEntity && this.hasArmorSet(player = (PlayerEntity)target)) {
            if (this.source.contains(event.getSource())) {
                event.setAmount(0.0f);
            }
            if (this.source == DamageSource.field_76376_m) {
                event.setAmount(event.getAmount() * 0.75f);
            }
        }
    }

    public void clearPotions(ItemStack stack, PlayerEntity player) {
        List<Effect> potionsToRemove = player.func_70651_bq().stream().filter(effect -> effect.func_188419_a().func_220303_e() == EffectType.HARMFUL && effect.getCurativeItems().stream().anyMatch(e -> e.func_77969_a(new ItemStack((IItemProvider)Items.field_151117_aB)))).map(EffectInstance::func_188419_a).distinct().collect(Collectors.toList());
        potionsToRemove.forEach(potion -> {
            if (ManaItemHandler.instance().requestManaExactForTool(stack, player, 100, true)) {
                player.func_195063_d(potion);
                ((ServerWorld)player.field_70170_p).func_72863_F().func_217216_a((Entity)player, (IPacket)new SRemoveEntityEffectPacket(player.func_145782_y(), potion));
            }
        });
    }
}
