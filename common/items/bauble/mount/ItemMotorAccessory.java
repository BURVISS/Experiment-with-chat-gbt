/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.Item$Properties
 *  net.minecraft.world.World
 *  vazkii.botania.common.item.relic.ItemRelicBauble
 */
package com.meteor.extrabotany.common.items.bauble.mount;

import com.meteor.extrabotany.api.items.IMountableAccessory;
import com.meteor.extrabotany.common.entities.mountable.EntityMotor;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import vazkii.botania.common.item.relic.ItemRelicBauble;

public class ItemMotorAccessory
extends ItemRelicBauble
implements IMountableAccessory {
    public ItemMotorAccessory(Item.Properties props) {
        super(props);
    }

    @Override
    public Entity getMountableEntity(World world) {
        EntityMotor motor = new EntityMotor(world);
        motor.func_213293_j(0.0, 0.0, 0.0);
        motor.setMountable(true);
        return motor;
    }
}
