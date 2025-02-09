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
 *  vazkii.botania.api.item.IRelic
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vazkii.botania.api.item.IRelic;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class GoldClothRecipe
extends SpecialRecipe {
    public static final SpecialRecipeSerializer<GoldClothRecipe> SERIALIZER = new SpecialRecipeSerializer(GoldClothRecipe::new);

    public GoldClothRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    public boolean matches(CraftingInventory inv, World worldIn) {
        boolean foundGoldCloth = false;
        boolean foundItem = false;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b()) continue;
            if (stack.func_77973_b() == ModItems.goldcloth && !foundGoldCloth) {
                foundGoldCloth = true;
                continue;
            }
            if (foundItem) continue;
            if (stack.func_77973_b() instanceof IRelic) {
                foundItem = true;
                continue;
            }
            return false;
        }
        return foundGoldCloth && foundItem;
    }

    public ItemStack getCraftingResult(CraftingInventory inv) {
        ItemStack item = ItemStack.field_190927_a;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b() || !(stack.func_77973_b() instanceof IRelic) || !item.func_190926_b()) continue;
            item = stack;
        }
        ItemStack copy = item.func_77946_l();
        ItemNBTHelper.removeEntry((ItemStack)copy, (String)"soulbindUUID");
        return copy;
    }

    public boolean func_194133_a(int width, int height) {
        return width > 1 || height > 1;
    }

    public IRecipeSerializer<?> func_199559_b() {
        return SERIALIZER;
    }
}
