package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class Sprint extends Module {
    public Sprint() { super("Sprint", Category.MOVEMENT); }
    @Override
    public void onTick() {
        if (mc.player != null && mc.options.forwardKey.isPressed()) {
            mc.player.setSprinting(true);
        }
    }
}
