package aether.render;

import net.minecraft.client.gui.DrawContext;

public final class RoundedRenderer {

    private RoundedRenderer() {
    }


    public static void drawRoundedRect(
            DrawContext context,
            float x,
            float y,
            float width,
            float height,
            float radius,
            int color
    ) {

        int left = (int) x;
        int top = (int) y;

        int right = (int) (x + width);
        int bottom = (int) (y + height);


        // Центральная часть

        context.fill(
                left + (int) radius,
                top,
                right - (int) radius,
                bottom,
                color
        );


        context.fill(
                left,
                top + (int) radius,
                right,
                bottom - (int) radius,
                color
        );


        // Углы

        drawCircle(
                context,
                left + radius,
                top + radius,
                radius,
                color
        );


        drawCircle(
                context,
                right - radius,
                top + radius,
                radius,
                color
        );


        drawCircle(
                context,
                left + radius,
                bottom - radius,
                radius,
                color
        );


        drawCircle(
                context,
                right - radius,
                bottom - radius,
                radius,
                color
        );
    }


    private static void drawCircle(
            DrawContext context,
            float centerX,
            float centerY,
            float radius,
            int color
    ) {

        int r = (int) radius;

        for (int x = -r; x <= r; x++) {

            for (int y = -r; y <= r; y++) {

                if (x * x + y * y <= r * r) {

                    context.fill(
                            (int) (centerX + x),
                            (int) (centerY + y),
                            (int) (centerX + x + 1),
                            (int) (centerY + y + 1),
                            color
                    );
                }
            }
        }
    }

}
