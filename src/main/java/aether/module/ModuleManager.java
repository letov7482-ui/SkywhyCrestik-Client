package aether.module;

import aether.module.visual.Fullbright;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {


    private final List<Module> modules =
            new ArrayList<>();


    public ModuleManager() {

        initialize();

    }


    private void initialize() {

        register(
                new Fullbright()
        );

    }


    public void register(
            Module module
    ) {

        if (module == null) {
            return;
        }


        modules.add(module);

    }


    public void unregister(
            Module module
    ) {

        modules.remove(module);

    }


    public List<Module> getModules() {

        return modules;

    }


    public Module getByName(
            String name
    ) {

        for (Module module : modules) {

            if (module.getName()
                    .equalsIgnoreCase(name)) {

                return module;
            }

        }

        return null;

    }


    public List<Module> getByCategory(
            Category category
    ) {

        List<Module> result =
                new ArrayList<>();


        for (Module module : modules) {

            if (module.getCategory()
                    == category) {

                result.add(module);

            }

        }


        return result;

    }


    public void tick() {

        for (Module module : modules) {

            if (module.isEnabled()) {

                module.onTick();

            }

        }

    }


    public void disableAll() {

        for (Module module : modules) {

            if (module.isEnabled()) {

                module.setEnabled(false);

            }

        }

    }

}
