package aether.core;

import aether.config.ConfigManager;
import aether.event.EventBus;
import aether.gui.notification.NotificationManager;
import aether.hud.HudManager;
import aether.module.ModuleManager;
import aether.particle.ParticleManager;
import aether.theme.ThemeManager;

public final class Managers {

    public static ModuleManager MODULE;
    public static HudManager HUD;
    public static ConfigManager CONFIG;
    public static NotificationManager NOTIFICATION;
    public static ParticleManager PARTICLE;
    public static EventBus EVENT_BUS;

    private Managers() {
    }

    public static void initialize() {

        AetherClient.getLogger().info("Initializing Event Bus...");
        EVENT_BUS = new EventBus();

        AetherClient.getLogger().info("Initializing Theme Engine...");
        ThemeManager.initialize();

        AetherClient.getLogger().info("Initializing Module Manager...");
        MODULE = new ModuleManager();

        AetherClient.getLogger().info("Initializing HUD Manager...");
        HUD = new HudManager();

        AetherClient.getLogger().info("Initializing Notification Manager...");
        NOTIFICATION = new NotificationManager();

        AetherClient.getLogger().info("Initializing Particle Manager...");
        PARTICLE = new ParticleManager();

        AetherClient.getLogger().info("Initializing Config Manager...");
        CONFIG = new ConfigManager();
        CONFIG.load();

        AetherClient.getLogger().info("All managers initialized successfully.");

    }

}
