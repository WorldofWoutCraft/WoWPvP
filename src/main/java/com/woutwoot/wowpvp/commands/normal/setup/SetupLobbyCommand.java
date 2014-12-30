package com.woutwoot.wowpvp.commands.normal.setup;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.game.area.Lobby;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Wout on 10/12/2014 - 22:33.
 */
public class SetupLobbyCommand extends NormalCommand {

    @Override
    public String getName() {
        return "setuplobby";
    }

    @Override
    public List<String> getAliases() {
        aliases.add("setlobby");
        return aliases;
    }

    @Override
    public void process(CommandSender sender, String[] args) {
        Messages messages = new Messages(sender);
        Player player;

        if (sender instanceof Player && sender != null) {
            player = (Player) sender;
        } else {
            messages.sendMustBePlayerMessage();
            return;
        }

        if (args.length != 2) {
            messages.sendIncorrectNumberOfArgumentsMessage();
            return;
        }

        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");

        if (we == null) {
            messages.sendWorldEditNotInstalledMessage();
            return;
        }

        Selection sel = we.getSelection(player);

        if (sel == null) {
            messages.sendMustHaveSelectionCommand();
            return;
        }

        Location c1 = sel.getMaximumPoint();
        Location c2 = sel.getMaximumPoint();

        Main.getInstance().getManager().getGame(args[1]).setLobby(new Lobby(c1, c2));
        messages.sendLobbyCreateSuccess();
    }

}
