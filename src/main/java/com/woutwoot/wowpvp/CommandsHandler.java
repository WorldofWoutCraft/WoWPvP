package com.woutwoot.wowpvp;

import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.commands.ToggleCommand;
import com.woutwoot.wowpvp.commands.WoWPvPCommand;
import com.woutwoot.wowpvp.commands.normal.setup.DefineArenaCommand;
import com.woutwoot.wowpvp.commands.normal.setup.HelpCommand;
import com.woutwoot.wowpvp.commands.normal.setup.SetupCommand;
import com.woutwoot.wowpvp.commands.normal.setup.SetupLobbyCommand;
import com.woutwoot.wowpvp.commands.toggle.setup.AddLobbySpawnsCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                    if (wowCommand instanceof NormalCommand) {
                        ((NormalCommand) wowCommand).process(sender, args);
                    } else {
                        if (sender instanceof Player) {
                            ((ToggleCommand) wowCommand).toggle(((Player) sender), args);
                        }
                    }
                } else {
                    new Messages(sender).sendInvalidArgument();
                }
            } else {
                if (args.length == 0) {
                    ((NormalCommand) matchCommand("help")).process(sender, args);
                }
            }
            return true;
        }
        return false;
    }

    private void initCommands() {
        //Normal Commands
        //GAME
        //SETUP
        commands.add(new SetupCommand());
        commands.add(new HelpCommand());
        commands.add(new DefineArenaCommand());
        commands.add(new SetupLobbyCommand());

        //Toggle commands
        //GAME
        //SETUP
        commands.add(new AddLobbySpawnsCommand());
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
