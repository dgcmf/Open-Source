package br.com.gamersboard.dgcmf.comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import br.com.gamersboard.dgcmf.Main;

public class CMDTransmitir implements CommandExecutor {

	public static FileConfiguration cf = Main.getInstance().getConfig();
	public static String pf = cf.getString("Prefix").replace("&", "§");
	public static HashMap<String, Boolean> twitch = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§5§l[dgTwitch] §cVocê não é um jogador.");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("transmitindo")) {
			if (!p.hasPermission(cf.getString("PermissaoNecessaria"))) {
				p.sendMessage(pf + cf.getString("NTwitcher").replace("&", "§"));
				return true;
			} else {
				if (args.length == 0) {
					p.sendMessage(pf + cf.getString("Usage").replace("&", "§"));
					return true;
				}
				if (args[0].contains(cf.getString("ContainsURL"))) {
					if (twitch.containsKey(p.getName())) {
						p.sendMessage(pf + cf.getString("ContainsTransmission").replace("&", "§"));
						return true;
					} else {
						Bukkit.broadcastMessage(pf + cf.getString("Transmitindo").replace("&", "§")
								.replace("%jogador%", p.getName()).replace("%URL%", args[0].toLowerCase()));
						twitch.put(p.getName(), true);
						Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
							@Override
							public void run() {
								if(twitch.containsKey(p.getName())) {
									ActionBarAPI.sendActionBarToAllPlayers(pf + cf.getString("TransmitindoAB").replace("&", "§").replace("%jogador%", p.getName()),
											180);
								}
							}
						}, 0, 20L*150);
						return true;
					}
				} else {
					p.sendMessage(pf + cf.getString("URLMI").replace("&", "§"));
					return true;
				}
				
			}
			

		}
		return false;
	}

}
