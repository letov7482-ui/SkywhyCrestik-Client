package aether.module;


public abstract class Module {


    private final String name;

    private final Category category;


    private boolean enabled;



    public Module(
            String name,
            Category category
    ) {

        this.name = name;
        this.category = category;

    }



    public void toggle() {

        setEnabled(
                !enabled
        );

    }



    public void setEnabled(
            boolean enabled
    ) {

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



    public Category getCategory() {

        return category;

    }



    protected void onEnable() {

    }



    protected void onDisable() {

    }



    public void onTick() {

    }

}
