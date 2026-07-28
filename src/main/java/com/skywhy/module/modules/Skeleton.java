package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.player.PlayerEntity;

public class Skeleton extends Module {
    public Skeleton() { super("Skeleton", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null || mc.player == null) return;
        // Рендер скелета игроков
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            // Отрисовка линий между суставами
        }
    }
}
