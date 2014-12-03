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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wout on 3/12/2014 - 22:20.
 *
 * This class will hold the actual game code. It will eventually have the most code.
 */
public class Game {

    private Arena arena;
    private Lobby lobby;
    private String name;
    private List<Gamer> gamers = new LinkedList<>();
    private List<GameSign> signs = new ArrayList<>();
    private GameTask gameTickTask = new GameTickTask();
    private GameTask gameSignsTask = new GameSignsTask();

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

    public List<Gamer> getGamers() {
        return gamers;
    }

    public void addGamer(Gamer gamer){
        gamers.add(gamer);
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
}
