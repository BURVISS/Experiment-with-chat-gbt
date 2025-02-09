/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.util.IItemProvider
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.items.ItemStackHandler
 *  vazkii.botania.api.item.IRelic
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items.relic;

import com.meteor.extrabotany.common.handler.IAdvancementRequirement;
import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.ItemStackHandler;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemBuddhistrelics
extends ItemRelic
implements IAdvancementRequirement {
    public static final String TAG_MORPHING = "buddhist:morphing";
    public static final String TAG_DATA = "buddhist:data";
    public static final String TAG_HASDATA = "buddhist:hasdata";
    public static final int MANA_PER_DAMAGE = 4;

    public ItemBuddhistrelics(Item.Properties props) {
        super(props);
        MinecraftForge.EVENT_BUS.addListener(this::onItemUpdate);
    }

    @SubscribeEvent
    public void onItemUpdate(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof PlayerEntity && !event.getEntityLiving().field_70170_p.field_72995_K) {
            PlayerEntity player = (PlayerEntity)event.getEntityLiving();
            for (int i = 0; i < player.field_71071_by.func_70297_j_(); ++i) {
                ItemStack stack = player.field_71071_by.func_70301_a(i);
                if (!(stack.func_77973_b() instanceof IRelic) || !ItemNBTHelper.getBoolean((ItemStack)stack, (String)TAG_MORPHING, (boolean)false)) continue;
                if (ManaItemHandler.instance().requestManaExact(stack, player, 4, false)) {
                    ManaItemHandler.instance().requestManaExact(stack, player, 4, true);
                    continue;
                }
                ItemStack budd = ItemBuddhistrelics.expired(stack);
                if (budd.func_190926_b()) continue;
                player.field_71071_by.func_70299_a(i, budd);
            }
        }
    }

    public static void relicInit(ItemStack stack) {
        if (!ItemNBTHelper.getBoolean((ItemStack)stack, (String)TAG_HASDATA, (boolean)false)) {
            ItemStackHandler handler = new ItemStackHandler(5);
            handler.setStackInSlot(0, new ItemStack((IItemProvider)ModItems.excaliber));
            handler.setStackInSlot(1, new ItemStack((IItemProvider)ModItems.infinitewine));
            handler.setStackInSlot(2, new ItemStack((IItemProvider)ModItems.failnaught));
            handler.setStackInSlot(3, new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.infiniteFruit));
            handler.setStackInSlot(4, new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.kingKey));
            CompoundNBT data = handler.serializeNBT();
            ItemNBTHelper.setCompound((ItemStack)stack, (String)TAG_DATA, (CompoundNBT)data);
            ItemNBTHelper.setBoolean((ItemStack)stack, (String)TAG_HASDATA, (boolean)true);
        }
    }

    public static ItemStack expired(ItemStack morphstack) {
        if (ItemNBTHelper.getBoolean((ItemStack)morphstack, (String)TAG_MORPHING, (boolean)false)) {
            CompoundNBT data = ItemNBTHelper.getCompound((ItemStack)morphstack, (String)TAG_DATA, (boolean)false);
            ItemStackHandler handler = new ItemStackHandler(5);
            handler.deserializeNBT(data);
            int id = 0;
            for (int i = 0; i < 5; ++i) {
                ItemStack stack = handler.getStackInSlot(i).func_77946_l();
                if (morphstack.func_77973_b() != stack.func_77973_b()) continue;
                id = i;
                break;
            }
            ItemStack budd = new ItemStack((IItemProvider)ModItems.buddhistrelics);
            ItemStack copy = morphstack.func_77946_l();
            copy.func_196082_o().func_82580_o(TAG_DATA);
            handler.setStackInSlot(id, copy);
            ItemNBTHelper.setCompound((ItemStack)budd, (String)TAG_DATA, (CompoundNBT)handler.serializeNBT());
            ItemNBTHelper.setBoolean((ItemStack)budd, (String)TAG_HASDATA, (boolean)true);
            return budd.func_77946_l();
        }
        return ItemStack.field_190927_a;
    }

    public static ItemStack relicShift(ItemStack heldstack) {
        if (heldstack.func_77973_b() == ModItems.buddhistrelics) {
            ItemBuddhistrelics.relicInit(heldstack);
            CompoundNBT data = ItemNBTHelper.getCompound((ItemStack)heldstack, (String)TAG_DATA, (boolean)false);
            ItemStackHandler handler = new ItemStackHandler(5);
            handler.deserializeNBT(data);
            ItemStack stack = handler.getStackInSlot(0).func_77946_l();
            ItemNBTHelper.setBoolean((ItemStack)stack, (String)TAG_MORPHING, (boolean)true);
            ItemNBTHelper.setCompound((ItemStack)stack, (String)TAG_DATA, (CompoundNBT)data);
            return stack.func_77946_l();
        }
        if (ItemNBTHelper.getBoolean((ItemStack)heldstack, (String)TAG_MORPHING, (boolean)false)) {
            ItemStack copy;
            CompoundNBT data = ItemNBTHelper.getCompound((ItemStack)heldstack, (String)TAG_DATA, (boolean)false);
            ItemStackHandler handler = new ItemStackHandler(5);
            handler.deserializeNBT(data);
            int id = 0;
            for (int i = 0; i < 5; ++i) {
                ItemStack stack = handler.getStackInSlot(i).func_77946_l();
                if (heldstack.func_77973_b() != stack.func_77973_b()) continue;
                id = i;
                break;
            }
            if (id == 4) {
                ItemStack budd = new ItemStack((IItemProvider)ModItems.buddhistrelics);
                copy = heldstack.func_77946_l();
                copy.func_196082_o().func_82580_o(TAG_DATA);
                handler.setStackInSlot(4, copy);
                ItemNBTHelper.setCompound((ItemStack)budd, (String)TAG_DATA, (CompoundNBT)handler.serializeNBT());
                ItemNBTHelper.setBoolean((ItemStack)budd, (String)TAG_HASDATA, (boolean)true);
                return budd.func_77946_l();
            }
            ItemStack morph = handler.getStackInSlot(id + 1);
            copy = heldstack.func_77946_l();
            copy.func_196082_o().func_82580_o(TAG_DATA);
            handler.setStackInSlot(id, copy);
            ItemNBTHelper.setBoolean((ItemStack)morph, (String)TAG_MORPHING, (boolean)true);
            ItemNBTHelper.setCompound((ItemStack)morph, (String)TAG_DATA, (CompoundNBT)handler.serializeNBT());
            return morph.func_77946_l();
        }
        return ItemStack.field_190927_a;
    }

    @Override
    public String getAdvancementName() {
        return "egodefeat";
    }
}
