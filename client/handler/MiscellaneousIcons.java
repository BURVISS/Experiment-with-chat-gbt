/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.model.IBakedModel
 *  net.minecraft.client.renderer.model.RenderMaterial
 *  net.minecraft.client.renderer.texture.AtlasTexture
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.event.ModelBakeEvent
 *  net.minecraftforge.client.event.ModelRegistryEvent
 *  net.minecraftforge.client.model.ModelLoader
 *  vazkii.botania.mixin.AccessorModelBakery
 */
package com.meteor.extrabotany.client.handler;

import com.meteor.extrabotany.common.items.ModItems;
import java.util.Set;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import vazkii.botania.mixin.AccessorModelBakery;

public class MiscellaneousIcons {
    public static final MiscellaneousIcons INSTANCE = new MiscellaneousIcons();
    public final RenderMaterial dimensionCatalystOverlay = MiscellaneousIcons.mainAtlas("block/dimensioncatalyst");
    public final IBakedModel[] firstFractalWeaponModels = new IBakedModel[10];
    public final IBakedModel[] strengthenSlashModel = new IBakedModel[1];
    public final IBakedModel[] flamescionringModel = new IBakedModel[1];
    public final IBakedModel[] influxwaverprojectileModel = new IBakedModel[1];
    public final IBakedModel[] trueterrabladeprojectileModel = new IBakedModel[1];
    public final IBakedModel[] trueshadowkatanaprojectileModel = new IBakedModel[1];
    public final IBakedModel[] coregodWingsModel = new IBakedModel[4];
    public final IBakedModel[] coregodModel = new IBakedModel[1];
    public final IBakedModel[] butterflyprojectileModel = new IBakedModel[1];

    public void onModelRegister(ModelRegistryEvent evt) {
        int i;
        Set materials = AccessorModelBakery.getMaterials();
        materials.add(this.dimensionCatalystOverlay);
        for (i = 0; i < 10; ++i) {
            ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/sworddomain_" + i));
        }
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/strengthenslash"));
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/flamescionring"));
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/influxwaverprojectile"));
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/trueterrabladeprojectile"));
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/trueshadowkatanaprojectile"));
        for (i = 0; i < 4; ++i) {
            ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/wing_" + i));
        }
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/wing_coregod"));
        ModelLoader.addSpecialModel((ResourceLocation)new ResourceLocation("extrabotany", "icon/butterflyprojectile"));
    }

    public void onModelBake(ModelBakeEvent evt) {
        int i;
        for (i = 0; i < this.firstFractalWeaponModels.length; ++i) {
            this.firstFractalWeaponModels[i] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/sworddomain_" + i));
        }
        this.strengthenSlashModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/strengthenslash"));
        this.flamescionringModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/flamescionring"));
        this.influxwaverprojectileModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/influxwaverprojectile"));
        this.trueterrabladeprojectileModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/trueterrabladeprojectile"));
        this.trueshadowkatanaprojectileModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/trueshadowkatanaprojectile"));
        for (i = 0; i < this.coregodWingsModel.length; ++i) {
            this.coregodWingsModel[i] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/wing_" + i));
        }
        this.coregodModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/wing_coregod"));
        this.butterflyprojectileModel[0] = (IBakedModel)evt.getModelRegistry().get(new ResourceLocation("extrabotany", "icon/butterflyprojectile"));
    }

    private static RenderMaterial mainAtlas(String name) {
        return new RenderMaterial(AtlasTexture.field_110575_b, ModItems.prefix(name));
    }

    private MiscellaneousIcons() {
    }
}
