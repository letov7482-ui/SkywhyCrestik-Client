package aether.module;

public enum Category {

    VISUAL(
            "Visual",
            "Visual effects and rendering."
    ),

    HUD(
            "HUD",
            "Heads-up display elements."
    ),

    CLIENT(
            "Client",
            "Client settings and interface."
    ),

    WORLD(
            "World",
            "World rendering and utilities."
    ),

    MISC(
            "Misc",
            "Miscellaneous features."
    );

    private final String displayName;
    private final String description;

    Category(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
