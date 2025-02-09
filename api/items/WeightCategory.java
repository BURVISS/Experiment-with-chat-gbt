/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package com.meteor.extrabotany.api.items;

import net.minecraft.item.ItemStack;

public class WeightCategory {
    private ItemStack category;
    private Integer weight;

    public WeightCategory() {
    }

    public WeightCategory(ItemStack category, Integer weight) {
        this.setCategory(category);
        this.setWeight(weight);
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public ItemStack getCategory() {
        return this.category;
    }

    public void setCategory(ItemStack category) {
        this.category = category;
    }
}
