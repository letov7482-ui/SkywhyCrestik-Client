package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class RenderUtil {

    private RenderUtil() {
    }

    public static void fill(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            int color
    ) {

        context.fill(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + height),
                color
        );

    }

    public static void horizontalLine(
            DrawContext context,
            float x,
            float y,
            float width,
            int color
    ) {

        context.fill(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) y + 1,
                color
        );

    }

    public static void verticalLine(
            DrawContext context,
            float x,
            float y,
            float height,
            int color
    ) {

        context.fill(
                (int) x,
                (int) y,
                (int) x + 1,
                (int) (y + height),
                color
        );

    }

    public static void outline(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            int color
    ) {

        horizontalLine(context, x, y, width, color);

        horizontalLine(context, x, y + height - 1, width, color);

        verticalLine(context, x, y, height, color);

        verticalLine(context, x + width - 1, y, height, color);

    }

}
