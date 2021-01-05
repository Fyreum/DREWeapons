package de.fyreum.dreweapons.config;

import de.erethon.commons.chat.MessageUtil;
import de.fyreum.dreweapons.DREWeapons;

import java.io.File;

public class SchematicFileLoader {

    DREWeapons plugin = DREWeapons.getInstance();

    public File load(String schematicId) {
        String path = plugin.getDataFolder() + File.separator + "/schematics/" + schematicId + ".schematic";
        MessageUtil.log(plugin, "Loading " + path + "...");
        File file = new File(path);
        if (!file.exists()) {
            MessageUtil.log(plugin, "&eFile not found");
        } else {
            MessageUtil.log(plugin, "&aSuccessfully loaded " + file.getName() + "!");
        }
        return file;
    }

    public String getPath(String schematicId) {
        return plugin.getDataFolder() + File.separator + "/schematics/" + schematicId + ".schematic";
    }
}
