package dev.dmaax.hg;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import dev.dmaax.hg.commands.FeastCommand;
import dev.dmaax.hg.listeners.PlayerJoinAndQuit;

public class SpigotMain extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		registerEvents();
		registerCommands();
		Bukkit.getServer().getConsoleSender().sendMessage("§aPlugin iniciado.");
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll();
		Bukkit.getServer().getConsoleSender().sendMessage("§cPlugin desabilitado.");
	}
	
	private void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoinAndQuit(), this);
	}
	
	private void registerCommands() {
		getCommand("feast").setExecutor(new FeastCommand());
	}

}
