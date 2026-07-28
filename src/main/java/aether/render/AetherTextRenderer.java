package aether.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.font.TextRenderer;

public final class AetherTextRenderer {

    private static final MinecraftClient mc =
            MinecraftClient.getInstance();


    private AetherTextRenderer() {
    }


    public static void draw(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        if (mc.textRenderer == null) {
            return;
        }


        context.drawText(
                mc.textRenderer,
                text,
                (int) x,
                (int) y,
                color,
                true
        );
    }


    public static void drawShadow(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        if (mc.textRenderer == null) {
            return;
        }


        context.drawTextWithShadow(
                mc.textRenderer,
                text,
                (int) x,
                (int) y,
                color
        );
    }


    public static float getWidth(
            String text
    ) {

        if (mc.textRenderer == null) {
            return 0;
        }


        return mc.textRenderer
                .getWidth(text);
    }


    public static void drawCentered(
            DrawContext context,
            String text,
            float centerX,
            float y,
            int color
    ) {

        float width =
                getWidth(text);


        draw(
                context,
                text,
                centerX - width / 2f,
                y,
                color
        );
    }


    public static TextRenderer vanilla() {

        return mc.textRenderer;
    }

}
