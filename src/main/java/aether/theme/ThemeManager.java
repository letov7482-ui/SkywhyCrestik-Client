package aether.theme;

import aether.render.ColorUtil;

import java.util.ArrayList;
import java.util.List;

public final class ThemeManager {

    private static final List<Theme> THEMES =
            new ArrayList<>();


    private static Theme current;


    private ThemeManager() {
    }


    public static void initialize() {

        if (!THEMES.isEmpty()) {
            return;
        }


        register(
                new Theme(
                        "Aether Blue",
                        ColorUtil.rgb(
                                80,
                                150,
                                255
                        ),
                        ColorUtil.rgb(
                                120,
                                200,
                                255
                        ),
                        ColorUtil.rgba(
                                15,
                                18,
                                25,
                                220
                        ),
                        ColorUtil.rgb(
                                255,
                                255,
                                255
                        )
                )
        );


        register(
                new Theme(
                        "Purple Neon",
                        ColorUtil.rgb(
                                170,
                                80,
                                255
                        ),
                        ColorUtil.rgb(
                                220,
                                120,
                                255
                        ),
                        ColorUtil.rgba(
                                18,
                                12,
                                25,
                                220
                        ),
                        ColorUtil.rgb(
                                255,
                                255,
                                255
                        )
                )
        );


        register(
                new Theme(
                        "Red Eclipse",
                        ColorUtil.rgb(
                                255,
                                70,
                                90
                        ),
                        ColorUtil.rgb(
                                255,
                                150,
                                120
                        ),
                        ColorUtil.rgba(
                                25,
                                12,
                                15,
                                220
                        ),
                        ColorUtil.rgb(
                                255,
                                255,
                                255
                        )
                )
        );


        current = THEMES.get(0);
    }


    public static void register(
            Theme theme
    ) {

        THEMES.add(theme);
    }


    public static Theme getCurrent() {

        return current;
    }


    public static void setTheme(
            Theme theme
    ) {

        if (theme != null) {

            current = theme;
        }
    }


    public static List<Theme> getThemes() {

        return THEMES;
    }

}
