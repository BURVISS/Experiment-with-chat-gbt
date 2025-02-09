/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  javax.annotation.Nonnull
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.TickableSound
 *  net.minecraft.client.renderer.Rectangle2d
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.MobEntity
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.entity.ai.attributes.Attributes
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.LookAtGoal
 *  net.minecraft.entity.ai.goal.SwimGoal
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.ServerPlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.loot.LootTables
 *  net.minecraft.nbt.CompoundNBT
 *  net.minecraft.network.IPacket
 *  net.minecraft.network.PacketBuffer
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.IDataSerializer
 *  net.minecraft.network.play.server.SRemoveEntityEffectPacket
 *  net.minecraft.particles.IParticleData
 *  net.minecraft.particles.ParticleTypes
 *  net.minecraft.potion.Effect
 *  net.minecraft.potion.EffectInstance
 *  net.minecraft.potion.EffectType
 *  net.minecraft.tags.ITag$INamedTag
 *  net.minecraft.tileentity.BeaconTileEntity
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.Hand
 *  net.minecraft.util.IItemProvider
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.SoundEvents
 *  net.minecraft.util.Util
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.util.math.vector.Vector3i
 *  net.minecraft.util.registry.Registry
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextFormatting
 *  net.minecraft.util.text.TranslationTextComponent
 *  net.minecraft.world.BossInfo$Color
 *  net.minecraft.world.BossInfo$Overlay
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.IBlockReader
 *  net.minecraft.world.IServerWorld
 *  net.minecraft.world.World
 *  net.minecraft.world.server.ServerBossInfo
 *  net.minecraft.world.server.ServerWorld
 *  net.minecraftforge.api.distmarker.Dist
 *  net.minecraftforge.api.distmarker.OnlyIn
 *  net.minecraftforge.common.util.FakePlayer
 *  net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
 *  net.minecraftforge.fml.network.NetworkHooks
 *  vazkii.botania.client.core.handler.BossBarHandler
 *  vazkii.botania.client.fx.WispParticleData
 *  vazkii.botania.common.Botania
 *  vazkii.botania.common.block.ModBlocks
 *  vazkii.botania.common.core.helper.MathHelper
 *  vazkii.botania.common.core.helper.Vector3
 *  vazkii.botania.common.lib.ModTags$Blocks
 *  vazkii.botania.common.network.PacketBotaniaEffect
 *  vazkii.botania.common.network.PacketBotaniaEffect$EffectType
 *  vazkii.botania.common.network.PacketHandler
 */
package com.meteor.extrabotany.common.entities.ego;

import com.google.common.collect.ImmutableList;
import com.meteor.extrabotany.common.core.ConfigHandler;
import com.meteor.extrabotany.common.core.ModSounds;
import com.meteor.extrabotany.common.entities.ModEntities;
import com.meteor.extrabotany.common.entities.ego.EntityEGOBeam;
import com.meteor.extrabotany.common.entities.ego.EntityEGOLandmine;
import com.meteor.extrabotany.common.entities.ego.EntityEGOMinion;
import com.meteor.extrabotany.common.items.ModItems;
import com.meteor.extrabotany.common.items.bauble.ItemNatureOrb;
import com.meteor.extrabotany.common.items.relic.ItemFirstFractal;
import com.meteor.extrabotany.common.items.relic.ItemInfluxWaver;
import com.meteor.extrabotany.common.items.relic.ItemStarWrath;
import com.meteor.extrabotany.common.items.relic.ItemTrueShadowKatana;
import com.meteor.extrabotany.common.items.relic.ItemTrueTerrablade;
import com.mojang.blaze3d.matrix.MatrixStack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.client.renderer.Rectangle2d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.IDataSerializer;
import net.minecraft.network.play.server.SRemoveEntityEffectPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.BeaconTileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;
import vazkii.botania.client.core.handler.BossBarHandler;
import vazkii.botania.client.fx.WispParticleData;
import vazkii.botania.common.Botania;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.core.helper.MathHelper;
import vazkii.botania.common.core.helper.Vector3;
import vazkii.botania.common.lib.ModTags;
import vazkii.botania.common.network.PacketBotaniaEffect;
import vazkii.botania.common.network.PacketHandler;

public class EntityEGO
extends MobEntity
implements IEntityAdditionalSpawnData {
    public static final float ARENA_RANGE = 12.0f;
    public static final int ARENA_HEIGHT = 5;
    public static final float MAX_HP = 600.0f;
    private static final String TAG_INVUL_TIME = "invulTime";
    private static final String TAG_SOURCE_X = "sourceX";
    private static final String TAG_SOURCE_Y = "sourceY";
    private static final String TAG_SOURCE_Z = "sourcesZ";
    private static final String TAG_PLAYER_COUNT = "playerCount";
    private static final String TAG_STAGE = "stage";
    private static final String TAG_WEAPONTYPE = "weapontype";
    private static final ITag.INamedTag<Block> BLACKLIST = ModTags.Blocks.GAIA_BREAK_BLACKLIST;
    private static final DataParameter<Integer> INVUL_TIME = EntityDataManager.func_187226_a(EntityEGO.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> STAGE = EntityDataManager.func_187226_a(EntityEGO.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> WEAPON_TYPE = EntityDataManager.func_187226_a(EntityEGO.class, (IDataSerializer)DataSerializers.field_187192_b);
    private static final List<BlockPos> PYLON_LOCATIONS = ImmutableList.of((Object)new BlockPos(4, 1, 4), (Object)new BlockPos(4, 1, -4), (Object)new BlockPos(-4, 1, 4), (Object)new BlockPos(-4, 1, -4));
    private static final List<ResourceLocation> CHEATY_BLOCKS = Arrays.asList(new ResourceLocation("openblocks", "beartrap"), new ResourceLocation("thaumictinkerer", "magnet"));
    private int changeWeaponDelay = 0;
    private int attackDelay = 0;
    private float damageTaken = 0.0f;
    private int tpDelay = 0;
    private int playerCount = 0;
    private BlockPos source = BlockPos.field_177992_a;
    private final List<UUID> playersWhoAttacked = new ArrayList<UUID>();
    private final ServerBossInfo bossInfo = (ServerBossInfo)new ServerBossInfo(ModEntities.EGO.func_212546_e(), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS).func_186743_c(true);
    private UUID bossInfoUUID = this.bossInfo.func_186737_d();
    public PlayerEntity trueKiller = null;
    private int MAX_WAVE = 8;
    private int wave = 0;
    private int tpTimes = 0;
    private Integer[] waves = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
    private static final Pattern FAKE_PLAYER_PATTERN = Pattern.compile("^(?:\\[.*\\])|(?:ComputerCraft)$");

    public EntityEGO(EntityType<EntityEGO> type, World world) {
        super(type, world);
        this.field_70728_aV = 825;
    }

    public static boolean spawn(PlayerEntity player, ItemStack stack, World world, BlockPos pos) {
        ItemNatureOrb orb;
        if (!(world.func_175625_s(pos) instanceof BeaconTileEntity) || !EntityEGO.isTruePlayer((Entity)player) || EntityEGO.countEGOAround(world, pos) > 0) {
            return false;
        }
        if (!EntityEGO.checkInventory(player)) {
            if (!world.field_72995_K) {
                player.func_145747_a((ITextComponent)new TranslationTextComponent("extrabotanymisc.inventoryUnfeasible").func_240699_a_(TextFormatting.RED), Util.field_240973_b_);
            }
            return false;
        }
        if (world.func_175659_aa() == Difficulty.PEACEFUL) {
            if (!world.field_72995_K) {
                player.func_145747_a((ITextComponent)new TranslationTextComponent("botaniamisc.peacefulNoob").func_240699_a_(TextFormatting.RED), Util.field_240973_b_);
            }
            return false;
        }
        List<BlockPos> invalidPylonBlocks = EntityEGO.checkPylons(world, pos);
        if (!invalidPylonBlocks.isEmpty()) {
            if (world.field_72995_K) {
                EntityEGO.warnInvalidBlocks(world, invalidPylonBlocks);
            } else {
                player.func_145747_a((ITextComponent)new TranslationTextComponent("botaniamisc.needsCatalysts").func_240699_a_(TextFormatting.RED), Util.field_240973_b_);
            }
            return false;
        }
        List<BlockPos> invalidArenaBlocks = EntityEGO.checkArena(world, pos);
        if (!invalidArenaBlocks.isEmpty()) {
            if (world.field_72995_K) {
                EntityEGO.warnInvalidBlocks(world, invalidArenaBlocks);
            } else {
                PacketHandler.sendTo((ServerPlayerEntity)((ServerPlayerEntity)player), (Object)new PacketBotaniaEffect(PacketBotaniaEffect.EffectType.ARENA_INDICATOR, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), new int[0]));
                player.func_145747_a((ITextComponent)new TranslationTextComponent("botaniamisc.badArena").func_240699_a_(TextFormatting.RED), Util.field_240973_b_);
            }
            return false;
        }
        if (stack.func_77973_b() == ModItems.natureorb && (orb = (ItemNatureOrb)stack.func_77973_b()).getXP(stack) < 200000) {
            return false;
        }
        if (!world.field_72995_K) {
            int playerCount;
            if (stack.func_77973_b() == ModItems.natureorb) {
                orb = (ItemNatureOrb)stack.func_77973_b();
                orb.setXP(stack, orb.getXP(stack) - 200000);
            } else {
                stack.func_190918_g(1);
            }
            EntityEGO e = (EntityEGO)ModEntities.EGO.func_200721_a(world);
            e.func_70107_b((double)pos.func_177958_n() + 0.5, pos.func_177956_o() + 3, (double)pos.func_177952_p() + 0.5);
            e.source = pos;
            e.setWeaponType(0);
            e.func_200203_b(player.func_145748_c_());
            e.playerCount = playerCount = e.getPlayersAround().size();
            e.setInvulTime(0);
            e.func_110148_a(Attributes.field_233826_i_).func_111128_a(20.0);
            e.func_110148_a(Attributes.field_233818_a_).func_111128_a((double)(600.0f * (float)playerCount));
            e.func_184185_a(SoundEvents.field_187525_aO, 10.0f, 0.1f);
            e.func_70606_j(e.func_110138_aP());
            e.func_213386_a((IServerWorld)((ServerWorld)world), world.func_175649_E(e.func_233580_cy_()), SpawnReason.EVENT, null, null);
            world.func_217376_c((Entity)e);
        }
        return true;
    }

    private static List<BlockPos> checkPylons(World world, BlockPos beaconPos) {
        ArrayList<BlockPos> invalidPylonBlocks = new ArrayList<BlockPos>();
        for (BlockPos coords : PYLON_LOCATIONS) {
            BlockPos pos_ = beaconPos.func_177971_a((Vector3i)coords);
            BlockState state = world.func_180495_p(pos_);
            if (state.func_177230_c() == ModBlocks.gaiaPylon) continue;
            invalidPylonBlocks.add(pos_);
        }
        return invalidPylonBlocks;
    }

    private static List<BlockPos> checkArena(World world, BlockPos beaconPos) {
        ArrayList<BlockPos> trippedPositions = new ArrayList<BlockPos>();
        int range = (int)Math.ceil(12.0);
        for (int x = -range; x <= range; ++x) {
            for (int z = -range; z <= range; ++z) {
                if (Math.abs(x) == 4 && Math.abs(z) == 4 || MathHelper.pointDistancePlane((double)x, (double)z, (double)0.0, (double)0.0) > 12.0f) continue;
                boolean hasFloor = false;
                for (int y = -2; y <= 5; ++y) {
                    boolean isBlockHere;
                    if (x == 0 && y == 0 && z == 0) continue;
                    BlockPos pos = beaconPos.func_177982_a(x, y, z);
                    BlockState state = world.func_180495_p(pos);
                    boolean allowBlockHere = y < 0;
                    boolean bl = isBlockHere = !state.func_196952_d((IBlockReader)world, pos).func_197766_b();
                    if (allowBlockHere && isBlockHere) {
                        hasFloor = true;
                    }
                    if (y == 0 && !hasFloor) {
                        trippedPositions.add(pos.func_177977_b());
                    }
                    if (allowBlockHere || !isBlockHere || BLACKLIST.func_230235_a_((Object)state.func_177230_c())) continue;
                    trippedPositions.add(pos);
                }
            }
        }
        return trippedPositions;
    }

    private static void warnInvalidBlocks(World world, Iterable<BlockPos> invalidPositions) {
        WispParticleData data = WispParticleData.wisp((float)0.5f, (float)1.0f, (float)0.2f, (float)0.2f, (float)8.0f, (boolean)false);
        for (BlockPos pos_ : invalidPositions) {
            world.func_195594_a((IParticleData)data, (double)pos_.func_177958_n() + 0.5, (double)pos_.func_177956_o() + 0.5, (double)pos_.func_177952_p() + 0.5, 0.0, 0.0, 0.0);
        }
    }

    public ItemStack getWeapon() {
        switch (this.getWeaponType()) {
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
            case 4: {
                return new ItemStack((IItemProvider)ModItems.firstfractal);
            }
        }
        return ItemStack.field_190927_a;
    }

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (Goal)new SwimGoal((MobEntity)this));
        this.field_70714_bg.func_75776_a(1, (Goal)new LookAtGoal((MobEntity)this, PlayerEntity.class, 18.0f));
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(INVUL_TIME, (Object)0);
        this.field_70180_af.func_187214_a(STAGE, (Object)0);
        this.field_70180_af.func_187214_a(WEAPON_TYPE, (Object)0);
    }

    public int getInvulTime() {
        return (Integer)this.field_70180_af.func_187225_a(INVUL_TIME);
    }

    public BlockPos getSource() {
        return this.source;
    }

    public void setInvulTime(int time) {
        this.field_70180_af.func_187227_b(INVUL_TIME, (Object)time);
    }

    public int getStage() {
        return (Integer)this.field_70180_af.func_187225_a(STAGE);
    }

    public void setStage(int time) {
        this.field_70180_af.func_187227_b(STAGE, (Object)time);
    }

    public int getWeaponType() {
        return (Integer)this.field_70180_af.func_187225_a(WEAPON_TYPE);
    }

    public void setWeaponType(int time) {
        this.field_70180_af.func_187227_b(WEAPON_TYPE, (Object)time);
    }

    public void func_213281_b(CompoundNBT cmp) {
        super.func_213281_b(cmp);
        cmp.func_74768_a(TAG_INVUL_TIME, this.getInvulTime());
        cmp.func_74768_a(TAG_SOURCE_X, this.source.func_177958_n());
        cmp.func_74768_a(TAG_SOURCE_Y, this.source.func_177956_o());
        cmp.func_74768_a(TAG_SOURCE_Z, this.source.func_177952_p());
        cmp.func_74768_a(TAG_PLAYER_COUNT, this.playerCount);
        cmp.func_74768_a(TAG_STAGE, this.getStage());
        cmp.func_74768_a(TAG_WEAPONTYPE, this.getWeaponType());
    }

    public void func_70037_a(CompoundNBT cmp) {
        super.func_70037_a(cmp);
        this.setInvulTime(cmp.func_74762_e(TAG_INVUL_TIME));
        int x = cmp.func_74762_e(TAG_SOURCE_X);
        int y = cmp.func_74762_e(TAG_SOURCE_Y);
        int z = cmp.func_74762_e(TAG_SOURCE_Z);
        this.source = new BlockPos(x, y, z);
        this.playerCount = cmp.func_74764_b(TAG_PLAYER_COUNT) ? cmp.func_74762_e(TAG_PLAYER_COUNT) : 1;
        this.setStage(cmp.func_74762_e(TAG_STAGE));
        this.setWeaponType(cmp.func_74762_e(TAG_WEAPONTYPE));
        if (this.func_145818_k_()) {
            this.bossInfo.func_186739_a(this.func_145748_c_());
        }
    }

    public void func_200203_b(@Nullable ITextComponent name) {
        super.func_200203_b(name);
        this.bossInfo.func_186739_a(this.func_145748_c_());
    }

    public boolean func_70097_a(@Nonnull DamageSource source, float amount) {
        Entity e = source.func_76346_g();
        if (e instanceof PlayerEntity && EntityEGO.isTruePlayer(e) && this.getInvulTime() == 0) {
            PlayerEntity player = (PlayerEntity)e;
            if (!this.playersWhoAttacked.contains(player.func_110124_au())) {
                this.playersWhoAttacked.add(player.func_110124_au());
            }
            int cap = 25;
            float dmg = Math.min((float)cap, amount);
            this.damageTaken += dmg;
            if (this.damageTaken >= 50.0f && this.tryAttack()) {
                this.damageTaken = 0.0f;
                this.teleportRandomly();
            }
            if (this.getStage() == 2 && this.func_110143_aJ() - dmg <= this.func_110138_aP() * 0.05f) {
                this.func_70606_j(this.func_110138_aP() * 0.04f);
                return false;
            }
            return super.func_70097_a(source, dmg);
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

    public void func_70645_a(@Nonnull DamageSource source) {
        super.func_70645_a(source);
        LivingEntity entitylivingbase = this.func_94060_bK();
        if (!this.field_70170_p.field_72995_K) {
            this.sendMessageToAll("extrabotany.ego.death_" + this.field_70170_p.field_73012_v.nextInt(4));
        }
        this.func_184185_a(SoundEvents.field_187539_bB, 20.0f, (1.0f + (this.field_70170_p.field_73012_v.nextFloat() - this.field_70170_p.field_73012_v.nextFloat()) * 0.2f) * 0.7f);
        this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197626_s, this.func_226277_ct_(), this.func_226278_cu_(), this.func_226281_cx_(), 1.0, 0.0, 0.0);
        for (EntityEGOLandmine landmine : this.field_70170_p.func_217357_a(EntityEGOLandmine.class, EntityEGO.getArenaBB(this.getSource()))) {
            landmine.func_70106_y();
        }
        for (EntityEGOMinion minion : this.field_70170_p.func_217357_a(EntityEGOMinion.class, EntityEGO.getArenaBB(this.getSource()))) {
            minion.func_70106_y();
        }
    }

    public boolean func_213397_c(double dist) {
        return false;
    }

    protected void func_213354_a(@Nonnull DamageSource source, boolean wasRecentlyHit) {
        if (wasRecentlyHit && source.func_76346_g() instanceof PlayerEntity) {
            this.trueKiller = (PlayerEntity)source.func_76346_g();
        }
        for (UUID u : this.playersWhoAttacked) {
            PlayerEntity player = this.field_70170_p.func_217371_b(u);
            if (player == null) continue;
            PlayerEntity saveLastAttacker = this.field_70717_bb;
            Vector3d savePos = this.func_213303_ch();
            this.field_70717_bb = player;
            this.func_70107_b(player.func_226277_ct_(), player.func_226278_cu_(), player.func_226281_cx_());
            super.func_213354_a(DamageSource.func_76365_a((PlayerEntity)player), wasRecentlyHit);
            this.func_70107_b(savePos.func_82615_a(), savePos.func_82617_b(), savePos.func_82616_c());
            this.field_70717_bb = saveLastAttacker;
        }
        this.trueKiller = null;
    }

    public List<PlayerEntity> getPlayersAround() {
        return this.field_70170_p.func_175647_a(PlayerEntity.class, EntityEGO.getArenaBB(this.source), player -> EntityEGO.isTruePlayer((Entity)player) && !player.func_175149_v());
    }

    private static int countEGOAround(World world, BlockPos source) {
        List l = world.func_217357_a(EntityEGO.class, EntityEGO.getArenaBB(source));
        return l.size();
    }

    @Nonnull
    private static AxisAlignedBB getArenaBB(@Nonnull BlockPos source) {
        double range = 15.0;
        return new AxisAlignedBB((double)source.func_177958_n() + 0.5 - range, (double)source.func_177956_o() + 0.5 - range, (double)source.func_177952_p() + 0.5 - range, (double)source.func_177958_n() + 0.5 + range, (double)source.func_177956_o() + 0.5 + range, (double)source.func_177952_p() + 0.5 + range);
    }

    private static int countEGOMinionAround(World world, BlockPos source) {
        List l = world.func_217357_a(EntityEGOMinion.class, EntityEGO.getArenaBB(source));
        return l.size();
    }

    private void smashBlocksAround(int centerX, int centerY, int centerZ, int radius) {
        for (int dx = -radius; dx <= radius; ++dx) {
            for (int dy = -radius; dy <= radius + 1; ++dy) {
                for (int dz = -radius; dz <= radius; ++dz) {
                    int x = centerX + dx;
                    int y = centerY + dy;
                    int z = centerZ + dz;
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = this.field_70170_p.func_180495_p(pos);
                    Block block = state.func_177230_c();
                    if (state.func_185887_b((IBlockReader)this.field_70170_p, pos) == -1.0f) continue;
                    if (CHEATY_BLOCKS.contains(Registry.field_212618_g.func_177774_c((Object)block))) {
                        this.field_70170_p.func_175655_b(pos, true);
                        continue;
                    }
                    if (BLACKLIST.func_230235_a_((Object)block) || y < this.source.func_177956_o() || Math.abs(this.source.func_177958_n() - x) == 4 && Math.abs(this.source.func_177952_p() - z) == 4) continue;
                    this.field_70170_p.func_175655_b(pos, true);
                }
            }
        }
    }

    private void clearPotions(PlayerEntity player) {
        List<Effect> potionsToRemove = player.func_70651_bq().stream().filter(effect -> effect.func_76459_b() < 160 && effect.func_82720_e() && effect.func_188419_a().func_220303_e() != EffectType.HARMFUL).map(EffectInstance::func_188419_a).distinct().collect(Collectors.toList());
        potionsToRemove.forEach(potion -> {
            player.func_195063_d(potion);
            ((ServerWorld)this.field_70170_p).func_72863_F().func_217216_a((Entity)player, (IPacket)new SRemoveEntityEffectPacket(player.func_145782_y(), potion));
        });
    }

    private void keepInsideArena(PlayerEntity player) {
        if (MathHelper.pointDistanceSpace((double)player.func_226277_ct_(), (double)player.func_226278_cu_(), (double)player.func_226281_cx_(), (double)((double)this.source.func_177958_n() + 0.5), (double)((double)this.source.func_177956_o() + 0.5), (double)((double)this.source.func_177952_p() + 0.5)) >= 12.0f) {
            Vector3 sourceVector = new Vector3((double)this.source.func_177958_n() + 0.5, (double)this.source.func_177956_o() + 0.5, (double)this.source.func_177952_p() + 0.5);
            Vector3 playerVector = Vector3.fromEntityCenter((Entity)player);
            Vector3 motion = sourceVector.subtract(playerVector).normalize();
            player.func_213293_j(motion.x, 0.2, motion.z);
            player.field_70133_I = true;
            if (player.func_184187_bx() != null) {
                player.func_184187_bx().func_213293_j(motion.x, 0.2, motion.z);
                player.func_184187_bx().field_70133_I = true;
            }
        }
    }

    private void particles() {
        float rad;
        for (int i = 0; i < 360; i += 8) {
            float r = 0.6f;
            float g = 0.0f;
            float b = 0.2f;
            float m = 0.15f;
            float mv = 0.35f;
            rad = (float)i * (float)Math.PI / 180.0f;
            double x = (double)this.source.func_177958_n() + 0.5 - Math.cos(rad) * 12.0;
            double y = (double)this.source.func_177956_o() + 0.5;
            double z = (double)this.source.func_177952_p() + 0.5 - Math.sin(rad) * 12.0;
            WispParticleData data = WispParticleData.wisp((float)0.5f, (float)r, (float)g, (float)b);
            this.field_70170_p.func_195594_a((IParticleData)data, x, y, z, (double)((float)(Math.random() - 0.5) * m), (double)((float)(Math.random() - 0.5) * mv), (double)((float)(Math.random() - 0.5) * m));
        }
        if (this.getInvulTime() >= 20) {
            Vector3 pos = Vector3.fromEntityCenter((Entity)this).subtract(new Vector3(0.0, 0.2, 0.0));
            for (BlockPos arr : PYLON_LOCATIONS) {
                Vector3 pylonPos = new Vector3((double)(this.source.func_177958_n() + arr.func_177958_n()), (double)(this.source.func_177956_o() + arr.func_177956_o()), (double)(this.source.func_177952_p() + arr.func_177952_p()));
                double worldTime = this.field_70173_aa;
                rad = 0.75f + (float)Math.random() * 0.05f;
                double xp = pylonPos.x + 0.5 + Math.cos(worldTime /= 5.0) * (double)rad;
                double zp = pylonPos.z + 0.5 + Math.sin(worldTime) * (double)rad;
                Vector3 partPos = new Vector3(xp, pylonPos.y, zp);
                Vector3 mot = pos.subtract(partPos).multiply(0.04);
                float r = 0.7f + (float)Math.random() * 0.3f;
                float g = (float)Math.random() * 0.3f;
                float b = 0.7f + (float)Math.random() * 0.3f;
                WispParticleData data = WispParticleData.wisp((float)(0.25f + (float)Math.random() * 0.1f), (float)r, (float)g, (float)b, (float)1.0f);
                this.field_70170_p.func_195594_a((IParticleData)data, partPos.x, partPos.y, partPos.z, 0.0, (double)(-(-0.075f - (float)Math.random() * 0.015f)), 0.0);
                WispParticleData data1 = WispParticleData.wisp((float)0.4f, (float)r, (float)g, (float)b);
                this.field_70170_p.func_195594_a((IParticleData)data1, partPos.x, partPos.y, partPos.z, (double)((float)mot.x), (double)((float)mot.y), (double)((float)mot.z));
            }
        }
    }

    public static boolean checkFeasibility(ItemStack stack) {
        if (stack.func_190926_b()) {
            return true;
        }
        String modid = stack.func_77973_b().getRegistryName().func_110624_b();
        return modid.contains("extrabotany") || modid.contains("botania") || modid.contains("minecraft");
    }

    public static boolean checkInventory(PlayerEntity player) {
        if (player.func_184812_l_() || ((Boolean)ConfigHandler.COMMON.disableDisarm.get()).booleanValue()) {
            return true;
        }
        for (int i = 0; i < player.field_71071_by.func_70297_j_(); ++i) {
            ItemStack stack = player.field_71071_by.func_70301_a(i);
            if (EntityEGO.checkFeasibility(stack)) continue;
            return false;
        }
        return true;
    }

    public static void disarm(PlayerEntity player) {
        if (!((Boolean)ConfigHandler.COMMON.disableDisarm.get()).booleanValue() && !player.func_184812_l_()) {
            for (int i = 0; i < player.field_71071_by.func_70297_j_(); ++i) {
                ItemStack stack = player.field_71071_by.func_70301_a(i);
                if (EntityEGO.checkFeasibility(stack)) continue;
                player.func_71019_a(stack, false);
                player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
            }
        }
    }

    public void unlegalPlayercount() {
        if (this.getPlayersAround().size() > this.playerCount) {
            for (PlayerEntity player : this.getPlayersAround()) {
                if (this.field_70170_p.field_72995_K) continue;
                player.func_145747_a((ITextComponent)new TranslationTextComponent("extrabotanymisc.unlegalPlayercount").func_240699_a_(TextFormatting.RED), Util.field_240973_b_);
            }
            this.func_70106_y();
        }
    }

    public boolean tryAttack() {
        if (this.getPlayersAround().isEmpty()) {
            return false;
        }
        Entity target = (Entity)this.getPlayersAround().get(0);
        this.func_184609_a(Hand.MAIN_HAND);
        if (!this.field_70170_p.field_72995_K) {
            switch (this.getWeaponType()) {
                case 0: {
                    ((ItemTrueShadowKatana)ModItems.trueshadowkatana).attackEntity((LivingEntity)this, target);
                    break;
                }
                case 1: {
                    ((ItemTrueTerrablade)ModItems.trueterrablade).attackEntity((LivingEntity)this, target);
                    break;
                }
                case 2: {
                    ((ItemInfluxWaver)ModItems.influxwaver).attackEntity((LivingEntity)this, target);
                    break;
                }
                case 3: {
                    ((ItemStarWrath)ModItems.starwrath).attackEntity((LivingEntity)this, target);
                    break;
                }
                case 4: {
                    ((ItemFirstFractal)ModItems.firstfractal).attackEntity((LivingEntity)this, target);
                }
            }
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        int invul = this.getInvulTime();
        List<Integer> WAVES = Arrays.asList(this.waves);
        if (this.field_70170_p.field_72995_K) {
            this.particles();
            PlayerEntity player = Botania.proxy.getClientPlayer();
            if (this.getPlayersAround().contains(player)) {
                player.field_71075_bZ.field_75100_b &= player.field_71075_bZ.field_75098_d;
            }
            return;
        }
        this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        if (this.func_184218_aH()) {
            this.func_184210_p();
        }
        if (this.field_70170_p.func_175659_aa() == Difficulty.PEACEFUL) {
            this.func_70106_y();
        }
        for (PlayerEntity playerEntity : this.getPlayersAround()) {
            EntityEGO.disarm(playerEntity);
        }
        if (!((Boolean)ConfigHandler.COMMON.disableLimit.get()).booleanValue()) {
            this.unlegalPlayercount();
        }
        if (invul > 0) {
            this.setInvulTime(invul - 1);
            if ((this.getStage() == 1 || this.getStage() == 3) && invul >= 20) {
                this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.0, this.func_213322_ci().func_82616_c());
                if (invul % 60 == 0 && this.wave < this.MAX_WAVE) {
                    EntityEGOLandmine.spawnLandmine(this.wave, this.field_70170_p, this.source, this);
                    ++this.wave;
                }
                return;
            }
            if (this.getStage() == 2 && invul >= 20) {
                this.func_213293_j(this.func_213322_ci().func_82615_a(), 0.0, this.func_213322_ci().func_82616_c());
                this.func_70606_j(this.func_110143_aJ() + 0.25f);
                if (EntityEGO.countEGOMinionAround(this.field_70170_p, this.source) == 0) {
                    this.setInvulTime(0);
                }
                return;
            }
        }
        if (this.attackDelay > 0) {
            --this.attackDelay;
        } else if (this.tryAttack()) {
            int delay;
            this.attackDelay = delay = (int)((double)(80 - this.getStage() * 15) + 15.0 * Math.random());
        }
        this.smashBlocksAround(net.minecraft.util.math.MathHelper.func_76128_c((double)this.func_226277_ct_()), net.minecraft.util.math.MathHelper.func_76128_c((double)this.func_226278_cu_()), net.minecraft.util.math.MathHelper.func_76128_c((double)this.func_226281_cx_()), 1);
        List<PlayerEntity> players = this.getPlayersAround();
        if (players.isEmpty() && !this.field_70170_p.func_217369_A().isEmpty()) {
            this.func_70106_y();
        } else {
            for (PlayerEntity player : players) {
                if (player.func_70608_bn()) {
                    player.func_213366_dy();
                }
                this.clearPotions(player);
                this.keepInsideArena(player);
                player.field_71075_bZ.field_75100_b &= player.field_71075_bZ.field_75098_d;
            }
        }
        if (!this.func_70089_S() || players.isEmpty()) {
            return;
        }
        if (this.changeWeaponDelay > 0) {
            --this.changeWeaponDelay;
        } else {
            this.changeWeaponDelay = 100;
            int n = this.getStage() == 0 ? this.field_70170_p.field_73012_v.nextInt(2) : (this.getStage() == 1 ? this.field_70170_p.field_73012_v.nextInt(4) : 4);
            this.setWeaponType(n);
        }
        if (this.tpDelay > 0) {
            --this.tpDelay;
        } else if (this.tryAttack()) {
            this.teleportRandomly();
            ++this.tpTimes;
            this.tpDelay = 100 - this.getStage() * 10;
        }
        if (this.getStage() == 0 && this.func_110143_aJ() < 0.75f * this.func_110138_aP()) {
            this.setStage(1);
            this.setInvulTime(460);
            Collections.shuffle(WAVES);
            this.func_70634_a((double)this.source.func_177958_n() + 0.5, this.source.func_177956_o() + 3, (double)this.source.func_177952_p() + 0.5);
            EntityEGOBeam entityEGOBeam = new EntityEGOBeam(this.field_70170_p);
            entityEGOBeam.func_70107_b((double)this.source.func_177958_n() + 0.5, this.source.func_177956_o(), (double)this.source.func_177952_p() + 0.5);
            entityEGOBeam.summoner = this;
            entityEGOBeam.setColor(1.0f, 1.0f, 1.0f);
            entityEGOBeam.setSpeedModifier(1.6f);
            entityEGOBeam.setBeamDamage(11.0f);
            this.field_70170_p.func_217376_c((Entity)entityEGOBeam);
            this.sendMessageToAll("extrabotany.ego.stage0_" + this.field_70170_p.field_73012_v.nextInt(4));
        }
        if (this.getStage() == 1 && this.func_110143_aJ() < 0.25f * this.func_110138_aP()) {
            this.setStage(2);
            this.setInvulTime(600);
            this.setWeaponType(4);
            EntityEGOMinion.spawn(this, this.field_70170_p, this.getSource(), 60.0f * (float)this.playerCount);
            this.func_70634_a((double)this.source.func_177958_n() + 0.5, this.source.func_177956_o() + 3, (double)this.source.func_177952_p() + 0.5);
            this.sendMessageToAll("extrabotany.ego.stage1_" + this.field_70170_p.field_73012_v.nextInt(4));
        }
        if (this.getStage() == 2 && this.func_110143_aJ() <= 0.05f * this.func_110138_aP()) {
            this.wave = 0;
            this.setStage(3);
            this.setInvulTime(460);
            this.sendMessageToAll("extrabotany.ego.stage2_" + this.field_70170_p.field_73012_v.nextInt(4));
            EntityEGOBeam entityEGOBeam = new EntityEGOBeam(this.field_70170_p);
            entityEGOBeam.func_70107_b((double)this.source.func_177958_n() + 0.5, this.source.func_177956_o(), (double)this.source.func_177952_p() + 0.5);
            entityEGOBeam.summoner = this;
            entityEGOBeam.setColor(1.0f, 1.0f, 1.0f);
            entityEGOBeam.setSpeedModifier(1.8f);
            entityEGOBeam.setBeamDamage(11.0f);
            this.field_70170_p.func_217376_c((Entity)entityEGOBeam);
            Vector3d vec = new Vector3d(6.0, 0.0, 0.0);
            EntityEGOBeam beamRed = new EntityEGOBeam(this.field_70170_p);
            beamRed.func_70107_b((double)this.source.func_177958_n() + 0.5 + vec.field_72450_a, this.source.func_177956_o(), (double)this.source.func_177952_p() + 0.5 + vec.field_72449_c);
            beamRed.summoner = this;
            beamRed.setColor(0.8f, 0.1f, 0.1f);
            beamRed.setSpeedModifier(1.2f);
            beamRed.setBeamDamage(17.0f);
            this.field_70170_p.func_217376_c((Entity)beamRed);
            vec.func_178785_b(2.0943952f);
            EntityEGOBeam beamGreen = new EntityEGOBeam(this.field_70170_p);
            beamGreen.func_70107_b((double)this.source.func_177958_n() + 0.5 + vec.field_72450_a, this.source.func_177956_o(), (double)this.source.func_177952_p() + 0.5 + vec.field_72449_c);
            beamGreen.summoner = this;
            beamGreen.setColor(0.1f, 0.8f, 0.1f);
            beamGreen.setSpeedModifier(1.5f);
            beamGreen.setBeamDamage(13.0f);
            this.field_70170_p.func_217376_c((Entity)beamGreen);
            vec.func_178785_b(2.0943952f);
            EntityEGOBeam beamBlue = new EntityEGOBeam(this.field_70170_p);
            beamBlue.func_70107_b((double)this.source.func_177958_n() + 0.5 + vec.field_72450_a, this.source.func_177956_o(), (double)this.source.func_177952_p() + 0.5 + vec.field_72449_c);
            beamBlue.summoner = this;
            beamBlue.setColor(0.1f, 0.1f, 0.8f);
            beamBlue.setSpeedModifier(2.1f);
            beamBlue.setBeamDamage(8.0f);
            this.field_70170_p.func_217376_c((Entity)beamBlue);
            vec.func_178785_b(2.0943952f);
            this.func_70634_a((double)this.source.func_177958_n() + 0.5, this.source.func_177956_o() + 3, (double)this.source.func_177952_p() + 0.5);
        }
    }

    public void sendMessageToAll(String text) {
        for (PlayerEntity player : this.getPlayersAround()) {
            player.func_145747_a((ITextComponent)new TranslationTextComponent(text, new Object[]{this.func_200201_e()}), this.func_110124_au());
        }
    }

    public void func_70606_j(float f) {
        super.func_70606_j(f);
    }

    public boolean func_184222_aU() {
        return false;
    }

    public ResourceLocation func_184647_J() {
        if (this.getStage() < 2) {
            return LootTables.field_186419_a;
        }
        return ModItems.prefix("ego");
    }

    public void func_184178_b(ServerPlayerEntity player) {
        super.func_184178_b(player);
        this.bossInfo.func_186760_a(player);
    }

    public void func_184203_c(ServerPlayerEntity player) {
        super.func_184203_c(player);
        this.bossInfo.func_186761_b(player);
    }

    protected void func_85033_bc() {
        if (this.getInvulTime() == 0) {
            super.func_85033_bc();
        }
    }

    public boolean func_70104_M() {
        return super.func_70104_M() && this.getInvulTime() == 0;
    }

    private void teleportRandomly() {
        Vector3d newPosVec;
        BlockPos tentativeFloorPos;
        double newZ;
        double newX;
        double oldX = this.func_226277_ct_();
        double oldY = this.func_226278_cu_();
        double oldZ = this.func_226281_cx_();
        double newY = this.source.func_177956_o();
        int tries = 0;
        do {
            newX = (double)this.source.func_177958_n() + (this.field_70146_Z.nextDouble() - 0.5) * 12.0;
            newZ = (double)this.source.func_177952_p() + (this.field_70146_Z.nextDouble() - 0.5) * 12.0;
        } while (++tries < 50 && MathHelper.pointDistanceSpace((double)newX, (double)newY, (double)newZ, (double)this.source.func_177958_n(), (double)this.source.func_177956_o(), (double)this.source.func_177952_p()) > 12.0f);
        if (tries == 50) {
            newX = (double)this.source.func_177958_n() + 0.5;
            newY = (double)this.source.func_177956_o() + 1.6;
            newZ = (double)this.source.func_177952_p() + 0.5;
        }
        if (this.field_70170_p.func_180495_p(tentativeFloorPos = new BlockPos(newX, newY - 1.0, newZ)).func_196952_d((IBlockReader)this.field_70170_p, tentativeFloorPos).func_197766_b()) {
            newY -= 1.0;
        }
        this.func_70634_a(newX, newY, newZ);
        this.field_70170_p.func_184148_a(null, oldX, oldY, oldZ, SoundEvents.field_187534_aX, this.func_184176_by(), 1.0f, 1.0f);
        this.func_184185_a(SoundEvents.field_187534_aX, 1.0f, 1.0f);
        Random random = this.func_70681_au();
        int particleCount = 128;
        for (int i = 0; i < particleCount; ++i) {
            double progress = (double)i / (double)(particleCount - 1);
            float vx = (random.nextFloat() - 0.5f) * 0.2f;
            float vy = (random.nextFloat() - 0.5f) * 0.2f;
            float vz = (random.nextFloat() - 0.5f) * 0.2f;
            double px = oldX + (newX - oldX) * progress + (random.nextDouble() - 0.5) * (double)this.func_213311_cf() * 2.0;
            double py = oldY + (newY - oldY) * progress + random.nextDouble() * (double)this.func_213302_cg();
            double pz = oldZ + (newZ - oldZ) * progress + (random.nextDouble() - 0.5) * (double)this.func_213311_cf() * 2.0;
            this.field_70170_p.func_195594_a((IParticleData)ParticleTypes.field_197599_J, px, py, pz, (double)vx, (double)vy, (double)vz);
        }
        Vector3d oldPosVec = new Vector3d(oldX, oldY + (double)(this.func_213302_cg() / 2.0f), oldZ);
        if (oldPosVec.func_72436_e(newPosVec = new Vector3d(newX, newY + (double)(this.func_213302_cg() / 2.0f), newZ)) > 1.0) {
            for (PlayerEntity player : this.getPlayersAround()) {
                boolean hit = player.func_174813_aQ().func_186662_g(0.25).func_216365_b(oldPosVec, newPosVec).isPresent();
                if (!hit) continue;
                player.func_70097_a(DamageSource.func_76358_a((LivingEntity)this), 6.0f);
            }
            int breakSteps = (int)oldPosVec.func_72438_d(newPosVec);
            if (breakSteps >= 2) {
                for (int i = 0; i < breakSteps; ++i) {
                    float progress = (float)i / (float)(breakSteps - 1);
                    int breakX = net.minecraft.util.math.MathHelper.func_76128_c((double)(oldX + (newX - oldX) * (double)progress));
                    int breakY = net.minecraft.util.math.MathHelper.func_76128_c((double)(oldY + (newY - oldY) * (double)progress));
                    int breakZ = net.minecraft.util.math.MathHelper.func_76128_c((double)(oldZ + (newZ - oldZ) * (double)progress));
                    this.smashBlocksAround(breakX, breakY, breakZ, 1);
                }
            }
        }
    }

    @OnlyIn(value=Dist.CLIENT)
    public ResourceLocation getBossBarTexture() {
        return BossBarHandler.defaultBossBar;
    }

    @OnlyIn(value=Dist.CLIENT)
    public Rectangle2d getBossBarTextureRect() {
        return new Rectangle2d(0, 0, 185, 15);
    }

    @OnlyIn(value=Dist.CLIENT)
    public Rectangle2d getBossBarHPTextureRect() {
        Rectangle2d barRect = this.getBossBarTextureRect();
        return new Rectangle2d(0, barRect.func_199319_b() + barRect.func_199317_d(), 181, 7);
    }

    @OnlyIn(value=Dist.CLIENT)
    public int bossBarRenderCallback(MatrixStack ms, int x, int y) {
        ms.func_227860_a_();
        int px = x + 160;
        int py = y + 12;
        Minecraft mc = Minecraft.func_71410_x();
        ItemStack stack = new ItemStack((IItemProvider)Items.field_196184_dx);
        mc.func_175599_af().func_175042_a(stack, px, py);
        mc.field_71466_p.func_238405_a_(ms, Integer.toString(this.playerCount), (float)(px + 15), (float)(py + 4), 0xFFFFFF);
        ms.func_227865_b_();
        return 5;
    }

    public UUID getBossInfoUuid() {
        return this.bossInfoUUID;
    }

    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeInt(this.playerCount);
        buffer.writeLong(this.source.func_218275_a());
        buffer.writeLong(this.bossInfoUUID.getMostSignificantBits());
        buffer.writeLong(this.bossInfoUUID.getLeastSignificantBits());
    }

    @OnlyIn(value=Dist.CLIENT)
    public void readSpawnData(PacketBuffer additionalData) {
        this.playerCount = additionalData.readInt();
        this.source = BlockPos.func_218283_e((long)additionalData.readLong());
        long msb = additionalData.readLong();
        long lsb = additionalData.readLong();
        this.bossInfoUUID = new UUID(msb, lsb);
        Minecraft.func_71410_x().func_147118_V().func_147682_a((ISound)new EgoMusic(this));
    }

    @Nonnull
    public IPacket<?> func_213297_N() {
        return NetworkHooks.getEntitySpawningPacket((Entity)this);
    }

    public boolean func_184652_a(PlayerEntity player) {
        return false;
    }

    @OnlyIn(value=Dist.CLIENT)
    private static class EgoMusic
    extends TickableSound {
        private final EntityEGO guardian;

        public EgoMusic(EntityEGO guardian) {
            super(ModSounds.swordland, SoundCategory.RECORDS);
            this.guardian = guardian;
            this.field_147660_d = guardian.getSource().func_177958_n();
            this.field_147661_e = guardian.getSource().func_177956_o();
            this.field_147658_f = guardian.getSource().func_177952_p();
        }

        public void func_73660_a() {
            if (!this.guardian.func_70089_S()) {
                this.func_239509_o_();
            }
        }
    }
}
