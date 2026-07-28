package aether.hud.elements;


import aether.hud.HudElement;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;



public final class Watermark extends HudElement {



    private float animation;



    public Watermark() {

        super(
                "Watermark",
                20,
                20
        );

    }



    @Override
    public void render(
            DrawContext context,
            float tickDelta
    ) {


        Theme theme =
                ThemeManager.getCurrent();



        if (theme == null) {
            return;
        }



        float width = 180;

        float height = 45;



        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height,
                12
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                14,
                theme.getBackground()
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                5,
                height,
                4,
                theme.getPrimary()
        );



        AetherTextRenderer.drawShadow(
                context,
                "✦ Aether Visuals",
                x + 15,
                y + 12,
                theme.getText()
        );



        AetherTextRenderer.draw(
                context,
                "1.0.0",
                x + 15,
                y + 28,
                theme.getSecondary()
        );

    }

}
