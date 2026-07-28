package aether.core;


import aether.config.ConfigManager;
import aether.event.EventBus;
import aether.gui.notification.NotificationManager;
import aether.hud.HudManager;
import aether.hud.HudRenderer;
import aether.module.ModuleManager;
import aether.particle.ParticleManager;
import aether.theme.ThemeManager;



public final class Managers {


    public static ModuleManager MODULE;

    public static HudManager HUD;

    public static ThemeManager THEME;

    public static ConfigManager CONFIG;

    public static NotificationManager NOTIFICATION;

    public static ParticleManager PARTICLE;

    public static EventBus EVENT_BUS;



    private Managers() {

    }





    public static void initialize() {



        EVENT_BUS =
                new EventBus();



        THEME =
                new ThemeManager();



        MODULE =
                new ModuleManager();



        HUD =
                new HudManager();



        NOTIFICATION =
                new NotificationManager();



        PARTICLE =
                new ParticleManager();



        CONFIG =
                new ConfigManager();



        EVENT_BUS.register(
                new HudRenderer()
        );



        CONFIG.load();



        AetherClient.getLogger()
                .info(
                        "Managers initialized successfully."
                );

    }

}
