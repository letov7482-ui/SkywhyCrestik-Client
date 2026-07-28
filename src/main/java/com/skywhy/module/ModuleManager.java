package com.skywhy.module;

import com.skywhy.module.modules.*;
import net.minecraft.client.MinecraftClient;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // COMBAT
        modules.add(new KillAura());
        modules.add(new Reach());
        modules.add(new Velocity());
        modules.add(new AutoClicker());
        modules.add(new AntiBot());
        modules.add(new CrystalAura());
        modules.add(new AutoTrap());

        // MOVEMENT
        modules.add(new Speed());
        modules.add(new Flight());
        modules.add(new LongJump());
        modules.add(new Strafe());
        modules.add(new Step());
        modules.add(new NoSlow());
        modules.add(new Sprint());
        modules.add(new Jesus());

        // PLAYER
        modules.add(new NoFall());
        modules.add(new AntiPush());
        modules.add(new AutoRespawn());
        modules.add(new FastPlace());
        modules.add(new AutoEat());
        modules.add(new Regen());
        modules.add(new AntiBlind());
        modules.add(new AutoFish());

        // VISUAL
        modules.add(new ESP());
        modules.add(new Nametags());
        modules.add(new Tracers());
        modules.add(new Skeleton());
        modules.add(new ItemESP());
        modules.add(new ChestESP());
        modules.add(new SpawnerESP());
        modules.add(new XRay());

        // RENDER
        modules.add(new FullBright());
        modules.add(new Freecam());
        modules.add(new Zoom());
        modules.add(new NoRender());
        modules.add(new WeatherChanger());
        modules.add(new CustomFOV());
        modules.add(new MotionBlur());

        // MISC
        modules.add(new MiddleClick());
        modules.add(new Timer());
        modules.add(new ChatSuffix());
        modules.add(new AntiAFK());

        // HUD
        modules.add(new WatermarkModule());

        // COSMETIC
        modules.add(new CosmeticManager());
    }

    public List<Module> getModules() { return modules; }
    public Module getModule(String name) {
        for (Module m : modules) if (m.getName().equalsIgnoreCase(name)) return m;
        return null;
    }
    public List<Module> getModulesByCategory(Module.Category cat) {
        List<Module> list = new ArrayList<>();
        for (Module m : modules) if (m.getCategory() == cat) list.add(m);
        return list;
    }
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;
        for (Module m : modules) if (m.isEnabled()) m.onTick();
    }
    public void onRender() {
        for (Module m : modules) if (m.isEnabled()) m.onRender();
    }
                    }
