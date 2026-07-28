package aether.setting;


public final class NumberSetting
        extends Setting<Double> {


    private final double min;

    private final double max;

    private final double increment;



    public NumberSetting(
            String name,
            double value,
            double min,
            double max,
            double increment
    ) {

        super(
                name,
                value
        );


        this.min = min;

        this.max = max;

        this.increment = increment;

    }



    @Override
    public void setValue(
            Double value
    ) {

        double fixed =
                Math.max(
                        min,
                        Math.min(
                                max,
                                value
                        )
                );


        super.setValue(
                fixed
        );

    }



    public double getMin() {

        return min;

    }



    public double getMax() {

        return max;

    }



    public double getIncrement() {

        return increment;

    }

        }
