package aether.gui;


import aether.core.Managers;
import aether.gui.components.CategoryPanel;
import aether.gui.components.ModuleButton;

import aether.module.Category;
import aether.module.Module;

import aether.render.AnimationUtil;
import aether.render.RoundedRenderer;
import aether.render.ShadowRenderer;
import aether.theme.Theme;
import aether.theme.ThemeManager;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;


import java.util.ArrayList;
import java.util.List;



public final class AetherScreen extends Screen {



    private final List<CategoryPanel> categories =
            new ArrayList<>();


    private final List<ModuleButton> modules =
            new ArrayList<>();



    private Category selectedCategory =
            Category.VISUAL;



    private float openAnimation;



    public AetherScreen() {

        super(
                Text.literal(
                        "Aether Visuals"
                )
        );

    }



    @Override
    protected void init() {


        categories.clear();


        float startY = 120;


        for (Category category :
                Category.values()) {


            categories.add(
                    new CategoryPanel(
                            category,
                            60,
                            startY,
                            140,
                            42
                    )
            );


            startY += 50;

        }


        rebuildModules();

    }



    private void rebuildModules() {


        modules.clear();


        if (Managers.MODULE == null) {
            return;
        }



        float y = 120;



        for (Module module :
                Managers.MODULE
                        .getByCategory(
                                selectedCategory
                        )) {


            modules.add(
                    new ModuleButton(
                            module,
                            250,
                            y,
                            300,
                            55
                    )
            );


            y += 65;

        }

    }




    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {


        openAnimation =
                AnimationUtil.animate(
                        openAnimation,
                        1f,
                        0.1f
                );



        renderBackground(
                context
        );



        Theme theme =
                ThemeManager.getCurrent();



        if (theme == null) {
            return;
        }



        float panelWidth =
                650;


        float panelHeight =
                420;



        float x =
                ResponsiveLayout.centerX(
                        panelWidth,
                        width
                );


        float y =
                ResponsiveLayout.centerY(
                        panelHeight,
                        height
                );



        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                panelWidth,
                panelHeight,
                20
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                panelWidth,
                panelHeight,
                18,
                theme.getBackground()
        );



        for (CategoryPanel panel :
                categories) {


            panel.render(
                    context,
                    mouseX,
                    mouseY
            );

        }



        for (ModuleButton button :
                modules) {


            button.render(
                    context,
                    mouseX,
                    mouseY
            );

        }



        super.render(
                context,
                mouseX,
                mouseY,
                delta
        );

    }



    @Override
    public boolean mouseClicked(
            double mouseX,
            double mouseY,
            int button
    ) {


        for (CategoryPanel panel :
                categories) {


            if (panel.mouseClicked(
                    mouseX,
                    mouseY
            )) {


                selectedCategory =
                        panel.getCategory();


                rebuildModules();


                return true;

            }

        }



        for (ModuleButton module :
                modules) {


            if (module.mouseClicked(
                    mouseX,
                    mouseY
            )) {


                return true;

            }

        }



        return super.mouseClicked(
                mouseX,
                mouseY,
                button
        );

    }



    @Override
    public boolean shouldPause() {

        return false;

    }

            }
