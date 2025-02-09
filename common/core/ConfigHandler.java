/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.ForgeConfigSpec
 *  net.minecraftforge.common.ForgeConfigSpec$BooleanValue
 *  net.minecraftforge.common.ForgeConfigSpec$Builder
 *  org.apache.commons.lang3.tuple.Pair
 */
package com.meteor.extrabotany.common.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHandler {
    public static final Client CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        Pair specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = (ForgeConfigSpec)specPair.getRight();
        CLIENT = (Client)specPair.getLeft();
        specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = (ForgeConfigSpec)specPair.getRight();
        COMMON = (Common)specPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue disableDisarm;
        public final ForgeConfigSpec.BooleanValue disableAdvancementCheck;
        public final ForgeConfigSpec.BooleanValue disableLimit;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("common");
            this.disableDisarm = builder.comment("Whether to disable the Ego's disarm. Default is false.").define("disableDisarm", false);
            this.disableAdvancementCheck = builder.comment("Whether to disable the Relic's Advancement Check. Default is false.").define("disableAdvancementCheck", false);
            this.disableLimit = builder.comment("Whether to disable the Ego's Limit of Number of Player. Default is false.").define("disableLimit", false);
            builder.pop();
        }
    }

    public static class Client {
        public final ForgeConfigSpec.BooleanValue disablelogInfo;

        public Client(ForgeConfigSpec.Builder builder) {
            builder.push("client");
            this.disablelogInfo = builder.comment("Whether to disable the spam in the logs. Default is false.").define("disableLogSpam", false);
            builder.pop();
        }
    }
}
