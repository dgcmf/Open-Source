package gamersboard.dgcmf;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import gamersboard.dgcmf.comandos.CMDHaste;
import gamersboard.dgcmf.eventos.Eventos;

public class Main extends JavaPlugin {
	
	
	Plugin pl;
	
	@Override
	public void onEnable() {
		pl = this;
		Bukkit.getConsoleSender().sendMessage("§5[dgHasteCapitalista] §7Ativado com §aSUCESSO§7.");
		getInstance().saveDefaultConfig();
		getCommand("haste").setExecutor(new CMDHaste());
		Bukkit.getPluginManager().registerEvents(new Eventos(), this);
	}
	public static Main getInstance() {
		return (Main) getPlugin((Class) Main.class);
	}

}
