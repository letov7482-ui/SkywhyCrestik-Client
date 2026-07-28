package com.skywhy.gui;

import com.skywhy.client.SkyWhyClient;
import com.skywhy.module.Module;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import java.awt.Color;

public class ClickGUI extends Screen {
    private int selectedCategory = 0;
    private int scrollOffset = 0;
    private Module.Category[] categories = Module.Category.values();

    public ClickGUI() {
        super(Text.literal("SkyWhy Crestik"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, width, height, 0x88000000);
        context.drawCenteredTextWithShadow(textRenderer, "§bSkyWhy §fCrestik", width / 2, 15, 0x00AAFF);

        int catX = 20, catY = 45;
        for (int i = 0; i < categories.length; i++) {
            int color = (i == selectedCategory) ? 0x00AAFF : 0x666666;
            context.drawText(textRenderer, (i == selectedCategory ? "§l" : "") + categories[i].name(), catX, catY + i * 20, color, false);
        }

        int modX = 120, modY = 45 + scrollOffset, index = 0;
        for (Module m : SkyWhyClient.INSTANCE.moduleManager.getModules()) {
            if (m.getCategory() != categories[selectedCategory]) continue;
            int bg = m.isEnabled() ? new Color(0, 100, 200, 150).getRGB() : new Color(40, 40, 40, 180).getRGB();
            context.fill(modX - 4, modY + index * 22 - 2, modX + 200, modY + index * 22 + 20, bg);
            context.drawText(textRenderer, (m.isEnabled() ? "§a" : "§7") + m.getName(), modX, modY + index * 22, 0xFFFFFF, false);
            context.drawText(textRenderer, m.isEnabled() ? "§aON" : "§7OFF", modX + 160, modY + index * 22, m.isEnabled() ? 0x00FFAA : 0x666666, false);
            index++;
        }
        context.drawText(textRenderer, "Click to toggle | Scroll | ESC to close", 20, height - 30, 0x666666, false);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int modX = 120, modY = 45 + scrollOffset, index = 0;
        for (Module m : SkyWhyClient.INSTANCE.moduleManager.getModules()) {
            if (m.getCategory() != categories[selectedCategory]) continue;
            if (mouseX > modX - 4 && mouseX < modX + 200 && mouseY > modY + index * 22 - 2 && mouseY < modY + index * 22 + 20) {
                m.toggle();
                SkyWhyClient.INSTANCE.configManager.save();
                return true;
            }
            index++;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        scrollOffset -= amount * 10;
        return super.mouseScrolled(mouseX, mouseY, amount);
    }
    @Override public boolean shouldPause() { return false; }
    @Override public boolean shouldCloseOnEsc() { return true; }
    }
