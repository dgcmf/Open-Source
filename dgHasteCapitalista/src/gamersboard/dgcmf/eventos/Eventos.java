package gamersboard.dgcmf.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

import gamersboard.dgcmf.comandos.CMDHaste;

public class Eventos implements Listener {
	
	
	
	@EventHandler
	public void onSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(CMDHaste.jogador.containsKey(p)) {
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
			CMDHaste.jogador.remove(p);
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player)e.getEntity();
		
		if(CMDHaste.jogador.containsKey(p)) {
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
			CMDHaste.jogador.remove(p);
		}
	}

}
