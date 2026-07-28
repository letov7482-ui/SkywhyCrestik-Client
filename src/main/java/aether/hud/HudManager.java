package aether.hud;


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


    }




    public void register(
            HudElement element
    ) {


        if (element == null) {
            return;
        }


        elements.add(
                element
        );

    }





    public void render(
            DrawContext context,
            float tickDelta
    ) {


        for (HudElement element :
                elements) {


            if (element.isEnabled()) {


                element.render(
                        context,
                        tickDelta
                );

            }

        }

    }





    public List<HudElement> getElements() {

        return elements;

    }



    public void tick() {

    }

}
