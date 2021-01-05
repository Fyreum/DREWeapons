package de.fyreum.dreweapons.commands;

import de.erethon.commons.command.DRECommandCache;
import de.erethon.commons.javaplugin.DREPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WeaponCommandCache extends DRECommandCache implements TabCompleter {

    public static final String LABEL = "dreweapons";
    final DREPlugin plugin;

    public WeaponCommandCache(DREPlugin plugin) {
        super(LABEL, plugin);
        this.plugin = plugin;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
