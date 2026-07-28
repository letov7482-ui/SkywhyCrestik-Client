package aether.hud;


import aether.core.Managers;
import aether.event.Event;
import aether.event.Listener;
import aether.event.events.Render2DEvent;



public final class HudRenderer implements Listener {


    @Override
    public void onEvent(
            Event event
    ) {


        if (!(event instanceof Render2DEvent render)) {

            return;

        }



        if (Managers.HUD == null) {

            return;

        }



        Managers.HUD.render(
                render.getContext(),
                render.getTickDelta()
        );

    }

}
