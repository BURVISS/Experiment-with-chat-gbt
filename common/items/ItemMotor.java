/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Rarity
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.EntityPredicates
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockRayTraceResult
 *  net.minecraft.util.math.RayTraceContext$FluidMode
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.world.World
 *  vazkii.botania.common.item.relic.ItemRelic
 */
package com.meteor.extrabotany.common.items;

import com.meteor.extrabotany.ExtraBotany;
import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import vazkii.botania.common.item.relic.ItemRelic;

public class ItemMotor
extends ItemRelic {
    private static final Predicate<Entity> field_219989_a = EntityPredicates.field_180132_d.and(Entity::func_70067_L);

    public ItemMotor() {
        super(new Item.Properties().func_200916_a(ExtraBotany.itemGroup).func_208103_a(Rarity.EPIC).func_200917_a(1).setNoRepair());
    }

    public ActionResult<ItemStack> func_77659_a(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.func_184586_b(handIn);
        BlockRayTraceResult raytraceresult = ItemMotor.func_219968_a((World)worldIn, (PlayerEntity)playerIn, (RayTraceContext.FluidMode)RayTraceContext.FluidMode.ANY);
        if (raytraceresult.func_216346_c() == RayTraceResult.Type.MISS) {
            return ActionResult.func_226250_c_((Object)itemstack);
        }
        Vector3d vec3d = playerIn.func_70676_i(1.0f);
        double d0 = 5.0;
        List list = worldIn.func_175674_a((Entity)playerIn, playerIn.func_174813_aQ().func_216361_a(vec3d.func_186678_a(5.0)).func_186662_g(1.0), field_219989_a);
        if (!list.isEmpty()) {
            Vector3d vec3d1 = playerIn.func_174824_e(1.0f);
            for (Entity entity : list) {
                AxisAlignedBB axisalignedbb = entity.func_174813_aQ().func_186662_g((double)entity.func_70111_Y());
                if (!axisalignedbb.func_72318_a(vec3d1)) continue;
                return ActionResult.func_226250_c_((Object)itemstack);
            }
        }
        if (raytraceresult.func_216346_c() == RayTraceResult.Type.BLOCK) {
            EntityMotor boatentity = new EntityMotor(worldIn, raytraceresult.func_216347_e().field_72450_a, raytraceresult.func_216347_e().field_72448_b, raytraceresult.func_216347_e().field_72449_c);
            boatentity.field_70177_z = playerIn.field_70177_z;
            boatentity.setOwnerId(playerIn.func_110124_au());
            if (!worldIn.func_226665_a__((Entity)boatentity, boatentity.func_174813_aQ().func_186662_g(-0.1))) {
                return ActionResult.func_226251_d_((Object)itemstack);
            }
            if (!worldIn.field_72995_K) {
                worldIn.func_217376_c((Entity)boatentity);
                if (!playerIn.field_71075_bZ.field_75098_d) {
                    itemstack.func_190918_g(1);
                }
            }
            return ActionResult.func_226248_a_((Object)itemstack);
        }
        return ActionResult.func_226250_c_((Object)itemstack);
    }
}
