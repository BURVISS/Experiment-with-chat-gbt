/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  javax.annotation.Nonnull
 *  net.minecraft.item.crafting.IRecipe
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.ShapelessRecipe
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.registries.ForgeRegistryEntry
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.google.gson.JsonObject;
import com.meteor.extrabotany.common.crafting.recipe.RelicUpgradeRecipe;
import javax.annotation.Nonnull;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

private static class RelicUpgradeRecipe.Serializer
extends ForgeRegistryEntry<IRecipeSerializer<?>>
implements IRecipeSerializer<RelicUpgradeRecipe> {
    private RelicUpgradeRecipe.Serializer() {
    }

    public RelicUpgradeRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
        return new RelicUpgradeRecipe((ShapelessRecipe)IRecipeSerializer.field_222158_b.func_199425_a_(recipeId, json));
    }

    public RelicUpgradeRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull PacketBuffer buffer) {
        return new RelicUpgradeRecipe((ShapelessRecipe)IRecipeSerializer.field_222158_b.func_199426_a_(recipeId, buffer));
    }

    public void write(@Nonnull PacketBuffer buffer, @Nonnull RelicUpgradeRecipe recipe) {
        IRecipeSerializer.field_222158_b.func_199427_a_(buffer, (IRecipe)recipe.compose);
    }
}
