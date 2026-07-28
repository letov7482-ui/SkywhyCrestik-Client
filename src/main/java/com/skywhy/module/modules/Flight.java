package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.util.math.Vec3d;

public class Flight extends Module {
    public Flight() { super("Flight", Category.MOVEMENT); }
    @Override
    public void onTick() {
        if (mc.player == null) return;
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(0.05f);
        mc.player.setVelocity(new Vec3d(mc.player.getVelocity().x, 0, mc.player.getVelocity().z));
    }
    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.getAbilities().flying = false;
            mc.player.getAbilities().setFlySpeed(0.05f);
        }
    }
}
