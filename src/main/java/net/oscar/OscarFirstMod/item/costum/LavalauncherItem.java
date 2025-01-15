package net.oscar.OscarFirstMod.item.costum;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.checkerframework.common.returnsreceiver.qual.This;

public class LavalauncherItem extends Item {
    public LavalauncherItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.FLINTANDSTEEL_USE, SoundSource.NEUTRAL, 1.0F, 1.0F);

        if (!world.isClientSide) {
            SmallFireball fireball = new SmallFireball(world, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);
            fireball.setPos(player.getX(), player.getY() + 1.5, player.getZ());
            world.addFreshEntity(fireball);
        }

        player.awardStat(Stats.ITEM_USED.get(this));

        player.getCooldowns().addCooldown(this, 20);

        return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide);
    }
}