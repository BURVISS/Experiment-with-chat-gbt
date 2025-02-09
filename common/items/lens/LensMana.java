/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.crafting.IRecipeType
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 *  vazkii.botania.api.internal.IManaBurst
 *  vazkii.botania.api.mana.BurstProperties
 *  vazkii.botania.api.recipe.IManaInfusionRecipe
 *  vazkii.botania.common.crafting.ModRecipeTypes
 *  vazkii.botania.common.item.lens.Lens
 */
package com.meteor.extrabotany.common.items.lens;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import vazkii.botania.api.internal.IManaBurst;
import vazkii.botania.api.mana.BurstProperties;
import vazkii.botania.api.recipe.IManaInfusionRecipe;
import vazkii.botania.common.crafting.ModRecipeTypes;
import vazkii.botania.common.item.lens.Lens;

public class LensMana
extends Lens {
    public void apply(ItemStack stack, BurstProperties props) {
        props.maxMana = 1000;
        props.motionModifier *= 0.5f;
        props.manaLossPerTick *= 2.0f;
    }

    public void updateBurst(IManaBurst burst, ItemStack stack) {
        ThrowableEntity entity = burst.entity();
        if (entity.field_70170_p.field_72995_K) {
            return;
        }
        int mana = burst.getMana();
        BlockState state = entity.field_70170_p.func_180495_p(burst.getBurstSourceBlockPos().func_177982_a(0, -1, 0));
        AxisAlignedBB axis = new AxisAlignedBB(entity.func_226277_ct_(), entity.func_226278_cu_(), entity.func_226281_cx_(), entity.field_70142_S, entity.field_70137_T, entity.field_70136_U).func_186662_g(1.0);
        List entities = entity.field_70170_p.func_217357_a(ItemEntity.class, axis);
        if (!burst.isFake()) {
            for (ItemEntity items : entities) {
                int manaToConsume;
                ItemStack itemstack;
                IManaInfusionRecipe recipe;
                if (items.func_174874_s() || (recipe = this.getMatchingRecipe(entity.field_70170_p, itemstack = items.func_92059_d(), state)) == null || mana < (manaToConsume = recipe.getManaToConsume())) continue;
                burst.setMana(mana - manaToConsume);
                itemstack.func_190918_g(1);
                ItemStack output = recipe.func_77571_b().func_77946_l();
                ItemEntity outputItem = new ItemEntity(entity.field_70170_p, items.func_226277_ct_(), items.func_226278_cu_() + 0.5, items.func_226281_cx_() + 0.5, output);
                outputItem.func_174867_a(50);
                entity.field_70170_p.func_217376_c((Entity)outputItem);
            }
        }
    }

    public static List<IManaInfusionRecipe> manaInfusionRecipes(World world) {
        return ModRecipeTypes.getRecipes((World)world, (IRecipeType)ModRecipeTypes.MANA_INFUSION_TYPE).values().stream().filter(r -> r instanceof IManaInfusionRecipe).map(r -> (IManaInfusionRecipe)r).collect(Collectors.toList());
    }

    public IManaInfusionRecipe getMatchingRecipe(World world, @Nonnull ItemStack stack, @Nonnull BlockState state) {
        ArrayList<IManaInfusionRecipe> matchingNonCatRecipes = new ArrayList<IManaInfusionRecipe>();
        ArrayList<IManaInfusionRecipe> matchingCatRecipes = new ArrayList<IManaInfusionRecipe>();
        for (IManaInfusionRecipe recipe : LensMana.manaInfusionRecipes(world)) {
            if (!recipe.matches(stack)) continue;
            if (recipe.getRecipeCatalyst() == null) {
                matchingNonCatRecipes.add(recipe);
                continue;
            }
            if (!recipe.getRecipeCatalyst().test(state)) continue;
            matchingCatRecipes.add(recipe);
        }
        return !matchingCatRecipes.isEmpty() ? (IManaInfusionRecipe)matchingCatRecipes.get(0) : (!matchingNonCatRecipes.isEmpty() ? (IManaInfusionRecipe)matchingNonCatRecipes.get(0) : null);
    }
}
