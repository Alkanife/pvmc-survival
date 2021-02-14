package fr.alkanife.survivalplugin;

import fr.alkanife.survivalplugin.command.AFKCommand;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.setPlayerListName("§f" + player.getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (AFKCommand.afkPlayers.contains(player.getUniqueId()))
            AFKCommand.afkPlayers.remove(player.getUniqueId());
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
        if (!SurvivalPlugin.skipNights)
            return;

        if (event.getBedEnterResult() != PlayerBedEnterEvent.BedEnterResult.OK)
            return;

        Player player = event.getPlayer();
        World world = player.getWorld();

        world.setTime(0);

        Bukkit.broadcastMessage("§e" + player.getName() + "§7§o a fait rompich.");
    }

}
