package com.woutwoot.wowpvp.commands.normal.setup;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.woutwoot.wowpvp.commands.NormalCommand;
import com.woutwoot.wowpvp.commands.WoWPvPCommand;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class DefineArenaCommand implements WoWPvPCommand, NormalCommand {

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
        Messages messages = new Messages(sender);
        Player player;
        if (sender instanceof Player && sender != null) {
            player = (Player) sender;
        } else {
            messages.sendMustBePlayerMessage();
            return;
        }

        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        Selection sel = we.getSelection(player);

        if (sel == null) {
            messages.sendMustHaveSelectionCommand();
            return;
        }


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
