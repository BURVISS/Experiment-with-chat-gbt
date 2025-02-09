/*
 * Decompiled with CFR 0.152.
 */
package com.meteor.extrabotany.common.entities;

public static enum EntityJudahOath.Type {
    JUDAH(0, "judah"),
    KIRA(1, "kira"),
    SAKURA(2, "sakura");

    private final String name;
    private final int metadata;

    private EntityJudahOath.Type(int metadataIn, String nameIn) {
        this.name = nameIn;
        this.metadata = metadataIn;
    }

    public String getName() {
        return this.name;
    }

    public int getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return this.name;
    }

    public static EntityJudahOath.Type byId(int id) {
        if (id < 0 || id >= EntityJudahOath.Type.values().length) {
            id = 0;
        }
        return EntityJudahOath.Type.values()[id];
    }

    public static EntityJudahOath.Type getTypeFromString(String nameIn) {
        for (int i = 0; i < EntityJudahOath.Type.values().length; ++i) {
            if (!EntityJudahOath.Type.values()[i].getName().equals(nameIn)) continue;
            return EntityJudahOath.Type.values()[i];
        }
        return EntityJudahOath.Type.values()[0];
    }
}
