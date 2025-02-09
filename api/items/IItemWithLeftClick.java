/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 */
package com.meteor.extrabotany.api.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public interface IItemWithLeftClick {
    public void onLeftClick(PlayerEntity var1, Entity var2);
}
