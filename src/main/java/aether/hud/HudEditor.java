package aether.hud;

public final class HudEditor {

    private static boolean opened;

    private HudEditor() {
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


    public static void mouseClicked(
            double mouseX,
            double mouseY
    ) {

        if (!opened) {
            return;
        }

        if (aether.core.Managers.HUD != null) {

            aether.core.Managers.HUD.mousePressed(
                    mouseX,
                    mouseY
            );
        }
    }


    public static void mouseDragged(
            double mouseX,
            double mouseY
    ) {

        if (!opened) {
            return;
        }

        if (aether.core.Managers.HUD != null) {

            aether.core.Managers.HUD.mouseDragged(
                    mouseX,
                    mouseY
            );
        }
    }


    public static void mouseReleased() {

        if (!opened) {
            return;
        }

        if (aether.core.Managers.HUD != null) {

            aether.core.Managers.HUD.mouseReleased();
        }
    }

}
