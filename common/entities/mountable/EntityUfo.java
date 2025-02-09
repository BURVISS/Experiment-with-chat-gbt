/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.BoatEntity$Status
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IndirectEntityDamageSource
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.mountable;

import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.mountable.EntityMountable;
import com.meteor.extrabotany.common.items.ModItems;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityUfo
extends EntityMountable {
    private static final String TAG_CATCHED_ID = "catched_id";
    private static final DataParameter<Integer> CATCHED_ID = EntityDataManager.func_187226_a(EntityUfo.class, (IDataSerializer)DataSerializers.field_187192_b);

    public EntityUfo(EntityType<? extends EntityUfo> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.field_70156_m = true;
    }

    public EntityUfo(World worldIn) {
        super(ModEntities.UFO, worldIn);
    }

    public EntityUfo(World worldIn, double x, double y, double z) {
        super(ModEntities.UFO, worldIn);
        this.func_70107_b(x, y, z);
        this.func_213293_j(0.0, 0.0, 0.0);
        this.field_70169_q = x;
        this.field_70167_r = y;
        this.field_70166_s = z;
        this.func_189654_d(true);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(CATCHED_ID, (Object)-1);
    }

    public double func_70042_X() {
        return 0.605;
    }

    @Override
    public Item func_184455_j() {
        return ModItems.cosmiccarkey;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        PlayerEntity player = null;
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0) instanceof PlayerEntity) {
            player = (PlayerEntity)this.func_184188_bt().get(0);
            float speed = 0.75f;
            double mx = -MathHelper.func_76126_a((float)(player.field_70177_z / 180.0f * (float)Math.PI)) * MathHelper.func_76134_b((float)(player.field_70125_A / 180.0f * (float)Math.PI)) * speed;
            double mz = MathHelper.func_76134_b((float)(player.field_70177_z / 180.0f * (float)Math.PI)) * MathHelper.func_76134_b((float)(player.field_70125_A / 180.0f * (float)Math.PI)) * speed;
            double my = 0.0;
            Vector3d f0 = new Vector3d(0.0, 0.0, 0.0);
            Vector3d vecf = new Vector3d(mx, my, mz);
            Vector3d vecl = new Vector3d(mx, my, mz).func_178785_b(1.5707964f).func_186678_a(0.75);
            Vector3d vecr = new Vector3d(mx, my, mz).func_178785_b(-1.5707964f).func_186678_a(0.75);
            Vector3d vecb = new Vector3d(mx, my, mz).func_178785_b((float)Math.PI).func_186678_a((double)0.6f);
            if (this.field_184461_aB) {
                f0 = f0.func_178787_e(vecf);
            }
            if (this.field_184480_az) {
                f0 = f0.func_178787_e(vecl);
            }
            if (this.field_184459_aA) {
                f0 = f0.func_178787_e(vecr);
            }
            if (this.field_184463_aC) {
                f0 = f0.func_178787_e(vecb);
            }
            if (this.spaceInputDown) {
                f0 = f0.func_72441_c(0.0, 0.35, 0.0);
            } else if (this.ctrlInputDown) {
                f0 = f0.func_72441_c(0.0, -0.35, 0.0);
            }
            if (f0.func_72433_c() != 0.0) {
                this.field_70177_z = EntityUfo.getRotationFromVector(player.field_70177_z, f0.func_72432_b());
            }
            this.func_213317_d(f0);
        }
        if (this.getCatchedID() != -1) {
            Entity entity = this.field_70170_p.func_73045_a(this.getCatchedID());
            if (entity == null || entity.field_70128_L || entity.func_70032_d((Entity)this) >= 16.0f) {
                this.setCatchedID(-1);
            } else {
                entity.func_213317_d(new Vector3d(this.func_226277_ct_() - entity.func_226277_ct_(), this.func_226278_cu_() - 2.0 - entity.func_226278_cu_(), this.func_226281_cx_() - entity.func_226281_cx_()).func_72432_b().func_186678_a(0.75));
                if (this.spaceInputDown) {
                    entity.func_70107_b(entity.func_226277_ct_(), entity.func_226278_cu_() + 0.33, entity.func_226281_cx_());
                } else if (this.ctrlInputDown) {
                    entity.func_70107_b(entity.func_226277_ct_(), entity.func_226278_cu_() - 0.37, entity.func_226281_cx_());
                }
                entity.field_70143_R = 0.0f;
            }
        }
    }

    public static float getRotationFromVector(float rot, Vector3d vec) {
        double f2 = vec.field_72449_c;
        double f3 = vec.field_72450_a;
        double f12 = Math.asin(f3);
        double f13 = Math.acos(f2);
        double yawx = -(f13 / 0.01745329238474369);
        double yawz = -(f12 / 0.01745329238474369);
        return MathHelper.func_76142_g((float)rot) >= 0.0f ? (float)(-yawx) : (float)yawx;
    }

    public List<LivingEntity> getEntitiesBelow() {
        return EntityUfo.getEntitiesBelow(new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_()), this.field_70170_p);
    }

    public static List<LivingEntity> getEntitiesBelow(BlockPos source, World world) {
        return world.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)((float)source.func_177958_n() + 2.0f), (double)((float)source.func_177956_o() - 0.5f), (double)((float)source.func_177952_p() + 2.0f), (double)((float)source.func_177958_n() - 1.5f), (double)((float)source.func_177956_o() - 16.0f), (double)((float)source.func_177952_p() - 1.5f)));
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_180431_b(source)) {
            return false;
        }
        if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
            boolean flag;
            if (source instanceof IndirectEntityDamageSource && source.func_76346_g() != null && this.func_184196_w(source.func_76346_g())) {
                return false;
            }
            this.func_70269_c(-this.func_70267_i());
            this.func_70265_b(10);
            this.func_70018_K();
            boolean bl = flag = source.func_76346_g() instanceof PlayerEntity && ((PlayerEntity)source.func_76346_g()).field_71075_bZ.field_75098_d;
            if (source.func_76346_g() instanceof PlayerEntity) {
                this.func_70266_a(this.func_70271_g() + amount * 10.0f);
            }
            if (flag || this.func_70271_g() > 40.0f) {
                if (!flag && this.field_70170_p.func_82736_K().func_223586_b(GameRules.field_223604_g)) {
                    this.func_199701_a_(this.getItemStack());
                }
                this.func_70106_y();
            }
            return true;
        }
        return true;
    }

    public BoatEntity.Status func_184449_t() {
        BoatEntity.Status boatentity$status = this.func_184444_v();
        if (boatentity$status != null) {
            this.field_184465_aD = this.func_174813_aQ().field_72337_e;
            return boatentity$status;
        }
        if (this.func_184446_u()) {
            return BoatEntity.Status.IN_WATER;
        }
        float f = this.func_184441_l();
        if (f > 0.0f) {
            this.field_184467_aE = f;
            return BoatEntity.Status.ON_LAND;
        }
        return BoatEntity.Status.IN_AIR;
    }

    public void func_184450_w() {
        double d0 = -0.04f;
        double d1 = 0.0;
        double d2 = 0.0;
        this.field_184472_g = 0.05f;
        if (this.field_184471_aG == BoatEntity.Status.IN_AIR && this.field_184469_aF != BoatEntity.Status.IN_AIR && this.field_184469_aF != BoatEntity.Status.ON_LAND) {
            this.field_184465_aD = this.func_174813_aQ().field_72338_b + (double)this.func_213302_cg();
            this.func_70107_b(this.func_226277_ct_(), (double)(this.func_184451_k() - this.func_213302_cg()) + 0.101, this.func_226281_cx_());
            this.func_213317_d(this.func_213322_ci().func_216372_d(1.0, 0.0, 1.0));
            this.field_184473_aH = 0.0;
            this.field_184469_aF = BoatEntity.Status.IN_WATER;
        } else {
            if (this.field_184469_aF == BoatEntity.Status.IN_WATER) {
                d2 = (this.field_184465_aD - this.func_174813_aQ().field_72338_b + 0.1) / (double)this.func_213302_cg();
                this.field_184472_g = 0.9f;
            } else if (this.field_184469_aF == BoatEntity.Status.UNDER_FLOWING_WATER) {
                d1 = -7.0E-4;
                this.field_184472_g = 0.9f;
            } else if (this.field_184469_aF == BoatEntity.Status.UNDER_WATER) {
                d2 = 0.01f;
                this.field_184472_g = 0.8f;
            } else if (this.field_184469_aF == BoatEntity.Status.IN_AIR) {
                this.field_184472_g = 0.9f;
            } else if (this.field_184469_aF == BoatEntity.Status.ON_LAND) {
                this.field_184472_g = 0.9f;
                if (this.func_184179_bs() instanceof PlayerEntity) {
                    this.field_184467_aE /= 2.0f;
                }
            }
            Vector3d vec3d = this.func_213322_ci();
            this.func_213293_j(vec3d.field_72450_a * (double)this.field_184472_g, vec3d.field_72448_b + d1, vec3d.field_72449_c * (double)this.field_184472_g);
            this.field_184475_as *= this.field_184472_g;
            if (d2 > 0.0) {
                Vector3d vec3d1 = this.func_213322_ci();
                this.func_213293_j(vec3d1.field_72450_a, (vec3d1.field_72448_b + d2 * 0.06153846016296973) * 0.75, vec3d1.field_72449_c);
            }
        }
    }

    protected void func_184231_a(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.field_70143_R = 0.0f;
    }

    public void func_184443_x() {
    }

    protected void func_184454_a(Entity entityToUpdate) {
        this.func_181013_g(entityToUpdate.field_70177_z);
        float f = MathHelper.func_76142_g((float)(this.field_70177_z - entityToUpdate.field_70177_z));
        float f1 = MathHelper.func_76131_a((float)f, (float)-180.0f, (float)180.0f);
        this.field_70126_B += f1 - f;
        this.field_70177_z += f1 - f;
        this.func_70034_d(this.field_70177_z);
    }

    public ActionResultType func_184230_a(PlayerEntity player, Hand hand) {
        if (player.func_226563_dT_()) {
            return ActionResultType.PASS;
        }
        if (this.field_184474_h < 60.0f) {
            if (!this.field_70170_p.field_72995_K) {
                return player.func_184220_m((Entity)this) ? ActionResultType.CONSUME : ActionResultType.PASS;
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    protected void func_70037_a(CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setCatchedID(compound.func_74762_e(TAG_CATCHED_ID));
    }

    @Override
    protected void func_213281_b(CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a(TAG_CATCHED_ID, this.getCatchedID());
    }

    public void setCatchedID(int i) {
        this.field_70180_af.func_187227_b(CATCHED_ID, (Object)i);
    }

    public int getCatchedID() {
        return (Integer)this.field_70180_af.func_187225_a(CATCHED_ID);
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
