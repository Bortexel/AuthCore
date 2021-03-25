package ru.bortexel.authcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.bortexel.authcore.listeners.ConnectionListener;
import ru.bortexel.authcore.listeners.MoveListener;

public final class AuthCore extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new ConnectionListener(this), this);
    }
}
