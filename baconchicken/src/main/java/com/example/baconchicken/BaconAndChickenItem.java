package com.example.baconchicken;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

/** Food item that also restores the eater's health to full (all hearts). */
public class BaconAndChickenItem extends Item {
    public BaconAndChickenItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide) {
            entity.setHealth(entity.getMaxHealth());
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
