package aether.mixin;

import aether.gui.AetherScreen;
import aether.gui.ClickGUI;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;

import org.lwjgl.glfw.GLFW;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(KeyBinding.class)
public class KeyboardMixin {


    @Inject(
            method = "onKeyPressed",
            at = @At("HEAD")
    )
    private static void onKeyPressed(
            CallbackInfo ci
    ) {

        MinecraftClient mc =
                MinecraftClient.getInstance();


        if (mc.currentScreen != null) {
            return;
        }


        long window =
                mc.getWindow()
                        .getHandle();


        if (GLFW.glfwGetKey(
                window,
                GLFW.GLFW_KEY_RIGHT_SHIFT
        )
                == GLFW.GLFW_PRESS) {


            ClickGUI.toggle();


            if (ClickGUI.isOpened()) {

                mc.setScreen(
                        new AetherScreen()
                );

            }

        }

    }

}
