package com.woutwoot.wowpvp.setup;

import com.woutwoot.wowpvp.tools.Vars;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Wout on 7/12/2014 - 15:00.
 */
public class Wizard {

    private CommandSender sender;

    public Wizard(CommandSender sender) {
        this.sender = sender;
    }

    public void sendWizardInstructions() {
        s("Thank you for using {pluginname}! Let's get started shall we?");
        s("Step 1 is to create the actual arena where the game will be played.");
        s("{playername}, Please select that arena using WorldEdit, and then use /{maincommand} [define] (arenaname)");
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
        message = message.replace("{maincommand}", Vars.mainCommand);
        message = message.replace("[", pluginArg.toString());
        message = message.replace("]", mainColor.toString());
        message = message.replace("(", playerArg.toString());
        message = message.replace(")", mainColor.toString());
        sender.sendMessage(message);
    }

    public void sendHelpMessage() {
        s("{pluginname} commands:");
        s("/{maincommand} [help] - Shows this message");
        s("/{maincommand} [setup] - Starts the setup wizard.");
    }
}
