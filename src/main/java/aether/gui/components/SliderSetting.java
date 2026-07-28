package aether.gui.components;


import aether.setting.NumberSetting;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;



public final class SliderSetting {


    private final NumberSetting setting;


    private final float x;
    private final float y;

    private final float width;
    private final float height;



    private boolean dragging;



    public SliderSetting(
            NumberSetting setting,
            float x,
            float y,
            float width,
            float height
    ) {


        this.setting = setting;


        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

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



        AetherTextRenderer.draw(
                context,
                setting.getName(),
                x,
                y,
                theme.getText()
        );



        float barY =
                y + 22;



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                barY,
                width,
                6,
                3,
                theme.getSecondary()
        );



        float progress =
                (float)
                (
                    (setting.getValue()
                    -
                    setting.getMin())
                    /
                    (
                    setting.getMax()
                    -
                    setting.getMin()
                    )
                );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                barY,
                width * progress,
                6,
                3,
                theme.getPrimary()
        );



        AetherTextRenderer.draw(
                context,
                String.valueOf(
                        setting.getValue()
                ),
                x + width + 10,
                y,
                theme.getSecondary()
        );

    }





    public void mouseClicked(
            double mouseX,
            double mouseY
    ) {


        if (isHovered(
                (int) mouseX,
                (int) mouseY
        )) {


            dragging = true;


            updateValue(
                    mouseX
            );

        }

    }





    public void mouseReleased() {

        dragging = false;

    }





    public void mouseDragged(
            double mouseX
    ) {


        if (dragging) {


            updateValue(
                    mouseX
            );

        }

    }





    private void updateValue(
            double mouseX
    ) {


        double percent =
                (mouseX - x)
                /
                width;



        percent =
                Math.max(
                        0,
                        Math.min(
                                1,
                                percent
                        )
                );



        double value =
                setting.getMin()
                +
                (
                setting.getMax()
                -
                setting.getMin()
                )
                *
                percent;



        value =
                Math.round(
                        value
                        /
                        setting.getIncrement()
                )
                *
                setting.getIncrement();



        setting.setValue(
                value
        );

    }





    private boolean isHovered(
            int mouseX,
            int mouseY
    ) {


        return mouseX >= x
                &&
                mouseX <= x + width
                &&
                mouseY >= y
                &&
                mouseY <= y + height + 20;

    }

}
