package aether.gui;


import aether.core.Managers;

import aether.gui.components.CategoryPanel;
import aether.gui.components.ModuleButton;
import aether.gui.components.SettingPanel;

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


    private final List<ModuleButton> moduleButtons =
            new ArrayList<>();


    private final SettingPanel settingPanel =
            new SettingPanel(
                    900,
                    120,
                    300,
                    420
            );



    private Category selectedCategory =
            Category.VISUAL;



    private Module selectedModule;



    private float animation;



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


        float categoryY = 120;



        for (Category category :
                Category.values()) {


            CategoryPanel panel =
                    new CategoryPanel(
                            category,
                            60,
                            categoryY,
                            150,
                            42
                    );


            if (category == selectedCategory) {

                panel.setSelected(true);

            }


            categories.add(
                    panel
            );


            categoryY += 55;

        }


        rebuildModules();

    }




    private void rebuildModules() {


        moduleButtons.clear();


        if (Managers.MODULE == null) {
            return;
        }



        float y = 120;



        for (Module module :
                Managers.MODULE
                        .getByCategory(
                                selectedCategory
                        )) {


            moduleButtons.add(
                    new ModuleButton(
                            module,
                            260,
                            y,
                            300,
                            55
                    )
            );


            y += 70;

        }

    }




    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ) {


        animation =
                AnimationUtil.animate(
                        animation,
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



        float width = 1260;

        float height = 520;



        float x =
                ResponsiveLayout.centerX(
                        width,
                        this.width
                );



        float y =
                ResponsiveLayout.centerY(
                        height,
                        this.height
                );



        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height,
                20
        );



        RoundedRenderer.drawRoundedRect(
                context,
                x,
                y,
                width,
                height,
                20,
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
                moduleButtons) {


            button.render(
                    context,
                    mouseX,
                    mouseY
            );

        }



        settingPanel.render(
                context,
                mouseX,
                mouseY
        );



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



                selectedModule =
                        null;



                settingPanel.setModule(
                        null
                );



                rebuildModules();



                return true;

            }

        }



        for (ModuleButton moduleButton :
                moduleButtons) {


            if (moduleButton.mouseClicked(
                    mouseX,
                    mouseY
            )) {


                selectedModule =
                        moduleButton.getModule();



                settingPanel.setModule(
                        selectedModule
                );



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
