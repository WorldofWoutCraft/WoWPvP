package com.woutwoot.wowpvp.game.area;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Wout on 3/12/2014 - 22:02.
 *
 * The lobby is the area you will be teleported to before the game is actually started.
 */
public class Lobby {

    private Location corner1;
    private Location corner2;
    private List<Location> teleportLocations;

    /**
     * Create a new lobby (cuboid)
     *
     * @param corner1 1st corner
     * @param corner2 2nd corner
     */
    public Lobby(Location corner1, Location corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        teleportLocations = new ArrayList<>();
    }

    /**
     * Get the 1st corner of the lobby cuboid region.
     * @return first corner.
     */
    public Location getCorner1() {
        return corner1;
    }

    /**
     * Set the 1st corner of the lobby cuboid region.
     */
    public void setCorner1(Location corner1) {
        this.corner1 = corner1;
    }

    /**
     * Get the 2nd corner of the lobby cuboid region.
     * @return 2nd corner
     */
    public Location getCorner2() {
        return corner2;
    }

    /**
     * Set the 2nd corner of the lobby cuboid region.
     * @param corner2
     */
    public void setCorner2(Location corner2) {
        this.corner2 = corner2;
    }

    /**
     * Add a location to the list of teleport locations.
     *
     * @param location
     */
    public void addTeleportLocation(Location location) {
        teleportLocations.add(location.clone());
    }

    /**
     * Tries to remove the location from the list. Has to be the same Block location.
     *
     * @param location
     */
    public void removeTeleportLocation(Location location) {
        Location removeLocation = null;
        for (Location l : teleportLocations) {
            boolean x = l.getBlockX() == location.getBlockX();
            boolean y = l.getBlockY() == location.getBlockY();
            boolean z = l.getBlockZ() == location.getBlockZ();
            boolean w = l.getWorld().getName().equals(location.getWorld().getName());
            if (x && y && z && w) {
                removeLocation = l;
            }
        }
        if (removeLocation != null) {
            teleportLocations.remove(removeLocation);
        }
    }

    /**
     * Get a random location from the list of teleport locations.
     *
     * @return
     */
    public Location getRandomTeleportLocation() {
        int index = new Random().nextInt(teleportLocations.size());
        Location loc = teleportLocations.get(index);
        return loc;
    }

}
