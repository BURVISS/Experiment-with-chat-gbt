/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.spongepowered.asm.mixin.Mixins
 *  org.spongepowered.asm.mixin.connect.IMixinConnector
 */
package com.meteor.extrabotany.common;

import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;

public class MixinConnector
implements IMixinConnector {
    public void connect() {
        Mixins.addConfigurations((String[])new String[]{"assets/extrabotany/extrabotany.mixins.json"});
    }
}
