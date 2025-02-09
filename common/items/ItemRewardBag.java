/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.StringTextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.World
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.api.items.BonusHelper;
import com.meteor.extrabotany.api.items.WeightCategory;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemRewardBag
extends Item {
    List<WeightCategory> categoryList = new ArrayList<WeightCategory>();

    public ItemRewardBag(Item.Properties prop, List<WeightCategory> categoryList) {
        super(prop);
        this.categoryList = categoryList;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_77624_a(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag flags) {
        super.func_77624_a(stack, world, tooltip, flags);
        DecimalFormat df = new DecimalFormat("0.00%");
        int sum = BonusHelper.sum(this.categoryList);
        for (WeightCategory category : this.categoryList) {
            String percentage = df.format((float)category.getWeight().intValue() / (float)sum);
            String stackname = new TranslationTextComponent(category.getCategory().func_77977_a()).getString();
            int count = category.getCategory().func_190916_E();
            TextFormatting color = (float)category.getWeight().intValue() / (float)sum <= 0.01f ? TextFormatting.GOLD : TextFormatting.RESET;
            tooltip.add((ITextComponent)new StringTextComponent(String.format("%s x%d %s", stackname, count, percentage)).func_240699_a_(color));
        }
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity player, Hand handIn) {
        ItemStack itemstack = player.func_184586_b(handIn);
        ItemStack reward = BonusHelper.rollItem(player, this.categoryList);
        if (!reward.func_190926_b() && !worldIn.field_72995_K) {
            ItemStack stack = reward.func_77946_l();
            worldIn.func_184148_a(null, player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_(), SoundEvents.field_187737_v, SoundCategory.PLAYERS, 0.5f, 0.4f / (worldIn.field_73012_v.nextFloat() * 0.4f + 0.8f));
            player.func_199701_a_(stack).func_174868_q();
            if (!player.field_71075_bZ.field_75098_d) {
                itemstack.func_190918_g(1);
            }
            return ActionResult.func_226248_a_((Object)itemstack);
        }
        return ActionResult.func_226251_d_((Object)itemstack);
    }
}
