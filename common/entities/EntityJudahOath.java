/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.ThrowableEntity
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities;

import com.meteor.extrabotany.common.entities.ModEntities;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityJudahOath
extends ThrowableEntity {
    private LivingEntity owner;
    private static final DataParameter<Float> ROTATION = EntityDataManager.func_187226_a(EntityJudahOath.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Float> DAMAGE = EntityDataManager.func_187226_a(EntityJudahOath.class, (IDataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Integer> TYPE = EntityDataManager.func_187226_a(EntityJudahOath.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Optional<UUID>> UUID = EntityDataManager.func_187226_a(EntityJudahOath.class, (IDataSerializer)DataSerializers.field_187203_m);

    public EntityJudahOath(EntityType<? extends EntityJudahOath> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityJudahOath(World worldIn, LivingEntity owner) {
        super(ModEntities.JUDAHOATH, worldIn);
        this.owner = owner;
        this.func_184224_h(true);
    }

    public void func_70088_a() {
        this.field_70180_af.func_187214_a(DAMAGE, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(ROTATION, (Object)Float.valueOf(0.0f));
        this.field_70180_af.func_187214_a(TYPE, (Object)Type.JUDAH.ordinal());
        this.field_70180_af.func_187214_a(UUID, Optional.empty());
    }

    public UUID getUUID() {
        return (UUID)((Optional)this.field_70180_af.func_187225_a(UUID)).get();
    }

    public void setUUID(UUID u) {
        this.field_70180_af.func_187227_b(UUID, Optional.ofNullable(u));
    }

    public void setType(Type raftType) {
        this.field_70180_af.func_187227_b(TYPE, (Object)raftType.ordinal());
    }

    public Type getJudahType() {
        return Type.byId((Integer)this.field_70180_af.func_187225_a(TYPE));
    }

    public float getDamage() {
        return ((Float)this.field_70180_af.func_187225_a(DAMAGE)).floatValue();
    }

    public void setDamage(float f) {
        this.field_70180_af.func_187227_b(DAMAGE, (Object)Float.valueOf(f));
    }

    public float getRotation() {
        return ((Float)this.field_70180_af.func_187225_a(ROTATION)).floatValue();
    }

    public void setRotation(float rot) {
        this.field_70180_af.func_187227_b(ROTATION, (Object)Float.valueOf(rot));
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    public static enum Type {
        JUDAH(0, "judah"),
        KIRA(1, "kira"),
        SAKURA(2, "sakura");

        private final String name;
        private final int metadata;

        private Type(int metadataIn, String nameIn) {
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

        public static Type byId(int id) {
            if (id < 0 || id >= Type.values().length) {
                id = 0;
            }
            return Type.values()[id];
        }

        public static Type getTypeFromString(String nameIn) {
            for (int i = 0; i < Type.values().length; ++i) {
                if (!Type.values()[i].getName().equals(nameIn)) continue;
                return Type.values()[i];
            }
            return Type.values()[0];
        }
    }

    public static enum Status {
        INAIR,
        STANDBY;

    }
}
