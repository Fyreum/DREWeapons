package de.fyreum.dreweapons;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.compatibility.Internals;
import de.erethon.commons.javaplugin.DREPlugin;
import de.erethon.commons.javaplugin.DREPluginSettings;
import de.erethon.factionsxl.FactionsXL;
import de.fyreum.dreweapons.commands.WeaponCommandCache;
import de.fyreum.dreweapons.config.SchematicFileLoader;
import de.fyreum.dreweapons.config.WeaponConfig;
import de.fyreum.dreweapons.weapon.WeaponLoreManager;
import org.bukkit.Bukkit;

import java.io.File;

public final class DREWeapons extends DREPlugin {

    private static DREWeapons instance;
    private WeaponConfig weaponConfig;
    private WeaponLoreManager weaponLoreManager;
    private SchematicFileLoader schematicFileLoader;
    private WeaponCommandCache commandCache;
    private WorldEditPlugin worldEditPlugin;
    private FactionsXL factionsXL;

    public DREWeapons() {
        settings = DREPluginSettings.builder()
                .paper(true)
                .economy(false)
                .internals(Internals.v1_16_R1)
                .build();
    }

    @Override
    public void onEnable() {
        // instances
        instance = this;
        this.instantiateWeaponConfig();
        weaponLoreManager = new WeaponLoreManager(weaponConfig.getLorePrefix());
        schematicFileLoader = new SchematicFileLoader();
        commandCache = new WeaponCommandCache(instance);
        // WorldEdit
        if (Bukkit.getPluginManager().isPluginEnabled("WorldEdit") && Bukkit.getPluginManager().getPlugin("WorldEdit") != null) {
            worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
            MessageUtil.log("&aSuccessfully Found WorldEdit on the server!");
        } else {
            MessageUtil.log("&4Couldn't find WorldEdit on the server.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        // FactionsXL
        if (Bukkit.getPluginManager().isPluginEnabled("FactionsXL") && Bukkit.getPluginManager().getPlugin("FactionsXL") != null) {
            factionsXL = (FactionsXL) Bukkit.getPluginManager().getPlugin("FactionsXL");
            MessageUtil.log("&aSuccessfully Found FactionsXL on the server!");
        } else {
            MessageUtil.log("&4Couldn't find FactionsXL on the server -> some features may not work");
        }
        // setup
        this.setCommandCache(commandCache);
        commandCache.register(instance);
        this.getCommand(WeaponCommandCache.LABEL).setTabCompleter(commandCache);
        this.attemptToSaveResource("languages/german.yml", false);
        this.getMessageHandler().setDefaultLanguage(weaponConfig.getLanguage());
    }

    @Override
    public void onDisable() {

    }

    public void instantiateWeaponConfig() {
        weaponConfig = new WeaponConfig(new File(getDataFolder(), "config.yml"));
    }

    public WeaponConfig getWeaponConfig() {
        return weaponConfig;
    }

    public WeaponLoreManager getWeaponLoreManager() {
        return weaponLoreManager;
    }

    public SchematicFileLoader getSchematicFileLoader() {
        return schematicFileLoader;
    }

    @Override
    public WeaponCommandCache getCommandCache() {
        return commandCache;
    }

    public WorldEditPlugin getWorldEditPlugin() {
        return worldEditPlugin;
    }

    public FactionsXL getFactionsXL() {
        return factionsXL;
    }

    public static DREWeapons getInstance() {
        return instance;
    }
}
