package de.fyreum.dreweapons.weapon;

import de.erethon.commons.player.PlayerCollection;

import java.util.UUID;

public interface SecuredAccess {

    UUID getOwner();
    
    PlayerCollection getAccessors();

}
