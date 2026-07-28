package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class Scaffold extends Module {
    public Scaffold() { super("Scaffold", Category.MOVEMENT); }
    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        if (mc.player.getY() % 1 > 0.1) return;
        BlockPos below = mc.player.getBlockPos().down();
        if (mc.world.getBlockState(below).isAir()) {
            for (int i = 0; i < 9; i++) {
                ItemStack stack = mc.player.getInventory().getStack(i);
                if (stack.getItem() instanceof BlockItem) {
                    mc.player.getInventory().selectedSlot = i;
                    BlockHitResult hit = new BlockHitResult(
                        new Vec3d(below.getX() + 0.5, below.getY(), below.getZ() + 0.5),
                        Direction.UP,
                        below,
                        false
                    );
                    mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, hit);
                    break;
                }
            }
        }
    }
}
