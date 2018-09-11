package br.com.gamersboard.dgcmf.furnaces.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.gamersboard.dgcmf.furnaces.inventory.Inventarios;

public class CMDFurnace implements CommandExecutor {
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("§5§l[dgRefinaria] §cVoce não é um jogador.");
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("refinaria")) {
			if(!p.hasPermission(Inventarios.cf.getString("PermissaoNecessaria"))) {
				p.sendMessage(Inventarios.cf.getString("Prefix").replace("&", "§") + " " + Inventarios.cf.getString("SemPermissao").replace("&", "§"));
				return true;
			} else {
				Inventarios.abrir1(p);
				return true;
			}
		}
		return false;
	}

}
