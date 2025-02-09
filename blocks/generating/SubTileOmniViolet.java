/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.IWorldReader
 *  net.minecraft.world.World
 *  vazkii.botania.api.subtile.RadiusDescriptor
 *  vazkii.botania.api.subtile.RadiusDescriptor$Square
 *  vazkii.botania.api.subtile.TileEntityGeneratingFlower
 *  vazkii.botania.common.core.handler.ModSounds
 */
package com.meteor.extrabotany.common.blocks.generating;

import com.meteor.extrabotany.common.blocks.ModSubtiles;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import vazkii.botania.api.subtile.RadiusDescriptor;
import vazkii.botania.api.subtile.TileEntityGeneratingFlower;
import vazkii.botania.common.core.handler.ModSounds;

public class SubTileOmniViolet
extends TileEntityGeneratingFlower {
    private static final String TAG_BURN_TIME = "burnTime";
    private static final int FUEL_CAP = 32000;
    private static final int RANGE = 2;
    int burnTime = 0;

    public SubTileOmniViolet() {
        super(ModSubtiles.OMNIVIOLET);
    }

    private float getPower(World world, BlockPos pos) {
        return world.func_180495_p(pos).getEnchantPowerBonus((IWorldReader)world, pos);
    }

    private float getPower() {
        float power = 0.0f;
        for (int k = -1; k <= 1; ++k) {
            for (int l = -1; l <= 1; ++l) {
                if (k == 0 && l == 0 || !this.func_145831_w().func_175623_d(this.getEffectivePos().func_177982_a(l, 0, k)) || !this.func_145831_w().func_175623_d(this.getEffectivePos().func_177982_a(l, 1, k))) continue;
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l * 2, 0, k * 2));
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l * 2, 1, k * 2));
                if (l == 0 || k == 0) continue;
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l * 2, 0, k));
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l * 2, 1, k));
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l, 0, k * 2));
                power += this.getPower(this.func_145831_w(), this.getEffectivePos().func_177982_a(l, 1, k * 2));
            }
        }
        return power;
    }

    public void tickFlower() {
        super.tickFlower();
        float buff = 1.0f + this.getPower() * 0.05f;
        if (this.burnTime > 0) {
            --this.burnTime;
            this.addMana((int)(8.0f * Math.min(7.0f, buff)));
        }
        if (this.linkedCollector != null && this.burnTime == 0 && this.getMana() < this.getMaxMana()) {
            int slowdown = this.getSlowdownFactor();
            for (ItemEntity item : this.func_145831_w().func_217357_a(ItemEntity.class, new AxisAlignedBB(this.getEffectivePos().func_177982_a(-2, -2, -2), this.getEffectivePos().func_177982_a(3, 3, 3)))) {
                int burnTime;
                ItemStack stack;
                if (item.field_70173_aa < 59 + slowdown || item.field_70128_L || (stack = item.func_92059_d()).func_190926_b() || stack.func_77973_b().hasContainerItem(stack) || (burnTime = stack.func_77973_b() == Items.field_151122_aG ? 50 : (stack.func_77973_b() == Items.field_151164_bB ? 65 : 0)) <= 0 || stack.func_190916_E() <= 0) continue;
                this.burnTime = Math.min(32000, burnTime);
                stack.func_190918_g(1);
                this.func_145831_w().func_184133_a(null, this.getEffectivePos(), ModSounds.endoflame, SoundCategory.BLOCKS, 0.2f, 1.0f);
                this.sync();
                return;
            }
        }
    }

    public int getMaxMana() {
        return 1500;
    }

    public int getValueForPassiveGeneration() {
        return 8;
    }

    public int getColor() {
        return 0xEE82EE;
    }

    public void writeToPacketNBT(CompoundNBT cmp) {
        super.writeToPacketNBT(cmp);
        cmp.func_74768_a(TAG_BURN_TIME, this.burnTime);
    }

    public void readFromPacketNBT(CompoundNBT cmp) {
        super.readFromPacketNBT(cmp);
        this.burnTime = cmp.func_74762_e(TAG_BURN_TIME);
    }

    public RadiusDescriptor getRadius() {
        return new RadiusDescriptor.Square(this.getEffectivePos(), 2);
    }

    public boolean canGeneratePassively() {
        return this.burnTime > 0;
    }
}
