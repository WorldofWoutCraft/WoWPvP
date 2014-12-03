package com.woutwoot.wowpvp.game.area;

import org.bukkit.Location;

/**
 * Created by Wout on 3/12/2014 - 22:02.
 */
public class Arena {

    private Location corner1;
    private Location corner2;
    //TODO: Handle block regen/arena reset here.

    public Arena(Location corner1, Location corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public Location getCorner1() {
        return corner1;
    }

    public void setCorner1(Location corner1) {
        this.corner1 = corner1;
    }

    public Location getCorner2() {
        return corner2;
    }

    public void setCorner2(Location corner2) {
        this.corner2 = corner2;
    }

    public void regenerateArena(){
        //TODO
    }

    public void saveArena(){
        //TODO
    }
}
