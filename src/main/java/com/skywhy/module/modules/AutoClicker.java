package com.skywhy.module.modules;
import com.skywhy.module.Module;
import net.minecraft.util.Hand;

public class AutoClicker extends Module {
    private long lastClick = 0;
    public AutoClicker() { super("AutoClicker", Category.COMBAT); }
    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        if (System.currentTimeMillis() - lastClick < 100) return;
        if (mc.options.attackKey.isPressed()) {
            mc.player.swingHand(Hand.MAIN_HAND);
            lastClick = System.currentTimeMillis();
        }
    }
}
