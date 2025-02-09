/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.eventbus.api.IEventBus
 */
package com.meteor.extrabotany.common;

import com.meteor.extrabotany.common.core.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;

public class ServerProxy
implements IProxy {
    @Override
    public void registerHandlers() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    }
}
