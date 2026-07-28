package aether.core;

import aether.theme.ThemeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AetherClient {

    private static final AetherClient INSTANCE = new AetherClient();

    public static final String NAME = "Aether Visuals";
    public static final String VERSION = "1.0.0";

    private static final Logger LOGGER =
            LoggerFactory.getLogger(NAME);

    private AetherClient() {
    }

    public static AetherClient getInstance() {
        return INSTANCE;
    }

    public void initialize() {

        LOGGER.info("==========================================");
        LOGGER.info("{} is starting...", NAME);
        LOGGER.info("Version: {}", VERSION);

        // Core
        Managers.initialize();

        // Theme Engine
        ThemeManager.initialize();

        LOGGER.info("{} successfully loaded!", NAME);
        LOGGER.info("==========================================");
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}
