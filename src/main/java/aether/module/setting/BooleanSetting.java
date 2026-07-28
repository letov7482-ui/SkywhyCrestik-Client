package aether.module.setting;

public final class BooleanSetting extends Setting<Boolean> {

    public BooleanSetting(
            String name,
            String description,
            boolean defaultValue
    ) {
        super(
                name,
                description,
                defaultValue
        );
    }

    public boolean isEnabled() {
        return getValue();
    }

    public void toggle() {
        setValue(!getValue());
    }

}
