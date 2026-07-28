package aether.setting;


import java.util.Arrays;
import java.util.List;



public final class ModeSetting
        extends Setting<String> {


    private final List<String> modes;



    public ModeSetting(
            String name,
            String current,
            String... modes
    ) {

        super(
                name,
                current
        );


        this.modes =
                Arrays.asList(
                        modes
                );

    }



    public void cycle() {

        int index =
                modes.indexOf(
                        getValue()
                );


        index++;


        if (index >= modes.size()) {

            index = 0;

        }


        setValue(
                modes.get(index)
        );

    }



    public List<String> getModes() {

        return modes;

    }

        }
