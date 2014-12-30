package com.woutwoot.wowpvp.commands.normal.setup;

import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class HelpCommand extends NormalCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public List<String> getAliases() {
        aliases.add("info");
        aliases.add("tutorial");
        return aliases;
    }

    @Override
    public void process(CommandSender sender, String[] args) {
        new Messages(sender).sendHelpMessage();
    }

}
