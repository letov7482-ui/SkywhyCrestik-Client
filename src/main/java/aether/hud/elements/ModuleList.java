package aether.hud.elements;


import aether.core.Managers;
import aether.hud.HudElement;

import aether.module.Module;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;


import java.util.Comparator;
import java.util.List;



public final class ModuleList extends HudElement {



    public ModuleList() {

        super(
                "Module List",
                20,
                180
        );

    }



    @Override
    public void render(
            DrawContext context,
            float tickDelta
    ) {


        Theme theme =
                ThemeManager.getCurrent();



        if (theme == null) {
            return;
        }



        if (Managers.MODULE == null) {
            return;
        }



        List<Module> enabledModules =
                Managers.MODULE
                        .getModules()
                        .stream()
                        .filter(
                                Module::isEnabled
                        )
                        .sorted(
                                Comparator.comparingInt(
                                        module ->
                                                module.getName()
                                                        .length()
                                )
                                .reversed()
                        )
                        .toList();



        float offset = 0;



        for (Module module :
                enabledModules) {



            float width =
                    180;



            float height =
                    32;



            float elementY =
                    y + offset;



            ShadowRenderer.drawShadow(
                    context,
                    x,
                    elementY,
                    width,
                    height,
                    10
            );



            RoundedRenderer.drawRoundedRect(
                    context,
                    x,
                    elementY,
                    width,
                    height,
                    10,
                    theme.getBackground()
            );



            RoundedRenderer.drawRoundedRect(
                    context,
                    x,
                    elementY,
                    4,
                    height,
                    4,
                    theme.getPrimary()
            );



            AetherTextRenderer.drawShadow(
                    context,
                    module.getName(),
                    x + 14,
                    elementY + 10,
                    theme.getText()
            );



            offset += 38;

        }

    }

}
