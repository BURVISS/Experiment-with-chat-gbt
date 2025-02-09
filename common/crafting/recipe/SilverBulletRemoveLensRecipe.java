/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.inventory.CraftingInventory
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.SpecialRecipe
 *  net.minecraft.item.crafting.SpecialRecipeSerializer
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  vazkii.botania.common.crafting.recipe.RecipeUtils
 *  vazkii.botania.common.item.ItemManaGun
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.meteor.extrabotany.common.items.ModItems;
import javax.annotation.Nonnull;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import vazkii.botania.common.crafting.recipe.RecipeUtils;
import vazkii.botania.common.item.ItemManaGun;

public class SilverBulletRemoveLensRecipe
extends SpecialRecipe {
    public static final SpecialRecipeSerializer<SilverBulletRemoveLensRecipe> SERIALIZER = new SpecialRecipeSerializer(SilverBulletRemoveLensRecipe::new);

    public SilverBulletRemoveLensRecipe(ResourceLocation id) {
        super(id);
    }

    public boolean matches(@Nonnull CraftingInventory inv, @Nonnull World world) {
        boolean foundGun = false;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b()) continue;
            if (stack.func_77973_b() == ModItems.silverbullet && !ItemManaGun.getLens((ItemStack)stack).func_190926_b()) {
                foundGun = true;
                continue;
            }
            return false;
        }
        return foundGun;
    }

    @Nonnull
    public ItemStack getCraftingResult(@Nonnull CraftingInventory inv) {
        ItemStack gun = ItemStack.field_190927_a;
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b() || stack.func_77973_b() != ModItems.silverbullet) continue;
            gun = stack;
        }
        ItemStack gunCopy = gun.func_77946_l();
        gunCopy.func_190920_e(1);
        ItemManaGun.setLens((ItemStack)gunCopy, (ItemStack)ItemStack.field_190927_a);
        return gunCopy;
    }

    public boolean func_194133_a(int width, int height) {
        return width * height > 0;
    }

    @Nonnull
    public IRecipeSerializer<?> func_199559_b() {
        return SERIALIZER;
    }

    @Nonnull
    public NonNullList<ItemStack> getRemainingItems(@Nonnull CraftingInventory inv) {
        return RecipeUtils.getRemainingItemsSub((IInventory)inv, s -> {
            if (s.func_77973_b() == ModItems.silverbullet) {
                ItemStack stack = ItemManaGun.getLens((ItemStack)s);
                stack.func_190920_e(1);
                return stack;
            }
            return null;
        });
    }
}
