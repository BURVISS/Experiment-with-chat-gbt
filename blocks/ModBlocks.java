/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractBlock
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.block.Block
 *  net.minecraft.block.Blocks
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.registry.Registry
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package com.meteor.extrabotany.common.blocks;

import com.meteor.extrabotany.common.blocks.BlockDimensionCatalyst;
import com.meteor.extrabotany.common.blocks.BlockManaBuffer;
import com.meteor.extrabotany.common.blocks.BlockPowerFrame;
import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModBlocks {
    public static final Block powerframe = new BlockPowerFrame(AbstractBlock.Properties.func_200950_a((AbstractBlock)Blocks.field_150474_ac));
    public static final Block manabuffer = new BlockManaBuffer(AbstractBlock.Properties.func_200950_a((AbstractBlock)Blocks.field_150348_b));
    public static final Block dimensioncatalyst = new BlockDimensionCatalyst(AbstractBlock.Properties.func_200950_a((AbstractBlock)Blocks.field_150348_b));

    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModBlocks.register(r, "powerframe", powerframe);
        ModBlocks.register(r, "manabuffer", manabuffer);
        ModBlocks.register(r, "dimensioncatalyst", dimensioncatalyst);
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry r = evt.getRegistry();
        Item.Properties props = ModItems.defaultBuilder();
        ModBlocks.register(r, Registry.field_212618_g.func_177774_c((Object)powerframe), new BlockItem(powerframe, props));
        ModBlocks.register(r, Registry.field_212618_g.func_177774_c((Object)manabuffer), new BlockItem(manabuffer, props));
        ModBlocks.register(r, Registry.field_212618_g.func_177774_c((Object)dimensioncatalyst), new BlockItem(dimensioncatalyst, props));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register((IForgeRegistryEntry)thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        ModBlocks.register(reg, ModBlocks.prefix(name), thing);
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation("extrabotany", path);
    }
}
