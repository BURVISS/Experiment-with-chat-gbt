/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  javax.annotation.Nonnull
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.inventory.CraftingInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.ICraftingRecipe
 *  net.minecraft.item.crafting.IRecipe
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.item.crafting.Ingredient
 *  net.minecraft.item.crafting.ShapelessRecipe
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraftforge.registries.ForgeRegistryEntry
 *  vazkii.botania.api.item.IRelic
 */
package com.meteor.extrabotany.common.crafting.recipe;

import com.google.gson.JsonObject;
import java.util.Map;
import javax.annotation.Nonnull;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;
import vazkii.botania.api.item.IRelic;

public class RelicUpgradeRecipe
implements ICraftingRecipe {
    private final ShapelessRecipe compose;
    public static final IRecipeSerializer<RelicUpgradeRecipe> SERIALIZER = new Serializer();

    public RelicUpgradeRecipe(ShapelessRecipe compose) {
        this.compose = compose;
    }

    public boolean matches(@Nonnull CraftingInventory inv, @Nonnull World world) {
        return this.compose.func_77569_a(inv, world);
    }

    @Nonnull
    public ItemStack getCraftingResult(@Nonnull CraftingInventory inv) {
        ItemStack out = this.compose.func_77572_b(inv);
        for (int i = 0; i < inv.func_70302_i_(); ++i) {
            ItemStack stack = inv.func_70301_a(i);
            if (stack.func_190926_b() || !(stack.func_77973_b() instanceof IRelic)) continue;
            EnchantmentHelper.func_82782_a((Map)EnchantmentHelper.func_82781_a((ItemStack)stack), (ItemStack)out);
            IRelic relic = (IRelic)stack.func_77973_b();
            relic.bindToUUID(relic.getSoulbindUUID(stack), out);
            break;
        }
        return out;
    }

    public boolean func_194133_a(int width, int height) {
        return this.compose.func_194133_a(width, height);
    }

    @Nonnull
    public ItemStack func_77571_b() {
        return this.compose.func_77571_b();
    }

    @Nonnull
    public NonNullList<Ingredient> func_192400_c() {
        return this.compose.func_192400_c();
    }

    @Nonnull
    public ResourceLocation func_199560_c() {
        return this.compose.func_199560_c();
    }

    @Nonnull
    public IRecipeSerializer<?> func_199559_b() {
        return SERIALIZER;
    }

    private static class Serializer
    extends ForgeRegistryEntry<IRecipeSerializer<?>>
    implements IRecipeSerializer<RelicUpgradeRecipe> {
        private Serializer() {
        }

        public RelicUpgradeRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
            return new RelicUpgradeRecipe((ShapelessRecipe)IRecipeSerializer.field_222158_b.func_199425_a_(recipeId, json));
        }

        public RelicUpgradeRecipe read(@Nonnull ResourceLocation recipeId, @Nonnull PacketBuffer buffer) {
            return new RelicUpgradeRecipe((ShapelessRecipe)IRecipeSerializer.field_222158_b.func_199426_a_(recipeId, buffer));
        }

        public void write(@Nonnull PacketBuffer buffer, @Nonnull RelicUpgradeRecipe recipe) {
            IRecipeSerializer.field_222158_b.func_199427_a_(buffer, (IRecipe)recipe.compose);
        }
    }
}
