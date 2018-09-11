package br.com.gamersboard.dgcmf.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

public class CMDTransmissao implements CommandExecutor {
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("§5[dgTwitch] §cVocê precisa ser um jogador.");
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("transmissao")) {
			if(args.length == 0) {
				p.sendMessage(CMDTransmitir.pf + "§7Utilize o seguinte comando: §5/transmissao encerrar§7.");
				return true;
			}
			if(args[0].equalsIgnoreCase("encerrar")) {
				if(!CMDTransmitir.twitch.containsKey(p.getName())) {
					p.sendMessage(CMDTransmitir.pf + CMDTransmitir.cf.getString("NoContainsTransmission").replace("&", "§"));
					return true;
				} else {
					CMDTransmitir.twitch.remove(p.getName());
					ActionBarAPI.sendActionBar(p, CMDTransmitir.pf + CMDTransmitir.cf.getString("ParouStreamAB").replace("&", "§"), 180);
					p.sendMessage(CMDTransmitir.pf + CMDTransmitir.cf.getString("ParouStream").replace("&", "§"));
					return true;
				}
			}
		}
		return false;
	}
	

}
