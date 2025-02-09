/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.ForgeConfigSpec$BooleanValue
 *  net.minecraftforge.common.ForgeConfigSpec$Builder
 */
package com.meteor.extrabotany.common.core;

import net.minecraftforge.common.ForgeConfigSpec;

public static class ConfigHandler.Common {
    public final ForgeConfigSpec.BooleanValue disableDisarm;
    public final ForgeConfigSpec.BooleanValue disableAdvancementCheck;
    public final ForgeConfigSpec.BooleanValue disableLimit;

    public ConfigHandler.Common(ForgeConfigSpec.Builder builder) {
        builder.push("common");
        this.disableDisarm = builder.comment("Whether to disable the Ego's disarm. Default is false.").define("disableDisarm", false);
        this.disableAdvancementCheck = builder.comment("Whether to disable the Relic's Advancement Check. Default is false.").define("disableAdvancementCheck", false);
        this.disableLimit = builder.comment("Whether to disable the Ego's Limit of Number of Player. Default is false.").define("disableLimit", false);
        builder.pop();
    }
}
