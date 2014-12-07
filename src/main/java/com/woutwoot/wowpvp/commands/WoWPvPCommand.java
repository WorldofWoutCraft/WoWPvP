package com.woutwoot.wowpvp.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:03.
 */
public interface WoWPvPCommand {

    public String getName();

    public List<String> getAliases();

    public String getPermission();

    public void process(CommandSender sender, String[] args);

    public boolean match(String s);

}
