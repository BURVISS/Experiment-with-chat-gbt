/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  javax.annotation.Nonnull
 *  net.minecraft.item.crafting.IRecipe
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.ShapedRecipe
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.registries.ForgeRegistryEntry
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.google.gson.JsonObject;
import com.meteor.extrabotany.common.crafting.recipe.RelicUpgradeShapedRecipe;
import javax.annotation.Nonnull;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

private static class RelicUpgradeShapedRecipe.Serializer
extends ForgeRegistryEntry<IRecipeSerializer<?>>
implements IRecipeSerializer<RelicUpgradeShapedRecipe> {
    private RelicUpgradeShapedRecipe.Serializer() {
    }

    public RelicUpgradeShapedRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        return new RelicUpgradeShapedRecipe((ShapedRecipe)IRecipeSerializer.field_222157_a.func_199425_a_(recipeId, json));
    }

    public RelicUpgradeShapedRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull PacketBuffer buffer) {
        return new RelicUpgradeShapedRecipe((ShapedRecipe)IRecipeSerializer.field_222157_a.func_199426_a_(recipeId, buffer));
    }

    public void write(@Nonnull PacketBuffer buffer, @Nonnull RelicUpgradeShapedRecipe recipe) {
        IRecipeSerializer.field_222157_a.func_199427_a_(buffer, (IRecipe)recipe.compose);
    }
}
