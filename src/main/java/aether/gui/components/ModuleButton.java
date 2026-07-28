package aether.gui.components;

import aether.module.Module;
import aether.render.AetherTextRenderer;
import aether.render.AnimationUtil;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;


public final class ModuleButton extends RoundedButton {


    private final Module module;


    private float enabledAnimation;



    public ModuleButton(
            Module module,
            float x,
            float y,
            float width,
            float height
    ) {

        super(
                x,
                y,
                width,
                height
        );


        this.module = module;

    }



    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY
    ) {


        Theme theme =
                ThemeManager.getCurrent();


        if (theme == null) {
            return;
        }



        enabledAnimation =
                AnimationUtil.animate(
                        enabledAnimation,
                        module.isEnabled()
                                ? 1f
                                : 0f,
                        0.12f
                );



        boolean hovered =
                isHovered(
                        mouseX,
                        mouseY
                );



        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height,
                10
        );



        int background =
                theme.getBackground();



        if (hovered) {

            background =
                    theme.getSecondary();

        }



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                12,
                background
        );



        if (enabledAnimation > 0.01f) {


            RoundedRenderer.drawRoundedRect(
                    context,
                    x,
                    y,
                    4,
                    height,
                    4,
                    theme.getPrimary()
            );

        }



        AetherTextRenderer.drawShadow(
                context,
                module.getName(),
                x + 14,
                y + 10,
                theme.getText()
        );



        AetherTextRenderer.draw(
                context,
                module.getCategory()
                        .name(),
                x + 14,
                y + 27,
                theme.getSecondary()
        );



        if (module.isEnabled()) {


            AetherTextRenderer.draw(
                    context,
                    "● ENABLED",
                    x + width - 80,
                    y + 18,
                    theme.getPrimary()
            );

        }

    }



    @Override
    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ) {


        if (super.mouseClicked(
                mouseX,
                mouseY
        )) {


            module.toggle();

            return true;

        }


        return false;

    }



    public Module getModule() {

        return module;

    }

}
