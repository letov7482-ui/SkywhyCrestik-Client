package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.block.entity.MobSpawnerBlockEntity;

public class SpawnerESP extends Module {
    public SpawnerESP() { super("SpawnerESP", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null) return;
        for (MobSpawnerBlockEntity spawner : mc.world.getBlockEntities(MobSpawnerBlockEntity.class)) {
            // Подсветка спавнеров
        }
    }
}
