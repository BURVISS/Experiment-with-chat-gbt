/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.util.Pair
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.UseAction
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectUtils
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.DrinkHelper
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.StringTextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.api.BotaniaAPI
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.api.brew.IBrewItem
 *  vazkii.botania.common.brew.ModBrews
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.lib.ResourceLocationHelper
 */
package com.meteor.extrabotany.common.items.brew;

import com.google.common.collect.Lists;
import com.meteor.extrabotany.common.items.ModItems;
import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.api.brew.IBrewItem;
import vazkii.botania.common.brew.ModBrews;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.lib.ResourceLocationHelper;

public class ItemBrewBase
extends Item
implements IBrewItem {
    private static final String TAG_BREW_KEY = "brewKey";
    private static final String TAG_SWIGS_LEFT = "swigsLeft";
    private final int swigs;
    private final int drinkSpeed;
    private final Supplier<Item> baseItem;
    private final float multiplier;
    private final int amplifier;

    public ItemBrewBase(Item.Properties builder, int swigs, int drinkSpeed, float multiplier, int amplifier, Supplier<Item> baseItem) {
        super(builder);
        this.swigs = swigs;
        this.drinkSpeed = drinkSpeed;
        this.baseItem = baseItem;
        this.multiplier = multiplier;
        this.amplifier = amplifier;
    }

    public int func_77626_a(ItemStack stack) {
        return this.drinkSpeed;
    }

    @Nonnull
    public UseAction func_77661_b(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(World world, PlayerEntity player, @Nonnull Hand hand) {
        ItemStack stack = player.func_184586_b(hand);
        if (this.getSwigsLeft(stack) <= 0) {
            return ActionResult.func_226251_d_((Object)stack);
        }
        return DrinkHelper.func_234707_a_((World)world, (PlayerEntity)player, (Hand)hand);
    }

    @Nonnull
    public ItemStack func_77654_b(@Nonnull ItemStack stack, World world, LivingEntity living) {
        if (!world.field_72995_K) {
            for (EffectInstance effect : this.getBrew(stack).getPotionEffects(stack)) {
                EffectInstance newEffect = new EffectInstance(effect.func_188419_a(), (int)((float)effect.func_76459_b() * this.multiplier), effect.func_76458_c() + this.amplifier, true, true);
                if (effect.func_188419_a().func_76403_b()) {
                    effect.func_188419_a().func_180793_a((Entity)living, (Entity)living, living, newEffect.func_76458_c(), 1.0);
                    continue;
                }
                living.func_195064_c(newEffect);
            }
            if (world.field_73012_v.nextBoolean()) {
                world.func_184148_a(null, living.func_226277_ct_(), living.func_226278_cu_(), living.func_226281_cx_(), SoundEvents.field_187739_dZ, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
            int swigs = this.getSwigsLeft(stack);
            if (living instanceof PlayerEntity && !((PlayerEntity)living).field_71075_bZ.field_75098_d) {
                if (swigs == 1 && stack.func_77973_b() != ModItems.infinitewine) {
                    ItemStack result = this.getBaseStack();
                    if (!((PlayerEntity)living).field_71071_by.func_70441_a(result)) {
                        return result;
                    }
                    return ItemStack.field_190927_a;
                }
                this.setSwigsLeft(stack, swigs - 1);
            }
        }
        return stack;
    }

    public void func_150895_a(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            for (Brew brew : BotaniaAPI.instance().getBrewRegistry()) {
                if (brew == ModBrews.fallbackBrew) continue;
                ItemStack stack = new ItemStack((IItemProvider)this);
                ItemBrewBase.setBrew(stack, brew);
                list.add((Object)stack);
            }
        }
    }

    @Nonnull
    public ITextComponent func_200295_i(@Nonnull ItemStack stack) {
        return new TranslationTextComponent(this.func_77658_a(), new Object[]{new TranslationTextComponent(this.getBrew(stack).getTranslationKey(stack)), new StringTextComponent(Integer.toString(this.getSwigsLeft(stack))).func_240699_a_(TextFormatting.BOLD)});
    }

    @OnlyIn(value=Dist.CLIENT)
    public void addPotionTooltip(List<EffectInstance> list, List<ITextComponent> lores, float durationFactor) {
        ArrayList list1 = Lists.newArrayList();
        if (list.isEmpty()) {
            lores.add((ITextComponent)new TranslationTextComponent("effect.none").func_240699_a_(TextFormatting.GRAY));
        } else {
            for (EffectInstance effectinstance : list) {
                TranslationTextComponent iformattabletextcomponent = new TranslationTextComponent(effectinstance.func_76453_d());
                Effect effect = effectinstance.func_188419_a();
                Map map = effect.func_111186_k();
                if (!map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
                        AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.func_111166_b(), effect.func_111183_a(effectinstance.func_76458_c(), attributemodifier), attributemodifier.func_220375_c());
                        list1.add(new Pair(entry.getKey(), (Object)attributemodifier1));
                    }
                }
                if (effectinstance.func_76458_c() > 0) {
                    iformattabletextcomponent = new TranslationTextComponent("potion.withAmplifier", new Object[]{iformattabletextcomponent, new TranslationTextComponent("potion.potency." + String.valueOf(effectinstance.func_76458_c() + this.amplifier))});
                }
                if (effectinstance.func_76459_b() > 20) {
                    iformattabletextcomponent = new TranslationTextComponent("potion.withDuration", new Object[]{iformattabletextcomponent, EffectUtils.func_188410_a((EffectInstance)new EffectInstance(effectinstance.func_188419_a(), (int)((float)effectinstance.func_76459_b() * this.multiplier)), (float)durationFactor)});
                }
                lores.add((ITextComponent)iformattabletextcomponent.func_240699_a_(effect.func_220303_e().func_220306_a()));
            }
        }
        if (!list1.isEmpty()) {
            lores.add(StringTextComponent.field_240750_d_);
            lores.add((ITextComponent)new TranslationTextComponent("potion.whenDrank").func_240699_a_(TextFormatting.DARK_PURPLE));
            for (Pair pair : list1) {
                AttributeModifier attributemodifier2 = (AttributeModifier)pair.getSecond();
                double d0 = attributemodifier2.func_111164_d();
                double d1 = attributemodifier2.func_220375_c() != AttributeModifier.Operation.MULTIPLY_BASE && attributemodifier2.func_220375_c() != AttributeModifier.Operation.MULTIPLY_TOTAL ? attributemodifier2.func_111164_d() : attributemodifier2.func_111164_d() * 100.0;
                if (d0 > 0.0) {
                    lores.add((ITextComponent)new TranslationTextComponent("attribute.modifier.plus." + attributemodifier2.func_220375_c().func_220371_a(), new Object[]{ItemStack.field_111284_a.format(d1), new TranslationTextComponent(((Attribute)pair.getFirst()).func_233754_c_())}).func_240699_a_(TextFormatting.BLUE));
                    continue;
                }
                if (!(d0 < 0.0)) continue;
                lores.add((ITextComponent)new TranslationTextComponent("attribute.modifier.take." + attributemodifier2.func_220375_c().func_220371_a(), new Object[]{ItemStack.field_111284_a.format(d1 *= -1.0), new TranslationTextComponent(((Attribute)pair.getFirst()).func_233754_c_())}).func_240699_a_(TextFormatting.RED));
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flags) {
        this.addPotionTooltip(this.getBrew(stack).getPotionEffects(stack), list, 1.0f);
    }

    public Brew getBrew(ItemStack stack) {
        String key = ItemNBTHelper.getString((ItemStack)stack, (String)TAG_BREW_KEY, (String)"");
        return (Brew)BotaniaAPI.instance().getBrewRegistry().func_82594_a(ResourceLocation.func_208304_a((String)key));
    }

    public static void setBrew(ItemStack stack, @Nullable Brew brew) {
        ResourceLocation id = brew != null ? BotaniaAPI.instance().getBrewRegistry().func_177774_c((Object)brew) : ResourceLocationHelper.prefix((String)"fallback");
        ItemBrewBase.setBrew(stack, id);
    }

    public static void setBrew(ItemStack stack, ResourceLocation brew) {
        ItemNBTHelper.setString((ItemStack)stack, (String)TAG_BREW_KEY, (String)brew.toString());
    }

    @Nonnull
    public static String getSubtype(ItemStack stack) {
        return stack.func_77942_o() ? ItemNBTHelper.getString((ItemStack)stack, (String)TAG_BREW_KEY, (String)"none") : "none";
    }

    public int getSwigs() {
        return this.swigs;
    }

    public int getSwigsLeft(ItemStack stack) {
        return ItemNBTHelper.getInt((ItemStack)stack, (String)TAG_SWIGS_LEFT, (int)this.swigs);
    }

    public void setSwigsLeft(ItemStack stack, int swigs) {
        ItemNBTHelper.setInt((ItemStack)stack, (String)TAG_SWIGS_LEFT, (int)swigs);
    }

    public ItemStack getBaseStack() {
        return new ItemStack((IItemProvider)this.baseItem.get());
    }
}
