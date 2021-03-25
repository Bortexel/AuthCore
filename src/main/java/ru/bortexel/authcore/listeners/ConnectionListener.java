package ru.bortexel.authcore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.bortexel.authcore.AuthCore;

public class ConnectionListener implements Listener {
    private final AuthCore plugin;

    public ConnectionListener(AuthCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Убрать сообщение о входе на сервер
        event.setJoinMessage(null);

        // Скрыть игрока у всех других игроков, скрыть всех других игроков у текущего игрока
        for (Player player : event.getPlayer().getServer().getOnlinePlayers()) {
            player.hidePlayer(this.plugin, event.getPlayer());
            event.getPlayer().hidePlayer(this.plugin, player);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // Убрать сообщение о выходе с сервера
        event.setQuitMessage(null);
    }
}
