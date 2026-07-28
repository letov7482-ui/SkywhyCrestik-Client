package aether.hud;

import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public final class HudManager {

    private final List<HudElement> elements = new ArrayList<>();


    public HudManager() {

    }


    public void register(HudElement element) {

        if (element == null) {
            return;
        }

        elements.add(element);
    }


    public void unregister(HudElement element) {

        elements.remove(element);
    }


    public void render(DrawContext context) {

        for (HudElement element : elements) {

            if (element.isEnabled()) {
                element.render(context);
            }

        }
    }


    public void tick() {

        for (HudElement element : elements) {

            if (element.isEnabled()) {
                element.tick();
            }

        }
    }


    public List<HudElement> getElements() {

        return elements;
    }


    public HudElement getByName(String name) {

        for (HudElement element : elements) {

            if (element.getName()
                    .equalsIgnoreCase(name)) {

                return element;
            }
        }

        return null;
    }


    public void mousePressed(
            double mouseX,
            double mouseY
    ) {

        for (HudElement element : elements) {

            element.mousePressed(
                    mouseX,
                    mouseY
            );
        }
    }


    public void mouseDragged(
            double mouseX,
            double mouseY
    ) {

        for (HudElement element : elements) {

            element.mouseDragged(
                    mouseX,
                    mouseY
            );
        }
    }


    public void mouseReleased() {

        for (HudElement element : elements) {

            element.mouseReleased();
        }
    }

}
