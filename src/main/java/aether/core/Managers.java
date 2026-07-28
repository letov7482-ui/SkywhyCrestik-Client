package aether.core;

import aether.config.ConfigManager;
import aether.event.EventBus;
import aether.gui.notification.NotificationManager;
import aether.hud.HudManager;
import aether.module.ModuleManager;
import aether.particle.ParticleManager;

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

        AetherClient.getLogger()
                .info("Initializing managers...");

        EVENT_BUS = new EventBus();

        MODULE = new ModuleManager();

        HUD = new HudManager();

        NOTIFICATION = new NotificationManager();

        PARTICLE = new ParticleManager();

        CONFIG = new ConfigManager();

        CONFIG.load();

        AetherClient.getLogger()
                .info("Managers initialized.");

    }

}
