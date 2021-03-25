package ru.bortexel.authcore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import ru.bortexel.authcore.AuthCore;

import java.util.Calendar;

public class ConnectionListener implements Listener {
    private final AuthCore plugin;

    public ConnectionListener(AuthCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // --- Убрать сообщение о входе на сервер ---
        event.setJoinMessage(null);

        // --- Скрыть игрока у всех других игроков, скрыть всех других игроков у текущего игрока ---
        for (Player player : event.getPlayer().getServer().getOnlinePlayers()) {
            player.hidePlayer(this.plugin, event.getPlayer());
            event.getPlayer().hidePlayer(this.plugin, player);
        }

        // --- Установить игроку время, похожее на реальное ---
        Calendar calendar = Calendar.getInstance();
        // Берём текущее время сервера
        calendar.setTimeInMillis(System.currentTimeMillis());
        // Получаем текущий час в часовом поясе сервера
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // Количество часов, что надо вычесть, чтобы получить в игре время,
        // приблизительно соответствующее реальному.
        // Если верить Minecraft Wiki, то разница должна составлять 6 часов.
        // Однако мне кажется, что 8 - более оптимальное значение.
        final int offset = 8;

        // В игровом дне 24000 тактов. В сутках 24 часа. Совпадение?
        // Поэтому просто умножим текущий час на 1000.
        // Реальная полночь соответствует рассвету в игре.
        // Поэтому вычтем offset из текущего времени.
        event.getPlayer().setPlayerTime((hour - offset) * 1000, false);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        // Убрать сообщение о выходе с сервера
        event.setQuitMessage(null);
    }
}
