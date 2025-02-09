/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  javax.annotation.Nullable
 *  net.minecraft.data.IFinishedRecipe
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.ResourceLocation
 *  vazkii.botania.api.BotaniaAPI
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.common.crafting.ModRecipeTypes
 */
package com.meteor.extrabotany.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.common.crafting.ModRecipeTypes;

private static class BrewProvider.FinishedRecipe
implements IFinishedRecipe {
    private final ResourceLocation id;
    private final Brew brew;
    private final Ingredient[] inputs;

    private BrewProvider.FinishedRecipe(ResourceLocation id, Brew brew, Ingredient ... inputs) {
        this.id = id;
        this.brew = brew;
        this.inputs = inputs;
    }

    public void func_218610_a(JsonObject json) {
        json.addProperty("brew", BotaniaAPI.instance().getBrewRegistry().func_177774_c((Object)this.brew).toString());
        JsonArray ingredients = new JsonArray();
        for (Ingredient ingr : this.inputs) {
            ingredients.add(ingr.func_200304_c());
        }
        json.add("ingredients", (JsonElement)ingredients);
    }

    public ResourceLocation func_200442_b() {
        return this.id;
    }

    public IRecipeSerializer<?> func_218609_c() {
        return ModRecipeTypes.BREW_SERIALIZER;
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
