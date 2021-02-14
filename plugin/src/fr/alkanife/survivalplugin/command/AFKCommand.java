package fr.alkanife.survivalplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AFKCommand implements CommandExecutor {

    public static List<UUID> afkPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player))
            return true;

        Player player = (Player) commandSender;

        if (afkPlayers.contains(player.getUniqueId())) {
            afkPlayers.remove(player.getUniqueId());

            player.setPlayerListName("§f" + player.getName());
            player.sendMessage("§7§oTu n'es plus affiché AFK.");
        } else {
            afkPlayers.add(player.getUniqueId());

            player.setPlayerListName("§7AFK §f" + player.getName());
            player.sendMessage("§7§oTu es désormais affiché AFK.");
        }

        return true;
    }
}
