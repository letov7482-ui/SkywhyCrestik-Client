package aether.module.visual;

import aether.module.Category;
import aether.module.Module;

import net.minecraft.client.MinecraftClient;


public final class Fullbright extends Module {


    private final MinecraftClient mc =
            MinecraftClient.getInstance();


    private double previousGamma;



    public Fullbright() {

        super(
                "Fullbright",
                Category.VISUAL
        );

    }



    @Override
    protected void onEnable() {

        if (mc.options == null) {
            return;
        }


        previousGamma =
                mc.options
                        .getGamma()
                        .getValue();


        mc.options
                .getGamma()
                .setValue(
                        16.0
                );

    }



    @Override
    protected void onDisable() {

        if (mc.options == null) {
            return;
        }


        mc.options
                .getGamma()
                .setValue(
                        previousGamma
                );

    }

}
