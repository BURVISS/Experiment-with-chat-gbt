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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.tags.ITag
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.common.Tags$Items
 *  vazkii.botania.common.block.ModBlocks
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 *  vazkii.botania.common.crafting.ModRecipeTypes
 *  vazkii.botania.common.item.ModItems
 */
package com.meteor.extrabotany.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.crafting.ModRecipeTypes;
import vazkii.botania.common.item.ModItems;

public class RuneRecipeProvider
extends RecipeProvider {
    public RuneRecipeProvider(DataGenerator gen) {
        super(gen);
    }

    public String func_200397_b() {
        return "ExtraBotany runic altar recipes";
    }

    protected void func_200404_a(Consumer<IFinishedRecipe> consumer) {
        consumer.accept(new FinishedRecipe(RuneRecipeProvider.idFor("firstfractal"), new ItemStack((IItemProvider)com.meteor.extrabotany.common.items.ModItems.firstfractal), 500000, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.trueshadowkatana}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.trueterrablade}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.influxwaver}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.starwrath}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.excaliber}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151041_m}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151048_u}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_234754_kI_}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.manasteelSword}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.elementiumSword}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.gildedmashedpotato}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.theuniverse})}));
        consumer.accept(new FinishedRecipe(RuneRecipeProvider.idFor("gildedpotato"), new ItemStack((IItemProvider)com.meteor.extrabotany.common.items.ModItems.gildedpotato, 4), 2000, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151174_bG}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151174_bG}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151174_bG}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_151174_bG}), Ingredient.func_199805_a((ITag)Tags.Items.INGOTS_GOLD)}));
        consumer.accept(new FinishedRecipe(RuneRecipeProvider.idFor("sunring"), new ItemStack((IItemProvider)com.meteor.extrabotany.common.items.ModItems.sunring), 500000, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.theend}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.froststar}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.deathring}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.auraRingGreater}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.miningRing}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.pixieRing}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.swapRing}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.waterRing}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.manadrivering}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.reachRing})}));
        consumer.accept(new FinishedRecipe(RuneRecipeProvider.idFor("moonpendant"), new ItemStack((IItemProvider)com.meteor.extrabotany.common.items.ModItems.moonpendant), 500000, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.theorigin}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.knockbackBelt}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.superCloudPendant}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.superLavaPendant}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.icePendant}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.itemFinder})}));
        consumer.accept(new FinishedRecipe(RuneRecipeProvider.idFor("potatochips"), new ItemStack((IItemProvider)com.meteor.extrabotany.common.items.ModItems.potatochips), 50000, new Ingredient[]{Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{com.meteor.extrabotany.common.items.ModItems.gildedpotato}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.tinyPotatoMask}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModBlocks.tinyPotato}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{ModItems.runeMana}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_190929_cY}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_190929_cY}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_190929_cY}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_222113_pS}), Ingredient.func_199804_a((IItemProvider[])new IItemProvider[]{Items.field_222102_pI})}));
    }

    private static ResourceLocation idFor(String s) {
        return com.meteor.extrabotany.common.items.ModItems.prefix("runic_altar/" + s);
    }

    private static class FinishedRecipe
    implements IFinishedRecipe {
        private final ResourceLocation id;
        private final ItemStack output;
        private final int mana;
        private final Ingredient[] inputs;

        private FinishedRecipe(ResourceLocation id, ItemStack output, int mana, Ingredient ... inputs) {
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
}
