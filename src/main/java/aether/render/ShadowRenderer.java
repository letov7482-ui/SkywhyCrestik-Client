package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class ShadowRenderer {

    private ShadowRenderer() {
    }

    /**
     * Простая мягкая тень.
     * Позже заменим на настоящий Blur/Bloom Shadow.
     */
    public static void draw(
            DrawContext context,
            float x,
            float y,
            float width,
            float height
    ) {

        int alpha1 = 35 << 24;
        int alpha2 = 20 << 24;
        int alpha3 = 10 << 24;

        // Верх
        context.fill(
                (int) x - 1,
                (int) y - 1,
                (int) (x + width) + 1,
                (int) y,
                alpha2
        );

        // Низ
        context.fill(
                (int) x - 1,
                (int) (y + height),
                (int) (x + width) + 1,
                (int) (y + height) + 1,
                alpha2
        );

        // Лево
        context.fill(
                (int) x - 1,
                (int) y,
                (int) x,
                (int) (y + height),
                alpha2
        );

        // Право
        context.fill(
                (int) (x + width),
                (int) y,
                (int) (x + width) + 1,
                (int) (y + height),
                alpha2
        );

        // Внешняя тень
        context.fill(
                (int) x - 2,
                (int) y - 2,
                (int) (x + width) + 2,
                (int) (y + height) + 2,
                alpha3
        );

        // Центральная лёгкая тень
        context.fill(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + height),
                alpha1
        );

    }

}
