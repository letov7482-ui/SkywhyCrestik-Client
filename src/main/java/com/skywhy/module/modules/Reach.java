package com.skywhy.module.modules;
import com.skywhy.module.Module;

public class Reach extends Module {
    public Reach() { super("Reach", Category.COMBAT); }
    @Override
    public void onTick() { if (mc.player != null) mc.player.getAbilities().setReach(42); }
}
