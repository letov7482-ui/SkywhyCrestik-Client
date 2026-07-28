package aether.render;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class TextRenderer {

    private TextRenderer() {
    }

    private static net.minecraft.client.font.TextRenderer mc() {
        return MinecraftClient.getInstance().textRenderer;
    }

    public static void draw(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        context.drawText(
                mc(),
                text,
                (int) x,
                (int) y,
                color,
                false
        );

    }

    public static void drawShadow(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        context.drawText(
                mc(),
                text,
                (int) x,
                (int) y,
                color,
                true
        );

    }

    public static void drawCentered(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        int width = getWidth(text);

        draw(
                context,
                text,
                x - width / 2F,
                y,
                color
        );

    }

    public static void drawCenteredShadow(
            DrawContext context,
            String text,
            float x,
            float y,
            int color
    ) {

        int width = getWidth(text);

        drawShadow(
                context,
                text,
                x - width / 2F,
                y,
                color
        );

    }

    public static int getWidth(String text) {
        return mc().getWidth(text);
    }

    public static int getHeight() {
        return mc().fontHeight;
    }

}
