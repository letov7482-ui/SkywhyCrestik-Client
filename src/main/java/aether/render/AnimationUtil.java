package aether.render;

public final class AnimationUtil {

    private AnimationUtil() {
    }


    /**
     * Плавное приближение значения к цели
     */
    public static float animate(
            float current,
            float target,
            float speed
    ) {

        if (speed <= 0) {
            return target;
        }


        float difference =
                target - current;


        float animation =
                difference * speed;


        if (Math.abs(animation) < 0.001f) {
            return target;
        }


        return current + animation;
    }


    /**
     * Быстрое плавное появление
     */
    public static float easeOut(
            float value
    ) {

        return 1 -
                (1 - value)
                        *
                        (1 - value);
    }


    /**
     * Плавное ускорение и замедление
     */
    public static float easeInOut(
            float value
    ) {

        if (value < 0.5f) {

            return 2 *
                    value *
                    value;
        }


        return 1 -
                (float)
                        Math.pow(
                                -2 *
                                value +
                                2,
                                2
                        )
                        /
                        2;
    }


    /**
     * Ограничение значения
     */
    public static float clamp(
            float value,
            float min,
            float max
    ) {

        return Math.max(
                min,
                Math.min(
                        max,
                        value
                )
        );
    }


    /**
     * Линейная интерполяция
     */
    public static float lerp(
            float start,
            float end,
            float delta
    ) {

        return start +
                (end - start)
                        *
                        delta;
    }

}
