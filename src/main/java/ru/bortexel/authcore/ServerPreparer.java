package ru.bortexel.authcore;

import org.bukkit.GameRule;
import org.bukkit.Server;
import org.bukkit.World;

public class ServerPreparer {
    private final Server server;

    public ServerPreparer(Server server) {
        this.server = server;
    }

    public void prepare() {
        for (World world : this.server.getWorlds()) {
            world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
            world.setGameRule(GameRule.DISABLE_RAIDS, true);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_ENTITY_DROPS, false);
            world.setGameRule(GameRule.DO_FIRE_TICK, false);
            world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
            world.setGameRule(GameRule.DO_INSOMNIA, false);
            world.setGameRule(GameRule.DO_MOB_LOOT, false);
            world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
            world.setGameRule(GameRule.DO_PATROL_SPAWNING, false);
            world.setGameRule(GameRule.DO_TILE_DROPS, false);
            world.setGameRule(GameRule.DO_TRADER_SPAWNING, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
            world.setGameRule(GameRule.DROWNING_DAMAGE, false);
            world.setGameRule(GameRule.FALL_DAMAGE, false);
            world.setGameRule(GameRule.FIRE_DAMAGE, false);
            world.setGameRule(GameRule.FORGIVE_DEAD_PLAYERS, true);
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
            world.setGameRule(GameRule.MOB_GRIEFING, false);
            world.setGameRule(GameRule.RANDOM_TICK_SPEED, 0);
            world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
            world.setGameRule(GameRule.SPAWN_RADIUS, 0);
        }
    }
}
