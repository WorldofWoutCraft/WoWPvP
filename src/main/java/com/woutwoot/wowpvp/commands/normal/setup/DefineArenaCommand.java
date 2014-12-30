package com.woutwoot.wowpvp.commands.normal.setup;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class DefineArenaCommand extends NormalCommand {

    @Override
    public String getName() {
        return "definearena";
    }

    @Override
    public List<String> getAliases() {
        aliases.add("defarena");
        aliases.add("darena");
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

        Main.getInstance().getManager().createGame(args[1], c1, c2);
        messages.sendArenaCreateSuccess();
    }


}
