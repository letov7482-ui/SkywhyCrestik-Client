package aether;

import aether.core.Managers;
import aether.event.events.TickEvent;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class AetherClient implements ClientModInitializer {


    public static final String NAME =
            "Aether Visuals";


    public static final String VERSION =
            "1.0.0";


    private static final Logger LOGGER =
            LoggerFactory.getLogger(NAME);



    @Override
    public void onInitializeClient() {


        LOGGER.info(
                "================================"
        );


        LOGGER.info(
                "{} loading...",
                NAME
        );


        LOGGER.info(
                "Version: {}",
                VERSION
        );



        Managers.initialize();



        registerEvents();



        LOGGER.info(
                "{} loaded successfully!",
                NAME
        );


        LOGGER.info(
                "================================"
        );

    }



    private void registerEvents() {



        ClientTickEvents.END_CLIENT_TICK.register(
                client -> {


                    if (Managers.EVENT_BUS != null) {


                        Managers.EVENT_BUS.post(
                                new TickEvent()
                        );

                    }


                    if (Managers.MODULE != null) {


                        Managers.MODULE.tick();

                    }


                    if (Managers.HUD != null) {


                        Managers.HUD.tick();

                    }


                    if (Managers.NOTIFICATION != null) {


                        Managers.NOTIFICATION.tick();

                    }

                }
        );

    }



    public static Logger getLogger() {

        return LOGGER;

    }

}
