package com.woutwoot.wowpvp.game.area;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        spawnLocations = new ArrayList<>();
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

    /**
     * Add a location to the list of spawn locations.
     *
     * @param location
     */
    public void addSpawnLocation(Location location) {
        spawnLocations.add(location.clone());
    }

    /**
     * Tries to remove the location from the list. Has to be the same Block location.
     *
     * @param location
     * @return true if the location was removed.
     */
    public boolean removeSpawnLocation(Location location) {
        Location removeLocation = null;
        for (Location l : spawnLocations) {
            boolean x = l.getBlockX() == location.getBlockX();
            boolean y = l.getBlockY() == location.getBlockY();
            boolean z = l.getBlockZ() == location.getBlockZ();
            boolean w = l.getWorld().getName().equals(location.getWorld().getName());
            if (x && y && z && w) {
                removeLocation = l;
            }
        }
        if (removeLocation != null) {
            spawnLocations.remove(removeLocation);
            return true;
        }
        return false;
    }

    /**
     * Toggle a location to be added/removed.
     *
     * @return true when the location was added. Otherwise false.
     */
    public boolean toggleSpawnLocation(Location location) {
        if (removeSpawnLocation(location)) {
            return false;
        } else {
            addSpawnLocation(location);
            return true;
        }
    }

    /**
     * Get a random location from the list of spawn locations.
     *
     * @return
     */
    public Location getRandomSpawnLocation() {
        int index = new Random().nextInt(spawnLocations.size());
        Location loc = spawnLocations.get(index);
        return loc;
    }

    public void regenerateArena(){
        //TODO
    }

    public void saveArena(){
        //TODO
    }
}
