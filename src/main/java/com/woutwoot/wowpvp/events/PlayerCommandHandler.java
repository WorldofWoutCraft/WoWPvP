package com.woutwoot.wowpvp.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * Created by Wout on 3/12/2014 - 23:22.
 */
public class PlayerCommandHandler implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerTryCommand(PlayerCommandPreprocessEvent event){

    }
}
