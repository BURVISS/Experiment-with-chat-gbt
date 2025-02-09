/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.audio.TickableSound
 *  net.minecraft.util.SoundCategory
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 */
package com.meteor.extrabotany.common.entities.ego;

import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value=Dist.CLIENT)
private static class EntityEGO.EgoMusic
extends TickableSound {
    private final EntityEGO guardian;

    public EntityEGO.EgoMusic(EntityEGO guardian) {
        super(ModSounds.swordland, SoundCategory.RECORDS);
        this.guardian = guardian;
        this.field_147660_d = guardian.getSource().func_177958_n();
        this.field_147661_e = guardian.getSource().func_177956_o();
        this.field_147658_f = guardian.getSource().func_177952_p();
    }

    public void func_73660_a() {
        if (!this.guardian.func_70089_S()) {
            this.func_239509_o_();
        }
    }
}
