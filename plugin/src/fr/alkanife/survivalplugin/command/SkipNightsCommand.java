package fr.alkanife.survivalplugin.command;

import fr.alkanife.survivalplugin.SurvivalPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SkipNightsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (SurvivalPlugin.skipNights) {
            SurvivalPlugin.skipNights = false;
            commandSender.sendMessage("§7§oSkip nights désactivé");
        } else {
            SurvivalPlugin.skipNights = true;
            commandSender.sendMessage("§7§oSkip nights activé");
        }

        return true;
    }
}
