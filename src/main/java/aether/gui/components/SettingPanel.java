package aether.gui.components;


import aether.module.Module;

import aether.setting.BooleanSetting;
import aether.setting.ModeSetting;
import aether.setting.NumberSetting;
import aether.setting.Setting;

import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;


import java.util.ArrayList;
import java.util.List;



public final class SettingPanel {


    private Module module;


    private final float x;
    private final float y;

    private final float width;
    private final float height;



    private final List<SettingButton> booleanSettings =
            new ArrayList<>();


    private final List<SliderSetting> numberSettings =
            new ArrayList<>();


    private final List<ModeSelector> modeSettings =
            new ArrayList<>();



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


        booleanSettings.clear();
        numberSettings.clear();
        modeSettings.clear();



        if (module == null) {
            return;
        }



        float offset = 65;



        for (Setting<?> setting :
                module.getSettings()) {



            if (setting instanceof BooleanSetting bool) {


                booleanSettings.add(
                        new SettingButton(
                                bool,
                                x + 20,
                                y + offset,
                                width - 40,
                                40
                        )
                );


            }



            if (setting instanceof NumberSetting number) {


                numberSettings.add(
                        new SliderSetting(
                                number,
                                x + 20,
                                y + offset,
                                width - 80,
                                45
                        )
                );


            }



            if (setting instanceof ModeSetting mode) {


                modeSettings.add(
                        new ModeSelector(
                                mode,
                                x + 20,
                                y + offset,
                                width - 40,
                                40
                        )
                );

            }



            offset += 55;

        }

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
                15
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                16,
                theme.getBackground()
        );



        if (module == null) {

            return;

        }



        for (SettingButton button :
                booleanSettings) {


            button.render(
                    context,
                    mouseX,
                    mouseY
            );

        }



        for (SliderSetting slider :
                numberSettings) {


            slider.render(
                    context,
                    mouseX,
                    mouseY
            );

        }



        for (ModeSelector mode :
                modeSettings) {


            mode.render(
                    context,
                    mouseX,
                    mouseY
            );

        }

    }




    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ) {



        for (SettingButton button :
                booleanSettings) {


            if (button.mouseClicked(
                    mouseX,
                    mouseY
            )) {

                return true;

            }

        }



        for (ModeSelector mode :
                modeSettings) {


            if (mode.mouseClicked(
                    mouseX,
                    mouseY
            )) {

                return true;

            }

        }



        for (SliderSetting slider :
                numberSettings) {


            slider.mouseClicked(
                    mouseX,
                    mouseY
            );

        }



        return false;

    }




    public void mouseReleased() {


        for (SliderSetting slider :
                numberSettings) {


            slider.mouseReleased();

        }

    }




    public void mouseDragged(
            double mouseX
    ) {


        for (SliderSetting slider :
                numberSettings) {


            slider.mouseDragged(
                    mouseX
            );

        }

    }

                }
