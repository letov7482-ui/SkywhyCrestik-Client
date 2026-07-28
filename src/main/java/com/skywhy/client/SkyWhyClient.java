package com.skywhy.client;

import com.skywhy.module.ModuleManager;
import com.skywhy.anti.AntiBanSystem;
import com.skywhy.hud.HUDManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class SkyWhyClient implements ClientModInitializer {
    public static SkyWhyClient INSTANCE;
    public ModuleManager moduleManager;
    public HUDManager hudManager;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        moduleManager = new ModuleManager();
        hudManager = new HUDManager();
        AntiBanSystem.init();
        System.out.println("[SkyWhy] Ultimate Client Loaded!");
    }

    public static void onTick() {
        if (INSTANCE != null && INSTANCE.moduleManager != null) {
            INSTANCE.moduleManager.onTick();
            AntiBanSystem.bypass();
        }
    }
}
