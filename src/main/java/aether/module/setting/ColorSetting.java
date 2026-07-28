package aether.module.setting;

import java.awt.Color;

public final class ColorSetting extends Setting<Color> {

    public ColorSetting(
            String name,
            String description,
            Color defaultColor
    ) {
        super(
                name,
                description,
                defaultColor
        );
    }

    public int getRGB() {
        return getValue().getRGB();
    }

    public float getRed() {
        return getValue().getRed() / 255.0F;
    }

    public float getGreen() {
        return getValue().getGreen() / 255.0F;
    }

    public float getBlue() {
        return getValue().getBlue() / 255.0F;
    }

    public float getAlpha() {
        return getValue().getAlpha() / 255.0F;
    }

}
