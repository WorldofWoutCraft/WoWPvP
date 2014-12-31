package com.woutwoot.wowpvp.commands.normal.setup;

import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class SetupCommand extends NormalCommand {

    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public List<String> getAliases() {
        aliases.add("wizard");
        return aliases;
    }

    @Override
    public String getDescription() {
        return "Setup wizard command";
    }

    @Override
    public void process(CommandSender sender, String[] args) {
        new Messages(sender).sendFirstInstructions();
    }


}
