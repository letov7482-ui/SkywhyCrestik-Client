package aether.render;


import aether.core.Managers;
import aether.event.events.Render2DEvent;


import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;



public final class AetherRender {


    private AetherRender() {

    }



    public static void initialize() {



        HudRenderCallback.EVENT.register(
                (
                        drawContext,
                        tickDelta
                ) -> {


                    if (Managers.EVENT_BUS == null) {

                        return;

                    }



                    Managers.EVENT_BUS.post(
                            new Render2DEvent(
                                    drawContext,
                                    tickDelta
                            )
                    );


                }
        );

    }

}
