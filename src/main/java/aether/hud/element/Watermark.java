package aether.hud.element;

import aether.hud.HudElement;
import aether.render.AetherTextRenderer;
import aether.render.AnimationUtil;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;


public final class Watermark extends HudElement {


    private final MinecraftClient mc =
            MinecraftClient.getInstance();


    private float animation;


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

        animation =
                AnimationUtil.animate(
                        animation,
                        1,
                        0.08f
                );


        if (animation <= 0) {
            return;
        }


        Theme theme =
                ThemeManager.getCurrent();


        if (theme == null) {
            return;
        }


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
                theme.getBackground()
        );


        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                4,
                height,
                4,
                theme.getPrimary()
        );


        AetherTextRenderer.drawShadow(
                context,
                "Aether Visuals",
                x + 14,
                y + 9,
                theme.getText()
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
                theme.getSecondary()
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
