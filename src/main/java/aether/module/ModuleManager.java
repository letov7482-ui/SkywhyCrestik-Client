package aether.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModuleManager {

    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
    }

    public void initialize() {

        /*
         * Register modules here.
         *
         * Example:
         *
         * register(new WatermarkModule());
         * register(new FullBright());
         * register(new ChinaHat());
         * register(new TargetESP());
         */

    }

    public void register(Module module) {

        if (module == null) {
            return;
        }

        modules.add(module);

    }

    public List<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public List<Module> getEnabledModules() {

        List<Module> enabled = new ArrayList<>();

        for (Module module : modules) {

            if (module.isEnabled()) {
                enabled.add(module);
            }

        }

        return enabled;

    }

    public List<Module> getModules(Category category) {

        List<Module> result = new ArrayList<>();

        for (Module module : modules) {

            if (module.getCategory() == category) {
                result.add(module);
            }

        }

        return result;

    }

    public Module getModule(String name) {

        for (Module module : modules) {

            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }

        }

        return null;

    }

    public <T extends Module> T getModule(Class<T> clazz) {

        for (Module module : modules) {

            if (clazz.isInstance(module)) {
                return clazz.cast(module);
            }

        }

        return null;

    }

    public boolean contains(String name) {
        return getModule(name) != null;
    }

}
