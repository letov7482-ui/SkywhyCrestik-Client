package aether.gui.components;


import aether.module.Module;
import aether.setting.BooleanSetting;
import aether.setting.ModeSetting;
import aether.setting.NumberSetting;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;


import net.minecraft.client.gui.DrawContext;


public final class SettingPanel {


    private Module module;


    private final float x;
    private final float y;

    private final float width;
    private final float height;



    public SettingPanel(
            float x,
            float y,
            float width,
            float height
    ) {

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

    }



    public void setModule(
            Module module
    ) {

        this.module = module;

    }



    public void render(
            DrawContext context,
            int mouseX,
            int mouseY
    ) {


        Theme theme =
                ThemeManager.getCurrent();



        if (theme == null) {
            return;
        }



        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height,
                14
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                14,
                theme.getBackground()
        );



        if (module == null) {


            AetherTextRenderer.draw(
                    context,
                    "Select module",
                    x + 20,
                    y + 20,
                    theme.getSecondary()
            );


            return;

        }



        AetherTextRenderer.drawShadow(
                context,
                module.getName(),
                x + 20,
                y + 20,
                theme.getText()
        );



        float offset = 55;



        for (var setting :
                module.getSettings()) {



            if (setting instanceof BooleanSetting bool) {


                drawBoolean(
                        context,
                        bool.getName(),
                        bool.isEnabled(),
                        offset,
                        theme
                );


            }



            if (setting instanceof NumberSetting number) {


                drawNumber(
                        context,
                        number,
                        offset,
                        theme
                );


            }



            if (setting instanceof ModeSetting mode) {


                drawMode(
                        context,
                        mode,
                        offset,
                        theme
                );

            }



            offset += 45;

        }

    }




    private void drawBoolean(
            DrawContext context,
            String name,
            boolean enabled,
            float offset,
            Theme theme
    ) {


        String value =
                enabled
                        ?
                        "ON"
                        :
                        "OFF";



        AetherTextRenderer.draw(
                context,
                name,
                x + 20,
                y + offset,
                theme.getText()
        );



        AetherTextRenderer.draw(
                context,
                value,
                x + width - 60,
                y + offset,
                enabled
                        ?
                        theme.getPrimary()
                        :
                        theme.getSecondary()
        );

    }





    private void drawNumber(
            DrawContext context,
            NumberSetting setting,
            float offset,
            Theme theme
    ) {


        AetherTextRenderer.draw(
                context,
                setting.getName(),
                x + 20,
                y + offset,
                theme.getText()
        );



        AetherTextRenderer.draw(
                context,
                String.valueOf(
                        setting.getValue()
                ),
                x + width - 70,
                y + offset,
                theme.getSecondary()
        );

    }





    private void drawMode(
            DrawContext context,
            ModeSetting setting,
            float offset,
            Theme theme
    ) {


        AetherTextRenderer.draw(
                context,
                setting.getName(),
                x + 20,
                y + offset,
                theme.getText()
        );



        AetherTextRenderer.draw(
                context,
                setting.getValue(),
                x + width - 100,
                y + offset,
                theme.getPrimary()
        );

    }

  }
