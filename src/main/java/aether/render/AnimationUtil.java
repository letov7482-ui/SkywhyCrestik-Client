package aether.render;

public final class AnimationUtil {

    private AnimationUtil() {
    }

    /**
     * Smooth interpolation.
     */
    public static float animate(float current, float target, float speed) {

        speed = clamp(speed, 0.0F, 1.0F);

        return current + (target - current) * speed;
    }

    public static double animate(double current, double target, double speed) {

        speed = clamp(speed, 0.0, 1.0);

        return current + (target - current) * speed;
    }

    /**
     * Linear interpolation.
     */
    public static float lerp(float start, float end, float delta) {

        delta = clamp(delta, 0.0F, 1.0F);

        return start + (end - start) * delta;
    }

    public static double lerp(double start, double end, double delta) {

        delta = clamp(delta, 0.0, 1.0);

        return start + (end - start) * delta;
    }

    /**
     * Ease Out Cubic.
     */
    public static float easeOut(float progress) {

        progress = clamp(progress, 0.0F, 1.0F);

        return 1.0F - (float) Math.pow(1.0F - progress, 3.0);
    }

    /**
     * Ease In Cubic.
     */
    public static float easeIn(float progress) {

        progress = clamp(progress, 0.0F, 1.0F);

        return progress * progress * progress;
    }

    /**
     * Ease In Out Cubic.
     */
    public static float easeInOut(float progress) {

        progress = clamp(progress, 0.0F, 1.0F);

        return progress < 0.5F
                ? 4.0F * progress * progress * progress
                : 1.0F - (float) Math.pow(-2.0F * progress + 2.0F, 3.0) / 2.0F;
    }

    public static float clamp(float value, float min, float max) {

        return Math.max(min, Math.min(max, value));
    }

    public static double clamp(double value, double min, double max) {

        return Math.max(min, Math.min(max, value));
    }

}
