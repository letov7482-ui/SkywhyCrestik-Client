package com.skywhy.gui;

import com.skywhy.module.modules.KillAura;
import com.skywhy.utils.RotationUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class RotationSettingsGUI extends Screen {
    private final KillAura killAura;
    private int selectedMode = 0;

    public RotationSettingsGUI(KillAura killAura) {
        super(Text.literal("Rotation Settings"));
        this.killAura = killAura;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0x88000000);
        context.drawCenteredTextWithShadow(textRenderer, "KillAura Rotation Settings", width / 2, 20, 0x00AAFF);

        String[] modes = {"INSTANT", "SMOOTH", "SILENT", "90°", "180°", "270°", "360°", "RANDOM"};
        int y = 60;
        for (int i = 0; i < modes.length; i++) {
            int color = (i == selectedMode) ? 0x00FFAA : 0xFFFFFF;
            context.drawText(textRenderer, (i == selectedMode ? "§a» " : "   ") + modes[i], 20, y, color, false);
            y += 20;
        }

        context.drawText(textRenderer, "Speed: " + killAura.rotationSpeed, 20, y + 20, 0xAAAAAA, false);
        context.drawText(textRenderer, "Left Click to select, Right Click to back", 20, height - 30, 0x666666, false);

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int y = 60;
        for (int i = 0; i < 8; i++) {
            if (mouseX > 20 && mouseX < 200 && mouseY > y && mouseY < y + 16) {
                selectedMode = i;
                RotationUtils.RotationMode mode = switch (i) {
                    case 0 -> RotationUtils.RotationMode.INSTANT;
                    case 1 -> RotationUtils.RotationMode.SMOOTH;
                    case 2 -> RotationUtils.RotationMode.SILENT;
                    case 3 -> RotationUtils.RotationMode.90_DEGREE;
                    case 4 -> RotationUtils.RotationMode.180_DEGREE;
                    case 5 -> RotationUtils.RotationMode.270_DEGREE;
                    case 6 -> RotationUtils.RotationMode.360_DEGREE;
                    default -> RotationUtils.RotationMode.RANDOM;
                };
                killAura.setRotationMode(mode);
                return true;
            }
            y += 20;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() { return false; }
}
