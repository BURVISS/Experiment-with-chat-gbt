/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickBlock
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickEmpty
 *  vazkii.botania.api.mana.ManaItemHandler
 */
package com.meteor.extrabotany.common.items.bauble;

import com.meteor.extrabotany.api.items.IItemWithLeftClick;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.entities.projectile.EntityAuraFire;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.meteor.extrabotany.common.network.LeftClickPack;
import com.meteor.extrabotany.common.network.NetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import vazkii.botania.api.mana.ManaItemHandler;

public class ItemJingweiFeather
extends ItemBauble
implements IItemWithLeftClick {
    public static final int MANA_PER_DAMAGE = 300;

    public ItemJingweiFeather(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::leftClick);
        MinecraftForge.EVENT_BUS.addListener(this::leftClickBlock);
        MinecraftForge.EVENT_BUS.addListener(this::attackEntity);
    }

    public void attackEntity(AttackEntityEvent evt) {
        if (!evt.getPlayer().field_70170_p.field_72995_K && !EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getPlayer()).func_190926_b()) {
            this.onLeftClick(evt.getPlayer(), evt.getTarget());
        }
    }

    public void leftClick(PlayerInteractEvent.LeftClickEmpty evt) {
        if (!EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getPlayer()).func_190926_b()) {
            NetworkHandler.INSTANCE.sendToServer((Object)new LeftClickPack(EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getPlayer())));
        }
    }

    public void leftClickBlock(PlayerInteractEvent.LeftClickBlock evt) {
        if (evt.getPlayer().field_70170_p.field_72995_K && !EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getPlayer()).func_190926_b()) {
            NetworkHandler.INSTANCE.sendToServer((Object)new LeftClickPack(EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getPlayer())));
        }
    }

    @Override
    public void onLeftClick(PlayerEntity living, Entity target) {
        if (living.func_184614_ca().func_190926_b() && living.func_184825_o(0.0f) == 1.0f && ManaItemHandler.instance().requestManaExactForTool(new ItemStack((IItemProvider)this), living, 300, true)) {
            EntityAuraFire proj = new EntityAuraFire(living.field_70170_p, (LivingEntity)living);
            proj.func_70107_b(living.func_226277_ct_(), living.func_226278_cu_() + 1.1, living.func_226281_cx_());
            proj.func_234612_a_((Entity)living, living.field_70125_A, living.field_70177_z, 0.0f, 0.8f, 0.9f);
            if (!living.field_70170_p.field_72995_K) {
                living.field_70170_p.func_217376_c((Entity)proj);
            }
        }
    }
}
