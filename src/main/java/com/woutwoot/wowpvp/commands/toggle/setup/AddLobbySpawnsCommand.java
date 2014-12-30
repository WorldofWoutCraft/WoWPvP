package com.woutwoot.wowpvp.commands.toggle.setup;

import com.woutwoot.wowpvp.Main;
import com.woutwoot.wowpvp.commands.ToggleCommand;
import com.woutwoot.wowpvp.game.Game;
import com.woutwoot.wowpvp.setup.Messages;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Wout on 4/12/2014 - 12:02.
 */
public class AddLobbySpawnsCommand extends ToggleCommand {

    public AddLobbySpawnsCommand() {
        super();
    }

    @Override
    public String getName() {
        return "addlobbyspawns";
    }

    @Override
    public List<String> getAliases() {
        aliases.add("addlspawns");
        return aliases;
    }

    @Override
    public void process(Player player) {
        String[] args = this.getArgs(player.getUniqueId());
        Messages m = new Messages(player);

        if (args == null || args.length <= 1) {
            m.sendInvalidArgument();
            return;
        }

        if (Main.getInstance().getManager().getGame(args[1]) != null) {
            Game game = Main.getInstance().getManager().getGame(args[1]);
            if (game.getLobby().toggleTeleportLocation(player.getLocation())) {
                m.sendLocationAdded();
            } else {
                m.sendLocationRemoved();
            }
        } else {
            m.sendGameDoesNotExist();
        }
    }

    @Override
    protected void sendOffMessage(Player player) {
        new Messages(player).sendEndAddingLobbySpawns();
    }

    @Override
    protected void sendOnMessage(Player player) {
        new Messages(player).sendStartAddingLobbySpawns();
    }

}
