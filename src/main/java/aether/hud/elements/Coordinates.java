package aether.hud.elements;


import aether.hud.HudElement;

import aether.render.AetherTextRenderer;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;

import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;



public final class Coordinates extends HudElement {


    private final MinecraftClient mc =
            MinecraftClient.getInstance();



    public Coordinates() {

        super(
                "Coordinates",
                20,
                125
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



        if (mc.player == null) {
            return;
        }



        int xPos =
                (int)
                mc.player
                        .getX();



        int yPos =
                (int)
                mc.player
                        .getY();



        int zPos =
                (int)
                mc.player
                        .getZ();



        String text =
                "XYZ: "
                +
                xPos
                +
                " "
                +
                yPos
                +
                " "
                +
                zPos;



        float width = 170;

        float height = 35;



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
                12,
                theme.getBackground()
        );



        AetherTextRenderer.drawShadow(
                context,
                text,
                x + 15,
                y + 12,
                theme.getText()
        );

    }

}
