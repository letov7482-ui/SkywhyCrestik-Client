package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class AutoTrap extends Module {
    public AutoTrap() { super("AutoTrap", Category.COMBAT); }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        BlockPos pos = mc.player.getBlockPos();
        
        // Строим клетку вокруг игрока
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = 0; y <= 2; y++) {
                    BlockPos target = pos.add(x, y, z);
                    if (mc.world.getBlockState(target).isAir()) {
                        placeBlock(target);
                    }
                }
            }
        }
    }

    private void placeBlock(BlockPos pos) {
        for (int i = 0; i < 9; i++) {
            ItemStack stack = mc.player.getInventory().getStack(i);
            if (stack.getItem() instanceof BlockItem) {
                mc.player.getInventory().selectedSlot = i;
                BlockHitResult hit = new BlockHitResult(
                    new Vec3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5),
                    Direction.UP, pos, false
                );
                mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, hit);
                return;
            }
        }
    }
}
