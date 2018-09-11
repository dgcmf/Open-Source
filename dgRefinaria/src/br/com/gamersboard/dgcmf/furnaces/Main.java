package br.com.gamersboard.dgcmf.furnaces;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.gamersboard.dgcmf.furnaces.commands.CMDFurnace;
import br.com.gamersboard.dgcmf.furnaces.inventory.Inventarios;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	
	Plugin pl;
	private static Economy econ;
    public static Permission perms;
    private static Chat chat;
	@Override
	public void onEnable() {
		pl = this;
		registerComandos();
		Bukkit.getConsoleSender().sendMessage("§5[dgRefinaria] §7Ativado com §aSUCESSO§7.");
		getInstance().saveDefaultConfig();
		registerEventos();
		this.setupEconomy();
	}
	@Override
	public void onDisable() {
		pl = null;
		
	}
	private void registerComandos() {

		getCommand("refinaria").setExecutor(new CMDFurnace());
	}
	private void registerEventos() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Inventarios(), this);
	}
	public static Main getInstance() {
		return (Main) getPlugin((Class) Main.class);
	}
	private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEcononomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public Chat getChat() {
        return chat;
    }
	

}
