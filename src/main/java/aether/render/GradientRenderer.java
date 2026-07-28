package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class GradientRenderer {

    private GradientRenderer() {
    }

    public static void vertical(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            int topColor,
            int bottomColor
    ) {

        context.fillGradient(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + height),
                topColor,
                bottomColor
        );

    }

    public static void horizontal(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            int leftColor,
            int rightColor
    ) {

        // Пока используем вертикальный метод.
        // Позже заменим собственной реализацией через VertexConsumer.
        context.fillGradient(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + height),
                leftColor,
                rightColor
        );

    }

}
