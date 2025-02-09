/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  javax.annotation.Nullable
 *  net.minecraft.data.IFinishedRecipe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.ResourceLocation
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.crafting.ModRecipeTypes
 */
package com.meteor.extrabotany.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.crafting.ModRecipeTypes;

private static class RuneRecipeProvider.FinishedRecipe
implements IFinishedRecipe {
    private final ResourceLocation id;
    private final ItemStack output;
    private final int mana;
    private final Ingredient[] inputs;

    private RuneRecipeProvider.FinishedRecipe(ResourceLocation id, ItemStack output, int mana, Ingredient ... inputs) {
        this.id = id;
        this.output = output;
        this.mana = mana;
        this.inputs = inputs;
    }

    public void func_218610_a(JsonObject json) {
        json.add("output", (JsonElement)ItemNBTHelper.serializeStack((ItemStack)this.output));
        JsonArray ingredients = new JsonArray();
        for (Ingredient ingr : this.inputs) {
            ingredients.add(ingr.func_200304_c());
        }
        json.addProperty("mana", (Number)this.mana);
        json.add("ingredients", (JsonElement)ingredients);
    }

    public ResourceLocation func_200442_b() {
        return this.id;
    }

    public IRecipeSerializer<?> func_218609_c() {
        return ModRecipeTypes.RUNE_SERIALIZER;
    }

    @Nullable
    public JsonObject func_200440_c() {
        return null;
    }

    @Nullable
    public ResourceLocation func_200443_d() {
        return null;
    }
}
