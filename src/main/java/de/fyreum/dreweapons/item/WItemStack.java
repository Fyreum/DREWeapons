package de.fyreum.dreweapons.item;

import de.fyreum.dreweapons.DREWeapons;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public class WItemStack extends ItemStack {

    DREWeapons plugin = DREWeapons.getInstance();

    public WItemStack(String schematicId) {
        this(schematicId, 1);
    }

    public WItemStack(String schematicId, int amount) {
        super(Material.CHEST, amount);
        getItemMeta().setDisplayName(plugin.getWeaponConfig());
        getItemMeta().setLore(Collections.singletonList(plugin.getWeaponLoreManager().getFullLore(schematicId)));
    }
}
