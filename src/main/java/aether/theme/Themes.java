package aether.theme;

import java.awt.Color;

public final class Themes {

    private Themes() {
    }

    public static final Theme AETHER = new Theme(
            "Aether",

            new Color(72, 140, 255),
            new Color(116, 190, 255),

            new Color(18, 22, 30, 210),

            new Color(245, 247, 250),

            new Color(160, 170, 185)
    );

    public static final Theme AURORA = new Theme(
            "Aurora",

            new Color(130, 90, 255),
            new Color(170, 130, 255),

            new Color(20, 20, 32, 210),

            Color.WHITE,

            new Color(175, 175, 190)
    );

    public static final Theme EMERALD = new Theme(
            "Emerald",

            new Color(0, 210, 145),
            new Color(70, 255, 180),

            new Color(18, 25, 22, 210),

            Color.WHITE,

            new Color(180, 195, 185)
    );

}
