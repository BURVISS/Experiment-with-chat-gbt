/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.data.IDataProvider
 *  net.minecraftforge.common.data.ExistingFileHelper
 *  net.minecraftforge.eventbus.api.SubscribeEvent
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber$Bus
 *  net.minecraftforge.fml.event.lifecycle.GatherDataEvent
 */
package com.meteor.extrabotany.data;

import com.meteor.extrabotany.data.BlockstateProvider;
import com.meteor.extrabotany.data.ItemModelProvider;
import com.meteor.extrabotany.data.recipes.BrewProvider;
import com.meteor.extrabotany.data.recipes.ManaInfusionProvider;
import com.meteor.extrabotany.data.recipes.RecipeProvider;
import com.meteor.extrabotany.data.recipes.RuneRecipeProvider;
import net.minecraft.data.IDataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid="extrabotany", bus=Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        ExistingFileHelper helper = evt.getExistingFileHelper();
        if (evt.includeServer()) {
            evt.getGenerator().func_200390_a((IDataProvider)new RecipeProvider(evt.getGenerator()));
            evt.getGenerator().func_200390_a((IDataProvider)new BrewProvider(evt.getGenerator()));
            evt.getGenerator().func_200390_a((IDataProvider)new ManaInfusionProvider(evt.getGenerator()));
            evt.getGenerator().func_200390_a((IDataProvider)new RuneRecipeProvider(evt.getGenerator()));
        }
        if (evt.includeClient()) {
            evt.getGenerator().func_200390_a((IDataProvider)new BlockstateProvider(evt.getGenerator(), helper));
            evt.getGenerator().func_200390_a((IDataProvider)new ItemModelProvider(evt.getGenerator(), helper));
        }
    }
}
