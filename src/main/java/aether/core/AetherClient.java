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

    private boolean initialized;

    private AetherClient() {
    }

    public static AetherClient getInstance() {
        return INSTANCE;
    }

    public void initialize() {

        if (initialized) {
            return;
        }

        initialized = true;

        LOGGER.info("======================================");
        LOGGER.info("{} starting...", NAME);
        LOGGER.info("Version: {}", VERSION);

        Managers.initialize();

        ThemeManager.initialize();

        LOGGER.info("{} loaded successfully!", NAME);
        LOGGER.info("======================================");
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}
