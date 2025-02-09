/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.NonNullList
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  vazkii.botania.common.item.block.ItemBlockSpecialFlower
 */
package com.meteor.extrabotany.common;

import com.meteor.extrabotany.common.blocks.ModBlocks;
import com.meteor.extrabotany.common.blocks.ModSubtiles;
import com.meteor.extrabotany.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;

public final class ExtraBotanyGroup
extends ItemGroup {
    NonNullList<ItemStack> list;

    public ExtraBotanyGroup() {
        super("extrabotany");
        this.func_78014_h();
        this.func_78025_a("extrabotany.png");
    }

    public ItemStack func_78016_d() {
        return new ItemStack((IItemProvider)ModItems.pylon);
    }

    public boolean hasSearchBar() {
        return true;
    }

    @OnlyIn(value=Dist.CLIENT)
    public void func_78018_a(NonNullList<ItemStack> list) {
        this.list = list;
        this.addFlower(ModSubtiles.annoyingflower, ModSubtiles.annoyingflowerFloating);
        this.addFlower(ModSubtiles.serenitian, ModSubtiles.serenitianFloating);
        this.addFlower(ModSubtiles.bellflower, ModSubtiles.bellflowerFloating);
        this.addFlower(ModSubtiles.edelweiss, ModSubtiles.edelweissFloating);
        this.addFlower(ModSubtiles.geminiorchid, ModSubtiles.geminiorchidFloating);
        this.addFlower(ModSubtiles.sunbless, ModSubtiles.sunblessFloating);
        this.addFlower(ModSubtiles.moonbless, ModSubtiles.moonblessFloating);
        this.addFlower(ModSubtiles.omniviolet, ModSubtiles.omnivioletFloating);
        this.addFlower(ModSubtiles.reikarlily, ModSubtiles.reikarlilyFloating);
        this.addFlower(ModSubtiles.tinkleflower, ModSubtiles.tinkleflowerFloating);
        this.addBlock(ModBlocks.powerframe);
        this.addBlock(ModBlocks.manabuffer);
        this.addBlock(ModBlocks.dimensioncatalyst);
        this.addItem(ModItems.recordego);
        this.addItem(ModItems.recordherrscher);
        this.addItem(ModItems.lensmana);
        this.addItem(ModItems.lenspotion);
        this.addItem(ModItems.lenspush);
        this.addItem(ModItems.lenssmelt);
        this.addItem(ModItems.lenssupercondutor);
        this.addItem(ModItems.lenstrace);
        this.addItem(ModItems.gildedpotato);
        this.addItem(ModItems.gildedmashedpotato);
        this.addItem(ModItems.nightmarefuel);
        this.addItem(ModItems.spiritfuel);
        this.addItem(ModItems.spirit);
        this.addItem(ModItems.shadowium);
        this.addItem(ModItems.photonium);
        this.addItem(ModItems.aerialite);
        this.addItem(ModItems.goldcloth);
        this.addItem(ModItems.orichalcos);
        this.addItem(ModItems.heromedal);
        this.addItem(ModItems.universalpetal);
        this.addItem(ModItems.elementrune);
        this.addItem(ModItems.sinrune);
        this.addItem(ModItems.thechaos);
        this.addItem(ModItems.theorigin);
        this.addItem(ModItems.theend);
        this.addItem(ModItems.theuniverse);
        this.addItem(ModItems.aerostone);
        this.addItem(ModItems.earthstone);
        this.addItem(ModItems.aquastone);
        this.addItem(ModItems.ignisstone);
        this.addItem(ModItems.thecommunity);
        this.addItem(ModItems.peaceamulet);
        this.addItem(ModItems.powerglove);
        this.addItem(ModItems.froststar);
        this.addItem(ModItems.deathring);
        this.addItem(ModItems.manadrivering);
        this.addItem(ModItems.natureorb);
        this.addItem(ModItems.jingweifeather);
        this.addItem(ModItems.potatochips);
        this.addItem(ModItems.sunring);
        this.addItem(ModItems.moonpendant);
        this.addItem(ModItems.manareader);
        this.addItem(ModItems.walkingcane);
        this.addItem(ModItems.shadowkatana);
        this.addItem(ModItems.silverbullet);
        this.addItem(ModItems.rodofdiscord);
        this.addItem(ModItems.influxwaver);
        this.addItem(ModItems.starwrath);
        this.addItem(ModItems.trueshadowkatana);
        this.addItem(ModItems.trueterrablade);
        this.addItem(ModItems.challengeticket);
        this.addItem(ModItems.sagesmanaring);
        this.addItem(ModItems.excaliber);
        this.addItem(ModItems.failnaught);
        this.addItem(ModItems.camera);
        this.addItem(ModItems.coregod);
        this.addItem(ModItems.motor);
        this.addItem(ModItems.motoraccessory);
        this.addItem(ModItems.cosmiccarkey);
        this.addItem(ModItems.cosmiccarkeyaccessory);
        this.addItem(ModItems.gemofconquest);
        this.addItem(ModItems.flamescionweapon);
        this.addItem(ModItems.firstfractal);
        this.addItem(ModItems.buddhistrelics);
        this.addItem(ModItems.armor_miku_helm);
        this.addItem(ModItems.armor_miku_chest);
        this.addItem(ModItems.armor_miku_legs);
        this.addItem(ModItems.armor_miku_boots);
        this.addItem(ModItems.armor_goblinslayer_helm);
        this.addItem(ModItems.armor_goblinslayer_chest);
        this.addItem(ModItems.armor_goblinslayer_legs);
        this.addItem(ModItems.armor_goblinslayer_boots);
        this.addItem(ModItems.armor_shadowwarrior_helm);
        this.addItem(ModItems.armor_shadowwarrior_chest);
        this.addItem(ModItems.armor_shadowwarrior_legs);
        this.addItem(ModItems.armor_shadowwarrior_boots);
        this.addItem(ModItems.armor_shootingguardian_helm);
        this.addItem(ModItems.armor_shootingguardian_chest);
        this.addItem(ModItems.armor_shootingguardian_legs);
        this.addItem(ModItems.armor_shootingguardian_boots);
        this.addItem(ModItems.armor_maid_helm);
        this.addItem(ModItems.armor_maid_chest);
        this.addItem(ModItems.armor_maid_legs);
        this.addItem(ModItems.armor_maid_boots);
        this.addItem(ModItems.foxear);
        this.addItem(ModItems.foxmask);
        this.addItem(ModItems.pylon);
        this.addItem(ModItems.blackglasses);
        this.addItem(ModItems.thuglife);
        this.addItem(ModItems.redscarf);
        this.addItem(ModItems.mask);
        this.addItem(ModItems.supercrown);
        this.addItem(ModItems.rewardbaga);
        this.addItem(ModItems.rewardbagb);
        this.addItem(ModItems.rewardbagc);
        this.addItem(ModItems.rewardbagd);
        this.addItem(ModItems.emptybottle);
        this.addItem(ModItems.manadrink);
        this.addItem(ModItems.cocktail);
        this.addItem(ModItems.splashgrenade);
        this.addItem(ModItems.infinitewine);
    }

    private void addFlower(Block flower, Block floating) {
        this.addItem((Item)new ItemBlockSpecialFlower(flower, ModItems.defaultBuilder()));
        this.addItem((Item)new ItemBlockSpecialFlower(floating, ModItems.defaultBuilder()));
    }

    private void addBlock(Block block) {
        new BlockItem(block, ModItems.defaultBuilder()).func_150895_a((ItemGroup)this, this.list);
    }

    private void addItem(Item item) {
        item.func_150895_a((ItemGroup)this, this.list);
    }
}
