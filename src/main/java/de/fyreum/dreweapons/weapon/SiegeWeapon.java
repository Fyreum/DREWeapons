package de.fyreum.dreweapons.weapon;

import de.erethon.commons.player.PlayerCollection;
import de.fyreum.dreweapons.DREWeapons;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

public class SiegeWeapon implements SchematicContainer, SecuredAccess {

    DREWeapons plugin = DREWeapons.getInstance();

    private final String displayName;
    private final String schematicId;
    private final UUID owner;
    private final PlayerCollection accessors;

    public SiegeWeapon(String displayName, String schematicId, UUID owner, UUID... accessors) {
        this.displayName = displayName;
        this.schematicId = schematicId;
        this.owner = owner;
        this.accessors = new PlayerCollection(Arrays.asList(accessors));
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public UUID getOwner() {
        return owner;
    }

    @Override
    public PlayerCollection getAccessors() {
        return accessors;
    }

    public boolean isAccessor(UUID player) {
        return accessors.contains(player);
    }

    @Override
    public String getSchematicId() {
        return schematicId;
    }

    public String getSchematicId(String lore) {
        return plugin.getWeaponLoreManager().getSchematicId(getFullLore());
    }

    public String getFullLore() {
        return plugin.getWeaponLoreManager().getFullLore(schematicId);
    }

    @Override
    public String getSchematicFilePath() {
        return plugin.getSchematicFileLoader().getPath(schematicId);
    }

    @Override
    public File getSchematicFile() {
        return plugin.getSchematicFileLoader().load(schematicId);
    }
}
