package com.woutwoot.wowpvp;

import com.woutwoot.wowpvp.events.*;
import com.woutwoot.wowpvp.game.GameManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by woutwoot on 3/12/2014 - 20:26.
 */
public class Main extends JavaPlugin {

    private GameManager manager = new GameManager();

    private CommandsHandler commandsHandler = new CommandsHandler();

    private static Main instance;

    @Override
    public void onEnable(){
        init();
        registerEvents();
    }

    @Override
    public void onDisable(){

    }

    public static Main getInstance() {
        return instance;
    }

    private void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new PlayerCommandHandler(), this);
        pm.registerEvents(new PlayerLeaveHandler(), this);
        pm.registerEvents(new PlayerJoinHandler(), this);
        pm.registerEvents(new PlayerTeleportHandler(), this);
        pm.registerEvents(new PlayerRespawnHandler(), this);
        pm.registerEvents(new PlayerDeathHandler(), this);
        pm.registerEvents(new PlayerChatHandler(), this);
    }

    private void init() {
        instance = this;
        this.manager = new GameManager();
        this.getCommand("wowpvp").setExecutor(commandsHandler);
    }

    public GameManager getManager() {
        return manager;
    }
}
