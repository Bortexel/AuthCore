package ru.bortexel.authcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.hanging.HangingBreakEvent;

public class EntityListener implements Listener {
    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        // Энтити не должны взрываться
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        // Энтити не должны получать урон
        event.setCancelled(true);
    }

    @EventHandler
    public void onHangingBreak(HangingBreakEvent event) {
        // Нельзя ломать поводки
        event.setCancelled(true);
    }
}
