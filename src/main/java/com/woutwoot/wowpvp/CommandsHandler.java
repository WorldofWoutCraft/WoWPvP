package com.woutwoot.wowpvp;

import com.woutwoot.wowpvp.commands.WoWPvPCommand;
import com.woutwoot.wowpvp.commands.normal.setup.HelpCommand;
import com.woutwoot.wowpvp.commands.normal.setup.SetupCommand;
import com.woutwoot.wowpvp.tools.Vars;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:08.
 */
public class CommandsHandler implements CommandExecutor {

    private List<WoWPvPCommand> commands = new ArrayList<>();

    public CommandsHandler() {
        this.initCommands();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if (command.getName().equals("wowpvp")) {
            if (args.length >= 1 && args[0] != null) {
                WoWPvPCommand wowCommand = matchCommand(args[0]);
                if (wowCommand != null) {
                    wowCommand.process(sender, args);
                } else {
                    sender.sendMessage(Vars.tag + "Invalid argument. Try /" + name + " help.");
                }
            } else {
                if (args.length == 0) {
                    matchCommand("help").process(sender, args);
                }
            }
            return true;
        }
        return false;
    }

    private void initCommands() {
        commands.add(new SetupCommand());
        commands.add(new HelpCommand());
    }

    private WoWPvPCommand matchCommand(String s) {
        for (WoWPvPCommand command : commands) {
            if (command.match(s)) {
                return command;
            }
        }
        return null;
    }
}
