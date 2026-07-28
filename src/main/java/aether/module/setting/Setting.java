package aether.module.setting;

public abstract class Setting<T> {

    private final String name;
    private final String description;

    private T value;
    private final T defaultValue;

    protected Setting(
            String name,
            String description,
            T defaultValue
    ) {
        this.name = name;
        this.description = description;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public void reset() {
        value = defaultValue;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }

}
