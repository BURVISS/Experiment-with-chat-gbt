/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 */
package com.meteor.extrabotany.common.core;

import com.mojang.authlib.GameProfile;

public interface IProxy {
    default public void registerHandlers() {
    }

    default public void preloadSkin(GameProfile customSkin) {
    }
}
