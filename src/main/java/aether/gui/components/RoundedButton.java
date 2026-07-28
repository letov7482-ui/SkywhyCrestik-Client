package aether.gui.components;

import aether.render.AnimationUtil;
import aether.render.RoundedRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;


public class RoundedButton {


    protected float x;
    protected float y;

    protected float width;
    protected float height;


    private float hoverAnimation;



    public RoundedButton(
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



    public void render(
            DrawContext context,
            int mouseX,
            int mouseY
    ) {


        boolean hovered =
                isHovered(
                        mouseX,
                        mouseY
                );


        hoverAnimation =
                AnimationUtil.animate(
                        hoverAnimation,
                        hovered ? 1f : 0f,
                        0.15f
                );



        Theme theme =
                ThemeManager.getCurrent();



        if (theme == null) {
            return;
        }



        int color =
                theme.getBackground();



        if (hoverAnimation > 0) {


            color =
                    theme.getPrimary();

        }



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                12,
                color
        );

    }



    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ) {


        return isHovered(
                (int) mouseX,
                (int) mouseY
        );

    }



    protected boolean isHovered(
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



    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }


    public float getWidth() {
        return width;
    }


    public float getHeight() {
        return height;
    }

}
