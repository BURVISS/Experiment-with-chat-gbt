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
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectUtils
 *  net.minecraft.util.ActionResult
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
import com.meteor.extrabotany.common.entities.EntitySplashGrenade;
import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.ActionResult;
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

public class ItemSplashGrenade
extends Item
implements IBrewItem {
    private static final String TAG_BREW_KEY = "brewKey";

    public ItemSplashGrenade(Item.Properties properties) {
        super(properties);
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.func_184586_b(handIn);
        EntitySplashGrenade sg = new EntitySplashGrenade(worldIn, playerIn);
        sg.setItem(itemstack);
        sg.func_70107_b(playerIn.func_226277_ct_(), playerIn.func_226278_cu_() + 1.1, playerIn.func_226281_cx_());
        sg.func_234612_a_((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, -5.0f, 0.8f, 1.0f);
        if (!worldIn.field_72995_K) {
            worldIn.func_217376_c((Entity)sg);
        }
        worldIn.func_184148_a(null, playerIn.func_226277_ct_(), playerIn.func_226278_cu_(), playerIn.func_226281_cx_(), SoundEvents.field_187827_fP, SoundCategory.PLAYERS, 0.5f, 0.8f);
        if (!playerIn.field_71075_bZ.field_75098_d) {
            itemstack.func_190918_g(1);
        }
        return ActionResult.func_226250_c_((Object)itemstack);
    }

    public void func_150895_a(ItemGroup tab, NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            for (Brew brew : BotaniaAPI.instance().getBrewRegistry()) {
                if (brew == ModBrews.fallbackBrew) continue;
                ItemStack stack = new ItemStack((IItemProvider)this);
                ItemSplashGrenade.setBrew(stack, brew);
                list.add((Object)stack);
            }
        }
    }

    @Nonnull
    public ITextComponent func_200295_i(@Nonnull ItemStack stack) {
        return new TranslationTextComponent(this.func_77658_a(), new Object[]{new TranslationTextComponent(this.getBrew(stack).getTranslationKey(stack))});
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void addPotionTooltip(List<EffectInstance> list, List<ITextComponent> lores, float durationFactor) {
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
                    iformattabletextcomponent = new TranslationTextComponent("potion.withAmplifier", new Object[]{iformattabletextcomponent, new TranslationTextComponent("potion.potency." + effectinstance.func_76458_c())});
                }
                if (effectinstance.func_76459_b() > 20) {
                    iformattabletextcomponent = new TranslationTextComponent("potion.withDuration", new Object[]{iformattabletextcomponent, EffectUtils.func_188410_a((EffectInstance)new EffectInstance(effectinstance.func_188419_a(), (int)((float)effectinstance.func_76459_b() * 0.6f)), (float)durationFactor)});
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
        ItemSplashGrenade.addPotionTooltip(this.getBrew(stack).getPotionEffects(stack), list, 1.0f);
    }

    public Brew getBrew(ItemStack stack) {
        String key = ItemNBTHelper.getString((ItemStack)stack, (String)TAG_BREW_KEY, (String)"");
        return (Brew)BotaniaAPI.instance().getBrewRegistry().func_82594_a(ResourceLocation.func_208304_a((String)key));
    }

    public static void setBrew(ItemStack stack, @Nullable Brew brew) {
        ResourceLocation id = brew != null ? BotaniaAPI.instance().getBrewRegistry().func_177774_c((Object)brew) : ResourceLocationHelper.prefix((String)"fallback");
        ItemSplashGrenade.setBrew(stack, id);
    }

    public static void setBrew(ItemStack stack, ResourceLocation brew) {
        ItemNBTHelper.setString((ItemStack)stack, (String)TAG_BREW_KEY, (String)brew.toString());
    }

    @Nonnull
    public static String getSubtype(ItemStack stack) {
        return stack.func_77942_o() ? ItemNBTHelper.getString((ItemStack)stack, (String)TAG_BREW_KEY, (String)"none") : "none";
    }
}
