package aether.gui.components;


import aether.setting.BooleanSetting;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;



public final class SettingButton {


    private final BooleanSetting setting;


    private final float x;
    private final float y;

    private final float width;
    private final float height;



    public SettingButton(
            BooleanSetting setting,
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



        boolean hovered =
                isHovered(
                        mouseX,
                        mouseY
                );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                10,
                hovered
                        ?
                        theme.getSecondary()
                        :
                        theme.getBackground()
        );



        AetherTextRenderer.draw(
                context,
                setting.getName(),
                x + 15,
                y + 12,
                theme.getText()
        );



        String state =
                setting.isEnabled()
                        ?
                        "ON"
                        :
                        "OFF";



        AetherTextRenderer.draw(
                context,
                state,
                x + width - 45,
                y + 12,
                setting.isEnabled()
                        ?
                        theme.getPrimary()
                        :
                        theme.getSecondary()
        );

    }




    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ) {


        if (isHovered(
                (int) mouseX,
                (int) mouseY
        )) {


            setting.toggle();

            return true;

        }


        return false;

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
                mouseY <= y + height;

    }


}
