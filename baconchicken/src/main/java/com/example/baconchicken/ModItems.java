package com.example.baconchicken;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BaconChickenMod.MOD_ID);

    public static final FoodProperties BACON_AND_CHICKEN_FOOD = new FoodProperties.Builder()
            .nutrition(20)              // fills the entire hunger bar
            .saturationMod(1.0f)
            .alwaysEat()
            // Regeneration II for 30 seconds
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 1.0f)
            // Strength II for 30 seconds
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), 1.0f)
            .build();

    public static final RegistryObject<Item> BACON_AND_CHICKEN = ITEMS.register("bacon_and_chicken",
            () -> new BaconAndChickenItem(new Item.Properties().stacksTo(16).food(BACON_AND_CHICKEN_FOOD)));
}
