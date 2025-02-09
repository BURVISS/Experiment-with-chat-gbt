/*
 * Decompiled with CFR 0.152.
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import com.meteor.extrabotany.common.blocks.generating.SubTileSunBless;

public class SubTileMoonBless
extends SubTileSunBless {
    public SubTileMoonBless() {
        super(ModSubtiles.MOONBLESS);
    }

    @Override
    public int getColor() {
        return 0xFFFF00;
    }

    @Override
    public int getValueForPassiveGeneration() {
        return 1;
    }

    @Override
    public boolean canGeneratePassively() {
        return !this.func_145831_w().func_72935_r() && this.ticksExisted % 4 == 0;
    }
}
