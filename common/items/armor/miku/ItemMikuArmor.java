/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.ClientPlayerEntity
 *  net.minecraft.client.renderer.entity.model.BipedModel
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.inventory.EquipmentSlotType$Group
 *  net.minecraft.item.ArmorItem
 *  net.minecraft.item.IArmorMaterial
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.LazyValue
 *  net.minecraft.util.text.IFormattableTextComponent
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.StringTextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.fml.DistExecutor
 *  vazkii.botania.api.item.IPhantomInkable
 *  vazkii.botania.api.mana.IManaDiscountArmor
 *  vazkii.botania.api.mana.IManaUsingItem
 *  vazkii.botania.api.mana.ManaItemHandler
 *  vazkii.botania.client.core.handler.TooltipHandler
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.equipment.tool.ToolCommons
 */
package com.meteor.extrabotany.common.items.armor.miku;

import com.meteor.extrabotany.api.ExtraBotanyAPI;
import com.meteor.extrabotany.client.model.armor.ModelMikuArmor;
import com.meteor.extrabotany.common.items.ModItems;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import vazkii.botania.api.item.IPhantomInkable;
import vazkii.botania.api.mana.IManaDiscountArmor;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import vazkii.botania.client.core.handler.TooltipHandler;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

public class ItemMikuArmor
extends ArmorItem
implements IManaUsingItem,
IPhantomInkable,
IManaDiscountArmor {
    private static final int MANA_PER_DAMAGE = 70;
    private static final String TAG_PHANTOM_INK = "phantomInk";
    private final LazyValue<BipedModel<?>> model;
    public final EquipmentSlotType type;
    private static final LazyValue<ItemStack[]> armorSet = new LazyValue(() -> new ItemStack[]{new ItemStack((IItemProvider)ModItems.armor_miku_helm), new ItemStack((IItemProvider)ModItems.armor_miku_chest), new ItemStack((IItemProvider)ModItems.armor_miku_legs), new ItemStack((IItemProvider)ModItems.armor_miku_boots)});

    public ItemMikuArmor(EquipmentSlotType type, Item.Properties props) {
        this(type, ExtraBotanyAPI.INSTANCE.getMikuArmorMaterial(), props);
    }

    public ItemMikuArmor(EquipmentSlotType type, IArmorMaterial mat, Item.Properties props) {
        super(mat, type, props);
        this.type = type;
        this.model = (LazyValue)DistExecutor.unsafeRunForDist(() -> () -> new LazyValue(() -> this.provideArmorModelForSlot(type)), () -> () -> null);
    }

    public float getDiscount(ItemStack stack, int slot, PlayerEntity player, @Nullable ItemStack tool) {
        return this.hasArmorSet(player) ? 0.15f : 0.0f;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flags) {
        TooltipHandler.addOnShift(list, () -> this.addInformationAfterShift(stack, world, list, flags));
    }

    @OnlyIn(value=Dist.CLIENT)
    public void addInformationAfterShift(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flags) {
        ItemStack[] stacks;
        ClientPlayerEntity player = Minecraft.func_71410_x().field_71439_g;
        list.add(this.getArmorSetTitle((PlayerEntity)player));
        this.addArmorSetDescription(stack, list);
        for (ItemStack armor : stacks = this.getArmorSetStacks()) {
            IFormattableTextComponent cmp = new StringTextComponent(" - ").func_230529_a_(armor.func_200301_q());
            EquipmentSlotType slot = ((ArmorItem)armor.func_77973_b()).func_185083_B_();
            cmp.func_240699_a_(this.hasArmorSetItem((PlayerEntity)player, slot) ? TextFormatting.GREEN : TextFormatting.GRAY);
            list.add((ITextComponent)cmp);
        }
        if (this.hasPhantomInk(stack)) {
            list.add((ITextComponent)new TranslationTextComponent("botaniamisc.hasPhantomInk").func_240699_a_(TextFormatting.GRAY));
        }
    }

    public void func_77663_a(ItemStack stack, World world, Entity player, int slot, boolean selected) {
        if (player instanceof PlayerEntity) {
            this.onArmorTick(stack, world, (PlayerEntity)player);
        }
    }

    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.field_72995_K && stack.func_77952_i() > 0 && ManaItemHandler.instance().requestManaExact(stack, player, 140, true)) {
            stack.func_196085_b(stack.func_77952_i() - 1);
        }
    }

    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return ToolCommons.damageItemIfPossible((ItemStack)stack, (int)amount, entity, (int)70);
    }

    @Nonnull
    public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return this.hasPhantomInk(stack) ? "botania:textures/model/armor_invisible.png" : this.getArmorTextureAfterInk(stack, slot);
    }

    public String getArmorTextureAfterInk(ItemStack stack, EquipmentSlotType slot) {
        return "extrabotany:textures/model/armor_miku.png";
    }

    @OnlyIn(value=Dist.CLIENT)
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A original) {
        return (A)((BipedModel)this.model.func_179281_c());
    }

    @OnlyIn(value=Dist.CLIENT)
    public BipedModel<?> provideArmorModelForSlot(EquipmentSlotType slot) {
        return new ModelMikuArmor(slot);
    }

    public boolean usesMana(ItemStack stack) {
        return true;
    }

    public ItemStack[] getArmorSetStacks() {
        return (ItemStack[])armorSet.func_179281_c();
    }

    public boolean hasArmorSet(PlayerEntity player) {
        return this.hasArmorSetItem(player, EquipmentSlotType.HEAD) && this.hasArmorSetItem(player, EquipmentSlotType.CHEST) && this.hasArmorSetItem(player, EquipmentSlotType.LEGS) && this.hasArmorSetItem(player, EquipmentSlotType.FEET);
    }

    public boolean hasArmorSetItem(PlayerEntity player, EquipmentSlotType slot) {
        if (player == null || player.field_71071_by == null || player.field_71071_by.field_70460_b == null) {
            return false;
        }
        ItemStack stack = player.func_184582_a(slot);
        if (stack.func_190926_b()) {
            return false;
        }
        switch (slot) {
            case HEAD: {
                return stack.func_77973_b() == ModItems.armor_miku_helm;
            }
            case CHEST: {
                return stack.func_77973_b() == ModItems.armor_miku_chest;
            }
            case LEGS: {
                return stack.func_77973_b() == ModItems.armor_miku_legs;
            }
            case FEET: {
                return stack.func_77973_b() == ModItems.armor_miku_boots;
            }
        }
        return false;
    }

    private int getSetPiecesEquipped(PlayerEntity player) {
        int pieces = 0;
        for (EquipmentSlotType slot : EquipmentSlotType.values()) {
            if (slot.func_188453_a() != EquipmentSlotType.Group.ARMOR || !this.hasArmorSetItem(player, slot)) continue;
            ++pieces;
        }
        return pieces;
    }

    public IFormattableTextComponent getArmorSetName() {
        return new TranslationTextComponent("extrabotany.armorset.miku.name");
    }

    private ITextComponent getArmorSetTitle(PlayerEntity player) {
        IFormattableTextComponent end = this.getArmorSetName().func_240702_b_(" (" + this.getSetPiecesEquipped(player) + "/" + this.getArmorSetStacks().length + ")").func_240699_a_(TextFormatting.GRAY);
        return new TranslationTextComponent("botaniamisc.armorset").func_240702_b_(" ").func_230529_a_((ITextComponent)end);
    }

    @OnlyIn(value=Dist.CLIENT)
    public void addArmorSetDescription(ItemStack stack, List<ITextComponent> list) {
        list.add((ITextComponent)new TranslationTextComponent("extrabotany.armorset.miku.desc").func_240699_a_(TextFormatting.GRAY));
    }

    public boolean hasPhantomInk(ItemStack stack) {
        return ItemNBTHelper.getBoolean((ItemStack)stack, (String)TAG_PHANTOM_INK, (boolean)false);
    }

    public void setPhantomInk(ItemStack stack, boolean ink) {
        ItemNBTHelper.setBoolean((ItemStack)stack, (String)TAG_PHANTOM_INK, (boolean)ink);
    }
}
