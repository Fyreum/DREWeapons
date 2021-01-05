package de.fyreum.dreweapons.config;

import de.erethon.commons.config.DREConfig;
import org.bukkit.ChatColor;

import java.io.File;

public class WeaponConfig extends DREConfig {

    public static final int CONFIG_VERSION = 1;

    private String language = "german";
    private String lorePrefix = ChatColor.translateAlternateColorCodes('&', "&9Schematic&8: &7");

    public WeaponConfig(File file) {
        super(file, CONFIG_VERSION);
        if (initialize) {
            initialize();
        }
        load();
    }

    public String getLanguage() {
        return language;
    }

    public String getLorePrefix() {
        return lorePrefix;
    }

    @Override
    public void initialize() {
        if (!config.contains("language")) {
            config.set("language", language);
        }
        if (!config.contains("lorePrefix")) {
            config.set("lorePrefix", lorePrefix);
        }
        save();
    }

    @Override
    public void save() {
        config.set("language", language);
        config.set("lorePrefix", lorePrefix);
        super.save();
    }

    @Override
    public void load() {
        language = config.getString("language");
        String lorePrefix = config.getString("lorePrefix");
        if (lorePrefix != null) {
            this.lorePrefix = ChatColor.translateAlternateColorCodes('&', lorePrefix);
        }
    }
}
