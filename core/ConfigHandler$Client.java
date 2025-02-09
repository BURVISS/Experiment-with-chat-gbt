/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.ForgeConfigSpec$BooleanValue
 *  net.minecraftforge.common.ForgeConfigSpec$Builder
 */
package com.meteor.extrabotany.common.core;

import net.minecraftforge.common.ForgeConfigSpec;

public static class ConfigHandler.Client {
    public final ForgeConfigSpec.BooleanValue disablelogInfo;

    public ConfigHandler.Client(ForgeConfigSpec.Builder builder) {
        builder.push("client");
        this.disablelogInfo = builder.comment("Whether to disable the spam in the logs. Default is false.").define("disableLogSpam", false);
        builder.pop();
    }
}
