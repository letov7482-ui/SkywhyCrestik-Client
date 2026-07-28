package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class RoundedRenderer {

    private RoundedRenderer() {
    }

    /**
     * Пока используем обычный прямоугольник.
     * Позже здесь появится настоящий Rounded Renderer
     * через VertexConsumer и RenderLayer.
     */
    public static void draw(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            float radius,
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

}
