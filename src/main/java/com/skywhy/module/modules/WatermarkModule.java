package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class WatermarkModule extends Module {
    public WatermarkModule() { super("Watermark", Category.HUD); }
    @Override
    public void onTick() {
        // HUD рендерится через HUDManager
    }
}
