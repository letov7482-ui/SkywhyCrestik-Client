package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class Speed extends Module {
    public Speed() { super("Speed", Category.MOVEMENT); }
    @Override
    public void onTick() {
        if (mc.player == null || !mc.player.isOnGround()) return;
        mc.player.getVelocity().x *= 1.3;
        mc.player.getVelocity().z *= 1.3;
    }
}
