package aether;

import aether.core.AetherClient;
import net.fabricmc.api.ClientModInitializer;

public final class Aether implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AetherClient.getInstance().initialize();
    }
}
