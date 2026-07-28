package aether.theme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ThemeManager {

    private static final List<Theme> THEMES = new ArrayList<>();

    private static Theme currentTheme;

    private ThemeManager() {
    }

    public static void initialize() {

        THEMES.clear();

        THEMES.add(Themes.AETHER);
        THEMES.add(Themes.AURORA);
        THEMES.add(Themes.EMERALD);

        currentTheme = Themes.AETHER;
    }

    public static Theme getTheme() {
        return currentTheme;
    }

    public static void setTheme(Theme theme) {

        if (theme == null) {
            return;
        }

        currentTheme = theme;
    }

    public static List<Theme> getThemes() {
        return Collections.unmodifiableList(THEMES);
    }

    public static Theme find(String name) {

        for (Theme theme : THEMES) {

            if (theme.getName().equalsIgnoreCase(name)) {
                return theme;
            }

        }

        return Themes.AETHER;
    }

}
