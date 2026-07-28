package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import java.util.Comparator;

public class CrystalAura extends Module {
    private long lastPlace = 0;
    private long lastBreak = 0;

    public CrystalAura() { super("CrystalAura", Category.COMBAT); }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        long now = System.currentTimeMillis();

        // Поиск кристалла для взрыва
        EndCrystalEntity crystal = mc.world.getEntitiesByClass(EndCrystalEntity.class, 
            mc.player.getBoundingBox().expand(5.0, 5.0, 5.0), c -> true)
            .stream()
            .min(Comparator.comparingDouble(c -> c.distanceTo(mc.player)))
            .orElse(null);

        if (crystal != null && now - lastBreak > 100) {
            mc.interactionManager.attackEntity(mc.player, crystal);
            mc.player.swingHand(Hand.MAIN_HAND);
            lastBreak = now;
            return;
        }

        // Поиск места для установки кристалла
        if (now - lastPlace > 200) {
            BlockPos pos = findPlacePos();
            if (pos != null && mc.player.getInventory().contains(Items.END_CRYSTAL.getDefaultStack())) {
                mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND);
                lastPlace = now;
            }
        }
    }

    private BlockPos findPlacePos() {
        for (int x = -3; x <= 3; x++) {
            for (int z = -3; z <= 3; z++) {
                for (int y = -1; y <= 1; y++) {
                    BlockPos pos = mc.player.getBlockPos().add(x, y, z);
                    if (mc.world.getBlockState(pos).isAir() && 
                        mc.world.getBlockState(pos.down()).isSolid()) {
                        return pos;
                    }
                }
            }
        }
        return null;
    }
}
