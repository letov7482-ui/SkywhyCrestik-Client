package com.skywhy.module;

import com.skywhy.module.modules.*;
import net.minecraft.client.MinecraftClient;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // ТОЛЬКО ТЕ МОДУЛИ, КОТОРЫЕ РЕАЛЬНО СУЩЕСТВУЮТ В ПАПКЕ modules/
        modules.add(new KillAura());
        modules.add(new Speed());
        modules.add(new Flight());
        modules.add(new FullBright());
        modules.add(new NoFall());
        modules.add(new Sprint());
        modules.add(new Scaffold());
        modules.add(new ESP());
        // ДОБАВЛЯЙТЕ НОВЫЕ МОДУЛИ ТОЛЬКО ПОСЛЕ СОЗДАНИЯ ИХ КЛАССОВ
    }

    public List<Module> getModules() { return modules; }

    public Module getModule(String name) {
        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(name)) return m;
        }
        return null;
    }

    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }
}
