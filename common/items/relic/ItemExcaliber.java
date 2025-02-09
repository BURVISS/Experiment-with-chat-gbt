/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.IItemTier
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemTier
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.RayTraceResult
 *  vazkii.botania.api.BotaniaAPI
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.api.mana.BurstProperties
 *  vazkii.botania.api.mana.ILensEffect
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.common.core.handler.ModSounds
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.core.helper.Vector3
 *  vazkii.botania.common.entity.EntityManaBurst
 *  vazkii.botania.common.item.equipment.tool.ToolCommons
 */
package com.meteor.extrabotany.common.items.relic;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.handler.DamageHandler;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import com.meteor.extrabotany.common.items.relic.ItemSwordRelic;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.api.mana.ILensEffect;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.common.core.handler.ModSounds;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.core.helper.Vector3;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

public class ItemExcaliber
extends ItemSwordRelic
implements IManaUsingItem,
ILensEffect,
IAdvancementRequirement {
    private static final String TAG_ATTACKER_USERNAME = "attackerUsername";
    private static final String TAG_HOME_ID = "homeID";
    private static final int MANA_PER_DAMAGE = 160;

    public ItemExcaliber(Item.Properties prop) {
        super((IItemTier)ItemTier.NETHERITE, 8, -2.0f, prop);
    }

    @Override
    public void onLeftClick(PlayerEntity player, Entity target) {
        if (!player.func_184614_ca().func_190926_b() && player.func_184614_ca().func_77973_b() == this && player.func_184825_o(0.0f) == 1.0f) {
            EntityManaBurst burst = ItemExcaliber.getBurst(player, player.func_184614_ca());
            player.field_70170_p.func_217376_c((Entity)burst);
            ToolCommons.damageItemIfPossible((ItemStack)player.func_184614_ca(), (int)1, (LivingEntity)player, (int)160);
            player.field_70170_p.func_184148_a(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), ModSounds.terraBlade, SoundCategory.PLAYERS, 0.4f, 1.4f);
        }
    }

    @Nonnull
    public Multimap<Attribute, AttributeModifier> func_111205_h(@Nonnull EquipmentSlotType slot) {
        Multimap ret = super.func_111205_h(slot);
        if (slot == EquipmentSlotType.MAINHAND) {
            ret = HashMultimap.create((Multimap)ret);
            ret.put((Object)Attributes.field_233821_d_, (Object)new AttributeModifier(UUID.fromString("995829fa-94c0-41bd-b046-0468c509a488"), "Excaliber modifier", 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        return ret;
    }

    public static EntityManaBurst getBurst(PlayerEntity player, ItemStack stack) {
        EntityManaBurst burst = new EntityManaBurst(player);
        float motionModifier = 9.0f;
        burst.setColor(0xFFFF20);
        burst.setMana(160);
        burst.setStartingMana(160);
        burst.setMinManaLoss(40);
        burst.setManaLossPerTick(4.0f);
        burst.setGravity(0.0f);
        burst.func_213293_j(burst.func_213322_ci().field_72450_a * (double)motionModifier, burst.func_213322_ci().field_72448_b * (double)motionModifier, burst.func_213322_ci().field_72449_c * (double)motionModifier);
        ItemStack lens = stack.func_77946_l();
        ItemNBTHelper.setString((ItemStack)lens, (String)TAG_ATTACKER_USERNAME, (String)player.func_200200_C_().getString());
        burst.setSourceLens(lens);
        return burst;
    }

    public void apply(ItemStack stack, BurstProperties props) {
    }

    public boolean collideBurst(IManaBurst burst, RayTraceResult pos, boolean isManaBlock, boolean dead, ItemStack stack) {
        return dead;
    }

    public void updateBurst(IManaBurst burst, ItemStack stack) {
        Entity home;
        ThrowableEntity entity = (ThrowableEntity)burst;
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_(), entity.func_226278_cu_(), entity.func_226281_cx_(), entity.field_70142_S, entity.field_70137_T, entity.field_70136_U).func_186662_g(1.0);
        String attacker = ItemNBTHelper.getString((ItemStack)burst.getSourceLens(), (String)TAG_ATTACKER_USERNAME, (String)"");
        int homeID = ItemNBTHelper.getInt((ItemStack)stack, (String)TAG_HOME_ID, (int)-1);
        if (homeID == -1) {
            AxisAlignedBB axis1 = new AxisAlignedBB(entity.func_226277_ct_() - 5.0, entity.func_226278_cu_() - 5.0, entity.func_226281_cx_() - 5.0, entity.field_70142_S + 5.0, entity.field_70137_T + 5.0, entity.field_70136_U + 5.0);
            List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis1);
            for (LivingEntity living : entities) {
                if (living instanceof PlayerEntity || !(living instanceof IMob) || living.field_70737_aN != 0) continue;
                homeID = living.func_145782_y();
                ItemNBTHelper.setInt((ItemStack)stack, (String)TAG_HOME_ID, (int)homeID);
                break;
            }
        }
        List entities = entity.field_70170_p.func_217357_a(LivingEntity.class, axis);
        if (homeID != -1 && (home = entity.field_70170_p.func_73045_a(homeID)) != null) {
            Vector3 vecEntity = Vector3.fromEntityCenter((Entity)home);
            Vector3 vecThis = Vector3.fromEntityCenter((Entity)entity);
            Vector3 vecMotion = vecEntity.subtract(vecThis);
            Vector3 vecCurrentMotion = new Vector3(entity.func_213322_ci().field_72450_a, entity.func_213322_ci().field_72448_b, entity.func_213322_ci().field_72449_c);
            vecMotion.normalize().multiply(vecCurrentMotion.mag());
            entity.func_213293_j(vecMotion.x, vecMotion.y, vecMotion.z);
        }
        for (LivingEntity living : entities) {
            if (living instanceof PlayerEntity && living.func_200200_C_().getString().equals(attacker) || living.field_70128_L) continue;
            int cost = 53;
            int mana = burst.getMana();
            if (mana < cost) continue;
            burst.setMana(mana - cost);
            float damage = BotaniaAPI.instance().getTerrasteelItemTier().func_200929_c() + 3.0f;
            if (burst.isFake() || entity.field_70170_p.field_72995_K) continue;
            PlayerEntity player = living.field_70170_p.func_217371_b(this.getSoulbindUUID(stack));
            DamageHandler.INSTANCE.dmg((Entity)living, (Entity)player, damage, DamageHandler.INSTANCE.NETURAL_PIERCING);
            entity.func_70106_y();
            break;
        }
    }

    public boolean doParticles(IManaBurst burst, ItemStack stack) {
        return true;
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
