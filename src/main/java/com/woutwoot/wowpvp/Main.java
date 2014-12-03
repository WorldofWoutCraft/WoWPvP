package com.woutwoot.wowpvp;

import com.woutwoot.wowpvp.events.PlayerCommandHandler;
import com.woutwoot.wowpvp.events.PlayerJoinHandler;
import com.woutwoot.wowpvp.events.PlayerLeaveHandler;
import com.woutwoot.wowpvp.events.PlayerTeleportHandler;
import com.woutwoot.wowpvp.game.GameManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by woutwoot on 3/12/2014 - 20:26.
 */
public class Main extends JavaPlugin {

    private GameManager manager = new GameManager();
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
    }

    private void init() {
        instance = this;
    }

}
