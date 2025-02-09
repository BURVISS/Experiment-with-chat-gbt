/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.MobEntity
 *  net.minecraft.entity.ai.attributes.AttributeModifierMap
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemGroup
 *  net.minecraft.item.crafting.IRecipeSerializer
 *  net.minecraft.potion.Effect
 *  net.minecraft.tileentity.TileEntityType
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.fml.DistExecutor
 *  net.minecraftforge.fml.ModList
 *  net.minecraftforge.fml.ModLoadingContext
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.config.ModConfig$Type
 *  net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
 *  net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  vazkii.botania.api.brew.Brew
 *  vazkii.patchouli.api.IMultiblock
 *  vazkii.patchouli.api.PatchouliAPI
 */
package com.meteor.extrabotany;

import com.meteor.extrabotany.client.ClientProxy;
import com.meteor.extrabotany.common.ExtraBotanyGroup;
import com.meteor.extrabotany.common.ServerProxy;
import com.meteor.extrabotany.common.blocks.ModBlocks;
import com.meteor.extrabotany.common.blocks.ModSubtiles;
import com.meteor.extrabotany.common.blocks.tile.ModTiles;
import com.meteor.extrabotany.common.blocks.tile.TilePowerFrame;
import com.meteor.extrabotany.common.capability.CapabilityHandler;
import com.meteor.extrabotany.common.core.ConfigHandler;
import com.meteor.extrabotany.common.core.EquipmentHandler;
import com.meteor.extrabotany.common.core.IProxy;
import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.ContributorListHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ModBrew;
import com.meteor.extrabotany.common.potions.ModPotions;
import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vazkii.botania.api.brew.Brew;
import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;

@Mod(value="extrabotany")
public class ExtraBotany {
    public static ItemGroup itemGroup = new ExtraBotanyGroup();
    public static IProxy proxy;
    public static boolean curiosLoaded;
    public static final Logger LOGGER;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyForward;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyBackward;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyLeft;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyRight;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyUp;
    @OnlyIn(value=Dist.CLIENT)
    public static KeyBinding keyFlight;

    public ExtraBotany() {
        proxy = (IProxy)DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
        proxy.registerHandlers();
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigHandler.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
        modBus.addGenericListener(EntityType.class, ModEntities::registerEntities);
        modBus.addGenericListener(SoundEvent.class, ModSounds::registerSounds);
        modBus.addGenericListener(IRecipeSerializer.class, ModItems::registerRecipeSerializers);
        modBus.addGenericListener(Brew.class, ModBrew::registerBrews);
        modBus.addGenericListener(Item.class, ModItems::registerItems);
        modBus.addGenericListener(Block.class, ModBlocks::registerBlocks);
        modBus.addGenericListener(Item.class, ModBlocks::registerItemBlocks);
        modBus.addGenericListener(Block.class, ModSubtiles::registerBlocks);
        modBus.addGenericListener(Item.class, ModSubtiles::registerItemBlocks);
        modBus.addGenericListener(TileEntityType.class, ModTiles::registerTiles);
        modBus.addGenericListener(TileEntityType.class, ModSubtiles::registerTEs);
        modBus.addGenericListener(Effect.class, ModPotions::registerPotions);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        curiosLoaded = ModList.get().isLoaded("curios");
        CapabilityHandler.register();
        EquipmentHandler.init();
        event.enqueueWork(() -> {
            ContributorListHandler.firstStart();
            GlobalEntityTypeAttributes.put(ModEntities.EGO, (AttributeModifierMap)MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, 0.55).func_233815_a_(Attributes.field_233818_a_, 600.0).func_233815_a_(Attributes.field_233820_c_, 1.0).func_233815_a_(Attributes.field_233826_i_, 20.0).func_233815_a_(Attributes.field_233819_b_, 35.0).func_233815_a_(Attributes.field_233823_f_, 8.0).func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntities.EGOMINION, (AttributeModifierMap)MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, 0.5).func_233815_a_(Attributes.field_233818_a_, 60.0).func_233815_a_(Attributes.field_233820_c_, 1.0).func_233815_a_(Attributes.field_233826_i_, 15.0).func_233815_a_(Attributes.field_233819_b_, 35.0).func_233815_a_(Attributes.field_233823_f_, 7.0).func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntities.HERRSCHER, (AttributeModifierMap)MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233821_d_, 0.55).func_233815_a_(Attributes.field_233818_a_, 600.0).func_233815_a_(Attributes.field_233820_c_, 1.0).func_233815_a_(Attributes.field_233826_i_, 20.0).func_233815_a_(Attributes.field_233819_b_, 35.0).func_233815_a_(Attributes.field_233823_f_, 8.0).func_233813_a_());
            PatchouliAPI.get().registerMultiblock(ModItems.prefix("frame_adv"), (IMultiblock)TilePowerFrame.MULTIBLOCK_ADV.func_179281_c());
        });
    }

    static {
        curiosLoaded = false;
        LOGGER = LogManager.getLogger((String)"extrabotany");
    }
}
