package com.skywhy.module.modules;

import com.skywhy.module.Module;

public class Freecam extends Module {
    private double startX, startY, startZ;

    public Freecam() { super("Freecam", Category.RENDER); }

    @Override
    public void onEnable() {
        if (mc.player == null) return;
        startX = mc.player.getX();
        startY = mc.player.getY();
        startZ = mc.player.getZ();
        mc.options.setPerspective(net.minecraft.client.option.Perspective.THIRD_PERSON_BACK);
    }

    @Override
    public void onTick() {
        if (mc.player == null) return;
        double speed = 0.2;
        if (mc.options.forwardKey.isPressed()) {
            startX += speed * Math.sin(Math.toRadians(mc.player.getYaw()));
            startZ += speed * Math.cos(Math.toRadians(mc.player.getYaw()));
        }
        if (mc.options.backKey.isPressed()) {
            startX -= speed * Math.sin(Math.toRadians(mc.player.getYaw()));
            startZ -= speed * Math.cos(Math.toRadians(mc.player.getYaw()));
        }
        if (mc.options.leftKey.isPressed()) {
            startX += speed * Math.cos(Math.toRadians(mc.player.getYaw()));
            startZ -= speed * Math.sin(Math.toRadians(mc.player.getYaw()));
        }
        if (mc.options.rightKey.isPressed()) {
            startX -= speed * Math.cos(Math.toRadians(mc.player.getYaw()));
            startZ += speed * Math.sin(Math.toRadians(mc.player.getYaw()));
        }
        if (mc.options.jumpKey.isPressed()) startY += speed;
        if (mc.options.sneakKey.isPressed()) startY -= speed;
        mc.player.setPosition(startX, startY, startZ);
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.setPosition(startX, startY, startZ);
            mc.options.setPerspective(net.minecraft.client.option.Perspective.FIRST_PERSON);
        }
    }
}
