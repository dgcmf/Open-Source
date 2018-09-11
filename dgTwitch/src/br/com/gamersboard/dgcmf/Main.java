package br.com.gamersboard.dgcmf;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.gamersboard.dgcmf.comandos.CMDTransmissao;
import br.com.gamersboard.dgcmf.comandos.CMDTransmitir;


public class Main extends JavaPlugin {
	
	
	Plugin pl;
	
	@Override
	public void onEnable() {
		pl = this;
		Bukkit.getConsoleSender().sendMessage("§5§l[dgTwitch] §7Plugin §a§lATIVADO §7com sucesso.");
		getInstance().saveDefaultConfig();
		getCommand("transmitindo").setExecutor(new CMDTransmitir());
		getCommand("transmissao").setExecutor(new CMDTransmissao());
	}
	
	@Override
	public void onDisable() {
		pl = null;
		Bukkit.getConsoleSender().sendMessage("§5§l[dgTwitch] §7Plugin §c§lDESATIVADO §7com sucesso.");
	}
	public static Main getInstance() {
		return (Main) getPlugin((Class) Main.class);
	}

}
