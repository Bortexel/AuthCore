package ru.bortexel.authcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.bortexel.authcore.listeners.BlockListener;
import ru.bortexel.authcore.listeners.ConnectionListener;
import ru.bortexel.authcore.listeners.EntityListener;
import ru.bortexel.authcore.listeners.MoveListener;

public final class AuthCore extends JavaPlugin {
    @Override
    public void onEnable() {
        // Зарегистрировать слушателей
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new ConnectionListener(this), this);
        pluginManager.registerEvents(new BlockListener(), this);
        pluginManager.registerEvents(new EntityListener(), this);

        // Выставить нужные игровые правила
        new ServerPreparer(this.getServer()).prepare();
    }
}
