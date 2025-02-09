/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.DataGenerator
 *  net.minecraft.item.Item
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.registry.Registry
 *  net.minecraftforge.client.model.generators.ItemModelProvider
 *  net.minecraftforge.common.data.ExistingFileHelper
 */
package com.meteor.extrabotany.data;

import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider
extends net.minecraftforge.client.model.generators.ItemModelProvider {
    private static final ResourceLocation GENERATED = new ResourceLocation("item/generated");

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, "extrabotany", existingFileHelper);
    }

    protected void registerModels() {
        Set<Item> items = Registry.field_212630_s.func_201756_e().filter(i -> "extrabotany".equals(Registry.field_212630_s.func_177774_c(i).func_110624_b())).collect(Collectors.toSet());
        this.registerItemOverrides(items);
    }

    private static String name(Item i) {
        return Registry.field_212630_s.func_177774_c((Object)i).func_110623_a();
    }

    private void registerItemOverrides(Set<Item> items) {
    }
}
