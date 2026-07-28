package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class MotionBlur extends Module {
    public MotionBlur() { super("MotionBlur", Category.RENDER); }

    @Override
    public void onTick() {
        // MotionBlur требует шейдеров
        // Упрощённая версия - просто замедление рендера
    }
}
