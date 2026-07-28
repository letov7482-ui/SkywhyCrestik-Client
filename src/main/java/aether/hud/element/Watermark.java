package aether.hud.element;

import aether.hud.HudElement;
import aether.render.AetherTextRenderer;
import aether.render.AnimationUtil;
import aether.render.ColorUtil;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class Watermark extends HudElement {


    private final MinecraftClient mc =
            MinecraftClient.getInstance();


    private float animation = 0;


    public Watermark() {

        super(
                "Watermark",
                10,
                10
        );

        width = 190;
        height = 48;
    }


    @Override
    protected void draw(
            DrawContext context
    ) {

        if (mc.player == null) {
            return;
        }


        animation =
                AnimationUtil.animate(
                        animation,
                        1,
                        0.08f
                );


        float scale =
                AnimationUtil.easeOut(
                        animation
                );


        if (scale <= 0) {
            return;
        }


        int background =
                ColorUtil.rgba(
                        15,
                        18,
                        25,
                        220
                );


        int accent =
                ColorUtil.rgb(
                        80,
                        150,
                        255
                );


        int white =
                ColorUtil.rgb(
                        255,
                        255,
                        255
                );


        int gray =
                ColorUtil.rgb(
                        170,
                        180,
                        195
                );


        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height,
                10
        );


        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                10,
                background
        );


        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                4,
                height,
                4,
                accent
        );


        AetherTextRenderer.drawShadow(
                context,
                "Aether Visuals",
                x + 14,
                y + 9,
                white
        );


        String info =
                getFPS()
                + " FPS  •  "
                + getPing()
                + " ms";


        AetherTextRenderer.draw(
                context,
                info,
                x + 14,
                y + 27,
                gray
        );

    }


    private int getFPS() {

        return mc.getCurrentFps();
    }


    private int getPing() {

        if (mc.player == null ||
                mc.getNetworkHandler() == null) {

            return 0;
        }


        var entry =
                mc.getNetworkHandler()
                        .getPlayerListEntry(
                                mc.player.getUuid()
                        );


        if (entry == null) {
            return 0;
        }


        return entry.getLatency();
    }

}
