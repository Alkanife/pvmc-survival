package fr.alkanife.survivalplugin;

import fr.alkanife.survivalplugin.command.AFKCommand;
import fr.alkanife.survivalplugin.command.SkipNightsCommand;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SurvivalPlugin extends JavaPlugin {

    public static boolean skipNights = true;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new NameChanger(), this);
        Bukkit.getPluginManager().registerEvents(new Events(), this);

        getCommand("afk").setExecutor(new AFKCommand());
        getCommand("skipnights").setExecutor(new SkipNightsCommand());

        Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers())
                player.setPlayerListHeaderFooter("§7" + new SimpleDateFormat("EEE d MMM yyyy hh:mm:ss aaa").format(new Date())
                        + "\n§7Ping: §e" + ((CraftPlayer) player).getHandle().ping + "§7 ms\n§f", "§f ");
        }, 20L, 10L);

        super.onEnable();
    }

}
