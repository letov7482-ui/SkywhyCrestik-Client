package aether.gui;

import aether.render.AnimationUtil;

public final class ClickGUI {

    private static boolean opened;

    private static float animation;


    private ClickGUI() {
    }


    public static void open() {

        opened = true;
    }


    public static void close() {

        opened = false;
    }


    public static void toggle() {

        opened = !opened;
    }


    public static boolean isOpened() {

        return opened;
    }


    public static float getAnimation() {

        animation =
                AnimationUtil.animate(
                        animation,
                        opened ? 1f : 0f,
                        0.12f
                );

        return AnimationUtil.easeOut(
                animation
        );
    }

}
