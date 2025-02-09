/*
 * Decompiled with CFR 0.152.
 */
package com.meteor.extrabotany.common.items.bauble;

public static enum ItemBaubleCosmetic.Variant {
    FOX_EAR(true),
    FOX_MASK(true),
    PYLON(true),
    BLACK_GLASSES(true),
    RED_SCARF,
    SUPER_CROWN(true),
    THUG_LIFE(true),
    MASK(true);

    private final boolean isHead;

    private ItemBaubleCosmetic.Variant(boolean isHead) {
        this.isHead = isHead;
    }

    private ItemBaubleCosmetic.Variant() {
        this(false);
    }

    static /* synthetic */ boolean access$000(ItemBaubleCosmetic.Variant x0) {
        return x0.isHead;
    }
}
