package gamersboard.dgcmf.comandos;

import java.util.HashMap;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import com.connorlinfoot.titleapi.TitleAPI;

import gamersboard.dgcmf.Main;

public class CMDHaste implements CommandExecutor {
	
	public static String prefix = Main.getInstance().getConfig().getString("Prefix").replace("&", "§");
	public static FileConfiguration cf = Main.getInstance().getConfig();
	public static HashMap<Player, Boolean> jogador = new HashMap<Player, Boolean>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§5§l[dgHasteCapitalista] §7Você não é um jogador.");
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("haste")) {
			if(!p.hasPermission(Main.getInstance().getConfig().getString("PermissaoNecessaria"))) {
				p.sendMessage(prefix + Main.getInstance().getConfig().getString("SemPermissao").replace("&", "§"));
				return true;
			}
				if(args.length == 0) {
					p.sendMessage(prefix + "§7Utilize: §b/haste ativar ou /haste desativar§7.");
					return true;
				}
				if(args[0].equalsIgnoreCase("ativar")) {
					if(jogador.containsKey(p)) {
						p.sendMessage(prefix + "§cSeu Haste já está ativado.");
						return true;
					} else {
						p.sendMessage(prefix + cf.getString("Ativado").replace("&", "§"));
						p.playSound(p.getLocation(), Sound.valueOf(cf.getString("soundType")), 1.5F, 1.5F);
						jogador.put(p, true);
						p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 999*999*999, 1));
						
						if(cf.getBoolean("actionActivated")) {
							ActionBarAPI.sendActionBar(p, cf.getString("msgAction").replace("&", "§"), 30);
						}
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("desativar")) {
					if(!jogador.containsKey(p)) {
						p.sendMessage(prefix + "§cVocê não está com Haste ativado.");
						return true;
					} else {
						p.sendMessage(prefix + cf.getString("Desativado").replace("&", "§"));
						jogador.remove(p);
						p.removePotionEffect(PotionEffectType.FAST_DIGGING);
						
						if(cf.getBoolean("actionActivated")) {
							ActionBarAPI.sendActionBar(p, cf.getString("msgActionD").replace("&", "§"), 30);
						}
						return true;
					}
				}
			}
		return false;
	}

}
