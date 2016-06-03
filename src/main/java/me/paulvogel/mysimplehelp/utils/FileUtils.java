package me.paulvogel.mysimplehelp.utils;

import me.paulvogel.mysimplehelp.MySimpleHelp;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Paul on 03.06.2016.
 */
public class FileUtils {

    private static File configFile;
    private static YamlConfiguration config;

    public static void init() {
        checkForFiles();
    }

    private static void checkForFiles() {
        FileUtils.configFile = new File(MySimpleHelp.getInstance().getDataFolder(), "config.yml");

        if (!FileUtils.configFile.exists()) {
            MySimpleHelp.getInstance().getLogger().info("No configfile found, creating...");
            setConfigs();
        }
        loadFiles();
    }

    public static void loadFiles() {
        try {
            if (FileUtils.config == null)
                FileUtils.configFile = new File(MySimpleHelp.getInstance().getDataFolder(), "config.yml");

            FileUtils.config = YamlConfiguration.loadConfiguration(FileUtils.configFile);
        } catch (Exception e) {
            MySimpleHelp.getInstance().getLogger().warning("Could not load configfiles!");
            e.printStackTrace();
        }
    }

    public static void setConfigs() {
        FileUtils.config = YamlConfiguration.loadConfiguration(FileUtils.configFile);
        if (!FileUtils.configFile.exists())
            MySimpleHelp.getInstance().saveResource("config.yml", false);
    }

    public static YamlConfiguration getConfig() {
        return config;
    }

}
