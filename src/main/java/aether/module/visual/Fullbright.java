package aether.module.visual;

import aether.module.Category;
import aether.module.Module;
import aether.setting.NumberSetting;

import net.minecraft.client.MinecraftClient;


public final class Fullbright extends Module {


    private final MinecraftClient mc =
            MinecraftClient.getInstance();


    private final NumberSetting brightness =
            new NumberSetting(
                    "Brightness",
                    16.0,
                    1.0,
                    32.0,
                    1.0
            );


    private double previousGamma;



    public Fullbright() {

        super(
                "Fullbright",
                Category.VISUAL
        );


        addSetting(
                brightness
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


        applyBrightness();

    }



    @Override
    public void onTick() {

        if (isEnabled()) {

            applyBrightness();

        }

    }



    private void applyBrightness() {

        if (mc.options == null) {
            return;
        }


        mc.options
                .getGamma()
                .setValue(
                        brightness
                                .getValue()
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



    public NumberSetting getBrightness() {

        return brightness;

    }

}
