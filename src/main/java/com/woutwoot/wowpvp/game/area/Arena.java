package com.woutwoot.wowpvp.game.area;

import org.bukkit.Location;

import java.util.List;

/**
 * Created by Wout on 3/12/2014 - 22:02.
 */
public class Arena {

    private Location corner1;
    private Location corner2;
    private List<Location> spawnLocations;
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

    public void addSpawnLocation(Location location) {
        spawnLocations.add(location.clone());
    }

    public void removeSpawnLocation(Location location) {
        Location removeLocation = null;
        for (Location l : spawnLocations) {
            boolean x = l.getBlockX() == location.getBlockX();
            boolean y = l.getBlockY() == location.getBlockY();
            boolean z = l.getBlockZ() == location.getBlockZ();
            if (x && y && z) {
                removeLocation = l;
            }
        }
        if (removeLocation != null) {
            spawnLocations.remove(removeLocation);
        }
    }

    public void regenerateArena(){
        //TODO
    }

    public void saveArena(){
        //TODO
    }
}
