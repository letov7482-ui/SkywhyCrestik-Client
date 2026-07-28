package com.skywhy.anti;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import java.util.Random;

public class AntiBanSystem {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private static final Random random = new Random();
    private static long lastJitter = 0;
    private static long lastRotate = 0;
    private static float rotationOffset = 0;
    private static boolean initialized = false;

    public static void init() { initialized = true; }

    public static void bypass() {
        if (!initialized || mc.player == null || mc.getNetworkHandler() == null) return;
        long now = System.currentTimeMillis();

        if (now - lastJitter > 50 + random.nextInt(100)) {
            double ox = (random.nextDouble() - 0.5) * 0.001;
            double oz = (random.nextDouble() - 0.5) * 0.001;
            mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(
                mc.player.getX() + ox, mc.player.getY(), mc.player.getZ() + oz,
                mc.player.isOnGround(), mc.player.isOnGround()  // 4-й и 5-й параметры
            ));
            lastJitter = now;
        }

        if (now - lastRotate > 100 + random.nextInt(200)) {
            float yawOff = (float)((random.nextDouble() - 0.5) * 2.0);
            float pitchOff = (float)((random.nextDouble() - 0.5) * 1.0);
            mc.getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(
                mc.player.getYaw() + yawOff, mc.player.getPitch() + pitchOff,
                mc.player.isOnGround(), mc.player.isOnGround()
            ));
            lastRotate = now;
        }

        if (random.nextInt(100) > 97) {
            mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player,
                ClientCommandC2SPacket.Mode.PRESS_SHIFT_KEY));
        }
        if (random.nextInt(100) > 98) {
            mc.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(mc.player,
                ClientCommandC2SPacket.Mode.RELEASE_SHIFT_KEY));
        }

        rotationOffset = (float)((random.nextDouble() - 0.5) * 0.5);
    }

    public static float getRotationOffset() { return rotationOffset; }
}
