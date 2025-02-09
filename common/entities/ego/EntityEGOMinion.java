/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  javax.annotation.Nonnull
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.MobEntity
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.LookAtGoal
 *  net.minecraft.entity.ai.goal.LookRandomlyGoal
 *  net.minecraft.entity.monster.MonsterEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.network.play.server.SRemoveEntityEffectPacket
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectType
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.StringTextComponent
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.IServerWorld
 *  net.minecraft.world.World
 *  net.minecraft.world.server.ServerWorld
 *  net.minecraftforge.common.util.FakePlayer
 *  net.minecraftforge.fml.network.NetworkHooks
 */
package com.meteor.extrabotany.common.entities.ego;

import com.google.common.collect.ImmutableList;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.ego.EntityEGO;
import com.meteor.extrabotany.common.handler.ContributorListHandler;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.relic.ItemInfluxWaver;
import com.meteor.extrabotany.common.items.relic.ItemStarWrath;
import com.meteor.extrabotany.common.items.relic.ItemTrueShadowKatana;
import com.meteor.extrabotany.common.items.relic.ItemTrueTerrablade;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.network.play.server.SRemoveEntityEffectPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityEGOMinion
extends MonsterEntity {
    public EntityEGO summoner;
    private static final List<BlockPos> SPAWN_LOCATIONS = ImmutableList.of((Object)new BlockPos(6, 1, 6), (Object)new BlockPos(6, 1, -6), (Object)new BlockPos(-6, 1, 6), (Object)new BlockPos(-6, 1, -6));
    private static final String TAG_TYPE = "type";
    private static final DataParameter<Integer> TYPE = EntityDataManager.func_187226_a(EntityEGOMinion.class, (IDataSerializer)DataSerializers.field_187192_b);
    private int attackCooldown = 0;
    private int tp = 0;
    private static final Pattern FAKE_PLAYER_PATTERN = Pattern.compile("^(?:\\[.*\\])|(?:ComputerCraft)$");

    public EntityEGOMinion(EntityType<? extends MonsterEntity> p_i48576_1_, World p_i48576_2_) {
        super(p_i48576_1_, p_i48576_2_);
    }

    public EntityEGOMinion(World p_i48576_2_) {
        super(ModEntities.EGOMINION, p_i48576_2_);
    }

    public void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(8, (Goal)new LookAtGoal((MobEntity)this, PlayerEntity.class, 16.0f));
        this.field_70714_bg.func_75776_a(8, (Goal)new LookRandomlyGoal((MobEntity)this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
    }

    public void func_70636_d() {
        List players;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            this.clearPotions((LivingEntity)this);
            if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL || this.summoner == null || this.summoner.field_70128_L) {
                this.func_70106_y();
            }
        }
        float RANGE = 16.0f;
        AxisAlignedBB axis = new AxisAlignedBB(this.func_213303_ch().func_72441_c((double)(-RANGE), (double)(-RANGE), (double)(-RANGE)), this.func_213303_ch().func_72441_c((double)(RANGE + 1.0f), (double)(RANGE + 1.0f), (double)(RANGE + 1.0f)));
        if (!(this.func_70638_az() != null && this.func_70638_az() instanceof PlayerEntity || (players = this.field_70170_p.func_217357_a(PlayerEntity.class, axis)).size() <= 0)) {
            this.func_70624_b((LivingEntity)players.get(0));
        }
        if (this.func_70638_az() != null) {
            Vector3d lookVec = this.func_70638_az().func_70040_Z().func_216372_d(1.0, 0.0, 1.0);
            double playerRot = Math.toRadians(this.func_70638_az().field_70177_z + 90.0f);
            if (lookVec.field_72450_a == 0.0 && lookVec.field_72449_c == 0.0) {
                lookVec = new Vector3d(Math.cos(playerRot), 0.0, Math.sin(playerRot));
            }
            lookVec = lookVec.func_72432_b().func_216372_d(3.5, 0.0, 3.5);
            if (this.func_110143_aJ() <= this.func_110138_aP() * 0.5f) {
                lookVec = lookVec.func_216372_d(-2.0, 0.0, -2.0);
                if (this.field_70173_aa % 40 == 0) {
                    this.func_70691_i(2.0f);
                }
            }
            lookVec = lookVec.func_178785_b((float)(1.5707963267948966 * (double)this.getMinionType() + Math.floor(this.field_70173_aa / 100) * Math.PI / 4.0));
            Vector3d targetPos = this.func_70638_az().func_213303_ch().func_178787_e(lookVec);
            if (!this.field_70170_p.field_72995_K) {
                if (this.func_213303_ch().func_72438_d(targetPos) >= 0.5) {
                    this.func_70605_aq().func_75642_a(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c, (double)0.7f);
                    ++this.tp;
                } else {
                    this.tp = 0;
                }
                if (this.tp >= 60) {
                    this.func_70634_a(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c);
                    this.tp = 0;
                }
            }
        }
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
        if (this.attackCooldown == 0 && this.tryAttack()) {
            this.attackCooldown = 90 + this.field_70170_p.field_73012_v.nextInt(40);
        }
    }

    public boolean tryAttack() {
        if (this.func_70638_az() == null) {
            return false;
        }
        this.func_184609_a(Hand.MAIN_HAND);
        if (!this.field_70170_p.field_72995_K) {
            switch (this.getMinionType()) {
                case 0: {
                    ((ItemTrueShadowKatana)ModItems.trueshadowkatana).attackEntity((LivingEntity)this, (Entity)this.func_70638_az());
                    break;
                }
                case 1: {
                    ((ItemTrueTerrablade)ModItems.trueterrablade).attackEntity((LivingEntity)this, (Entity)this.func_70638_az());
                    break;
                }
                case 2: {
                    ((ItemInfluxWaver)ModItems.influxwaver).attackEntity((LivingEntity)this, (Entity)this.func_70638_az());
                    break;
                }
                case 3: {
                    ((ItemStarWrath)ModItems.starwrath).attackEntity((LivingEntity)this, (Entity)this.func_70638_az());
                }
            }
        }
        return true;
    }

    public void clearPotions(LivingEntity player) {
        List<Effect> potionsToRemove = player.func_70651_bq().stream().filter(effect -> effect.func_188419_a().func_220303_e() == EffectType.HARMFUL).map(EffectInstance::func_188419_a).distinct().collect(Collectors.toList());
        potionsToRemove.forEach(potion -> {
            player.func_195063_d(potion);
            ((ServerWorld)player.field_70170_p).func_72863_F().func_217216_a((Entity)player, (IPacket)new SRemoveEntityEffectPacket(player.func_145782_y(), potion));
        });
    }

    public void func_70071_h_() {
        super.func_70071_h_();
    }

    public boolean func_70097_a(@Nonnull DamageSource source, float amount) {
        Entity e = source.func_76346_g();
        if (e instanceof PlayerEntity && EntityEGOMinion.isTruePlayer(e)) {
            float RANGE = 8.0f;
            AxisAlignedBB axis = new AxisAlignedBB(this.func_213303_ch().func_72441_c((double)(-RANGE), (double)(-RANGE), (double)(-RANGE)), this.func_213303_ch().func_72441_c((double)(RANGE + 1.0f), (double)(RANGE + 1.0f), (double)(RANGE + 1.0f)));
            List minions = this.field_70170_p.func_217357_a(EntityEGOMinion.class, axis);
            float resistance = Math.min(0.6f, (float)minions.size() * 0.15f);
            int cap = 20;
            return super.func_70097_a(source, Math.min((float)cap, amount * (1.0f - resistance)));
        }
        return false;
    }

    public static boolean isTruePlayer(Entity e) {
        if (!(e instanceof PlayerEntity)) {
            return false;
        }
        PlayerEntity player = (PlayerEntity)e;
        String name = player.func_200200_C_().getString();
        return !(player instanceof FakePlayer) && !FAKE_PLAYER_PATTERN.matcher(name).matches();
    }

    public void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74768_a(TAG_TYPE, this.getMinionType());
    }

    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setMinionType(cmp.func_74762_e(TAG_TYPE));
    }

    public static void spawn(EntityEGO summoner, World world, BlockPos pos, float health) {
        ArrayList<String> names = new ArrayList<String>(ContributorListHandler.contributorsMap.keySet());
        Collections.shuffle(names);
        names.add("ExtraMeteorP");
        names.add("Vazkii");
        names.add("Notch");
        names.add("LexManos");
        if (!world.field_72995_K) {
            int type = 0;
            for (BlockPos spawnpos : SPAWN_LOCATIONS) {
                EntityEGOMinion minion = new EntityEGOMinion(world);
                minion.summoner = summoner;
                BlockPos mpos = pos.func_177982_a(spawnpos.func_177958_n(), spawnpos.func_177956_o(), spawnpos.func_177952_p());
                minion.func_70107_b(mpos.func_177958_n(), mpos.func_177956_o(), mpos.func_177952_p());
                minion.func_200203_b((ITextComponent)new StringTextComponent((String)names.get(type)));
                minion.setMinionType(type++);
                minion.func_110148_a(Attributes.field_233818_a_).func_111128_a((double)health);
                minion.func_110148_a(Attributes.field_233826_i_).func_111128_a(10.0);
                minion.func_213386_a((IServerWorld)((ServerWorld)world), world.func_175649_E(minion.func_233580_cy_()), SpawnReason.EVENT, null, null);
                world.func_217376_c((Entity)minion);
            }
        }
    }

    public ItemStack getWeapon() {
        switch (this.getMinionType()) {
            case 0: {
                return new ItemStack((IItemProvider)ModItems.trueshadowkatana);
            }
            case 1: {
                return new ItemStack((IItemProvider)ModItems.trueterrablade);
            }
            case 2: {
                return new ItemStack((IItemProvider)ModItems.influxwaver);
            }
            case 3: {
                return new ItemStack((IItemProvider)ModItems.starwrath);
            }
        }
        return new ItemStack((IItemProvider)ModItems.excaliber);
    }

    public int getMinionType() {
        return (Integer)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setMinionType(int i) {
        this.field_70180_af.func_187227_b(TYPE, (Object)i);
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }
}
