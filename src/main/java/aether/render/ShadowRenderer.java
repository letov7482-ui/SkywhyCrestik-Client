package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class ShadowRenderer {

    private ShadowRenderer() {
    }


    public static void drawShadow(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            float radius
    ) {

        drawShadow(
                context,
                x,
                y,
                width,
                height,
                radius,
                60
        );
    }


    public static void drawShadow(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            float radius,
            int alpha
    ) {

        int shadowColor =
                ColorUtil.rgba(
                        0,
                        0,
                        0,
                        alpha
                );


        float offset = 4;


        RoundedRenderer.drawRoundedRect(
                context,
                x + offset,
                y + offset,
                width,
                height,
                radius,
                shadowColor
        );
    }

}
