package aether.theme;

public final class Theme {

    private final String name;

    private final int primary;
    private final int secondary;
    private final int background;
    private final int text;


    public Theme(
            String name,
            int primary,
            int secondary,
            int background,
            int text
    ) {

        this.name = name;

        this.primary = primary;
        this.secondary = secondary;
        this.background = background;
        this.text = text;
    }


    public String getName() {
        return name;
    }


    public int getPrimary() {
        return primary;
    }


    public int getSecondary() {
        return secondary;
    }


    public int getBackground() {
        return background;
    }


    public int getText() {
        return text;
    }

}
