package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module {
    public Speed() { super("Speed", Category.MOVEMENT); }
    @Override
    public void onTick() {
        if (mc.player == null || !mc.player.isOnGround()) return;
        Vec3d vel = mc.player.getVelocity();
        mc.player.setVelocity(vel.x * 1.3, vel.y, vel.z * 1.3);
    }
}
