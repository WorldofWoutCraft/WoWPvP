package com.woutwoot.wowpvp.game.gamer;

import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.tools.Vars;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.UUID;

/**
 * Created by Wout on 3/12/2014 - 22:03.
 */
public class Gamer {

    private UUID uuid;

    public Gamer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void sendMessage(String message){
        getPlayer().sendMessage(Vars.tag + message);
    }

    public Player getPlayer() {
        return Main.getInstance().getServer().getPlayer(uuid);
    }

    public void clearInventoryAndPotionEffects() {
        getPlayer().getInventory().setArmorContents(null);
        getPlayer().getInventory().clear();
        clearPotionEffects();
    }

    public void clearPotionEffects() {
        for (PotionEffect effect : getPlayer().getActivePotionEffects()) {
            getPlayer().removePotionEffect(effect.getType());
        }
    }

    public void heal() {
        getPlayer().setHealth(20);
        getPlayer().setFoodLevel(20);
    }

}
