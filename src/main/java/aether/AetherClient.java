package aether;


import aether.core.AetherClient;

import net.fabricmc.api.ClientModInitializer;



public final class AetherClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {


        aether.core.AetherClient
                .getInstance()
                .initialize();


    }

}
