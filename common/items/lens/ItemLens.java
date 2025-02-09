/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.mojang.datafixers.util.Pair
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.ai.attributes.Attribute
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.AttributeModifier$Operation
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectUtils
 *  net.minecraft.util.ResourceLocation
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
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.item.lens.ItemLens
 *  vazkii.botania.common.item.lens.Lens
 *  vazkii.botania.common.lib.ResourceLocationHelper
 */
package com.meteor.extrabotany.common.items.lens;

import com.google.common.collect.Lists;
import com.meteor.extrabotany.common.items.ModItems;
import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.ResourceLocation;
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
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.item.lens.Lens;
import vazkii.botania.common.lib.ResourceLocationHelper;

public class ItemLens
extends vazkii.botania.common.item.lens.ItemLens
implements IBrewItem {
    private static final String TAG_BREW_KEY = "brewKey";

    public ItemLens(Item.Properties builder, Lens lens, int props) {
        super(builder, lens, props);
    }

    public Brew getBrew(ItemStack stack) {
        String key = ItemNBTHelper.getString((ItemStack)stack, (String)TAG_BREW_KEY, (String)"");
        return (Brew)BotaniaAPI.instance().getBrewRegistry().func_82594_a(ResourceLocation.func_208304_a((String)key));
    }

    public static void setBrew(ItemStack stack, @Nullable Brew brew) {
        ResourceLocation id = brew != null ? BotaniaAPI.instance().getBrewRegistry().func_177774_c((Object)brew) : ResourceLocationHelper.prefix((String)"fallback");
        ItemLens.setBrew(stack, id);
    }

    public static void setBrew(ItemStack stack, ResourceLocation brew) {
        ItemNBTHelper.setString((ItemStack)stack, (String)TAG_BREW_KEY, (String)brew.toString());
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
                    iformattabletextcomponent = new TranslationTextComponent("potion.withAmplifier", new Object[]{iformattabletextcomponent, new TranslationTextComponent("potion.potency." + effectinstance.func_76458_c())});
                }
                if (effectinstance.func_76459_b() > 20) {
                    iformattabletextcomponent = new TranslationTextComponent("potion.withDuration", new Object[]{iformattabletextcomponent, EffectUtils.func_188410_a((EffectInstance)new EffectInstance(effectinstance.func_188419_a(), (int)((float)effectinstance.func_76459_b() * 0.25f)), (float)durationFactor)});
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
        super.func_77624_a(stack, world, list, flags);
        if (stack.func_77973_b() == ModItems.lenspotion) {
            this.addPotionTooltip(this.getBrew(stack).getPotionEffects(stack), list, 1.0f);
        }
    }
}
