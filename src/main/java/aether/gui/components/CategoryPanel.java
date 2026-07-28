package aether.gui.components;

import aether.module.Category;
import aether.render.AetherTextRenderer;
import aether.render.AnimationUtil;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;


public final class CategoryPanel {


    private final Category category;


    private final float x;
    private final float y;

    private final float width;
    private final float height;


    private boolean selected;


    private float animation;



    public CategoryPanel(
            Category category,
            float x,
            float y,
            float width,
            float height
    ) {

        this.category = category;

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

    }



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



        boolean hovered =
                isHovered(
                        mouseX,
                        mouseY
                );



        animation =
                AnimationUtil.animate(
                        animation,
                        selected || hovered
                                ? 1f
                                : 0f,
                        0.12f
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



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                12,
                background
        );



        if (animation > 0.01f) {


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



        int textColor =
                animation > 0.5f
                        ?
                        theme.getText()
                        :
                        theme.getSecondary();



        AetherTextRenderer.draw(
                context,
                category.name(),
                x + 16,
                y + 12,
                textColor
        );

    }



    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ) {


        if (isHovered(
                (int) mouseX,
                (int) mouseY
        )) {


            selected = true;

            return true;

        }


        return false;

    }



    public void setSelected(
            boolean selected
    ) {

        this.selected = selected;

    }



    public boolean isSelected() {

        return selected;

    }



    private boolean isHovered(
            int mouseX,
            int mouseY
    ) {


        return mouseX >= x
                &&
                mouseX <= x + width
                &&
                mouseY >= y
                &&
                mouseY <= y + height;

    }



    public Category getCategory() {

        return category;

    }

}
