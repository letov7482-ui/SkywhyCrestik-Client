package com.skywhy.module.modules;
import com.skywhy.module.Module;
import net.minecraft.util.math.Vec3d;

public class Velocity extends Module {
    public Velocity() { super("Velocity", Category.COMBAT); }
    @Override
    public void onTick() {
        if (mc.player == null) return;
        mc.player.setVelocity(new Vec3d(mc.player.getVelocity().x * 0.5, mc.player.getVelocity().y * 0.5, mc.player.getVelocity().z * 0.5));
    }
}
