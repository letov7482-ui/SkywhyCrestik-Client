package com.skywhy.module.modules;

import com.skywhy.module.Module;
import com.skywhy.anti.AntiBanSystem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class KillAura extends Module {
    private Random random = new Random();
    private long lastAttack = 0;
    private float range = 4.2f;
    private float hitboxMultiplier = 0.3f;
    private boolean silentRotate = true;

    public KillAura() { super("KillAura", Category.COMBAT); }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        Entity target = findTarget();
        if (target == null) return;

        long now = System.currentTimeMillis();
        int delay = 80 + random.nextInt(40);
        if (now - lastAttack < delay + random.nextInt(30)) return;

        double expandedRange = range + hitboxMultiplier;
        if (target.distanceTo(mc.player) > expandedRange + 1.0) return;

        if (silentRotate) {
            Vec3d targetPos = target.getPos().add(0, target.getHeight()/2, 0);
            double dx = targetPos.x - mc.player.getX();
            double dz = targetPos.z - mc.player.getZ();
            float yaw = (float)(Math.atan2(dz, dx) * 180 / Math.PI) - 90;
            float pitch = (float)(-Math.atan2(targetPos.y - mc.player.getEyeY(),
                Math.sqrt(dx*dx + dz*dz)) * 180 / Math.PI);
            mc.player.setYaw(yaw + AntiBanSystem.getRotationOffset());
            mc.player.setPitch(pitch + AntiBanSystem.getRotationOffset() * 0.5f);
        }

        mc.interactionManager.attackEntity(mc.player, target);
        mc.player.swingHand(Hand.MAIN_HAND);
        lastAttack = now + (long)(random.nextInt(20) - 10);

        // Server detection auto-switch
        if (mc.getCurrentServerEntry() != null) {
            String server = mc.getCurrentServerEntry().address;
            if (server.contains("funtime")) { range = 4.0f; hitboxMultiplier = 0.25f; }
            else if (server.contains("spooky")) { range = 4.5f; hitboxMultiplier = 0.35f; }
            else if (server.contains("crystal")) { range = 4.2f; hitboxMultiplier = 0.2f; }
            else if (server.contains("anchor")) { range = 4.0f; hitboxMultiplier = 0.3f; }
        }
    }

    private Entity findTarget() {
        if (mc.world == null) return null;
        List<Entity> targets = mc.world.getEntities()
            .stream()
            .filter(e -> e instanceof PlayerEntity && e != mc.player)
            .filter(e -> e.distanceTo(mc.player) < range + hitboxMultiplier + 2.0)
            .sorted(Comparator.comparingDouble(e -> e.distanceTo(mc.player)))
            .toList();
        return targets.isEmpty() ? null : targets.get(0);
    }
}
