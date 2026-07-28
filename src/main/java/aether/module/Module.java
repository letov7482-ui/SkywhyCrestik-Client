package aether.module;

public abstract class Module {

    private final String name;
    private final String description;
    private final Category category;

    private boolean enabled;

    protected Module(
            String name,
            String description,
            Category category
    ) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public final void toggle() {
        setEnabled(!enabled);
    }

    public final void setEnabled(boolean enabled) {

        if (this.enabled == enabled) {
            return;
        }

        this.enabled = enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    /**
     * Called when the module is enabled.
     */
    protected void onEnable() {
    }

    /**
     * Called when the module is disabled.
     */
    protected void onDisable() {
    }

    /**
     * Called every client tick.
     */
    public void onTick() {
    }

    /**
     * Called every render frame.
     */
    public void onRender() {
    }

    /**
     * Called when the world changes.
     */
    public void onWorldChange() {
    }

}
