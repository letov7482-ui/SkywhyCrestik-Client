package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.player.PlayerEntity;

public class Tracers extends Module {
    public Tracers() { super("Tracers", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null || mc.player == null) return;
        // Визуальные линии рисуются через Render2D/3D
        // Здесь логика для отрисовки через контекст
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            // Линия от игрока к цели
        }
    }
}
