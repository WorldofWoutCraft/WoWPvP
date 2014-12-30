package com.woutwoot.wowpvp.commands;

import com.woutwoot.wowpvp.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Wout on 7/12/2014 - 14:56.
 */
public abstract class ToggleCommand extends WoWPvPCommand implements Listener {

    protected Map<UUID, String[]> users = new HashMap<>();

    public ToggleCommand() {
        Main.getInstance().registerListener(this);
    }

    public abstract void process(Player player);

    protected abstract void sendOffMessage(Player player);

    protected abstract void sendOnMessage(Player player);

    /**
     * Toggle this command for a certain user. Users are identified using UUID
     *
     * @param uuid   The UUId for the user
     * @param sender
     * @return the new state. True when this user has the command now toggled on
     */
    public boolean toggle(Player sender, String[] args) {
        UUID uuid = sender.getUniqueId();
        if (isOn(uuid)) {
            setOff(uuid);
            sendOffMessage(sender);
            return false;
        } else {
            setOn(uuid, args);
            sendOnMessage(sender);
            return true;
        }
    }

    protected String[] getArgs(UUID uuid) {
        return users.get(uuid);
    }

    protected void setOn(UUID uuid, String[] args) {
        if (!isOn(uuid)) {
            users.put(uuid, args);
        }
    }

    protected void setOff(UUID uuid) {
        if (isOn(uuid)) {
            users.remove(uuid);
        }
    }

    protected boolean isOn(UUID uuid) {
        return users.keySet().contains(uuid);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOW)
    public void onClickAir(PlayerInteractEvent event) {
        if (this.isOn(event.getPlayer().getUniqueId()) && (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            this.process(event.getPlayer());
        }
    }

}
