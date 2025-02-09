/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.CraftingInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.SpecialRecipe
 *  net.minecraft.item.crafting.SpecialRecipeSerializer
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  vazkii.botania.api.brew.IBrewItem
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ItemBrewBase;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vazkii.botania.api.brew.IBrewItem;

public class LensPotionRecipe
extends SpecialRecipe {
    public static final SpecialRecipeSerializer<LensPotionRecipe> SERIALIZER = new SpecialRecipeSerializer(LensPotionRecipe::new);

    public LensPotionRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    public boolean matches(CraftingInventory inv, World worldIn) {
        boolean foundBrew = false;
        boolean foundItem = false;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b()) continue;
            if (stack.func_77973_b() == ModItems.cocktail && !foundBrew) {
                foundBrew = true;
                continue;
            }
            if (foundItem) continue;
            if (stack.func_77973_b() == ModItems.lenspotion) {
                foundItem = true;
                continue;
            }
            return false;
        }
        return foundBrew && foundItem;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack brewstack = ItemStack.field_190927_a;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b() || stack.func_77973_b() != ModItems.cocktail || !brewstack.func_190926_b()) continue;
            brewstack = stack;
        }
        IBrewItem brew = (IBrewItem)brewstack.func_77973_b();
        ItemStack lens = new ItemStack((IItemProvider)ModItems.lenspotion);
        ItemBrewBase.setBrew(lens, brew.getBrew(brewstack));
        return lens;
    }

    public boolean func_194133_a(int width, int height) {
        return width > 1 || height > 1;
    }

    public IRecipeSerializer<?> func_199559_b() {
        return SERIALIZER;
    }
}
