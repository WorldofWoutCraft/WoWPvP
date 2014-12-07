package com.woutwoot.wowpvp.game;

import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.game.area.Arena;
import com.woutwoot.wowpvp.game.area.Lobby;
import com.woutwoot.wowpvp.game.gamer.Gamer;
import com.woutwoot.wowpvp.game.signs.GameSign;
import com.woutwoot.wowpvp.game.tasks.GameSignsTask;
import com.woutwoot.wowpvp.game.tasks.GameTask;
import com.woutwoot.wowpvp.game.tasks.GameTickTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.*;

/**
 * Created by Wout on 3/12/2014 - 22:20.
 *
 * This class will hold the actual game code. It will eventually have the most code.
 */
public class Game {

    private String name;
    private Arena arena;
    private Lobby lobby;

    private Map<UUID, Gamer> gamers = new HashMap<>();

    private List<GameSign> signs = new ArrayList<>();

    private GameTask gameTickTask = new GameTickTask();
    private GameTask gameSignsTask = new GameSignsTask();

    private Map<UUID, Location> oldLocations = new HashMap<>();
    private Map<UUID, ItemStack[]> oldInventorys = new HashMap<>();
    private Map<UUID, ItemStack[]> oldArmors = new HashMap<>();

    public Game(String name) {
        this.name = name;
        this.startSignsTask();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<UUID, Gamer> getGamers() {
        return gamers;
    }

    public void addGamer(Gamer gamer){
        gamers.put(gamer.getUuid(), gamer);
        saveOldData(gamer);
        gamer.clearInventoryAndPotionEffects();
    }

    public void removeGamer(Gamer gamer) {
        gamer.clearPotionEffects();
        gamer.heal();
        gamer.getPlayer().getInventory().setContents(oldInventorys.get(gamer.getUuid()));
        gamer.getPlayer().getInventory().setArmorContents(oldArmors.get(gamer.getUuid()));
        gamer.getPlayer().teleport(oldLocations.get(gamer.getUuid()));
        gamers.remove(gamer);
    }

    private void saveOldData(Gamer gamer) {
        oldLocations.put(gamer.getUuid(), gamer.getPlayer().getLocation().clone());
        oldInventorys.put(gamer.getUuid(), gamer.getPlayer().getInventory().getContents().clone());
        oldArmors.put(gamer.getUuid(), gamer.getPlayer().getInventory().getArmorContents().clone());
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public List<GameSign> getSigns() {
        return signs;
    }

    public void addGameSign(GameSign sign){
        signs.add(sign);
    }

    private void startSignsTask() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), gameSignsTask, 20L, 10L);
    }

    private void startGameTask() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), gameSignsTask, 20L, 20L);
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public void broadcastMessage(String message) {
        for (Gamer g : gamers.values()) {
            g.sendMessage(message);
        }
    }
}
