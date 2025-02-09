/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.util.registry.Registry
 *  net.minecraftforge.client.model.generators.BlockStateProvider
 *  net.minecraftforge.common.data.ExistingFileHelper
 */
package com.meteor.extrabotany.data;

import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockstateProvider
extends BlockStateProvider {
    public BlockstateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, "extrabotany", exFileHelper);
    }

    @Nonnull
    public String func_200397_b() {
        return "ExtraBotany Blockstates";
    }

    protected void registerStatesAndModels() {
        Set remainingBlocks = Registry.field_212618_g.func_201756_e().filter(b -> "botania".equals(Registry.field_212618_g.func_177774_c(b).func_110624_b())).collect(Collectors.toSet());
    }
}
