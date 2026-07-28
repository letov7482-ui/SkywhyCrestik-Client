package com.skywhy.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class RotationUtils {
    private static final MinecraftClient mc = MinecraftClient.getInstance();

    public enum RotationMode {
        INSTANT, SMOOTH, SILENT, DEGREE_90, DEGREE_180, DEGREE_270, DEGREE_360, RANDOM
    }

    public static void rotateToEntity(Entity target, RotationMode mode, float speed) {
        if (mc.player == null || target == null) return;
        Vec3d targetPos = target.getPos().add(0, target.getHeight() / 2, 0);
        rotateToPosition(targetPos, mode, speed);
    }

    public static void rotateToPosition(Vec3d target, RotationMode mode, float speed) {
        if (mc.player == null) return;
        double dx = target.x - mc.player.getX();
        double dy = target.y - mc.player.getEyeY();
        double dz = target.z - mc.player.getZ();
        float targetYaw = (float) (Math.atan2(dz, dx) * 180 / Math.PI) - 90;
        float targetPitch = (float) (-Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * 180 / Math.PI);

        float currentYaw = mc.player.getYaw();
        float currentPitch = mc.player.getPitch();

        switch (mode) {
            case INSTANT:
                mc.player.setYaw(targetYaw);
                mc.player.setPitch(targetPitch);
                break;

            case SMOOTH:
                float yawDiff = MathHelper.wrapDegrees(targetYaw - currentYaw);
                float pitchDiff = MathHelper.wrapDegrees(targetPitch - currentPitch);
                mc.player.setYaw(currentYaw + yawDiff / speed);
                mc.player.setPitch(currentPitch + pitchDiff / speed);
                break;

            case SILENT:
                mc.player.networkHandler.sendPacket(
                    new net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.LookAndOnGround(
                        targetYaw, targetPitch, mc.player.isOnGround()
                    )
                );
                break;

            case DEGREE_90: {
                float yaw90 = roundToAngle(targetYaw, 90);
                mc.player.setYaw(yaw90);
                mc.player.setPitch(targetPitch);
                break;
            }

            case DEGREE_180: {
                float yaw180 = roundToAngle(targetYaw, 180);
                mc.player.setYaw(yaw180);
                mc.player.setPitch(targetPitch);
                break;
            }

            case DEGREE_270: {
                float yaw270 = roundToAngle(targetYaw, 270);
                mc.player.setYaw(yaw270);
                mc.player.setPitch(targetPitch);
                break;
            }

            case DEGREE_360: {
                float yaw360 = roundToAngle(targetYaw, 360);
                mc.player.setYaw(yaw360);
                mc.player.setPitch(targetPitch);
                break;
            }

            case RANDOM:
                float randomYaw = targetYaw + (float) (Math.random() * 30 - 15);
                float randomPitch = targetPitch + (float) (Math.random() * 10 - 5);
                mc.player.setYaw(randomYaw);
                mc.player.setPitch(randomPitch);
                break;
        }
    }

    private static float roundToAngle(float yaw, int angle) {
        float remainder = yaw % angle;
        if (remainder < 0) remainder += angle;
        if (remainder > angle / 2) {
            return yaw + (angle - remainder);
        } else {
            return yaw - remainder;
        }
    }

    public static float getAngleDifference(float yaw1, float yaw2) {
        float diff = MathHelper.wrapDegrees(yaw2 - yaw1);
        return Math.abs(diff);
    }

    public static boolean isLookingAtEntity(Entity entity, float tolerance) {
        if (mc.player == null || entity == null) return false;
        Vec3d targetPos = entity.getPos().add(0, entity.getHeight() / 2, 0);
        Vec3d lookVec = mc.player.getRotationVector();
        Vec3d toTarget = targetPos.subtract(mc.player.getEyePos()).normalize();
        double dot = lookVec.dotProduct(toTarget);
        return dot > Math.cos(Math.toRadians(tolerance));
    }
}
