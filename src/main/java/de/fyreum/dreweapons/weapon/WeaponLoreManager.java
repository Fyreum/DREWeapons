package de.fyreum.dreweapons.weapon;

import org.bukkit.ChatColor;

public class WeaponLoreManager {

    private final String lorePrefix;

    public WeaponLoreManager(String lorePrefix) {
        this.lorePrefix = lorePrefix;
    }

    public String getFullLore(String schematicID) {
        return lorePrefix + schematicID;
    }

    public String getSchematicId(String fullLore) {
        return strip(fullLore).replace(strip(lorePrefix), "");
    }

    public String getLorePrefix() {
        return lorePrefix;
    }

    // shortcuts

    private String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    private String strip(String s) {
        return ChatColor.stripColor(s);
    }
}
