/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicates
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.tileentity.ITickableTileEntity
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3i
 *  vazkii.botania.api.internal.VanillaPacketDispatcher
 *  vazkii.botania.api.mana.IManaReceiver
 *  vazkii.botania.api.mana.IThrottledPacket
 *  vazkii.botania.api.mana.spark.ISparkAttachable
 *  vazkii.botania.api.mana.spark.ISparkEntity
 *  vazkii.botania.common.block.tile.TileMod
 *  vazkii.botania.common.block.tile.mana.TilePool
 */
package com.meteor.extrabotany.common.blocks.tile;

import com.google.common.base.Predicates;
import com.meteor.extrabotany.common.blocks.tile.ModTiles;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import vazkii.botania.api.internal.VanillaPacketDispatcher;
import vazkii.botania.api.mana.IManaReceiver;
import vazkii.botania.api.mana.IThrottledPacket;
import vazkii.botania.api.mana.spark.ISparkAttachable;
import vazkii.botania.api.mana.spark.ISparkEntity;
import vazkii.botania.common.block.tile.TileMod;
import vazkii.botania.common.block.tile.mana.TilePool;

public class TileManaBuffer
extends TileMod
implements IManaReceiver,
ISparkAttachable,
ITickableTileEntity,
IThrottledPacket {
    private static final BlockPos[] POOL_LOCATIONS = new BlockPos[]{new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0), new BlockPos(0, 0, -1), new BlockPos(0, -1, 0)};
    public static final int MAX_MANA = 64000000;
    public static final int TRANSFER_SPEED = 1000;
    private static final String TAG_MANA = "mana";
    private int mana;
    private int ticks = 0;
    private boolean sendPacket = false;

    public TileManaBuffer() {
        super(ModTiles.MANA_BUFFER);
    }

    public void func_73660_a() {
        int space;
        int manaToGet;
        Object p;
        if (this.sendPacket && this.ticks % 10 == 0) {
            VanillaPacketDispatcher.dispatchTEToNearbyPlayers((TileEntity)this);
            this.sendPacket = false;
        }
        for (BlockPos o : POOL_LOCATIONS) {
            int current;
            int space2;
            int manaToGet2;
            Object p2;
            if (this.field_145850_b.func_175625_s(this.field_174879_c.func_177971_a((Vector3i)o)) instanceof TilePool) {
                p2 = (TilePool)this.field_145850_b.func_175625_s(this.field_174879_c.func_177971_a((Vector3i)o));
                manaToGet2 = Math.min(1000, p2.getCurrentMana());
                space2 = Math.max(0, 64000000 - this.getCurrentMana());
                current = Math.min(space2, manaToGet2);
                p2.receiveMana(-current);
                this.receiveMana(current);
                continue;
            }
            if (!(this.field_145850_b.func_175625_s(this.field_174879_c.func_177971_a((Vector3i)o)) instanceof TileManaBuffer)) continue;
            p2 = (TileManaBuffer)this.field_145850_b.func_175625_s(this.field_174879_c.func_177971_a((Vector3i)o));
            manaToGet2 = Math.min(1000, ((TileManaBuffer)((Object)p2)).getCurrentMana());
            space2 = Math.max(0, 64000000 - this.getCurrentMana());
            current = Math.min(space2, manaToGet2);
            ((TileManaBuffer)((Object)p2)).receiveMana(-current);
            this.receiveMana(current);
        }
        if (this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0)) instanceof TilePool) {
            p = (TilePool)this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0));
            manaToGet = Math.min(1000, this.getCurrentMana());
            space = Math.max(0, ((TilePool)p).manaCap - p.getCurrentMana());
            int current = Math.min(space, manaToGet);
            p.receiveMana(current);
            this.receiveMana(-current);
        } else if (this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0)) instanceof TileManaBuffer) {
            p = (TileManaBuffer)this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0));
            manaToGet = Math.min(1000, this.getCurrentMana());
            space = Math.max(0, 64000000 - ((TileManaBuffer)((Object)p)).getCurrentMana());
            int current = Math.min(space, manaToGet);
            ((TileManaBuffer)((Object)p)).receiveMana(current);
            this.receiveMana(-current);
        }
        ++this.ticks;
    }

    public void writePacketNBT(CompoundNBT cmp) {
        cmp.func_74768_a(TAG_MANA, this.mana);
    }

    public void readPacketNBT(CompoundNBT cmp) {
        this.mana = cmp.func_74762_e(TAG_MANA);
    }

    public boolean canAttachSpark(ItemStack stack) {
        return true;
    }

    public void attachSpark(ISparkEntity entity) {
    }

    public int getAvailableSpaceForMana() {
        int space = Math.max(0, 64000000 - this.getCurrentMana());
        if (space > 0) {
            return space;
        }
        return 0;
    }

    public ISparkEntity getAttachedSpark() {
        List sparks = this.field_145850_b.func_175647_a(Entity.class, new AxisAlignedBB(this.field_174879_c.func_177984_a(), this.field_174879_c.func_177984_a().func_177982_a(1, 1, 1)), (Predicate)Predicates.instanceOf(ISparkEntity.class));
        if (sparks.size() == 1) {
            Entity e = (Entity)sparks.get(0);
            return (ISparkEntity)e;
        }
        return null;
    }

    public boolean areIncomingTranfersDone() {
        return false;
    }

    public boolean isFull() {
        return this.getCurrentMana() >= 64000000;
    }

    public void receiveMana(int mana) {
        int old = this.mana;
        this.mana = Math.max(0, Math.min(this.getCurrentMana() + mana, 64000000));
        if (old != this.mana) {
            this.func_70296_d();
            this.markDispatchable();
        }
    }

    public boolean canReceiveManaFromBursts() {
        return true;
    }

    public int getCurrentMana() {
        return this.mana;
    }

    public void markDispatchable() {
        this.sendPacket = true;
    }
}
