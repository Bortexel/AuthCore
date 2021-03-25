package ru.bortexel.authcore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class BlockListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        // Нельзя ломать блоки
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        // Нельзя ставить блоки
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(BlockDamageEvent event) {
        // Нельзя наносить урон блокам
        event.setCancelled(true);
    }

    @EventHandler
    public void onBurn(BlockBurnEvent event) {
        // Блоки не должны сгорать
        event.setCancelled(true);
    }

    @EventHandler
    public void onExplode(BlockExplodeEvent event) {
        // Блоки не должны взрываться
        event.setCancelled(true);
    }

    @EventHandler
    public void onFade(BlockFadeEvent event) {
        // Блоки не должны исчезать
        event.setCancelled(true);
    }

    @EventHandler
    public void onForm(BlockFormEvent event) {
        // Блоки не должны создаваться другими блоками
        event.setCancelled(true);
    }

    @EventHandler
    public void onGrow(BlockGrowEvent event) {
        // Растения не должны расти
        event.setCancelled(true);
    }

    @EventHandler
    public void onIgnite(BlockIgniteEvent event) {
        // Блоки не должны загораться
        event.setCancelled(true);
    }

    @EventHandler
    public void onSpread(BlockSpreadEvent event) {
        // Блоки не должны распространяться
        event.setCancelled(true);
    }
}
