package aether.render;

import java.awt.Color;

public final class ColorUtil {

    private ColorUtil() {
    }

    public static Color alpha(Color color, int alpha) {
        return new Color(
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                alpha
        );
    }

    public static Color darker(Color color, float factor) {

        factor = Math.max(0.0F, Math.min(1.0F, factor));

        return new Color(
                Math.max((int) (color.getRed() * factor), 0),
                Math.max((int) (color.getGreen() * factor), 0),
                Math.max((int) (color.getBlue() * factor), 0),
                color.getAlpha()
        );
    }

    public static Color brighter(Color color, float factor) {

        factor = Math.max(1.0F, factor);

        return new Color(
                Math.min((int) (color.getRed() * factor), 255),
                Math.min((int) (color.getGreen() * factor), 255),
                Math.min((int) (color.getBlue() * factor), 255),
                color.getAlpha()
        );
    }

    public static Color interpolate(Color first, Color second, float progress) {

        progress = Math.max(0.0F, Math.min(1.0F, progress));

        int red = (int) (first.getRed() + (second.getRed() - first.getRed()) * progress);
        int green = (int) (first.getGreen() + (second.getGreen() - first.getGreen()) * progress);
        int blue = (int) (first.getBlue() + (second.getBlue() - first.getBlue()) * progress);
        int alpha = (int) (first.getAlpha() + (second.getAlpha() - first.getAlpha()) * progress);

        return new Color(red, green, blue, alpha);
    }

    public static Color rainbow(long speed, int offset) {

        double hue = ((System.currentTimeMillis() + offset) % speed) / (double) speed;

        return Color.getHSBColor(
                (float) hue,
                0.9F,
                1.0F
        );
    }

    public static int rgb(Color color) {
        return color.getRGB();
    }

}
