package ru.bortexel.authcore.listeners;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // Найти точку спавна в мире и телепортировать игрока туда, если его местоположение по Y < 0
        if (event.getTo() == null) return;
        int targetY = event.getTo().getBlockY();
        if (targetY > 0) return;

        World world = event.getTo().getWorld();
        if (world == null) return;
        event.setTo(world.getSpawnLocation());
    }
}
