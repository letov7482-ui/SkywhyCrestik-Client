package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.player.PlayerEntity;

public class ESP extends Module {
    public ESP() { super("ESP", Category.VISUAL); }
    @Override
    public void onRender() {
        if (mc.world == null || mc.player == null) return;
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            // Рендер ESP (упрощённо)
        }
    }
}
