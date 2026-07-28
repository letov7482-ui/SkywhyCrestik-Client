package aether.render;

public final class ColorUtil {

    private ColorUtil() {
    }


    public static int rgba(
            int red,
            int green,
            int blue,
            int alpha
    ) {

        return ((alpha & 0xFF) << 24)
                | ((red & 0xFF) << 16)
                | ((green & 0xFF) << 8)
                | (blue & 0xFF);
    }


    public static int rgb(
            int red,
            int green,
            int blue
    ) {

        return rgba(
                red,
                green,
                blue,
                255
        );
    }


    public static int setAlpha(
            int color,
            int alpha
    ) {

        return (color & 0x00FFFFFF)
                | ((alpha & 0xFF) << 24);
    }


    public static int getRed(
            int color
    ) {

        return (color >> 16) & 0xFF;
    }


    public static int getGreen(
            int color
    ) {

        return (color >> 8) & 0xFF;
    }


    public static int getBlue(
            int color
    ) {

        return color & 0xFF;
    }


    public static int getAlpha(
            int color
    ) {

        return (color >> 24) & 0xFF;
    }


    public static int interpolate(
            int start,
            int end,
            float progress
    ) {

        int r =
                (int) (
                        getRed(start)
                        +
                        (getRed(end) - getRed(start))
                                * progress
                );


        int g =
                (int) (
                        getGreen(start)
                        +
                        (getGreen(end) - getGreen(start))
                                * progress
                );


        int b =
                (int) (
                        getBlue(start)
                        +
                        (getBlue(end) - getBlue(start))
                                * progress
                );


        int a =
                (int) (
                        getAlpha(start)
                        +
                        (getAlpha(end) - getAlpha(start))
                                * progress
                );


        return rgba(
                r,
                g,
                b,
                a
        );
    }


    public static int rainbow(
            float speed,
            float offset
    ) {

        float hue =
                ((System.currentTimeMillis() * speed)
                        + offset)
                        % 360f / 360f;


        java.awt.Color color =
                java.awt.Color
                        .getHSBColor(
                                hue,
                                0.8f,
                                1f
                        );


        return rgb(
                color.getRed(),
                color.getGreen(),
                color.getBlue()
        );
    }

}
