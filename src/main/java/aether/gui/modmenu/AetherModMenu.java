package aether.gui.modmenu;


import aether.gui.AetherScreen;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.minecraft.client.gui.screen.Screen;



public final class AetherModMenu
        implements ModMenuApi {


    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {


        return parent -> new AetherScreen();

    }


        }
