package aether.config;

import aether.core.AetherClient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;


public final class ConfigManager {


    private final File directory;


    private final File configFile;



    public ConfigManager() {


        directory =
                new File(
                        "config/aether"
                );


        configFile =
                new File(
                        directory,
                        "config.json"
                );

    }



    public void load() {


        try {


            if (!directory.exists()) {

                directory.mkdirs();

            }



            if (!configFile.exists()) {

                save();

                return;

            }



            String data =
                    Files.readString(
                            configFile.toPath()
                    );


            AetherClient.getLogger()
                    .info(
                            "Config loaded."
                    );


        } catch (Exception e) {


            AetherClient.getLogger()
                    .error(
                            "Failed to load config",
                            e
                    );

        }

    }



    public void save() {


        try {


            if (!directory.exists()) {

                directory.mkdirs();

            }



            FileWriter writer =
                    new FileWriter(
                            configFile
                    );


            writer.write(
                    "{\n" +
                    "  \"client\": \"Aether Visuals\",\n" +
                    "  \"version\": \"1.0.0\"\n" +
                    "}"
            );


            writer.close();



            AetherClient.getLogger()
                    .info(
                            "Config saved."
                    );


        } catch (IOException e) {


            AetherClient.getLogger()
                    .error(
                            "Failed to save config",
                            e
                    );

        }

    }



    public File getConfigFile() {

        return configFile;

    }

}
