package gamersboard.dgcmf.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import gamersboard.dgcmf.Main;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventsList implements Listener {
	
	public static FileConfiguration cf = Main.getInstance().getConfig();
	
	@EventHandler
	public void onEntrar(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(cf.getBoolean("joinActivated")) {
			p.playSound(p.getLocation(), Sound.valueOf(cf.getString("onJoin")), 1.5F, 1.5F);
		}
		if(cf.getBoolean("globalPlayerJoinActivated")) {
			for(Player on : Bukkit.getOnlinePlayers()) {
				on.playSound(on.getLocation(), Sound.valueOf(cf.getString("globalPlayerJoin")), 1.5F, 1.5F);
			}
		}
	}
	@EventHandler
	public void onSair(PlayerQuitEvent e) {
		if(cf.getBoolean("playerQuitActivated")) {
			for(Player on : Bukkit.getOnlinePlayers()) {
				on.playSound(on.getLocation(), Sound.valueOf(cf.getString("globalPlayerQuit")), 1.5F, 1.5F);
			
			}
		}
	}
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player))
			  return;
			Player damaged = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			if(cf.getBoolean("damageActivated")) {
				damager.playSound(damager.getLocation(), Sound.valueOf("onHitDamage"), 1.5F, 1.5F);
				damaged.playSound(damaged.getLocation(), Sound.valueOf("onDamaged"), 1.5F, 1.5F);
			}
		
	}
	@EventHandler
	 public void onKill(PlayerDeathEvent e) {
	 Player killed = e.getEntity().getPlayer();
	 Player killer = e.getEntity().getKiller();
	 if(cf.getBoolean("killActivated")) {
	 killer.playSound(killer.getLocation(), Sound.valueOf("onKill"), 1.5F, 1.5F);
	 }
	 if(cf.getBoolean("deathActivated")) {
		 killed.playSound(killed.getLocation(), Sound.valueOf("onDeath"), 1.5F, 1.5F);
	 }
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if(cf.getBoolean("placeActivated")) {
			p.playSound(p.getLocation(), Sound.valueOf("onPlaceBlock"), 1.5F, 1.5F);
		}
	}
	
	@EventHandler
	public void onQuebrar(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(cf.getBoolean("breakActivated")) {
			p.playSound(p.getLocation(), Sound.valueOf("onBreakBlock"), 1.5F, 1.5F);
		}
	}
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		
		if(cf.getBoolean("respawnActivated")) {
			p.playSound(p.getLocation(), Sound.valueOf("onRespawn"), 1.5F, 1.5F);
		}
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(cf.getBoolean("chateventOPActivated")) {
			if(p.isOp()) {
				for(Player ons : Bukkit.getOnlinePlayers()) {
					ons.playSound(ons.getLocation(), Sound.valueOf("globalOPChatEvent"), 1.5F, 1.5F);
				}
			}
		}
		if(cf.getBoolean("chatEventActivated")) {
			p.playSound(p.getLocation(), Sound.valueOf("chatEvent"), 1.5F, 1.5F);
		}
	}


}
