package aether.theme;

import java.awt.Color;

public final class Theme {

    private final String name;

    private final Color primary;
    private final Color secondary;
    private final Color background;
    private final Color text;
    private final Color subText;

    public Theme(
            String name,
            Color primary,
            Color secondary,
            Color background,
            Color text,
            Color subText
    ) {

        this.name = name;

        this.primary = primary;
        this.secondary = secondary;
        this.background = background;

        this.text = text;
        this.subText = subText;

    }

    public String getName() {
        return name;
    }

    public Color getPrimary() {
        return primary;
    }

    public Color getSecondary() {
        return secondary;
    }

    public Color getBackground() {
        return background;
    }

    public Color getText() {
        return text;
    }

    public Color getSubText() {
        return subText;
    }

}
