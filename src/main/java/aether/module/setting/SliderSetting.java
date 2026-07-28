package aether.module.setting;

public final class SliderSetting extends Setting<Double> {

    private final double minimum;
    private final double maximum;
    private final double increment;

    public SliderSetting(
            String name,
            String description,
            double defaultValue,
            double minimum,
            double maximum,
            double increment
    ) {
        super(
                name,
                description,
                defaultValue
        );

        this.minimum = minimum;
        this.maximum = maximum;
        this.increment = increment;
    }

    @Override
    public void setValue(Double value) {

        if (value < minimum) {
            value = minimum;
        }

        if (value > maximum) {
            value = maximum;
        }

        value = Math.round(value / increment) * increment;

        super.setValue(value);
    }

    public double getMinimum() {
        return minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public double getIncrement() {
        return increment;
    }

}
