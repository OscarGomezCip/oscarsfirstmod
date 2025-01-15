package net.oscar.OscarFirstMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class modFood {
    public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100), 0.05f).build();
    public static final FoodProperties CHARGEDPEPPER = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.8f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500), 1f).effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).build();

}
