package com.woutwoot.wowpvp;

import com.woutwoot.wowpvp.events.*;
import com.woutwoot.wowpvp.game.GameManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by woutwoot on 3/12/2014 - 20:26.
 */
public class Main extends JavaPlugin {

    private GameManager manager = new GameManager();

    private CommandsHandler commandsHandler;

    private PluginManager pm;

    private static Main instance;

    @Override
    public void onEnable() {
        registerEvents();
    }

    @Override
    public void onDisable(){

    }

    public static Main getInstance() {
        return instance;
    }

    private void registerEvents() {
        registerListener(new PlayerCommandHandler());
        registerListener(new PlayerLeaveHandler());
        registerListener(new PlayerJoinHandler());
        registerListener(new PlayerTeleportHandler());
        registerListener(new PlayerRespawnHandler());
        registerListener(new PlayerDeathHandler());
        registerListener(new PlayerChatHandler());
    }

    private void init() {
        instance = this;
        this.manager = new GameManager();
        pm = this.getServer().getPluginManager();
        this.commandsHandler = new CommandsHandler();
        this.getCommand("wowpvp").setExecutor(commandsHandler);
    }

    public GameManager getManager() {
        return manager;
    }

    /**
     * Log a message to the console.
     *
     * @param s Message to log
     */
    public static void log(String s) {
        getInstance().getLogger().log(Level.WARNING, s);
    }

    public void registerListener(Listener listener) {
        pm.registerEvents(listener, this);
    }

    public CommandsHandler getCommandsHandler() {
        return commandsHandler;
    }
}
