package com.skywhy.module;

import net.minecraft.client.MinecraftClient;

public class Module {
    protected String name;
    protected boolean enabled;
    protected int key;
    protected Category category;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    public enum Category { COMBAT, MOVEMENT, PLAYER, VISUAL, RENDER, MISC, HUD, COSMETIC }

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
        this.key = 0;
    }

    public void toggle() { enabled = !enabled; }
    public void setEnabled(boolean e) { enabled = e; }
    public boolean isEnabled() { return enabled; }
    public String getName() { return name; }
    public Category getCategory() { return category; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
    public void onTick() {}
    public void onRender() {}
    public void onEnable() {}
    public void onDisable() {}
}
