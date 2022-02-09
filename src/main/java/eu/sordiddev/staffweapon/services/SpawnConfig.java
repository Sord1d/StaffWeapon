package eu.sordiddev.staffweapon.services;

import eu.sordiddev.staffweapon.Staffweapon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class SpawnConfig {
    @NotNull
    static Staffweapon plugin = Staffweapon.getPlugin(Staffweapon.class);

    private static FileConfiguration customConfig = null;
    private static File customConfigFile = null;

    public static void reloadCustomConfig() {
        if (customConfigFile == null) {
            customConfigFile = new File(plugin.getDataFolder(), "spawnpoints.yml");
        }
        customConfig = YamlConfiguration.loadConfiguration(customConfigFile);

        // Look for defaults in the jar
        Reader defConfigStream = null;
        defConfigStream = new InputStreamReader(Objects.requireNonNull(plugin.getResource("customConfig.yml")), StandardCharsets.UTF_8);
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            customConfig.setDefaults(defConfig);
        }
    }

    public static FileConfiguration getCustomConfig() {
        if (customConfig == null) {
            reloadCustomConfig();
        }
        return customConfig;
    }

    public static void saveCustomConfig() {
        if (customConfig == null || customConfigFile == null) {
            return;
        }
        try {
            getCustomConfig().save(customConfigFile);
        } catch (IOException ex) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + " [StaffWeapon] Could not save config to " + customConfigFile, String.valueOf(ex));
        }
    }

    public static void saveDefaultConfig() {
        if (customConfigFile == null) {
            customConfigFile = new File(plugin.getDataFolder(), "spawnpoints.yml");
        }
        if (!customConfigFile.exists()) {
            plugin.saveResource("spawnpoints.yml", false);
        }
    }

}
