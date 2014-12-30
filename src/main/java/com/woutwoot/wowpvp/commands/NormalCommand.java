package com.woutwoot.wowpvp.commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Wout on 7/12/2014 - 14:55.
 */
public abstract class NormalCommand extends WoWPvPCommand {

    public abstract void process(CommandSender sender, String[] args);

}
