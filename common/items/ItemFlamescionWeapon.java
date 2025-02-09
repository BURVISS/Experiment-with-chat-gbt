/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemTier
 *  net.minecraft.item.Rarity
 *  net.minecraft.item.SwordItem
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickBlock
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent$LeftClickEmpty
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.entities.EntityFlamescionSword;
import com.meteor.extrabotany.common.entities.EntityFlamescionVoid;
import com.meteor.extrabotany.common.entities.EntityStrengthenSlash;
import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import com.meteor.extrabotany.common.handler.FlamescionHandler;
import com.meteor.extrabotany.common.network.NetworkHandler;
import com.meteor.extrabotany.common.network.flamescion.FlamescionStrengthenPack;
import com.meteor.extrabotany.common.potions.ModPotions;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemFlamescionWeapon
extends SwordItem {
    public ItemFlamescionWeapon() {
        super((IItemTier)ItemTier.NETHERITE, 5, -1.6f, new Item.Properties().func_200916_a(ExtraBotany.itemGroup).func_208103_a(Rarity.EPIC).func_200917_a(1).setNoRepair());
        MinecraftForge.EVENT_BUS.addListener(this::leftClick);
        MinecraftForge.EVENT_BUS.addListener(this::leftClickBlock);
        MinecraftForge.EVENT_BUS.addListener(this::attackEntity);
    }

    @SubscribeEvent
    public void attackEntity(AttackEntityEvent evt) {
        if (!evt.getPlayer().field_70170_p.field_72995_K) {
            this.tryStrengthenAttack(evt.getPlayer());
        }
    }

    @SubscribeEvent
    public void leftClick(PlayerInteractEvent.LeftClickEmpty evt) {
        if (!evt.getItemStack().func_190926_b() && evt.getItemStack().func_77973_b() == this) {
            NetworkHandler.INSTANCE.sendToServer((Object)new FlamescionStrengthenPack());
        }
    }

    @SubscribeEvent
    public void leftClickBlock(PlayerInteractEvent.LeftClickBlock evt) {
        if (evt.getPlayer().field_70170_p.field_72995_K && !evt.getItemStack().func_190926_b() && evt.getItemStack().func_77973_b() == this) {
            NetworkHandler.INSTANCE.sendToServer((Object)new FlamescionStrengthenPack());
        }
    }

    public void tryStrengthenAttack(PlayerEntity player) {
        if (!player.field_70170_p.field_72995_K && !player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f) {
            if (player.func_70644_a(ModPotions.flamescion)) {
                for (int i = 0; i < 3; ++i) {
                    EntityStrengthenSlash slash = new EntityStrengthenSlash(player.field_70170_p, player);
                    Vector3d targetPos = player.func_213303_ch().func_178787_e(player.func_70040_Z().func_178785_b((float)Math.toRadians(-15.0f + 15.0f * (float)i)).func_186678_a(5.0));
                    Vector3d vec = targetPos.func_178788_d(player.func_213303_ch()).func_72432_b();
                    slash.func_213317_d(vec);
                    slash.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 0.5, player.func_226281_cx_());
                    slash.faceEntity(new BlockPos(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c));
                    player.field_70170_p.func_217376_c((Entity)slash);
                }
                player.func_184596_c(ModPotions.flamescion);
            } else if (FlamescionHandler.isFlamescionMode(player)) {
                EntityFlamescionSword sword = new EntityFlamescionSword(player.field_70170_p, player);
                Vector3d targetPos = player.func_213303_ch().func_178787_e(player.func_70040_Z().func_186678_a(5.0));
                Vector3d vec = targetPos.func_178788_d(player.func_213303_ch()).func_72432_b();
                sword.func_213317_d(vec);
                sword.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_() + 0.5, player.func_226281_cx_());
                player.field_70170_p.func_217376_c((Entity)sword);
            }
        }
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!FlamescionHandler.isOverloaded(playerIn)) {
            if (playerIn.func_225608_bj_() && !FlamescionHandler.isFlamescionMode(playerIn)) {
                if (playerIn.func_233570_aj_()) {
                    List<LivingEntity> entities = EntityMotor.getEntitiesAround(new BlockPos(playerIn.func_213303_ch()), 3.0f, worldIn);
                    for (LivingEntity entity : entities) {
                        entity.func_213317_d(entity.func_213322_ci().func_72441_c(0.0, 1.0, 0.0));
                        if (entity == playerIn) continue;
                        entity.func_195064_c(new EffectInstance(ModPotions.timelock, 60));
                    }
                    if (worldIn.field_72995_K) {
                        for (int i = 0; i < 360; i += 30) {
                            double r = 3.0;
                            double x = playerIn.func_226277_ct_() + r * Math.cos(Math.toRadians(i));
                            double y = playerIn.func_226278_cu_() + 0.5;
                            double z = playerIn.func_226281_cx_() + r * Math.sin(Math.toRadians(i));
                            for (int j = 0; j < 6; ++j) {
                                worldIn.func_195594_a((IParticleData)ParticleTypes.field_197631_x, x, y, z, 0.0, (double)(0.12f * (float)j), 0.0);
                            }
                        }
                    }
                } else if (worldIn.field_72995_K) {
                    for (int i = 0; i < 360; i += 15) {
                        double r = 0.5;
                        double x = playerIn.func_226277_ct_() + r * Math.cos(Math.toRadians(i));
                        double y = playerIn.func_226278_cu_() + 0.5;
                        double z = playerIn.func_226281_cx_() + r * Math.sin(Math.toRadians(i));
                        Vector3d vec = new Vector3d(x - playerIn.func_226277_ct_(), 0.0, z - playerIn.func_226281_cx_()).func_72432_b();
                        for (int j = 0; j < 3; ++j) {
                            worldIn.func_195594_a((IParticleData)ParticleTypes.field_197631_x, x, y, z, vec.func_186678_a((double)(0.25 + 0.01 * (double)j)).field_72450_a, 0.0, vec.func_186678_a((double)(0.25 + 0.01 * (double)j)).field_72449_c);
                        }
                    }
                }
                playerIn.func_195064_c(new EffectInstance(ModPotions.incandescence, 60));
            } else if (FlamescionHandler.isFlamescionMode(playerIn)) {
                Vector3d targetPos = playerIn.func_213303_ch().func_178787_e(playerIn.func_70040_Z().func_186678_a(5.0));
                EntityFlamescionVoid fvoid = new EntityFlamescionVoid(worldIn, playerIn);
                fvoid.func_70107_b(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c);
                if (!worldIn.field_72995_K) {
                    worldIn.func_217376_c((Entity)fvoid);
                }
                playerIn.func_195064_c(new EffectInstance(ModPotions.incandescence, 80));
                playerIn.func_184811_cZ().func_185145_a((Item)this, 40);
            }
        }
        return ActionResult.func_226250_c_((Object)playerIn.func_184586_b(handIn));
    }
}
