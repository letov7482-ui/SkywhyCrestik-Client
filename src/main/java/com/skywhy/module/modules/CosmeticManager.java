package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class CosmeticManager extends Module {
    public CosmeticManager() { super("Cosmetics", Category.COSMETIC); }
    @Override
    public void onRender() {
        // Косметика: плащи, крылья, аура
    }
}
