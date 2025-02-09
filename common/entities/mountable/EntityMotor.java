/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.Blocks
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.BoatEntity$Status
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.util.ActionResultType
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.IndirectEntityDamageSource
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.common.core.helper.ItemNBTHelper
 */
package com.meteor.extrabotany.common.entities.mountable;

import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.EntityKeyOfTruth;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.mountable.EntityMountable;
import com.meteor.extrabotany.common.handler.HerrscherHandler;
import com.meteor.extrabotany.common.items.ModItems;
import java.util.List;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.common.core.helper.ItemNBTHelper;

public class EntityMotor
extends EntityMountable {
    private static final String TAG_CYCLONETICKS = "cycloneticks";
    private static final String TAG_TECTONICENERGY = "tectonicenergy";
    private static final DataParameter<Integer> CYCLONE_TICKS = EntityDataManager.func_187226_a(EntityMotor.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> TECTONIC_ENERGY = EntityDataManager.func_187226_a(EntityMotor.class, (IDataSerializer)DataSerializers.field_187192_b);
    public int ridingTicks = 0;

    public EntityMotor(EntityType<? extends EntityMotor> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.field_70156_m = true;
    }

    public EntityMotor(World worldIn) {
        super(ModEntities.MOTOR, worldIn);
    }

    public EntityMotor(World worldIn, double x, double y, double z) {
        super(ModEntities.MOTOR, worldIn);
        this.func_70107_b(x, y, z);
        this.func_213293_j(0.0, 0.0, 0.0);
        this.field_70169_q = x;
        this.field_70167_r = y;
        this.field_70166_s = z;
    }

    public void func_70108_f(Entity entityIn) {
        super.func_70108_f(entityIn);
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0) instanceof PlayerEntity) {
            Entity passenger;
            PlayerEntity player = (PlayerEntity)this.func_184188_bt().get(0);
            Entity entity = passenger = this.func_184188_bt().size() > 1 ? (Entity)this.func_184188_bt().get(1) : null;
            if (entityIn != player && entityIn != passenger) {
                HerrscherHandler.iceAttack(entityIn, player, 7.0f);
                if (!(entityIn instanceof PlayerEntity)) {
                    player.func_130011_c(entityIn);
                }
                if (entityIn instanceof LivingEntity) {
                    LivingEntity livingEntity = (LivingEntity)entityIn;
                }
            }
        }
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TECTONIC_ENERGY, (Object)0);
        this.field_70180_af.func_187214_a(CYCLONE_TICKS, (Object)0);
    }

    public double func_70042_X() {
        return 0.225;
    }

    @Override
    public Item func_184455_j() {
        return ModItems.motor;
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack motor = new ItemStack((IItemProvider)this.func_184455_j());
        ItemNBTHelper.setString((ItemStack)motor, (String)"soulbindUUID", (String)this.getOwnerId().toString());
        return this.getMountable() ? ItemStack.field_190927_a : motor;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        PlayerEntity player = null;
        if (!this.func_184188_bt().isEmpty() && this.func_184188_bt().get(0) instanceof PlayerEntity) {
            player = (PlayerEntity)this.func_184188_bt().get(0);
            if (this.getCycloneTicks() > 0) {
                this.setPitch(-5.0f);
                if (this.getCycloneTicks() > 6) {
                    this.setRotation(-5.0f);
                }
            }
            float speed = 1.65f;
            double mx = -MathHelper.func_76126_a((float)(this.field_70177_z / 180.0f * (float)Math.PI)) * MathHelper.func_76134_b((float)(this.field_70125_A / 180.0f * (float)Math.PI)) * speed;
            double mz = MathHelper.func_76134_b((float)(this.field_70177_z / 180.0f * (float)Math.PI)) * MathHelper.func_76134_b((float)(this.field_70125_A / 180.0f * (float)Math.PI)) * speed;
            double my = this.func_213322_ci().field_72448_b;
            if (this.field_184461_aB) {
                this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197631_x, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), -mx, (double)0.15f, -mz);
            }
            if (this.field_184459_aA) {
                this.setRotation(-5.0f);
            } else if (this.field_184480_az) {
                this.setRotation(5.0f);
            } else {
                this.setRotation(0.0f);
                this.setPitch(0.0f);
            }
            ++this.ridingTicks;
            if (this.field_184461_aB && this.field_70123_F) {
                this.func_213293_j(this.func_213322_ci().field_72450_a, this.func_213322_ci().field_72448_b + (double)0.08f, this.func_213322_ci().field_72449_c);
            }
            if (this.ridingTicks >= 120) {
                if (this.getTectonicEnergy() < 800) {
                    this.setTectonicEnergy(Math.min(800, this.getTectonicEnergy() + 2));
                }
                if (this.spaceInputDown) {
                    if (this.getTectonicEnergy() >= 200) {
                        this.setTectonicEnergy(Math.max(0, this.getTectonicEnergy() - 6));
                        this.func_213293_j(mx, my, mz);
                        if (this.field_70170_p.func_180495_p(new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_()).func_177963_a(mx, my, mz)).func_177230_c() != Blocks.field_150350_a) {
                            this.func_70107_b(this.func_226277_ct_(), this.func_226278_cu_() + 1.0, this.func_226281_cx_());
                        }
                    } else {
                        this.setTectonicEnergy(0);
                    }
                }
                for (LivingEntity living : this.getEntitiesAround()) {
                    if (living == player || this.func_184188_bt().size() > 1 && living == this.func_184188_bt().get(1) || !living.func_70685_l((Entity)player) || !(living instanceof IMob) && player.func_110144_aD() != living || this.field_70173_aa % 15 != 0) continue;
                    EntityKeyOfTruth key = new EntityKeyOfTruth(this.field_70170_p, player);
                    key.func_70107_b(player.func_226277_ct_() - Math.random() * 2.0 + 1.0, player.func_226278_cu_() + (double)2.2f, player.func_226281_cx_() - Math.random() * 2.0 + 1.0);
                    if (Math.random() < 0.5) {
                        key.func_70107_b(living.func_226277_ct_() - Math.random() * 2.0 + 1.0, living.func_226278_cu_() + (double)2.2f, living.func_226281_cx_() - Math.random() * 2.0 + 1.0);
                    }
                    key.field_70177_z = player.field_70177_z;
                    key.setPitch(-player.field_70125_A);
                    key.setRotation(MathHelper.func_76142_g((float)(-player.field_70177_z + 180.0f)));
                    if (this.field_70170_p.field_72995_K) break;
                    this.field_70170_p.func_217376_c((Entity)key);
                    break;
                }
                if (this.getCycloneTicks() == 0 && this.ctrlInputDown && this.getTectonicEnergy() >= 400) {
                    this.setCycloneTicks(15);
                    this.setTectonicEnergy(this.getTectonicEnergy() - 400);
                    this.field_70170_p.func_184134_a(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), ModSounds.cyclone, SoundCategory.PLAYERS, 1.2f, 1.0f, true);
                }
                if (this.getCycloneTicks() > 6) {
                    player.field_70177_z -= 1.0f;
                    player.func_70034_d(player.func_70079_am() - 1.0f);
                    this.func_184454_a((Entity)player);
                }
                if (player.func_110143_aJ() < player.func_110138_aP() * 0.5f) {
                    player.func_70691_i(0.5f);
                }
                if (this.getCycloneTicks() == 12 || this.getCycloneTicks() == 6) {
                    for (LivingEntity living : EntityMotor.getEntitiesAround(new BlockPos(player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_()), 4.0f, player.field_70170_p)) {
                        if (living == player || this.func_184188_bt().size() > 1 && living == this.func_184188_bt().get(1)) continue;
                        HerrscherHandler.iceAttack((Entity)living, player, 4.5f);
                        player.func_130011_c((Entity)living);
                    }
                }
                if (this.getCycloneTicks() > 0) {
                    this.setCycloneTicks(this.getCycloneTicks() - 1);
                    this.field_184475_as += 5.0f;
                }
            }
        } else {
            this.ridingTicks = 0;
        }
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

    public List<LivingEntity> getEntitiesAround() {
        return EntityMotor.getEntitiesAround(new BlockPos(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_()), 12.0f, this.field_70170_p);
    }

    public static List<LivingEntity> getEntitiesAround(BlockPos source, float range, World world) {
        return world.func_217357_a(LivingEntity.class, new AxisAlignedBB((double)source.func_177958_n() + 0.5 - (double)range, (double)source.func_177956_o() + 0.5 - (double)range, (double)source.func_177952_p() + 0.5 - (double)range, (double)source.func_177958_n() + 0.5 + (double)range, (double)source.func_177956_o() + 0.5 + (double)range, (double)source.func_177952_p() + 0.5 + (double)range));
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
        double d1 = this.func_189652_ae() || this.spaceInputDown && this.getTectonicEnergy() >= 200 ? 0.0 : d0;
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
        if (this.func_184207_aI()) {
            float f = 0.0f;
            if (this.field_184480_az) {
                this.field_184475_as -= 1.0f;
            }
            if (this.field_184459_aA) {
                this.field_184475_as += 1.0f;
            }
            if (this.field_184459_aA != this.field_184480_az && !this.field_184461_aB && !this.field_184463_aC) {
                f += 0.005f;
            }
            this.field_70177_z += this.field_184475_as;
            if (this.field_184461_aB) {
                f += 0.0625f;
            }
            if (this.field_184463_aC) {
                f -= 0.006f;
            }
            this.func_213317_d(this.func_213322_ci().func_72441_c((double)(MathHelper.func_76126_a((float)(-this.field_70177_z * ((float)Math.PI / 180))) * f), 0.0, (double)(MathHelper.func_76134_b((float)(this.field_70177_z * ((float)Math.PI / 180))) * f)));
            this.func_184445_a(this.field_184459_aA && !this.field_184480_az || this.field_184461_aB, this.field_184480_az && !this.field_184459_aA || this.field_184461_aB);
        }
    }

    public ActionResultType func_184230_a(PlayerEntity player, Hand hand) {
        if (player.func_226563_dT_()) {
            return ActionResultType.PASS;
        }
        if (this.field_184474_h < 60.0f) {
            if (!this.field_70170_p.field_72995_K) {
                if (player.func_184220_m((Entity)this)) {
                    this.field_70170_p.func_184134_a(this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), ModSounds.rideon, SoundCategory.PLAYERS, 4.0f, 1.0f, true);
                }
                return player.func_184220_m((Entity)this) ? ActionResultType.CONSUME : ActionResultType.PASS;
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    protected void func_70037_a(CompoundNBT compound) {
        super.func_70037_a(compound);
        this.setTectonicEnergy(compound.func_74762_e(TAG_TECTONICENERGY));
        this.setCycloneTicks(compound.func_74762_e(TAG_CYCLONETICKS));
    }

    @Override
    protected void func_213281_b(CompoundNBT compound) {
        super.func_213281_b(compound);
        compound.func_74768_a(TAG_TECTONICENERGY, this.getTectonicEnergy());
        compound.func_74768_a(TAG_CYCLONETICKS, this.getCycloneTicks());
    }

    public void setCycloneTicks(int i) {
        this.field_70180_af.func_187227_b(CYCLONE_TICKS, (Object)i);
    }

    public int getCycloneTicks() {
        return (Integer)this.field_70180_af.func_187225_a(CYCLONE_TICKS);
    }

    public void setTectonicEnergy(int i) {
        this.field_70180_af.func_187227_b(TECTONIC_ENERGY, (Object)i);
    }

    public int getTectonicEnergy() {
        return (Integer)this.field_70180_af.func_187225_a(TECTONIC_ENERGY);
    }

    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
