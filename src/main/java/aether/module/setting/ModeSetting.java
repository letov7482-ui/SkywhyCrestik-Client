package aether.module.setting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ModeSetting extends Setting<String> {

    private final List<String> modes;

    public ModeSetting(
            String name,
            String description,
            String defaultMode,
            String... modes
    ) {
        super(
                name,
                description,
                defaultMode
        );

        this.modes = Arrays.asList(modes);

        if (!this.modes.contains(defaultMode)) {
            throw new IllegalArgumentException(
                    "Default mode must exist in modes list."
            );
        }
    }

    public List<String> getModes() {
        return Collections.unmodifiableList(modes);
    }

    public boolean is(String mode) {
        return getValue().equalsIgnoreCase(mode);
    }

    public void next() {

        int index = modes.indexOf(getValue());

        index++;

        if (index >= modes.size()) {
            index = 0;
        }

        setValue(modes.get(index));
    }

    public void previous() {

        int index = modes.indexOf(getValue());

        index--;

        if (index < 0) {
            index = modes.size() - 1;
        }

        setValue(modes.get(index));
    }

}
