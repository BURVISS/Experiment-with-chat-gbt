/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.CraftingInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.SpecialRecipe
 *  net.minecraft.item.crafting.SpecialRecipeSerializer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  vazkii.botania.api.brew.IBrewItem
 *  vazkii.botania.api.item.IRelic
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ItemBrewBase;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vazkii.botania.api.brew.IBrewItem;
import vazkii.botania.api.item.IRelic;

public class InfiniteWineChangeRecipe
extends SpecialRecipe {
    public static final SpecialRecipeSerializer<InfiniteWineChangeRecipe> SERIALIZER = new SpecialRecipeSerializer(InfiniteWineChangeRecipe::new);

    public InfiniteWineChangeRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    public boolean matches(CraftingInventory inv, World worldIn) {
        boolean foundInfiniteWine = false;
        boolean foundItem = false;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b()) continue;
            if (stack.func_77973_b() == ModItems.infinitewine && !foundInfiniteWine) {
                foundInfiniteWine = true;
                continue;
            }
            if (foundItem) continue;
            if (stack.func_77973_b() == ModItems.cocktail) {
                foundItem = true;
                continue;
            }
            return false;
        }
        return foundInfiniteWine && foundItem;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack item = ItemStack.field_190927_a;
        ItemStack cocktail = ItemStack.field_190927_a;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b()) continue;
            if (stack.func_77973_b() == ModItems.infinitewine && item.func_190926_b()) {
                item = stack;
                continue;
            }
            if (!cocktail.func_190926_b() || stack.func_77973_b() != ModItems.cocktail) continue;
            cocktail = stack;
        }
        IRelic relic = (IRelic)item.func_77973_b();
        ItemStack copy = item.func_77946_l();
        relic.bindToUUID(relic.getSoulbindUUID(item), copy);
        IBrewItem brew = (IBrewItem)cocktail.func_77973_b();
        ItemBrewBase.setBrew(copy, brew.getBrew(cocktail));
        return copy;
    }

    public boolean func_194133_a(int width, int height) {
        return width > 1 || height > 1;
    }

    public IRecipeSerializer<?> func_199559_b() {
        return SERIALIZER;
    }
}
