/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.loot.LootContext
 *  net.minecraft.loot.LootContext$Builder
 *  net.minecraft.loot.LootParameterSets
 *  net.minecraft.loot.LootTables
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.server.ServerWorld
 *  vazkii.botania.api.item.IPetalApothecary$State
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityFunctionalFlower
 *  vazkii.botania.common.block.tile.TileAltar
 */
package com.meteor.extrabotany.common.blocks.functional;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import vazkii.botania.api.item.IPetalApothecary;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityFunctionalFlower;
import vazkii.botania.common.block.tile.TileAltar;

public class SubTileAnnoyingFlower
extends TileEntityFunctionalFlower {
    private static final int COST = 300;
    private static final int RANGE = 3;
    private static final String TAG_TIME = "times";
    int times = 0;

    public SubTileAnnoyingFlower() {
        super(ModSubtiles.ANNOYING_FLOWER);
    }

    public void tickFlower() {
        int cd;
        super.tickFlower();
        if (this.redstoneSignal > 0) {
            return;
        }
        boolean hasWater = false;
        block0: for (int x = -3; x <= 3; ++x) {
            for (int z = -3; z <= 3; ++z) {
                BlockPos posi = this.getEffectivePos().func_177982_a(x, 0, z);
                if (!(this.func_145831_w().func_175625_s(posi) instanceof TileAltar)) continue;
                TileAltar te = (TileAltar)this.func_145831_w().func_175625_s(posi);
                boolean bl = hasWater = te.getFluid() == IPetalApothecary.State.WATER;
                if (hasWater) continue block0;
            }
        }
        for (ItemEntity item : this.func_145831_w().func_217357_a(ItemEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-3, -3, -3), this.getEffectivePos().func_177982_a(4, 4, 4)))) {
            if (item.func_92059_d().func_77973_b() != Items.field_151077_bg || item.func_92059_d().func_190916_E() <= 0) continue;
            item.func_92059_d().func_190918_g(1);
            this.times += 3;
        }
        int n = cd = this.times > 0 ? 360 : 900;
        if (this.redstoneSignal == 0 && this.ticksExisted % cd == 0 && this.getMana() >= 300 && hasWater && !this.func_145831_w().field_72995_K) {
            List stacks;
            ItemStack stack;
            Random rand = this.func_145831_w().field_73012_v;
            do {
                LootContext ctx = new LootContext.Builder((ServerWorld)this.field_145850_b).func_216022_a(LootParameterSets.field_216260_a);
                stacks = ((ServerWorld)this.field_145850_b).func_73046_m().func_200249_aQ().func_186521_a(LootTables.field_186387_al).func_216113_a(ctx);
                if (this.times > 0) {
                    stacks = ((ServerWorld)this.field_145850_b).func_73046_m().func_200249_aQ().func_186521_a(LootTables.field_186389_an).func_216113_a(ctx);
                }
                if (stacks.isEmpty()) {
                    return;
                }
                Collections.shuffle(stacks);
            } while ((stack = (ItemStack)stacks.get(0)).func_190926_b());
            int bound = 7;
            ItemEntity entity = new ItemEntity(this.func_145831_w(), (double)(this.getEffectivePos().func_177958_n() - 3 + rand.nextInt(bound)), (double)(this.getEffectivePos().func_177956_o() + 2), (double)(this.getEffectivePos().func_177952_p() - 3 + rand.nextInt(bound)), stack);
            entity.func_213317_d(Vector3d.field_186680_a);
            if (!this.func_145831_w().field_72995_K) {
                this.func_145831_w().func_217376_c((Entity)entity);
            }
            this.addMana(-300);
            this.sync();
        }
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
        cmp.func_74768_a(TAG_TIME, this.times);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
        this.times = cmp.func_74762_e(TAG_TIME);
    }

    public int getColor() {
        return 0;
    }

    public int getMaxMana() {
        return 1000;
    }

    public boolean acceptsRedstone() {
        return true;
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 3);
    }
}
