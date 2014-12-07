package com.woutwoot.wowpvp.commands.normal.setup;

import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.commands.WoWPvPCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class HelpCommand implements WoWPvPCommand, NormalCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("info");
        aliases.add("tutorial");
        return aliases;
    }

    @Override
    public String getPermission() {
        return "wowpvp.command.help";
    }

    @Override
    public void process(CommandSender sender, String[] args) {
        new Messages(sender).sendHelpMessage();
    }

    @Override
    public boolean match(String s) {
        if (this.getName().equalsIgnoreCase(s) || this.getAliases().contains(s)) {
            return true;
        } else {
            return false;
        }
    }

}
