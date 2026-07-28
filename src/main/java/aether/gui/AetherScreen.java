package aether.gui;

import aether.render.RoundedRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;


public final class AetherScreen extends Screen {


    public AetherScreen() {

        super(
                Text.literal(
                        "Aether Visuals"
                )
        );
    }


    @Override
    protected void init() {

    }


    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {

        renderBackground(
                context,
                mouseX,
                mouseY,
                delta
        );


        Theme theme =
                ThemeManager.getCurrent();


        if (theme == null) {
            return;
        }


        int width =
                this.width;


        int height =
                this.height;


        float panelWidth = 520;
        float panelHeight = 320;


        float x =
                (width - panelWidth) / 2f;


        float y =
                (height - panelHeight) / 2f;


        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                panelWidth,
                panelHeight,
                14,
                theme.getBackground()
        );


        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                panelWidth,
                3,
                3,
                theme.getPrimary()
        );


        context.drawText(
                textRenderer,
                "Aether Visuals",
                (int)x + 20,
                (int)y + 20,
                theme.getText(),
                true
        );


        context.drawText(
                textRenderer,
                "Visual Client",
                (int)x + 20,
                (int)y + 42,
                theme.getSecondary(),
                false
        );


        super.render(
                context,
                mouseX,
                mouseY,
                delta
        );
    }


    @Override
    public boolean shouldPause() {

        return false;
    }

}
