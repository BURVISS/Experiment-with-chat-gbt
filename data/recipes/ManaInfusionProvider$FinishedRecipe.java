/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.data.IFinishedRecipe
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.ResourceLocation
 *  vazkii.botania.api.recipe.StateIngredient
 *  vazkii.botania.common.block.ModBlocks
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.crafting.ModRecipeTypes
 *  vazkii.botania.common.crafting.StateIngredientHelper
 */
package com.meteor.extrabotany.data.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.api.recipe.StateIngredient;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.crafting.ModRecipeTypes;
import vazkii.botania.common.crafting.StateIngredientHelper;

private static class ManaInfusionProvider.FinishedRecipe
implements IFinishedRecipe {
    private static final StateIngredient CONJURATION = StateIngredientHelper.of((Block)ModBlocks.conjurationCatalyst);
    private static final StateIngredient ALCHEMY = StateIngredientHelper.of((Block)ModBlocks.alchemyCatalyst);
    private static final StateIngredient DIMENSION = StateIngredientHelper.of((Block)com.meteor.extrabotany.common.blocks.ModBlocks.dimensioncatalyst);
    private final ResourceLocation id;
    private final Ingredient input;
    private final ItemStack output;
    private final int mana;
    private final String group;
    @Nullable
    private final StateIngredient catalyst;

    public static ManaInfusionProvider.FinishedRecipe conjuration(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
        return new ManaInfusionProvider.FinishedRecipe(id, output, input, mana, "", CONJURATION);
    }

    public static ManaInfusionProvider.FinishedRecipe dimension(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
        return new ManaInfusionProvider.FinishedRecipe(id, output, input, mana, "", DIMENSION);
    }

    public static ManaInfusionProvider.FinishedRecipe alchemy(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
        return ManaInfusionProvider.FinishedRecipe.alchemy(id, output, input, mana, "");
    }

    public static ManaInfusionProvider.FinishedRecipe alchemy(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group) {
        return new ManaInfusionProvider.FinishedRecipe(id, output, input, mana, group, ALCHEMY);
    }

    public ManaInfusionProvider.FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
        this(id, output, input, mana, "");
    }

    public ManaInfusionProvider.FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group) {
        this(id, output, input, mana, group, null);
    }

    public ManaInfusionProvider.FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group, @Nullable StateIngredient catalyst) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.mana = mana;
        this.group = group;
        this.catalyst = catalyst;
    }

    public void func_218610_a(JsonObject json) {
        json.add("input", this.input.func_200304_c());
        json.add("output", (JsonElement)ItemNBTHelper.serializeStack((ItemStack)this.output));
        json.addProperty("mana", (Number)this.mana);
        if (!this.group.isEmpty()) {
            json.addProperty("group", this.group);
        }
        if (this.catalyst != null) {
            json.add("catalyst", (JsonElement)this.catalyst.serialize());
        }
    }

    public ResourceLocation func_200442_b() {
        return this.id;
    }

    public IRecipeSerializer<?> func_218609_c() {
        return ModRecipeTypes.MANA_INFUSION_SERIALIZER;
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
