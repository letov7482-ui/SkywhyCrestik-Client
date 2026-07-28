package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class Nametags extends Module {
    public Nametags() { super("Nametags", Category.VISUAL); }

    @Override
    public void onTick() {
        if (mc.world == null || mc.player == null) return;
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            double dist = p.distanceTo(mc.player);
            String tag = p.getName().getString() + " §7" + (int)dist + "m";
            p.setCustomName(Text.literal(tag));
            p.setCustomNameVisible(true);
        }
    }
}
