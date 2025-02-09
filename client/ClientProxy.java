/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.FlowerBlock
 *  net.minecraft.block.TallFlowerBlock
 *  net.minecraft.client.GameSettings
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.player.AbstractClientPlayerEntity
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.RenderTypeLookup
 *  net.minecraft.client.renderer.entity.IEntityRenderer
 *  net.minecraft.client.renderer.entity.PlayerRenderer
 *  net.minecraft.client.renderer.entity.SpriteRenderer
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.client.renderer.entity.model.PlayerModel
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.client.util.InputMappings
 *  net.minecraft.item.IItemPropertyGetter
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemModelsProperties
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.registry.Registry
 *  net.minecraftforge.client.event.ModelRegistryEvent
 *  net.minecraftforge.client.settings.IKeyConflictContext
 *  net.minecraftforge.client.settings.KeyConflictContext
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.eventbus.api.IEventBus
 *  net.minecraftforge.fml.DeferredWorkQueue
 *  net.minecraftforge.fml.client.registry.ClientRegistry
 *  net.minecraftforge.fml.client.registry.RenderingRegistry
 *  net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
 *  net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent
 *  net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
 *  vazkii.botania.common.block.decor.BlockFloatingFlower
 *  vazkii.botania.common.block.decor.BlockModMushroom
 */
package com.meteor.extrabotany.client;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.client.LayerFlamescion;
import com.meteor.extrabotany.client.LayerHerrscher;
import com.meteor.extrabotany.client.handler.ClientTickHandler;
import com.meteor.extrabotany.client.handler.ColorHandler;
import com.meteor.extrabotany.client.handler.HUDHandler;
import com.meteor.extrabotany.client.handler.MiscellaneousIcons;
import com.meteor.extrabotany.client.handler.ModelHandler;
import com.meteor.extrabotany.client.renderer.entity.RenderButterflyProjectile;
import com.meteor.extrabotany.client.renderer.entity.RenderDummy;
import com.meteor.extrabotany.client.renderer.entity.RenderEGO;
import com.meteor.extrabotany.client.renderer.entity.RenderEGOBeam;
import com.meteor.extrabotany.client.renderer.entity.RenderEGOLandmine;
import com.meteor.extrabotany.client.renderer.entity.RenderFlamescionSlash;
import com.meteor.extrabotany.client.renderer.entity.RenderFlamescionSword;
import com.meteor.extrabotany.client.renderer.entity.RenderFlamescionUlt;
import com.meteor.extrabotany.client.renderer.entity.RenderFlamescionVoid;
import com.meteor.extrabotany.client.renderer.entity.RenderHerrscher;
import com.meteor.extrabotany.client.renderer.entity.RenderKeyOfTruth;
import com.meteor.extrabotany.client.renderer.entity.RenderMotor;
import com.meteor.extrabotany.client.renderer.entity.RenderPhantomSword;
import com.meteor.extrabotany.client.renderer.entity.RenderProjectileBase;
import com.meteor.extrabotany.client.renderer.entity.RenderSlash;
import com.meteor.extrabotany.client.renderer.entity.RenderStrengthenSlash;
import com.meteor.extrabotany.client.renderer.entity.RenderUfo;
import com.meteor.extrabotany.common.blocks.ModBlocks;
import com.meteor.extrabotany.common.core.IProxy;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.handler.MemeHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.brew.ItemBrewBase;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.settings.IKeyConflictContext;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vazkii.botania.common.block.decor.BlockFloatingFlower;
import vazkii.botania.common.block.decor.BlockModMushroom;

public class ClientProxy
implements IProxy {
    public static KeyBinding MOUNT_SUMMON;
    public static KeyBinding UFO_CATCH;
    public static KeyBinding BUDDHIST_SHIFT;

    public void registerModels(ModelRegistryEvent evt) {
    }

    private static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOTOR, RenderMotor::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.KEY_OF_TRUTH, RenderKeyOfTruth::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SLASH, RenderSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.UFO, RenderUfo::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PHANTOMSWORD, RenderPhantomSword::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FLAMESCIONSLASH, RenderFlamescionSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SRENGTHENSLASH, RenderStrengthenSlash::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ULT, RenderFlamescionUlt::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SWORD, RenderFlamescionSword::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.VOID, RenderFlamescionVoid::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EGO, RenderEGO::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EGOMINION, RenderEGO::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EGOLANDMINE, RenderEGOLandmine::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EGOBEAM, RenderEGOBeam::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HERRSCHER, RenderHerrscher::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MAGICARROW, RenderDummy::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.AURAFIRE, RenderDummy::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.INFLUXWAVER, RenderProjectileBase::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TRUETERRABLADE, RenderProjectileBase::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TRUESHADOWKATANA, RenderProjectileBase::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BUTTERFLY, RenderButterflyProjectile::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SPLASHGRENADE, renderManager -> new SpriteRenderer(renderManager, Minecraft.func_71410_x().func_175599_af()));
    }

    public void onClientSetUpEvent(FMLClientSetupEvent event) {
        Minecraft mc = Minecraft.func_71410_x();
        GameSettings gameSettings = mc.field_71474_y;
        ExtraBotany.keyForward = gameSettings.field_74351_w;
        ExtraBotany.keyBackward = gameSettings.field_74368_y;
        ExtraBotany.keyLeft = gameSettings.field_74370_x;
        ExtraBotany.keyRight = gameSettings.field_74366_z;
        ExtraBotany.keyUp = gameSettings.field_74314_A;
        ExtraBotany.keyFlight = gameSettings.field_151444_V;
        ClientProxy.registerRenderTypes();
        ClientProxy.registerEntityRenderers();
        event.enqueueWork(ClientProxy::registerPropertyGetters);
    }

    @Override
    public void registerHandlers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::onClientSetUpEvent);
        modBus.addListener(this::loadComplete);
        modBus.addListener(this::registerModels);
        modBus.addListener(MiscellaneousIcons.INSTANCE::onModelRegister);
        modBus.addListener(MiscellaneousIcons.INSTANCE::onModelBake);
        modBus.addListener(ModelHandler::registerModels);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(HUDHandler::onOverlayRender);
        forgeBus.addListener(ClientTickHandler::clientTickEnd);
        MOUNT_SUMMON = new KeyBinding("key.extrabotany_mount_summon", (IKeyConflictContext)KeyConflictContext.GUI, InputMappings.func_197954_a((int)82, (int)0), "extrabotany");
        ClientRegistry.registerKeyBinding((KeyBinding)MOUNT_SUMMON);
        UFO_CATCH = new KeyBinding("key.extrabotany_ufo_catch", (IKeyConflictContext)KeyConflictContext.GUI, InputMappings.func_197954_a((int)82, (int)0), "extrabotany");
        ClientRegistry.registerKeyBinding((KeyBinding)UFO_CATCH);
        BUDDHIST_SHIFT = new KeyBinding("key.extrabotany_buddhist_shift", (IKeyConflictContext)KeyConflictContext.GUI, InputMappings.func_197954_a((int)341, (int)0), "extrabotany");
        ClientRegistry.registerKeyBinding((KeyBinding)BUDDHIST_SHIFT);
    }

    private static void registerRenderTypes() {
        RenderTypeLookup.setRenderLayer((Block)ModBlocks.powerframe, (RenderType)RenderType.func_228643_e_());
        Registry.field_212618_g.func_201756_e().filter(b -> Registry.field_212618_g.func_177774_c(b).func_110624_b().equals("extrabotany")).forEach(b -> {
            if (b instanceof BlockFloatingFlower || b instanceof FlowerBlock || b instanceof TallFlowerBlock || b instanceof BlockModMushroom) {
                RenderTypeLookup.setRenderLayer((Block)b, (RenderType)RenderType.func_228643_e_());
            }
        });
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        DeferredWorkQueue.runLater(() -> {
            this.initAuxiliaryRender();
            ColorHandler.init();
            MemeHandler.spam();
        });
    }

    private static void registerPropertyGetter(IItemProvider item, ResourceLocation id, IItemPropertyGetter propGetter) {
        ItemModelsProperties.func_239418_a_((Item)item.func_199767_j(), (ResourceLocation)id, (IItemPropertyGetter)propGetter);
    }

    private static void registerPropertyGetters() {
        IItemPropertyGetter brewGetter = (stack, world, entity) -> {
            ItemBrewBase item = (ItemBrewBase)stack.func_77973_b();
            return item.getSwigs() - item.getSwigsLeft(stack);
        };
        ClientProxy.registerPropertyGetter((IItemProvider)ModItems.cocktail, ModItems.prefix("swigs_taken"), brewGetter);
        ClientProxy.registerPropertyGetter((IItemProvider)ModItems.infinitewine, ModItems.prefix("swigs_taken"), brewGetter);
    }

    private void initAuxiliaryRender() {
        Map skinMap = Minecraft.func_71410_x().func_175598_ae().getSkinMap();
        PlayerRenderer render = (PlayerRenderer)skinMap.get("default");
        render.func_177094_a((LayerRenderer)new LayerHerrscher((IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>)render));
        render.func_177094_a((LayerRenderer)new LayerFlamescion((IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>)render));
        render = (PlayerRenderer)skinMap.get("slim");
        render.func_177094_a((LayerRenderer)new LayerHerrscher((IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>)render));
        render.func_177094_a((LayerRenderer)new LayerFlamescion((IEntityRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>>)render));
    }
}
