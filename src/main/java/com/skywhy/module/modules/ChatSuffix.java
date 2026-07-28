package com.skywhy.module.modules;

import com.skywhy.module.Module;
import net.minecraft.text.Text;

public class ChatSuffix extends Module {
    private String suffix = " §b| §fSkyWhy";

    public ChatSuffix() { super("ChatSuffix", Category.MISC); }

    @Override
    public void onTick() {
        if (mc.player != null) {
            // Добавление суффикса к сообщениям чата
            // Требуется перехват сообщений
        }
    }
}
