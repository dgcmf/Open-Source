package gamersboard.dgcmf;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import gamersboard.dgcmf.events.EventsList;


public class Main extends JavaPlugin {
	
	Plugin pl;
	
	@Override
	public void onEnable() {
		
		pl = this;
		Bukkit.getConsoleSender().sendMessage("§5§l[dgSounds] §7Ativado com Sucesso!");
		getInstance().saveDefaultConfig();
		registerEvents();
	}
	
	public static Main getInstance() {
		return (Main) getPlugin((Class) Main.class);
	}
	private void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EventsList(), this);

	}

}
