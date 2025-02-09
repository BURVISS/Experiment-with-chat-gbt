/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.enchantment.FrostWalkerEnchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.particles.BlockParticleData
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingAttackEvent
 *  vazkii.botania.api.item.IRelic
 *  vazkii.botania.common.core.handler.EquipmentHandler
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.equipment.bauble.ItemItemFinder
 *  vazkii.botania.common.item.equipment.bauble.ItemSuperCloudPendant
 *  vazkii.botania.common.item.equipment.bauble.ItemSuperLavaPendant
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.bauble;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.common.core.handler.EquipmentHandler;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.equipment.bauble.ItemItemFinder;
import vazkii.botania.common.item.equipment.bauble.ItemSuperCloudPendant;
import vazkii.botania.common.item.equipment.bauble.ItemSuperLavaPendant;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemMoonPendant
extends ItemSuperCloudPendant
implements IAdvancementRequirement,
IRelic {
    private final ItemRelic dummy = new ItemRelic(new Item.Properties());

    public ItemMoonPendant(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::onDamage);
    }

    public ItemRelic getDummy() {
        return this.dummy;
    }

    public void func_77663_a(ItemStack stack, World world, Entity entity, int slot, boolean held) {
        if (entity instanceof PlayerEntity) {
            this.dummy.updateRelic(stack, (PlayerEntity)entity);
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.func_77624_a(stack, world, tooltip, flags);
        this.dummy.func_77624_a(stack, world, tooltip, flags);
    }

    private void onDamage(LivingAttackEvent evt) {
        if (evt.getSource().func_76347_k() && !EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)evt.getEntityLiving()).func_190926_b()) {
            evt.setCanceled(true);
        }
    }

    public void onWornTick(ItemStack stack, LivingEntity player) {
        super.onWornTick(stack, player);
        if (player instanceof PlayerEntity) {
            PlayerEntity ePlayer = (PlayerEntity)player;
            this.dummy.updateRelic(stack, ePlayer);
            if (this.dummy.isRightPlayer(ePlayer, stack)) {
                this.onValidPlayerWornTick(stack, ePlayer);
            }
        }
    }

    public void onValidPlayerWornTick(ItemStack stack, PlayerEntity player) {
        ((ItemSuperLavaPendant)ModItems.superLavaPendant).onWornTick(stack, (LivingEntity)player);
        ((ItemItemFinder)ModItems.itemFinder).onWornTick(stack, (LivingEntity)player);
        if (!player.field_70170_p.field_72995_K && !player.func_225608_bj_()) {
            boolean lastOnGround = player.func_233570_aj_();
            player.func_230245_c_(true);
            FrostWalkerEnchantment.func_185266_a((LivingEntity)player, (World)player.field_70170_p, (BlockPos)player.func_233580_cy_(), (int)8);
            player.func_230245_c_(lastOnGround);
        } else if (player.field_70170_p.field_72995_K && !player.func_225608_bj_() && player.field_70170_p.field_73012_v.nextFloat() >= 0.25f) {
            player.field_70170_p.func_195594_a((IParticleData)new BlockParticleData(ParticleTypes.field_197628_u, Blocks.field_196604_cC.func_176223_P()), player.func_226277_ct_() + (double)player.field_70170_p.field_73012_v.nextFloat() * 0.6 - 0.3, player.func_226278_cu_() + 1.1, player.func_226281_cx_() + (double)player.field_70170_p.field_73012_v.nextFloat() * 0.6 - 0.3, 0.0, -0.15, 0.0);
        }
    }

    public Multimap<Attribute, AttributeModifier> getEquippedAttributeModifiers(ItemStack stack) {
        HashMultimap attributes = HashMultimap.create();
        attributes.put((Object)Attributes.field_233820_c_, (Object)new AttributeModifier(ItemMoonPendant.getBaubleUUID((ItemStack)stack), "Moon Pendant", 1.0, AttributeModifier.Operation.ADDITION));
        return attributes;
    }

    public boolean canEquip(ItemStack stack, LivingEntity entity) {
        return entity instanceof PlayerEntity && this.dummy.isRightPlayer((PlayerEntity)entity, stack) && EquipmentHandler.findOrEmpty((Item)this, (LivingEntity)entity).func_190926_b();
    }

    public void bindToUUID(UUID uuid, ItemStack stack) {
        this.dummy.bindToUUID(uuid, stack);
    }

    public UUID getSoulbindUUID(ItemStack stack) {
        return this.dummy.getSoulbindUUID(stack);
    }

    public boolean hasUUID(ItemStack stack) {
        return this.dummy.hasUUID(stack);
    }

    public int getEntityLifespan(ItemStack itemStack, World world) {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
