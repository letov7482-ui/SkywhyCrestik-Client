package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.item.FishingRodItem;
import net.minecraft.util.Hand;

public class AutoFish extends Module {
    private long lastCast = 0;
    private boolean fishing = false;

    public AutoFish() { super("AutoFish", Category.PLAYER); }

    @Override
    public void onTick() {
        if (mc.player == null) return;
        long now = System.currentTimeMillis();

        // Ищем удочку
        int slot = -1;
        for (int i = 0; i < 9; i++) {
            if (mc.player.getInventory().getStack(i).getItem() instanceof FishingRodItem) {
                slot = i;
                break;
            }
        }
        if (slot == -1) return;
        mc.player.getInventory().selectedSlot = slot;

        // Если есть удочка и нажимаем правую кнопку
        if (now - lastCast > 500) {
            mc.options.useKey.setPressed(true);
            lastCast = now;
        }
    }
}
