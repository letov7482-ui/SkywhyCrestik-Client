package aether.hud;


import aether.hud.elements.Coordinates;
import aether.hud.elements.FPSCounter;
import aether.hud.elements.ModuleList;
import aether.hud.elements.Watermark;


import net.minecraft.client.gui.DrawContext;


import java.util.ArrayList;
import java.util.List;



public final class HudManager {


    private final List<HudElement> elements =
            new ArrayList<>();



    public HudManager() {

        initialize();

    }




    private void initialize() {


        register(
                new Watermark()
        );


        register(
                new FPSCounter()
        );


        register(
                new Coordinates()
        );


        register(
                new ModuleList()
        );

    }





    public void register(
            HudElement element
    ) {


        if (element == null) {

            return;

        }



        if (!elements.contains(element)) {

            elements.add(
                    element
            );

        }

    }





    public void unregister(
            HudElement element
    ) {


        elements.remove(
                element
        );

    }





    public void render(
            DrawContext context,
            float tickDelta
    ) {


        for (HudElement element :
                elements) {


            if (!element.isEnabled()) {

                continue;

            }



            element.render(
                    context,
                    tickDelta
            );

        }

    }





    public void tick() {


        /*
         Здесь позже будут:

         - HUD анимации
         - плавное появление элементов
         - обновление ModuleList
         - эффекты

        */

    }





    public List<HudElement> getElements() {

        return elements;

    }





    public HudElement getByName(
            String name
    ) {


        for (HudElement element :
                elements) {


            if (element.getName()
                    .equalsIgnoreCase(name)) {


                return element;

            }

        }


        return null;

    }

}
