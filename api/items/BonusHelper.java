/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 */
package com.meteor.extrabotany.api.items;

import com.meteor.extrabotany.api.items.WeightCategory;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class BonusHelper {
    public static int sum(List<WeightCategory> categorys) {
        int weightSum = 0;
        for (WeightCategory wc : categorys) {
            weightSum += wc.getWeight().intValue();
        }
        return weightSum;
    }

    public static void addItem(ItemStack stack, int weight, List<WeightCategory> categorys) {
        WeightCategory w = new WeightCategory(stack, weight);
        categorys.add(w);
    }

    public static ItemStack rollItem(PlayerEntity player, List<WeightCategory> weightcategory) {
        int weightSum = BonusHelper.sum(weightcategory);
        Random random = new Random();
        int n = random.nextInt(weightSum);
        int m = 0;
        for (WeightCategory wc : weightcategory) {
            if (m <= n && n < m + wc.getWeight()) {
                if ((float)(wc.getWeight() / weightSum) <= 0.01f) {
                    // empty if block
                }
                return wc.getCategory();
            }
            m += wc.getWeight().intValue();
        }
        return ItemStack.field_190927_a;
    }
}
