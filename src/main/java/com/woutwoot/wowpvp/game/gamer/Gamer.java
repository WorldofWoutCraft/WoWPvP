package com.woutwoot.wowpvp.game.gamer;

import com.woutwoot.wowpvp.tools.Vars;
import org.bukkit.entity.Player;

/**
 * Created by Wout on 3/12/2014 - 22:03.
 */
public class Gamer {

    private Player player;

    public Gamer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void sendMessage(String message){
        player.sendMessage(Vars.tag + message);
    }
}
