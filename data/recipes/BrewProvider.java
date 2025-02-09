/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  javax.annotation.Nullable
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.data.IFinishedRecipe
 *  net.minecraft.data.RecipeProvider
 *  net.minecraft.item.Items
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  vazkii.botania.api.BotaniaAPI
 *  vazkii.botania.api.brew.Brew
 *  vazkii.botania.common.crafting.ModRecipeTypes
 */
package com.meteor.extrabotany.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ModBrew;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.common.crafting.ModRecipeTypes;

public class BrewProvider
extends RecipeProvider {
    public BrewProvider(DataGenerator gen) {
        super(gen);
    }

    public String func_200397_b() {
        return "ExtraBotany Brew recipes";
    }

    protected void func_200404_a(Consumer<IFinishedRecipe> consumer) {
        consumer.accept(new FinishedRecipe(BrewProvider.idFor("allmighty"), ModBrew.allmighty, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151075_bm}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151150_bK}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151073_bk}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151114_aO})}));
        consumer.accept(new FinishedRecipe(BrewProvider.idFor("shell"), ModBrew.shell, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151075_bm}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151153_ao}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_203183_eM}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_221655_bP})}));
        consumer.accept(new FinishedRecipe(BrewProvider.idFor("revolution"), ModBrew.revolution, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151075_bm}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151102_aT}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151035_b})}));
        consumer.accept(new FinishedRecipe(BrewProvider.idFor("deadpool"), ModBrew.deadpool, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151075_bm}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151078_bh}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151103_aS}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151065_br})}));
        consumer.accept(new FinishedRecipe(BrewProvider.idFor("floating"), ModBrew.floating, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151075_bm}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151102_aT}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_185161_cS})}));
    }

    private static ResourceLocation idFor(String s) {
        return ModItems.prefix("brew/" + s);
    }

    private static class FinishedRecipe
    implements IFinishedRecipe {
        private final ResourceLocation id;
        private final Brew brew;
        private final Ingredient[] inputs;

        private FinishedRecipe(ResourceLocation id, Brew brew, Ingredient ... inputs) {
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
}
