package com.skywhy.module.modules;
import com.skywhy.module.Module;
import net.minecraft.entity.player.PlayerEntity;

public class AntiBot extends Module {
    public AntiBot() { super("AntiBot", Category.COMBAT); }
    @Override
    public void onTick() {
        if (mc.world == null) return;
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            if (p.isInvisible()) p.remove(Entity.RemovalReason.DISCARDED);
        }
    }
}
