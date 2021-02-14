package fr.alkanife.survivalplugin;

import com.mojang.authlib.GameProfile;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.lang.reflect.Field;

public class NameChanger implements Listener {

    private final Field nameField;

    public NameChanger() {
        nameField = getField(GameProfile.class, "name");
    }

    @EventHandler
    public void onPreLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        try {
            if (player.getName().equalsIgnoreCase("Alkanife")) {
                nameField.set(((CraftPlayer) player).getProfile(), "alka");
                player.setDisplayName("alka");
            }

            if (player.getName().equalsIgnoreCase("SheeleCavalies")) {
                nameField.set(((CraftPlayer) player).getProfile(), "Sheele");
                player.setDisplayName("Sheele");
            }
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        }

    }

    private Field getField(Class<?> clazz, String name) {
        try {
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException | SecurityException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
