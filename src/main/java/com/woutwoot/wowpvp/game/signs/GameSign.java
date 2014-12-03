package com.woutwoot.wowpvp.game.signs;

import org.bukkit.block.Sign;

/**
 * Created by Wout on 3/12/2014 - 23:12.
 */
public abstract class GameSign {

    private Sign sign;

    public GameSign(Sign sign) {
        this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }
}
