/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 */
package com.meteor.extrabotany.common.core;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

public class Helper {
    public static Vector3d PosToVec(BlockPos pos) {
        return new Vector3d((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
    }
}
