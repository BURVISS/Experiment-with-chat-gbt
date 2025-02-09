/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.AbstractBlock
 *  net.minecraft.block.AbstractBlock$Properties
 *  net.minecraft.block.Block
 *  net.minecraft.block.Blocks
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.potion.Effects
 *  net.minecraft.tileentity.TileEntityType
 *  net.minecraft.tileentity.TileEntityType$Builder
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.registry.Registry
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 *  vazkii.botania.common.block.BlockFloatingSpecialFlower
 *  vazkii.botania.common.block.ModBlocks
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.block.ItemBlockSpecialFlower
 */
package com.meteor.extrabotany.common.blocks;

import com.meteor.extrabotany.common.blocks.BlockSpecialFlower;
import com.meteor.extrabotany.common.blocks.functional.SubTileAnnoyingFlower;
import com.meteor.extrabotany.common.blocks.functional.SubTileSerenitian;
import com.meteor.extrabotany.common.blocks.generating.SubTileBellFlower;
import com.meteor.extrabotany.common.blocks.generating.SubTileBloodyEnchantress;
import com.meteor.extrabotany.common.blocks.generating.SubTileEdelweiss;
import com.meteor.extrabotany.common.blocks.generating.SubTileGeminiOrchid;
import com.meteor.extrabotany.common.blocks.generating.SubTileMoonBless;
import com.meteor.extrabotany.common.blocks.generating.SubTileOmniViolet;
import com.meteor.extrabotany.common.blocks.generating.SubTileReikarLily;
import com.meteor.extrabotany.common.blocks.generating.SubTileSunBless;
import com.meteor.extrabotany.common.blocks.generating.SubTileTinkleFlower;
import com.meteor.extrabotany.common.libs.LibBlockNames;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import vazkii.botania.common.block.BlockFloatingSpecialFlower;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;

public class ModSubtiles {
    private static final AbstractBlock.Properties FLOWER_PROPS = AbstractBlock.Properties.func_200950_a((AbstractBlock)Blocks.field_196606_bd);
    private static final AbstractBlock.Properties FLOATING_PROPS = ModBlocks.FLOATING_PROPS;
    public static final Block bellflower = new BlockSpecialFlower(Effects.field_76424_c, 360, FLOWER_PROPS, SubTileBellFlower::new);
    public static final Block bellflowerFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileBellFlower::new);
    public static final Block edelweiss = new BlockSpecialFlower(Effects.field_76421_d, 80, FLOWER_PROPS, SubTileEdelweiss::new);
    public static final Block edelweissFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileEdelweiss::new);
    public static final Block sunbless = new BlockSpecialFlower(Effects.field_188425_z, 1600, FLOWER_PROPS, SubTileSunBless::new);
    public static final Block sunblessFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileSunBless::new);
    public static final Block moonbless = new BlockSpecialFlower(Effects.field_189112_A, 1600, FLOWER_PROPS, SubTileMoonBless::new);
    public static final Block moonblessFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileMoonBless::new);
    public static final Block geminiorchid = new BlockSpecialFlower(Effects.field_188423_x, 1600, FLOWER_PROPS, SubTileGeminiOrchid::new);
    public static final Block geminiorchidFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileGeminiOrchid::new);
    public static final Block tinkleflower = new BlockSpecialFlower(Effects.field_76422_e, 360, FLOWER_PROPS, SubTileTinkleFlower::new);
    public static final Block tinkleflowerFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileTinkleFlower::new);
    public static final Block omniviolet = new BlockSpecialFlower(Effects.field_76428_l, 360, FLOWER_PROPS, SubTileOmniViolet::new);
    public static final Block omnivioletFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileOmniViolet::new);
    public static final Block reikarlily = new BlockSpecialFlower(Effects.field_76430_j, 1600, FLOWER_PROPS, SubTileReikarLily::new);
    public static final Block reikarlilyFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileReikarLily::new);
    public static final Block annoyingflower = new BlockSpecialFlower(Effects.field_76438_s, 360, FLOWER_PROPS, SubTileAnnoyingFlower::new);
    public static final Block annoyingflowerFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileAnnoyingFlower::new);
    public static final Block bloodyenchantress = new BlockSpecialFlower(Effects.field_82731_v, 360, FLOWER_PROPS, SubTileBloodyEnchantress::new);
    public static final Block bloodyenchantressFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileBloodyEnchantress::new);
    public static final Block serenitian = new BlockSpecialFlower(Effects.field_220310_F, 360, FLOWER_PROPS, SubTileSerenitian::new);
    public static final Block serenitianFloating = new BlockFloatingSpecialFlower(FLOATING_PROPS, SubTileSerenitian::new);
    public static final TileEntityType<SubTileBellFlower> BELL_FLOWER = TileEntityType.Builder.func_223042_a(SubTileBellFlower::new, (Block[])new Block[]{bellflower, bellflowerFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileEdelweiss> EDELWEISS = TileEntityType.Builder.func_223042_a(SubTileEdelweiss::new, (Block[])new Block[]{edelweiss, edelweissFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileSunBless> SUNBLESS = TileEntityType.Builder.func_223042_a(SubTileSunBless::new, (Block[])new Block[]{sunbless, sunblessFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileMoonBless> MOONBLESS = TileEntityType.Builder.func_223042_a(SubTileMoonBless::new, (Block[])new Block[]{moonbless, moonblessFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileGeminiOrchid> GEMINIORCHID = TileEntityType.Builder.func_223042_a(SubTileGeminiOrchid::new, (Block[])new Block[]{geminiorchid, geminiorchidFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileTinkleFlower> TINKLEFLOWER = TileEntityType.Builder.func_223042_a(SubTileTinkleFlower::new, (Block[])new Block[]{tinkleflower, tinkleflowerFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileOmniViolet> OMNIVIOLET = TileEntityType.Builder.func_223042_a(SubTileOmniViolet::new, (Block[])new Block[]{omniviolet, omnivioletFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileReikarLily> REIKARLILY = TileEntityType.Builder.func_223042_a(SubTileReikarLily::new, (Block[])new Block[]{reikarlily, reikarlilyFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileAnnoyingFlower> ANNOYING_FLOWER = TileEntityType.Builder.func_223042_a(SubTileAnnoyingFlower::new, (Block[])new Block[]{annoyingflower, annoyingflowerFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileBloodyEnchantress> BLOODY_ENCHANTRESS = TileEntityType.Builder.func_223042_a(SubTileBloodyEnchantress::new, (Block[])new Block[]{bloodyenchantress, bloodyenchantressFloating}).func_206865_a(null);
    public static final TileEntityType<SubTileSerenitian> SERENITIAN = TileEntityType.Builder.func_223042_a(SubTileSerenitian::new, (Block[])new Block[]{serenitian, serenitianFloating}).func_206865_a(null);

    private static ResourceLocation floating(ResourceLocation orig) {
        return new ResourceLocation(orig.func_110624_b(), "floating_" + orig.func_110623_a());
    }

    private static ResourceLocation chibi(ResourceLocation orig) {
        return new ResourceLocation(orig.func_110624_b(), orig.func_110623_a() + "_chibi");
    }

    private static ResourceLocation getId(Block b) {
        return Registry.field_212618_g.func_177774_c((Object)b);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_BELLFLOWER, bellflower, bellflowerFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_EDELWEISS, edelweiss, edelweissFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_SUNBLESS, sunbless, sunblessFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_MOONBLESS, moonbless, moonblessFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_GEMINIORCHID, geminiorchid, geminiorchidFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_TINKLEFLOWER, tinkleflower, tinkleflowerFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_OMNIVIOLET, omniviolet, omnivioletFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_REIKARLILY, reikarlily, reikarlilyFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.FUNCTIONAL_ANNOYINGFLOWER, annoyingflower, annoyingflowerFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.GENERATING_BLOODYENCHANTRESS, bloodyenchantress, bloodyenchantressFloating);
        ModSubtiles.registerPair((IForgeRegistry<Block>)r, LibBlockNames.FUNCTIONAL_SERENITIAN, serenitian, serenitianFloating);
    }

    public static void registerPair(IForgeRegistry<Block> r, ResourceLocation name, Block flower, Block floating) {
        ModSubtiles.register(r, name, flower);
        ModSubtiles.register(r, ModSubtiles.floating(name), floating);
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, bellflower, bellflowerFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, edelweiss, edelweissFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, sunbless, sunblessFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, moonbless, moonblessFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, geminiorchid, geminiorchidFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, tinkleflower, tinkleflowerFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, omniviolet, omnivioletFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, reikarlily, reikarlilyFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, annoyingflower, annoyingflowerFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, bloodyenchantress, bloodyenchantressFloating);
        ModSubtiles.registerPairItemBlocks((IForgeRegistry<Item>)r, serenitian, serenitianFloating);
    }

    public static void registerPairItemBlocks(IForgeRegistry<Item> r, Block flower, Block floating) {
        Item.Properties props = ModItems.defaultBuilder();
        ModSubtiles.register(r, ModSubtiles.getId(flower), new ItemBlockSpecialFlower(flower, props));
        ModSubtiles.register(r, ModSubtiles.getId(floating), new ItemBlockSpecialFlower(floating, props));
    }

    public static void registerTEs(RegistryEvent.Register<TileEntityType<?>> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModSubtiles.register(r, ModSubtiles.getId(bellflower), BELL_FLOWER);
        ModSubtiles.register(r, ModSubtiles.getId(edelweiss), EDELWEISS);
        ModSubtiles.register(r, ModSubtiles.getId(sunbless), SUNBLESS);
        ModSubtiles.register(r, ModSubtiles.getId(moonbless), MOONBLESS);
        ModSubtiles.register(r, ModSubtiles.getId(geminiorchid), GEMINIORCHID);
        ModSubtiles.register(r, ModSubtiles.getId(tinkleflower), TINKLEFLOWER);
        ModSubtiles.register(r, ModSubtiles.getId(omniviolet), OMNIVIOLET);
        ModSubtiles.register(r, ModSubtiles.getId(reikarlily), REIKARLILY);
        ModSubtiles.register(r, ModSubtiles.getId(annoyingflower), ANNOYING_FLOWER);
        ModSubtiles.register(r, ModSubtiles.getId(bloodyenchantress), BLOODY_ENCHANTRESS);
        ModSubtiles.register(r, ModSubtiles.getId(serenitian), SERENITIAN);
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register((IForgeRegistryEntry)thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        ModSubtiles.register(reg, new ResourceLocation("extrabotany", name), thing);
    }
}
