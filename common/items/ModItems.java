/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.inventory.EquipmentSlotType
 *  net.minecraft.item.Food
 *  net.minecraft.item.Food$Builder
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.Rarity
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.Effects
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.event.RegistryEvent$Register
 *  net.minecraftforge.registries.IForgeRegistry
 *  net.minecraftforge.registries.IForgeRegistryEntry
 *  vazkii.botania.api.BotaniaAPI
 *  vazkii.botania.common.item.ModItems
 *  vazkii.botania.common.item.record.ItemModRecord
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.api.items.WeightCategory;
import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.crafting.recipe.CocktailRecipe;
import com.meteor.extrabotany.common.crafting.recipe.GoldClothRecipe;
import com.meteor.extrabotany.common.crafting.recipe.HolyGrenadeRecipe;
import com.meteor.extrabotany.common.crafting.recipe.InfiniteWineChangeRecipe;
import com.meteor.extrabotany.common.crafting.recipe.InfiniteWineRecipe;
import com.meteor.extrabotany.common.crafting.recipe.LensPotionRecipe;
import com.meteor.extrabotany.common.crafting.recipe.RelicUpgradeRecipe;
import com.meteor.extrabotany.common.crafting.recipe.RelicUpgradeShapedRecipe;
import com.meteor.extrabotany.common.crafting.recipe.SilverBulletRemoveLensRecipe;
import com.meteor.extrabotany.common.items.ItemChallengeTicket;
import com.meteor.extrabotany.common.items.ItemCosmicCarKey;
import com.meteor.extrabotany.common.items.ItemEmptyBottle;
import com.meteor.extrabotany.common.items.ItemFlamescionWeapon;
import com.meteor.extrabotany.common.items.ItemFriggaApple;
import com.meteor.extrabotany.common.items.ItemGemOfConquest;
import com.meteor.extrabotany.common.items.ItemManaDrink;
import com.meteor.extrabotany.common.items.ItemManaReader;
import com.meteor.extrabotany.common.items.ItemMotor;
import com.meteor.extrabotany.common.items.ItemNightmareFuel;
import com.meteor.extrabotany.common.items.ItemRewardBag;
import com.meteor.extrabotany.common.items.ItemRewardBagLimitedEdition;
import com.meteor.extrabotany.common.items.ItemRodOfDiscord;
import com.meteor.extrabotany.common.items.ItemShadowKatana;
import com.meteor.extrabotany.common.items.ItemSilverBullet;
import com.meteor.extrabotany.common.items.ItemSpearSubspace;
import com.meteor.extrabotany.common.items.ItemSpiritFuel;
import com.meteor.extrabotany.common.items.ItemTreasureBox;
import com.meteor.extrabotany.common.items.ItemUUZFan;
import com.meteor.extrabotany.common.items.ItemWalkingCane;
import com.meteor.extrabotany.common.items.armor.goblinslayer.ItemGoblinSlayerArmor;
import com.meteor.extrabotany.common.items.armor.maid.ItemMaidArmor;
import com.meteor.extrabotany.common.items.armor.maid.ItemMaidHelm;
import com.meteor.extrabotany.common.items.armor.miku.ItemMikuArmor;
import com.meteor.extrabotany.common.items.armor.shadowwarrior.ItemShadowWarriorArmor;
import com.meteor.extrabotany.common.items.armor.shootingguardian.ItemShootingGuardianArmor;
import com.meteor.extrabotany.common.items.armor.shootingguardian.ItemShootingGuardianHelm;
import com.meteor.extrabotany.common.items.bauble.ItemAeroStone;
import com.meteor.extrabotany.common.items.bauble.ItemAquaStone;
import com.meteor.extrabotany.common.items.bauble.ItemBauble;
import com.meteor.extrabotany.common.items.bauble.ItemBaubleCosmetic;
import com.meteor.extrabotany.common.items.bauble.ItemCoreGod;
import com.meteor.extrabotany.common.items.bauble.ItemDeathRing;
import com.meteor.extrabotany.common.items.bauble.ItemEarthStone;
import com.meteor.extrabotany.common.items.bauble.ItemFrostStar;
import com.meteor.extrabotany.common.items.bauble.ItemIgnisStone;
import com.meteor.extrabotany.common.items.bauble.ItemJingweiFeather;
import com.meteor.extrabotany.common.items.bauble.ItemManaDriveRing;
import com.meteor.extrabotany.common.items.bauble.ItemMoonPendant;
import com.meteor.extrabotany.common.items.bauble.ItemNatureOrb;
import com.meteor.extrabotany.common.items.bauble.ItemPotatoChips;
import com.meteor.extrabotany.common.items.bauble.ItemPowerGlove;
import com.meteor.extrabotany.common.items.bauble.ItemSunRing;
import com.meteor.extrabotany.common.items.bauble.ItemTheCommunity;
import com.meteor.extrabotany.common.items.bauble.mount.ItemCosmicCarKeyAccessory;
import com.meteor.extrabotany.common.items.bauble.mount.ItemMotorAccessory;
import com.meteor.extrabotany.common.items.brew.ItemCocktail;
import com.meteor.extrabotany.common.items.brew.ItemInfiniteWine;
import com.meteor.extrabotany.common.items.brew.ItemSplashGrenade;
import com.meteor.extrabotany.common.items.lens.ItemLens;
import com.meteor.extrabotany.common.items.lens.LensMana;
import com.meteor.extrabotany.common.items.lens.LensPotion;
import com.meteor.extrabotany.common.items.lens.LensPush;
import com.meteor.extrabotany.common.items.lens.LensSmelt;
import com.meteor.extrabotany.common.items.lens.LensSuperconductor;
import com.meteor.extrabotany.common.items.lens.LensTrace;
import com.meteor.extrabotany.common.items.relic.ItemBuddhistrelics;
import com.meteor.extrabotany.common.items.relic.ItemCamera;
import com.meteor.extrabotany.common.items.relic.ItemExcaliber;
import com.meteor.extrabotany.common.items.relic.ItemFailnaught;
import com.meteor.extrabotany.common.items.relic.ItemFirstFractal;
import com.meteor.extrabotany.common.items.relic.ItemInfluxWaver;
import com.meteor.extrabotany.common.items.relic.ItemJudahOath;
import com.meteor.extrabotany.common.items.relic.ItemSagesManaRing;
import com.meteor.extrabotany.common.items.relic.ItemStarWrath;
import com.meteor.extrabotany.common.items.relic.ItemTrueShadowKatana;
import com.meteor.extrabotany.common.items.relic.ItemTrueTerrablade;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.record.ItemModRecord;

public class ModItems {
    public static final Food SPIRITFUEL_PROP = new Food.Builder().func_221456_a(4).func_221454_a(0.3f).func_221455_b().func_221452_a(new EffectInstance(Effects.field_76432_h, 1, 2), 1.0f).func_221452_a(new EffectInstance(Effects.field_76439_r, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_76424_c, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_188425_z, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_76420_g, 500), 1.0f).func_221453_d();
    public static final Food NIGHTMAREFUEL_PROP = new Food.Builder().func_221456_a(4).func_221454_a(0.3f).func_221455_b().func_221452_a(new EffectInstance(Effects.field_76433_i, 1, 2), 1.0f).func_221452_a(new EffectInstance(Effects.field_76440_q, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_76421_d, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_189112_A, 500), 1.0f).func_221452_a(new EffectInstance(Effects.field_76437_t, 500), 1.0f).func_221453_d();
    public static final Food GILDEDMASHEDPOTATO_PROP = new Food.Builder().func_221456_a(5).func_221454_a(0.2f).func_221455_b().func_221452_a(new EffectInstance(Effects.field_76429_m, 600, 3), 1.0f).func_221452_a(new EffectInstance(Effects.field_76421_d, 600, 3), 1.0f).func_221452_a(new EffectInstance(Effects.field_76444_x, 600, 1), 1.0f).func_221453_d();
    public static final Food MANADRINK_PROP = new Food.Builder().func_221456_a(0).func_221454_a(0.0f).func_221455_b().func_221452_a(new EffectInstance(Effects.field_76429_m, 1200, 0), 1.0f).func_221452_a(new EffectInstance(Effects.field_76424_c, 1200, 0), 1.0f).func_221452_a(new EffectInstance(Effects.field_76430_j, 1200, 0), 1.0f).func_221453_d();
    public static final Food FRIEDCHICKEN_PROP = new Food.Builder().func_221456_a(6).func_221454_a(0.5f).func_221453_d();
    public static final Food FRIGGA_APPLE_PROP = new Food.Builder().func_221456_a(20).func_221454_a(1.0f).func_221455_b().func_221452_a(new EffectInstance(Effects.field_76444_x, 2400, 4), 1.0f).func_221453_d();
    public static final Item spiritfuel = new ItemSpiritFuel(ModItems.defaultBuilder().func_221540_a(SPIRITFUEL_PROP));
    public static final Item nightmarefuel = new ItemNightmareFuel(ModItems.defaultBuilder().func_221540_a(NIGHTMAREFUEL_PROP));
    public static final Item friedchicken = new Item(ModItems.defaultBuilder().func_221540_a(FRIEDCHICKEN_PROP));
    public static final Item gildedmashedpotato = new Item(ModItems.defaultBuilder().func_221540_a(GILDEDMASHEDPOTATO_PROP));
    public static final Item friggaapple = new ItemFriggaApple(ModItems.defaultBuilder().func_221540_a(FRIGGA_APPLE_PROP));
    public static final Item motor = new ItemMotor();
    public static final Item gemofconquest = new ItemGemOfConquest();
    public static final Item firstfractal = new ItemFirstFractal();
    public static final Item cosmiccarkey = new ItemCosmicCarKey();
    public static final Item flamescionweapon = new ItemFlamescionWeapon();
    public static final Item silverbullet = new ItemSilverBullet(ModItems.unstackable());
    public static final Item walkingcane = new ItemWalkingCane(ModItems.unstackable());
    public static final Item manareader = new ItemManaReader(ModItems.unstackable());
    public static final Item shadowkatana = new ItemShadowKatana(ModItems.unstackable());
    public static final Item rodofdiscord = new ItemRodOfDiscord(ModItems.unstackable());
    public static final Item uuzfan = new ItemUUZFan(ModItems.unstackable());
    public static final Item peaceamulet = new ItemBauble(ModItems.unstackable());
    public static final Item aerostone = new ItemAeroStone(ModItems.unstackable());
    public static final Item earthstone = new ItemEarthStone(ModItems.unstackable());
    public static final Item aquastone = new ItemAquaStone(ModItems.unstackable());
    public static final Item ignisstone = new ItemIgnisStone(ModItems.unstackable());
    public static final Item thecommunity = new ItemTheCommunity(ModItems.unstackable());
    public static final Item froststar = new ItemFrostStar(ModItems.unstackable());
    public static final Item deathring = new ItemDeathRing(ModItems.unstackable());
    public static final Item manadrivering = new ItemManaDriveRing(ModItems.unstackable());
    public static final Item natureorb = new ItemNatureOrb(ModItems.unstackable());
    public static final Item powerglove = new ItemPowerGlove(ModItems.unstackable());
    public static final Item jingweifeather = new ItemJingweiFeather(ModItems.unstackable());
    public static final Item motoraccessory = new ItemMotorAccessory(ModItems.unstackable());
    public static final Item cosmiccarkeyaccessory = new ItemCosmicCarKeyAccessory(ModItems.unstackable());
    public static final Item sagesmanaring = new ItemSagesManaRing(ModItems.relic());
    public static final Item excaliber = new ItemExcaliber(ModItems.relic());
    public static final Item failnaught = new ItemFailnaught(ModItems.relic());
    public static final Item influxwaver = new ItemInfluxWaver(ModItems.relic());
    public static final Item trueterrablade = new ItemTrueTerrablade(ModItems.relic());
    public static final Item trueshadowkatana = new ItemTrueShadowKatana(ModItems.relic());
    public static final Item starwrath = new ItemStarWrath(ModItems.relic());
    public static final Item buddhistrelics = new ItemBuddhistrelics(ModItems.relic());
    public static final Item camera = new ItemCamera(ModItems.relic());
    public static final Item coregod = new ItemCoreGod(ModItems.relic());
    public static final Item sunring = new ItemSunRing(ModItems.relic());
    public static final Item moonpendant = new ItemMoonPendant(ModItems.relic());
    public static final Item potatochips = new ItemPotatoChips(ModItems.unstackable());
    public static final Item spearsubspace = new ItemSpearSubspace(ModItems.relic());
    public static final Item judahoath = new ItemJudahOath(ModItems.relic());
    public static final Item judahoathkira = new ItemJudahOath(ModItems.relic());
    public static final Item judahoathsakura = new ItemJudahOath(ModItems.relic());
    public static final Item spirit = new Item(ModItems.defaultBuilder());
    public static final Item orichalcos = new Item(ModItems.defaultBuilder());
    public static final Item gildedpotato = new Item(ModItems.defaultBuilder());
    public static final Item heromedal = new Item(ModItems.defaultBuilder());
    public static final Item shadowium = new Item(ModItems.defaultBuilder());
    public static final Item goldcloth = new Item(ModItems.defaultBuilder());
    public static final Item photonium = new Item(ModItems.defaultBuilder());
    public static final Item emptybottle = new ItemEmptyBottle(ModItems.defaultBuilder());
    public static final Item aerialite = new Item(ModItems.defaultBuilder());
    public static final Item thechaos = new Item(ModItems.defaultBuilder());
    public static final Item theorigin = new Item(ModItems.defaultBuilder());
    public static final Item theend = new Item(ModItems.defaultBuilder());
    public static final Item theuniverse = new Item(ModItems.defaultBuilder());
    public static final Item universalpetal = new Item(ModItems.defaultBuilder());
    public static final Item elementrune = new Item(ModItems.defaultBuilder());
    public static final Item sinrune = new Item(ModItems.defaultBuilder());
    public static final Item challengeticket = new ItemChallengeTicket(ModItems.defaultBuilder());
    public static final Item manadrink = new ItemManaDrink(ModItems.defaultBuilder().func_221540_a(MANADRINK_PROP));
    public static final Item cocktail = new ItemCocktail(ModItems.unstackable());
    public static final Item infinitewine = new ItemInfiniteWine(ModItems.unstackable());
    public static final Item splashgrenade = new ItemSplashGrenade(ModItems.defaultBuilder().func_200917_a(32));
    public static final Item lenssmelt = new ItemLens(ModItems.unstackable(), new LensSmelt(), 4);
    public static final Item lensmana = new ItemLens(ModItems.unstackable(), new LensMana(), 8);
    public static final Item lenstrace = new ItemLens(ModItems.unstackable(), new LensTrace(), 32);
    public static final Item lenspush = new ItemLens(ModItems.unstackable(), new LensPush(), 8);
    public static final Item lenspotion = new ItemLens(ModItems.unstackable(), new LensPotion(), 8);
    public static final Item lenssupercondutor = new ItemLens(ModItems.unstackable(), new LensSuperconductor(), 1);
    public static final Item foxear = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.FOX_EAR, ModItems.unstackable());
    public static final Item foxmask = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.FOX_MASK, ModItems.unstackable());
    public static final Item blackglasses = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.BLACK_GLASSES, ModItems.unstackable());
    public static final Item thuglife = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.THUG_LIFE, ModItems.unstackable());
    public static final Item redscarf = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.RED_SCARF, ModItems.unstackable());
    public static final Item supercrown = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.SUPER_CROWN, ModItems.unstackable());
    public static final Item pylon = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.PYLON, ModItems.unstackable());
    public static final Item mask = new ItemBaubleCosmetic(ItemBaubleCosmetic.Variant.MASK, ModItems.unstackable());
    public static final List<WeightCategory> categoryListA = new ArrayList<WeightCategory>();
    public static final List<WeightCategory> categoryListB = new ArrayList<WeightCategory>();
    public static final List<WeightCategory> categoryListC = new ArrayList<WeightCategory>();
    public static final List<WeightCategory> categoryListD = new ArrayList<WeightCategory>();
    public static final Item treasurebox = new ItemTreasureBox(ModItems.unstackable());
    public static final Item rewardbaga = new ItemRewardBag(ModItems.defaultBuilder(), categoryListA);
    public static final Item rewardbagb = new ItemRewardBag(ModItems.defaultBuilder(), categoryListB);
    public static final Item rewardbagc = new ItemRewardBag(ModItems.defaultBuilder(), categoryListC);
    public static final Item rewardbagd = new ItemRewardBag(ModItems.defaultBuilder(), categoryListD);
    public static final Item rewardbaglimitededition = new ItemRewardBagLimitedEdition(ModItems.defaultBuilder());
    public static final Item armor_maid_helm = new ItemMaidHelm(ModItems.unstackable());
    public static final Item armor_maid_chest = new ItemMaidArmor(EquipmentSlotType.CHEST, ModItems.unstackable());
    public static final Item armor_maid_legs = new ItemMaidArmor(EquipmentSlotType.LEGS, ModItems.unstackable());
    public static final Item armor_maid_boots = new ItemMaidArmor(EquipmentSlotType.FEET, ModItems.unstackable());
    public static final Item armor_miku_helm = new ItemMikuArmor(EquipmentSlotType.HEAD, ModItems.unstackable());
    public static final Item armor_miku_chest = new ItemMikuArmor(EquipmentSlotType.CHEST, ModItems.unstackable());
    public static final Item armor_miku_legs = new ItemMikuArmor(EquipmentSlotType.LEGS, ModItems.unstackable());
    public static final Item armor_miku_boots = new ItemMikuArmor(EquipmentSlotType.FEET, ModItems.unstackable());
    public static final Item armor_goblinslayer_helm = new ItemGoblinSlayerArmor(EquipmentSlotType.HEAD, ModItems.unstackable());
    public static final Item armor_goblinslayer_chest = new ItemGoblinSlayerArmor(EquipmentSlotType.CHEST, ModItems.unstackable());
    public static final Item armor_goblinslayer_legs = new ItemGoblinSlayerArmor(EquipmentSlotType.LEGS, ModItems.unstackable());
    public static final Item armor_goblinslayer_boots = new ItemGoblinSlayerArmor(EquipmentSlotType.FEET, ModItems.unstackable());
    public static final Item armor_shadowwarrior_helm = new ItemShadowWarriorArmor(EquipmentSlotType.HEAD, ModItems.unstackable());
    public static final Item armor_shadowwarrior_chest = new ItemShadowWarriorArmor(EquipmentSlotType.CHEST, ModItems.unstackable());
    public static final Item armor_shadowwarrior_legs = new ItemShadowWarriorArmor(EquipmentSlotType.LEGS, ModItems.unstackable());
    public static final Item armor_shadowwarrior_boots = new ItemShadowWarriorArmor(EquipmentSlotType.FEET, ModItems.unstackable());
    public static final Item armor_shootingguardian_helm = new ItemShootingGuardianHelm(ModItems.unstackable());
    public static final Item armor_shootingguardian_chest = new ItemShootingGuardianArmor(EquipmentSlotType.CHEST, ModItems.unstackable());
    public static final Item armor_shootingguardian_legs = new ItemShootingGuardianArmor(EquipmentSlotType.LEGS, ModItems.unstackable());
    public static final Item armor_shootingguardian_boots = new ItemShootingGuardianArmor(EquipmentSlotType.FEET, ModItems.unstackable());
    public static final Item recordego = new ItemModRecord(1, ModSounds.swordland, ModItems.unstackable().func_208103_a(Rarity.RARE));
    public static final Item recordherrscher = new ItemModRecord(1, ModSounds.salvation, ModItems.unstackable().func_208103_a(Rarity.RARE));

    public static Item.Properties defaultBuilder() {
        return new Item.Properties().func_200916_a(ExtraBotany.itemGroup);
    }

    private static Item.Properties unstackable() {
        return ModItems.defaultBuilder().func_200917_a(1);
    }

    private static Item.Properties relic() {
        return ModItems.unstackable().func_208103_a(BotaniaAPI.instance().getRelicRarity()).setNoRepair();
    }

    public static void registerItems(RegistryEvent.Register<Item> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModItems.register(r, "spiritfuel", spiritfuel);
        ModItems.register(r, "nightmarefuel", nightmarefuel);
        ModItems.register(r, "gildedmashedpotato", gildedmashedpotato);
        ModItems.register(r, "friedchicken", friedchicken);
        ModItems.register(r, "friggaapple", friggaapple);
        ModItems.register(r, "challengeticket", challengeticket);
        ModItems.register(r, "motor", motor);
        ModItems.register(r, "gemofconquest", gemofconquest);
        ModItems.register(r, "firstfractal", firstfractal);
        ModItems.register(r, "cosmiccarkey", cosmiccarkey);
        ModItems.register(r, "flamescionweapon", flamescionweapon);
        ModItems.register(r, "silverbullet", silverbullet);
        ModItems.register(r, "walkingcane", walkingcane);
        ModItems.register(r, "manareader", manareader);
        ModItems.register(r, "shadowkatana", shadowkatana);
        ModItems.register(r, "rodofdiscord", rodofdiscord);
        ModItems.register(r, "uuzfan", uuzfan);
        ModItems.register(r, "aerostone", aerostone);
        ModItems.register(r, "earthstone", earthstone);
        ModItems.register(r, "aquastone", aquastone);
        ModItems.register(r, "ignisstone", ignisstone);
        ModItems.register(r, "thecommunity", thecommunity);
        ModItems.register(r, "peaceamulet", peaceamulet);
        ModItems.register(r, "froststar", froststar);
        ModItems.register(r, "deathring", deathring);
        ModItems.register(r, "manadrivering", manadrivering);
        ModItems.register(r, "natureorb", natureorb);
        ModItems.register(r, "powerglove", powerglove);
        ModItems.register(r, "jingweifeather", jingweifeather);
        ModItems.register(r, "motoraccessory", motoraccessory);
        ModItems.register(r, "cosmiccarkeyaccessory", cosmiccarkeyaccessory);
        ModItems.register(r, "excaliber", excaliber);
        ModItems.register(r, "sagesmanaring", sagesmanaring);
        ModItems.register(r, "failnaught", failnaught);
        ModItems.register(r, "influxwaver", influxwaver);
        ModItems.register(r, "trueterrablade", trueterrablade);
        ModItems.register(r, "trueshadowkatana", trueshadowkatana);
        ModItems.register(r, "starwrath", starwrath);
        ModItems.register(r, "camera", camera);
        ModItems.register(r, "buddhistrelics", buddhistrelics);
        ModItems.register(r, "coregod", coregod);
        ModItems.register(r, "sunring", sunring);
        ModItems.register(r, "moonpendant", moonpendant);
        ModItems.register(r, "potatochips", potatochips);
        ModItems.register(r, "spearsubspace", spearsubspace);
        ModItems.register(r, "judahoath", judahoath);
        ModItems.register(r, "judahoathkira", judahoathkira);
        ModItems.register(r, "judahoathsakura", judahoathsakura);
        ModItems.register(r, "manadrink", manadrink);
        ModItems.register(r, "cocktail", cocktail);
        ModItems.register(r, "infinitewine", infinitewine);
        ModItems.register(r, "splashgrenade", splashgrenade);
        ModItems.register(r, "spirit", spirit);
        ModItems.register(r, "orichalcos", orichalcos);
        ModItems.register(r, "photonium", photonium);
        ModItems.register(r, "shadowium", shadowium);
        ModItems.register(r, "aerialite", aerialite);
        ModItems.register(r, "gildedpotato", gildedpotato);
        ModItems.register(r, "heromedal", heromedal);
        ModItems.register(r, "goldcloth", goldcloth);
        ModItems.register(r, "emptybottle", emptybottle);
        ModItems.register(r, "thechaos", thechaos);
        ModItems.register(r, "theorigin", theorigin);
        ModItems.register(r, "theend", theend);
        ModItems.register(r, "theuniverse", theuniverse);
        ModItems.register(r, "universalpetal", universalpetal);
        ModItems.register(r, "elementrune", elementrune);
        ModItems.register(r, "sinrune", sinrune);
        ModItems.register(r, "lens_mana", lensmana);
        ModItems.register(r, "lens_potion", lenspotion);
        ModItems.register(r, "lens_push", lenspush);
        ModItems.register(r, "lens_smelt", lenssmelt);
        ModItems.register(r, "lens_superconductor", lenssupercondutor);
        ModItems.register(r, "lens_trace", lenstrace);
        ModItems.register(r, "foxear", foxear);
        ModItems.register(r, "foxmask", foxmask);
        ModItems.register(r, "pylon", pylon);
        ModItems.register(r, "blackglasses", blackglasses);
        ModItems.register(r, "redscarf", redscarf);
        ModItems.register(r, "thuglife", thuglife);
        ModItems.register(r, "supercrown", supercrown);
        ModItems.register(r, "mask", mask);
        ModItems.register(r, "maid_helm", armor_maid_helm);
        ModItems.register(r, "maid_chest", armor_maid_chest);
        ModItems.register(r, "maid_legs", armor_maid_legs);
        ModItems.register(r, "maid_boots", armor_maid_boots);
        ModItems.register(r, "miku_helm", armor_miku_helm);
        ModItems.register(r, "miku_chest", armor_miku_chest);
        ModItems.register(r, "miku_legs", armor_miku_legs);
        ModItems.register(r, "miku_boots", armor_miku_boots);
        ModItems.register(r, "goblinslayer_helm", armor_goblinslayer_helm);
        ModItems.register(r, "goblinslayer_chest", armor_goblinslayer_chest);
        ModItems.register(r, "goblinslayer_legs", armor_goblinslayer_legs);
        ModItems.register(r, "goblinslayer_boots", armor_goblinslayer_boots);
        ModItems.register(r, "shadowwarrior_helm", armor_shadowwarrior_helm);
        ModItems.register(r, "shadowwarrior_chest", armor_shadowwarrior_chest);
        ModItems.register(r, "shadowwarrior_legs", armor_shadowwarrior_legs);
        ModItems.register(r, "shadowwarrior_boots", armor_shadowwarrior_boots);
        ModItems.register(r, "shootingguardian_helm", armor_shootingguardian_helm);
        ModItems.register(r, "shootingguardian_chest", armor_shootingguardian_chest);
        ModItems.register(r, "shootingguardian_legs", armor_shootingguardian_legs);
        ModItems.register(r, "shootingguardian_boots", armor_shootingguardian_boots);
        ModItems.register(r, "recordego", recordego);
        ModItems.register(r, "recordherrscher", recordherrscher);
        categoryListA.add(new WeightCategory(new ItemStack((IItemProvider)universalpetal, 4), 10));
        categoryListA.add(new WeightCategory(new ItemStack((IItemProvider)universalpetal, 8), 10));
        categoryListA.add(new WeightCategory(new ItemStack((IItemProvider)universalpetal, 6), 30));
        categoryListB.add(new WeightCategory(new ItemStack((IItemProvider)elementrune, 2), 80));
        categoryListB.add(new WeightCategory(new ItemStack((IItemProvider)sinrune, 1), 20));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.manaSteel, 4), 15));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.manaPearl, 4), 15));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.manaDiamond, 4), 15));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.elementium, 3), 11));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.pixieDust, 3), 11));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.dragonstone, 3), 11));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.manaPowder, 8), 10));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.terrasteel, 1), 9));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.lifeEssence, 4), 8));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.gaiaIngot, 1), 7));
        categoryListC.add(new WeightCategory(new ItemStack((IItemProvider)heromedal, 1), 1));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151044_h, 6), 40));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151042_j, 4), 36));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151043_k, 4), 24));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151137_ax, 8), 22));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151079_bi, 4), 20));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)Items.field_151045_i, 1), 18));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.blackerLotus, 2), 16));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)vazkii.botania.common.item.ModItems.overgrowthSeed, 1), 12));
        categoryListD.add(new WeightCategory(new ItemStack((IItemProvider)buddhistrelics), 1));
        ModItems.register(r, "treasurebox", treasurebox);
        ModItems.register(r, "rewardbaga", rewardbaga);
        ModItems.register(r, "rewardbagb", rewardbagb);
        ModItems.register(r, "rewardbagc", rewardbagc);
        ModItems.register(r, "rewardbagd", rewardbagd);
        ModItems.register(r, "rewardbaglimitededition", rewardbaglimitededition);
    }

    public static void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> evt) {
        IForgeRegistry r = evt.getRegistry();
        ModItems.register(r, "goldcloth", GoldClothRecipe.SERIALIZER);
        ModItems.register(r, "infinitewine_change", InfiniteWineChangeRecipe.SERIALIZER);
        ModItems.register(r, "holygrenade", HolyGrenadeRecipe.SERIALIZER);
        ModItems.register(r, "infinitewine", InfiniteWineRecipe.SERIALIZER);
        ModItems.register(r, "cocktail", CocktailRecipe.SERIALIZER);
        ModItems.register(r, "lenspotion", LensPotionRecipe.SERIALIZER);
        ModItems.register(r, "relicupgrade", RelicUpgradeRecipe.SERIALIZER);
        ModItems.register(r, "relicupgradeshaped", RelicUpgradeShapedRecipe.SERIALIZER);
        ModItems.register(r, "silverbulletremovelens", SilverBulletRemoveLensRecipe.SERIALIZER);
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, ResourceLocation name, IForgeRegistryEntry<V> thing) {
        reg.register((IForgeRegistryEntry)thing.setRegistryName(name));
    }

    public static <V extends IForgeRegistryEntry<V>> void register(IForgeRegistry<V> reg, String name, IForgeRegistryEntry<V> thing) {
        ModItems.register(reg, ModItems.prefix(name), thing);
    }

    public static ResourceLocation prefix(String path) {
        return new ResourceLocation("extrabotany", path);
    }
}
