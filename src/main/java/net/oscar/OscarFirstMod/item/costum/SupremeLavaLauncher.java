package net.oscar.OscarFirstMod.item.costum;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.ClipContext;

public class SupremeLavaLauncher extends Item {
    public SupremeLavaLauncher(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        // Definir el cooldown
        player.getCooldowns().addCooldown(this, 10); // 10 ticks = 0.5 segundos

        if (!world.isClientSide) {
            // Calcular la posición de impacto
            Vec3 startVec = player.getEyePosition(1.0F);
            Vec3 lookVec = player.getViewVector(1.0F);
            Vec3 endVec = startVec.add(lookVec.scale(10.0D)); // Rango de 10 bloques

            ClipContext context = new ClipContext(startVec, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player);
            BlockHitResult hitResult = world.clip(context);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockpos = hitResult.getBlockPos().relative(hitResult.getDirection());

                // Colocar el bloque de lava
                world.setBlock(blockpos, Blocks.LAVA.defaultBlockState(), 11);
            }
        }

        itemstack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand)); // Reducir la durabilidad

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }
}



