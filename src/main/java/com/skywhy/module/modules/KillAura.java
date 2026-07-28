package com.skywhy.module.modules;

import com.skywhy.module.Module;
import com.skywhy.anti.AntiBanSystem;
import com.skywhy.utils.RotationUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class KillAura extends Module {
    public Random random = new Random();
    private long lastAttack = 0;
    private float range = 4.2f;
    private float hitboxMultiplier = 0.3f;
    public RotationUtils.RotationMode rotationMode = RotationUtils.RotationMode.SMOOTH;
    public float rotationSpeed = 10f;
    private boolean autoSwitchMode = true;
    private boolean silentRotate = true;

    public KillAura() { super("KillAura", Category.COMBAT); }

    @Override
    public void onTick() {
        if (mc.player == null || mc.world == null) return;
        Entity target = findTarget();
        if (target == null) return;

        long now = System.currentTimeMillis();
        int delay = getDelay();
        if (now - lastAttack < delay + random.nextInt(30)) return;

        double expandedRange = range + hitboxMultiplier;
        if (target.distanceTo(mc.player) > expandedRange + 1.0) return;

        if (silentRotate) {
            RotationUtils.rotateToEntity(target, rotationMode, rotationSpeed);
        } else {
            Vec3d targetPos = target.getPos().add(0, target.getHeight() / 2, 0);
            double dx = targetPos.x - mc.player.getX();
            double dz = targetPos.z - mc.player.getZ();
            float yaw = (float) (Math.atan2(dz, dx) * 180 / Math.PI) - 90;
            float pitch = (float) (-Math.atan2(targetPos.y - mc.player.getEyeY(),
                Math.sqrt(dx * dx + dz * dz)) * 180 / Math.PI);
            mc.player.setYaw(yaw + AntiBanSystem.getRotationOffset());
            mc.player.setPitch(pitch + AntiBanSystem.getRotationOffset() * 0.5f);
        }

        mc.interactionManager.attackEntity(mc.player, target);
        mc.player.swingHand(Hand.MAIN_HAND);
        lastAttack = now + (long) (random.nextInt(20) - 10);

        if (autoSwitchMode) {
            String server = mc.getCurrentServerEntry() != null ?
                mc.getCurrentServerEntry().address : "";
            if (server.contains("funtime") || server.contains("spooky")) {
                rotationMode = RotationUtils.RotationMode.RANDOM;
                rotationSpeed = 15f;
            } else if (server.contains("crystal") || server.contains("anchor")) {
                rotationMode = RotationUtils.RotationMode.SMOOTH;
                rotationSpeed = 8f;
            } else {
                rotationMode = RotationUtils.RotationMode.SMOOTH;
                rotationSpeed = 10f;
            }
        }
    }

    private int getDelay() {
        String server = mc.getCurrentServerEntry() != null ?
            mc.getCurrentServerEntry().address : "";
        if (server.contains("funtime")) return 80 + random.nextInt(40);
        if (server.contains("spooky")) return 100 + random.nextInt(50);
        if (server.contains("crystal")) return 50 + random.nextInt(30);
        if (server.contains("anchor")) return 60 + random.nextInt(40);
        return 80 + random.nextInt(30);
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

    public void setRotationMode(RotationUtils.RotationMode mode) { this.rotationMode = mode; }
    public void setRotationSpeed(float speed) { this.rotationSpeed = Math.max(speed, 1f); }
    public void setRange(float range) { this.range = Math.min(range, 5.0f); }
    public void setHitboxMultiplier(float val) { this.hitboxMultiplier = val; }
    public void setSilentRotate(boolean val) { this.silentRotate = val; }
    public void setAutoSwitchMode(boolean val) { this.autoSwitchMode = val; }
}
