package com.skywhy.hud;

import com.skywhy.client.SkyWhyClient;
import com.skywhy.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class HUDManager {
    private boolean enabled = true;

    public void render(DrawContext context) {
        if (!enabled) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        // Watermark
        context.drawText(mc.textRenderer, "§bSkyWhy §fClient", 4, 4, 0x00AAFF, false);
        context.drawText(mc.textRenderer, "FPS: " + mc.getCurrentFps(), 4, 16, 0xAAAAAA, false);

        // Arraylist
        int y = 40;
        for (Module m : SkyWhyClient.INSTANCE.moduleManager.getModules()) {
            if (m.isEnabled()) {
                context.drawText(mc.textRenderer, m.getName(), mc.getWindow().getScaledWidth() - 100, y, 0x00FFAA, false);
                y += 12;
            }
        }
    }

    public void setEnabled(boolean e) { enabled = e; }
}
