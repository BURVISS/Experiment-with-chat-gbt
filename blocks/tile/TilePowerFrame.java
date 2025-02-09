/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.tileentity.ITickableTileEntity
 *  net.minecraft.tileentity.TileEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.Hand
 *  net.minecraft.util.LazyValue
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3i
 *  vazkii.botania.api.internal.VanillaPacketDispatcher
 *  vazkii.botania.api.mana.IManaItem
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.block.ModBlocks
 *  vazkii.botania.common.block.tile.TileSimpleInventory
 *  vazkii.botania.common.block.tile.mana.TilePool
 *  vazkii.botania.common.core.helper.Vector3
 *  vazkii.patchouli.api.IMultiblock
 *  vazkii.patchouli.api.PatchouliAPI
 */
package com.meteor.extrabotany.common.blocks.tile;

import com.meteor.extrabotany.client.handler.ClientTickHandler;
import com.meteor.extrabotany.common.blocks.ModBlocks;
import com.meteor.extrabotany.common.blocks.tile.ModTiles;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemNatureOrb;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.LazyValue;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import vazkii.botania.api.internal.VanillaPacketDispatcher;
import vazkii.botania.api.mana.IManaItem;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.block.tile.TileSimpleInventory;
import vazkii.botania.common.block.tile.mana.TilePool;
import vazkii.botania.common.core.helper.Vector3;
import vazkii.patchouli.api.IMultiblock;
import vazkii.patchouli.api.PatchouliAPI;

public class TilePowerFrame
extends TileSimpleInventory
implements ITickableTileEntity {
    public static final int TRANSFER_SPEED = 1000;
    private static final String[][] PATTERN_ADV = new String[][]{{"P_____P", "_______", "_______", "_______", "_______", "_______", "P_____P"}, {"M_____M", "_______", "_______", "___0___", "_______", "_______", "M_____M"}};
    public static final LazyValue<IMultiblock> MULTIBLOCK_ADV = new LazyValue(() -> PatchouliAPI.get().makeMultiblock(PATTERN_ADV, new Object[]{Character.valueOf('P'), vazkii.botania.common.block.ModBlocks.naturaPylon, Character.valueOf('0'), ModBlocks.powerframe, Character.valueOf('M'), vazkii.botania.common.block.ModBlocks.manaPool}));
    public static final BlockPos[] POOL_LOCATIONS = new BlockPos[]{new BlockPos(3, 0, 3), new BlockPos(-3, 0, 3), new BlockPos(3, 0, -3), new BlockPos(-3, 0, -3)};

    public TilePowerFrame() {
        super(ModTiles.POWER_FRAME);
    }

    protected Inventory createItemHandler() {
        return new Inventory(1){

            public int func_70297_j_() {
                return 1;
            }

            public boolean func_94041_b(int slot, ItemStack stack) {
                return stack.func_77973_b() instanceof IManaItem || stack.func_77973_b() == ModItems.natureorb;
            }
        };
    }

    public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
        if (!(stack.func_77973_b() instanceof IManaItem) && stack.func_77973_b() != ModItems.natureorb) {
            return false;
        }
        boolean did = false;
        if (this.getItemHandler().func_70301_a(0).func_190926_b()) {
            did = true;
            ItemStack stackToAdd = stack.func_77946_l();
            stackToAdd.func_190920_e(1);
            this.getItemHandler().func_70299_a(0, stackToAdd);
            if (player == null || !player.field_71075_bZ.field_75098_d) {
                stack.func_190918_g(1);
            }
        }
        if (did) {
            VanillaPacketDispatcher.dispatchTEToNearbyPlayers((TileEntity)this);
        }
        return true;
    }

    public void func_73660_a() {
        int ritual;
        boolean transfering;
        block11: {
            int current;
            ItemStack stack;
            block12: {
                int space;
                int manaToGet;
                TilePool p;
                IManaItem item;
                int speed;
                block13: {
                    int redstoneSignal = 0;
                    for (Direction dir : Direction.values()) {
                        int redstoneSide = this.func_145831_w().func_175651_c(this.func_174877_v().func_177972_a(dir), dir);
                        redstoneSignal = Math.max(redstoneSignal, redstoneSide);
                    }
                    transfering = false;
                    ritual = 0;
                    if (((IMultiblock)MULTIBLOCK_ADV.func_179281_c()).validate(this.field_145850_b, this.func_174877_v()) != null) {
                        ritual = 1;
                    }
                    speed = 1000 * (1 + ritual);
                    stack = this.getItemHandler().func_70301_a(0);
                    if (stack.func_190926_b()) break block11;
                    if (!(stack.func_77973_b() instanceof IManaItem)) break block12;
                    item = (IManaItem)stack.func_77973_b();
                    if (!(this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0)) instanceof TilePool)) break block11;
                    p = (TilePool)this.field_145850_b.func_175625_s(this.field_174879_c.func_177982_a(0, 1, 0));
                    if (redstoneSignal != 0) break block13;
                    manaToGet = Math.min(speed, p.getCurrentMana());
                    space = Math.max(0, item.getMaxMana(stack) - item.getMana(stack));
                    current = Math.min(space, manaToGet);
                    if (!this.field_145850_b.field_72995_K) {
                        p.receiveMana(-current);
                        item.addMana(stack, current);
                    }
                    if (current > 0) {
                        transfering = true;
                    }
                    break block11;
                }
                manaToGet = Math.min(speed, item.getMana(stack));
                space = Math.max(0, p.manaCap - p.getCurrentMana());
                current = Math.min(space, manaToGet);
                if (!this.field_145850_b.field_72995_K) {
                    p.receiveMana(current);
                    item.addMana(stack, -current);
                }
                if (current <= 0) break block11;
                transfering = true;
                break block11;
            }
            if (stack.func_77973_b() == ModItems.natureorb && ritual > 0) {
                int xp = (int)Math.pow(4.0, ritual);
                ItemNatureOrb orb = (ItemNatureOrb)stack.func_77973_b();
                if (!this.field_145850_b.field_72995_K) {
                    orb.addXP(stack, xp);
                }
                if (orb.getXP(stack) < orb.getMaxXP(stack)) {
                    transfering = true;
                }
                BlockPos[] blockPosArray = POOL_LOCATIONS;
                int n = blockPosArray.length;
                for (current = 0; current < n; ++current) {
                    TilePool pool;
                    BlockPos offset = blockPosArray[current];
                    TileEntity tile = this.field_145850_b.func_175625_s(this.field_174879_c.func_177971_a((Vector3i)offset));
                    if (!(tile instanceof TilePool) || (pool = (TilePool)tile).getCurrentMana() < 10) continue;
                    pool.receiveMana(-10);
                    orb.addXP(stack, 2);
                }
            }
        }
        if (this.field_145850_b.field_72995_K && ritual >= 1 && transfering) {
            Vector3 pos = Vector3.fromBlockPos((BlockPos)this.func_174877_v()).add(new Vector3(0.0, 0.5, 0.0));
            for (BlockPos arr : POOL_LOCATIONS) {
                Vector3 pylonPos = new Vector3((double)(this.func_174877_v().func_177958_n() + arr.func_177958_n()), (double)((float)(this.func_174877_v().func_177956_o() + arr.func_177956_o()) + 1.2f), (double)(this.func_174877_v().func_177952_p() + arr.func_177952_p()));
                double worldTime = ClientTickHandler.ticksInGame;
                float rad = 0.75f + (float)Math.random() * 0.05f;
                double xp = pylonPos.x + 0.5 + Math.cos(worldTime /= 5.0) * (double)rad;
                double zp = pylonPos.z + 0.5 + Math.sin(worldTime) * (double)rad;
                Vector3 partPos = new Vector3(xp, pylonPos.y, zp);
                Vector3 mot = pos.subtract(partPos).multiply(0.04);
                float r = (float)Math.random() * 0.3f;
                float g = 0.75f + (float)Math.random() * 0.2f;
                float b = (float)Math.random() * 0.3f;
                WispParticleData data = WispParticleData.wisp((float)(0.25f + (float)Math.random() * 0.1f), (float)r, (float)g, (float)b, (float)1.0f);
                this.field_145850_b.func_195594_a((IParticleData)data, partPos.x, partPos.y, partPos.z, 0.0, (double)(-(-0.075f - (float)Math.random() * 0.015f)), 0.0);
                WispParticleData data1 = WispParticleData.wisp((float)0.4f, (float)r, (float)g, (float)b);
                this.field_145850_b.func_195594_a((IParticleData)data1, partPos.x, partPos.y, partPos.z, (double)((float)mot.x), (double)((float)mot.y), (double)((float)mot.z));
            }
        }
    }

    @Nonnull
    public AxisAlignedBB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }
}
