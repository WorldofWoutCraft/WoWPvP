package com.woutwoot.wowpvp.setup;

import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.commands.WoWPvPCommand;
import com.woutwoot.wowpvp.tools.Vars;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Wout on 7/12/2014 - 15:00.
 */
public class Messages {

    private CommandSender sender;

    public Messages(CommandSender sender) {
        this.sender = sender;
    }

    public void sendFirstInstructions() {
        s("Thank you for using {pluginname}! Let's get started shall we?");
        s("Step 1 is to create the actual arena where the game will be played.");
        s("{playername}, Please select that arena using WorldEdit, and then use /{maincommand} [definearena] (gamename)");
    }

    /**
     * Quick and simple method to send a message to the commandSender.
     * It will also color command arguments. Use [argument] for a plugin argument.
     * Use (argument) for a player argument. The method will color it.
     * Use {pluginname}, {playername} or {maincommand} as variables.
     *
     * @param message the message to send.
     */
    private void s(String message) {
        ChatColor mainColor = ChatColor.LIGHT_PURPLE;
        ChatColor pluginArg = ChatColor.AQUA;
        ChatColor playerArg = ChatColor.YELLOW;

        message = message.replace("{pluginname}", ChatColor.DARK_RED + Vars.pluginName + mainColor);
        message = message.replace("{playername}", sender.getName());
        message = message.replace("{maincommand}", ChatColor.DARK_RED + Vars.mainCommand + mainColor);
        message = message.replace("[", pluginArg.toString());
        message = message.replace("]", mainColor.toString());
        message = message.replace("(", playerArg.toString());
        message = message.replace(")", mainColor.toString());
        sender.sendMessage(mainColor + message);
    }

    public void sendHelpMessage() {
        s("{pluginname} commands:");
        if (sender.hasPermission("wowpvp.admin")) {
            for (WoWPvPCommand command : Main.getInstance().getCommandsHandler().getCommands()) {
                s("/{maincommand} [" + command.getName() + "] - " + command.getDescription());
            }
        }
        s("/{maincommand} [help] - Shows this message");
    }

    public void sendMustBePlayerMessage() {
        s("Sorry, but you have to be a player to use this command.");
    }

    public void sendMustHaveSelectionCommand() {
        s("You must have a WorldEdit selection before you use this command.");
    }

    public void sendIncorrectNumberOfArgumentsMessage() {
        s("Incorrect number of arguments.");
    }

    public void sendArenaCreateSuccess() {
        s("Success! The arena has been defined. Now use \"/{maincommand} [setuplobby] (gamename)\" to create a lobby for that arena. Make sure you use WorldEdit to select it first!");
    }

    public void sendWorldEditNotInstalledMessage() {
        s("You need to have WorldEdit installed to use this plugin.");
    }

    public void sendInvalidArgument() {
        s("Invalid argument \"/{maincommand} [help] might help you :)");
    }

    public void sendLobbyCreateSuccess() {
        s("Success! The lobby has been defined. Now use \"/{maincommand} [addlobbyspawns] (gamename)\" to add lobby spawn points.");
    }

    public void sendGameDoesNotExist() {
        s("Sorry! That game does not exist. You can list the available games using \"/{maincommand} [listgames]\"");
    }

    public void sendLocationAdded() {
        s("Your location has been added!");
    }

    public void sendLocationRemoved() {
        s("Your location has been removed!");
    }

    public void sendEndAddingLobbySpawns() {
        s("You stopped adding spawns for this lobby! Now use \"/{maincommand} [addplayerspawns] (gamename)\" to add arena spawn points.");
    }

    public void sendStartAddingLobbySpawns() {
        s("You can now add spawns for this lobby! Just right click!");
    }

    public void sendEndAddingPlayerSpawns() {
        s("You stopped adding spawns for this arena!"); //TODO: Add next thing to do
    }

    public void sendStartAddingPlayerSpawns() {
        s("You can now add spawns for this arena! Just right click!");
    }
}
