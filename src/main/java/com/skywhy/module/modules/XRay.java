package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.block.Blocks;

public class XRay extends Module {
    public XRay() { super("XRay", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null) return;
        // Упрощённый рентген - через изменение прозрачности блоков
        // Полноценный XRay требует шейдеров
    }
}
