package aether.hud.element;

import aether.hud.HudElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class Watermark extends HudElement {

    private final MinecraftClient mc;

    private final String title = "Aether Visuals";


    public Watermark() {

        super(
                "Watermark",
                10,
                10
        );

        this.mc = MinecraftClient.getInstance();

        this.width = 180;
        this.height = 45;
    }


    @Override
    protected void draw(
            DrawContext context
    ) {

        if (mc.player == null) {
            return;
        }


        int background =
                0xCC12161E;


        int accent =
                0xFF488CFF;


        int text =
                0xFFFFFFFF;


        int subText =
                0xFFB0BAC8;


        // Основной фон

        context.fill(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + height),
                background
        );


        // Акцентная линия

        context.fill(
                (int) x,
                (int) y,
                (int) (x + width),
                (int) (y + 2),
                accent
        );


        String info =
                getFps()
                + " FPS • "
                + getPing()
                + " ms";


        context.drawText(
                mc.textRenderer,
                title,
                (int) x + 12,
                (int) y + 10,
                text,
                true
        );


        context.drawText(
                mc.textRenderer,
                info,
                (int) x + 12,
                (int) y + 26,
                subText,
                false
        );

    }


    private int getFps() {

        return MinecraftClient
                .getInstance()
                .getCurrentFps();
    }


    private int getPing() {

        if (mc.getNetworkHandler() == null) {
            return 0;
        }


        if (mc.player == null) {
            return 0;
        }


        var entry =
                mc.getNetworkHandler()
                        .getPlayerListEntry(
                                mc.player
                                        .getUuid()
                        );


        if (entry == null) {
            return 0;
        }


        return entry.getLatency();
    }

}
