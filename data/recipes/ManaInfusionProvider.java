/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.data.IFinishedRecipe
 *  net.minecraft.data.RecipeProvider
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.util.IItemProvider
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
import com.meteor.extrabotany.common.items.ModItems;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import vazkii.botania.api.recipe.StateIngredient;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.crafting.ModRecipeTypes;
import vazkii.botania.common.crafting.StateIngredientHelper;

public class ManaInfusionProvider
extends RecipeProvider {
    public ManaInfusionProvider(DataGenerator gen) {
        super(gen);
    }

    public String func_200397_b() {
        return "ExtraBotany mana pool recipes";
    }

    protected void func_200404_a(Consumer<IFinishedRecipe> consumer) {
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("enderpearl"), new ItemStack((IItemProvider)Items.field_151079_bi), ManaInfusionProvider.ingr((IItemProvider)Items.field_151045_i), 20000));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("shulker_shell"), new ItemStack((IItemProvider)Items.field_190930_cZ), ManaInfusionProvider.ingr((IItemProvider)Items.field_151125_bZ), 20000));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("chorus_fruit"), new ItemStack((IItemProvider)Items.field_185161_cS), ManaInfusionProvider.ingr((IItemProvider)Items.field_151034_e), 500));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("end_stone"), new ItemStack((IItemProvider)Items.field_221828_dx), ManaInfusionProvider.ingr((IItemProvider)Items.field_221574_b), 500));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("nether_rack"), new ItemStack((IItemProvider)Items.field_221691_cH), ManaInfusionProvider.ingr((IItemProvider)Items.field_221585_m), 500));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("soul_sand"), new ItemStack((IItemProvider)Items.field_221693_cI), ManaInfusionProvider.ingr((IItemProvider)Items.field_221548_A), 500));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("quartz_ore"), new ItemStack((IItemProvider)Items.field_221860_en), ManaInfusionProvider.ingr((IItemProvider)Items.field_221552_E), 2000));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("blaze_rod"), new ItemStack((IItemProvider)Items.field_151072_bj, 2), ManaInfusionProvider.ingr((IItemProvider)Items.field_151072_bj), 20000));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("totem_of_undying"), new ItemStack((IItemProvider)Items.field_190929_cY), ManaInfusionProvider.ingr((IItemProvider)Items.field_151156_bN), 50000));
        consumer.accept(FinishedRecipe.dimension(ManaInfusionProvider.id("elytra"), new ItemStack((IItemProvider)Items.field_185160_cR), ManaInfusionProvider.ingr((IItemProvider)ModItems.theorigin), 50000));
    }

    private static ResourceLocation id(String s) {
        return ModItems.prefix("mana_infusion/" + s);
    }

    private static Ingredient ingr(IItemProvider i) {
        return Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{i});
    }

    private static class FinishedRecipe
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

        public static FinishedRecipe conjuration(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return new FinishedRecipe(id, output, input, mana, "", CONJURATION);
        }

        public static FinishedRecipe dimension(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return new FinishedRecipe(id, output, input, mana, "", DIMENSION);
        }

        public static FinishedRecipe alchemy(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return FinishedRecipe.alchemy(id, output, input, mana, "");
        }

        public static FinishedRecipe alchemy(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group) {
            return new FinishedRecipe(id, output, input, mana, group, ALCHEMY);
        }

        public FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            this(id, output, input, mana, "");
        }

        public FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group) {
            this(id, output, input, mana, group, null);
        }

        public FinishedRecipe(ResourceLocation id, ItemStack output, Ingredient input, int mana, String group, @Nullable StateIngredient catalyst) {
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
}
