package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.block.entity.ChestBlockEntity;

public class ChestESP extends Module {
    public ChestESP() { super("ChestESP", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null) return;
        for (ChestBlockEntity chest : mc.world.getBlockEntities(ChestBlockEntity.class)) {
            // Подсветка сундуков
            // В 1.21.4 используется другой метод
        }
    }
}
