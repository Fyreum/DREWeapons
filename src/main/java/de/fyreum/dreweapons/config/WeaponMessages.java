package de.fyreum.dreweapons.config;

import de.erethon.commons.chat.MessageUtil;
import de.erethon.commons.config.Message;
import de.erethon.commons.config.MessageHandler;
import de.fyreum.dreweapons.DREWeapons;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum WeaponMessages implements Message {



    ;

    private final String path;

    WeaponMessages(String path) {
        this.path = path;
    }

    @Override
    public String getMessage() {
        if (this.getMessageHandler().getMessage(this) == null) {
            return "Invalid Message at " + getPath();
        }
        return this.getMessageHandler().getMessage(this);
    }
    @Override
    public String getMessage(String... args) {
        if (this.getMessageHandler().getMessage(this, args) == null) {
            return "Invalid Message at " + getPath();
        }
        return this.getMessageHandler().getMessage(this, args);
    }

    public void sendMessage(CommandSender sender, String... args) {
        MessageUtil.sendMessage(sender, this.getMessage(args));
    }

    public void sendActionBar(Player player, String... args) {
        MessageUtil.sendActionBarMessage(player, this.getMessage(args));
    }

    @Override
    public MessageHandler getMessageHandler() {
        return DREWeapons.getInstance().getMessageHandler();
    }

    @Override
    public String getPath() {
        return path;
    }
}
