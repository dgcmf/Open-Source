package br.com.gamersboard.dgcmf.furnaces.inventory;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import br.com.gamersboard.dgcmf.furnaces.Main;

public class Inventarios implements Listener {
	
	public static FileConfiguration cf = Main.getInstance().getConfig();
	
	public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || !slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }
	
	public static void abrir1(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, cf.getString("Prefix").replace("&", "§") + " §7Refinar");
		
		
		int quantidade1 = getAmount(p, new ItemStack(Material.COAL_ORE));
		int valor = quantidade1*cf.getInt("Carvao");
		String formatado = NumberFormat.getInstance().format(valor);
		ItemStack fornalha1 = new ItemStack(Material.COAL);
		ItemMeta fornalha1m = fornalha1.getItemMeta();
		fornalha1m.setDisplayName("§7Minério de: §bCarvão");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("§7Para estar refinando §b" + quantidade1 + " §7são necessários: §bR$" + formatado + "§7.");
		fornalha1m.setLore(lore);
		fornalha1.setItemMeta(fornalha1m);
		
		
		int quantidade2 = getAmount(p, new ItemStack(Material.IRON_ORE));
		int valor2 = quantidade2*cf.getInt("Ferro");
		String formatado2 = NumberFormat.getInstance().format(valor2);
		ItemStack fornalha2 = new ItemStack(Material.IRON_INGOT);
		ItemMeta fornalha2m = fornalha2.getItemMeta();
		fornalha2m.setDisplayName("§7Minério de: §bFerro");
		ArrayList<String> lore1 = new ArrayList<>();
		lore1.add("§7Para estar refinando §b" + quantidade2 + " §7são necessários: §bR$" + formatado2 + "§7.");
		fornalha2m.setLore(lore1);
		fornalha2.setItemMeta(fornalha2m);
		
		
		int quantidade3 = getAmount(p, new ItemStack(Material.DIAMOND_ORE));
		int valor3 = quantidade3*cf.getInt("Diamante");
		String formatado3 = NumberFormat.getInstance().format(valor3);
		ItemStack fornalha3 = new ItemStack(Material.DIAMOND);
		ItemMeta fornalha3m = fornalha3.getItemMeta();
		fornalha3m.setDisplayName("§7Minério de: §bDiamante");
		ArrayList<String> lore2 = new ArrayList<>();
		lore2.add("§7Para estar refinando §b" + quantidade3 + " §7são necessários: §bR$" + formatado3 + "§7.");
		fornalha3m.setLore(lore2);
		fornalha3.setItemMeta(fornalha3m);
		
		
		int quantidade4 = getAmount(p, new ItemStack(Material.GOLD_ORE));
		int valor4 = quantidade4*cf.getInt("Ouro");
		String formatado4 = NumberFormat.getInstance().format(valor4);
		ItemStack fornalha4 = new ItemStack(Material.GOLD_INGOT);
		ItemMeta fornalha4m = fornalha4.getItemMeta();
		fornalha4m.setDisplayName("§7Minério de: §bOuro");
		ArrayList<String> lore3 = new ArrayList<>();
		lore3.add("§7Para estar refinando §b" + quantidade3 + " §7são necessários: §bR$" + formatado4 + "§7.");
		fornalha4m.setLore(lore3);
		fornalha4.setItemMeta(fornalha4m);
		
		
		int quantidade5 = getAmount(p, new ItemStack(Material.EMERALD_ORE));
		int valor5 = quantidade5*cf.getInt("Esmeralda");
		String formatado5 = NumberFormat.getInstance().format(valor5);
		ItemStack fornalha5 = new ItemStack(Material.EMERALD);
		ItemMeta fornalha5m = fornalha5.getItemMeta();
		fornalha5m.setDisplayName("§7Minério de: §bEsmeralda");
		ArrayList<String> lore4 = new ArrayList<>();
		lore4.add("§7Para estar refinando §b" + quantidade5 + " §7são necessários: §bR$" + formatado5 + "§7.");
		fornalha5m.setLore(lore4);
		fornalha5.setItemMeta(fornalha5m);
		
		int quantidade6 = getAmount(p, new ItemStack(Material.REDSTONE_ORE));
		int valor6 = quantidade6*cf.getInt("Redstone");
		String formatado6 = NumberFormat.getInstance().format(valor6);
		ItemStack fornalha6 = new ItemStack(Material.REDSTONE);
		ItemMeta fornalha6m = fornalha6.getItemMeta();
		fornalha6m.setDisplayName("§7Minério de: §bRedstone");
		ArrayList<String> lore5 = new ArrayList<>();
		lore5.add("§7Para estar refinando §b" + quantidade6 + " §7são necessários: §bR$" + formatado6 + "§7.");
		fornalha6m.setLore(lore5);
		fornalha6.setItemMeta(fornalha6m);
		
		Dye l = new Dye();
		l.setColor(DyeColor.BLUE);
		ItemStack lapis = l.toItemStack();
		
		ItemStack fornalha7 = lapis;
		ItemMeta fornalha7m = fornalha7.getItemMeta();
		fornalha7m.setDisplayName("§7Minério de: §bLapis");
		ArrayList<String> lore6 = new ArrayList<>();
		lore6.add("§7Você refina uma determinada parte deste item.");
		fornalha7m.setLore(lore6);
		fornalha7.setItemMeta(fornalha7m);
		
		int quantidade7 = getAmount(p, new ItemStack(Material.QUARTZ_ORE));
		int valor7 = quantidade7*cf.getInt("Quartzo");
		String formatado7 = NumberFormat.getInstance().format(valor7);
		ItemStack fornalha8 = new ItemStack(Material.QUARTZ);
		ItemMeta fornalha8m = fornalha8.getItemMeta();
		fornalha8m.setDisplayName("§7Minério de: §bQuartzo");
		ArrayList<String> lore8 = new ArrayList<>();
		lore8.add("§7Para estar refinando §b" + quantidade7 + " §7são necessários: §bR$" + formatado7 + "§7.");
		fornalha8m.setLore(lore8);
		fornalha8.setItemMeta(fornalha8m);
		
		inv.setItem(11, fornalha1);
		inv.setItem(12, fornalha2);
		inv.setItem(13, fornalha3);
		inv.setItem(14, fornalha4);
		inv.setItem(15, fornalha5);
		inv.setItem(16, fornalha6);
		inv.setItem(10, fornalha8);
		
		p.openInventory(inv);
	}
    public static void removeItems(Inventory inventory, Material type, int amount) {
        if (amount <= 0) return;
        int size = inventory.getSize();
        for (int slot = 0; slot < size; slot++) {
            ItemStack is = inventory.getItem(slot);
            if (is == null) continue;
            if (type == is.getType()) {
                int newAmount = is.getAmount() - amount;
                if (newAmount > 0) {
                    is.setAmount(newAmount);
                    break;
                } else {
                    inventory.clear(slot);
                    amount = -newAmount;
                    if (amount == 0) break;
                }
            }
        }
    }
	
	@EventHandler
	public void onClicar(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase(cf.getString("Prefix").replace("&", "§") + " §7Refinar")) {
			if(e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bCarvão")) {
				if(!p.getInventory().contains(Material.COAL_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.COAL_ORE));
				int valor = quantidade*cf.getInt("Carvao");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Carvão").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.COAL_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.COAL, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bQuartzo")) {
				if(!p.getInventory().contains(Material.QUARTZ_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.QUARTZ_ORE));
				int valor = quantidade*cf.getInt("Quartzo");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Quartzo").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.QUARTZ_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.QUARTZ, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bFerro")) {
				if(!p.getInventory().contains(Material.IRON_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.IRON_ORE));
				int valor = quantidade*cf.getInt("Ferro");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Ferro").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.IRON_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bDiamante")) {
				if(!p.getInventory().contains(Material.DIAMOND_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.DIAMOND_ORE));
				int valor = quantidade*cf.getInt("Diamante");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Diamante").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.DIAMOND_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.DIAMOND, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bOuro")) {
				if(!p.getInventory().contains(Material.GOLD_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.GOLD_ORE));
				int valor = quantidade*cf.getInt("Ouro");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Ouro").replace("%valor%", formatado));
				
				removeItems(p.getInventory(), Material.GOLD_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bEsmeralda")) {
				if(!p.getInventory().contains(Material.EMERALD_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.EMERALD_ORE));
				int valor = quantidade*cf.getInt("Esmeralda");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Esmeralda").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.EMERALD_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.EMERALD, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bRedstone")) {
				if(!p.getInventory().contains(Material.REDSTONE_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				int quantidade = getAmount(p, new ItemStack(Material.REDSTONE_ORE));
				int valor = quantidade*cf.getInt("Redstone");
				String formatado = NumberFormat.getInstance().format(valor);
				if(!Main.getEcononomy().has(p, valor)) {
					e.setCancelled(true);
					p.closeInventory();
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemDinheiro").replace("&", "§"));
					return;
				}
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+quantidade).replace("%tipo%", "Redstone").replace("%valor%", formatado));
				removeItems(p.getInventory(), Material.REDSTONE_ORE, quantidade);
				p.getInventory().addItem(new ItemStack(Material.REDSTONE, quantidade));
				Main.getEcononomy().withdrawPlayer(p, valor);
				e.setCancelled(true);
				p.closeInventory();
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Minério de: §bLapis")) {
				if(!p.getInventory().contains(Material.LAPIS_ORE)) {
					p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("SemItens").replace("&", "§"));
					e.setCancelled(true);p.closeInventory();
					return;
				}
				Dye l = new Dye();
				l.setColor(DyeColor.BLUE);
				ItemStack lapis = l.toItemStack();
				lapis.setAmount(getAmount(p, lapis));
				
				p.sendMessage(cf.getString("Prefix").replace("&", "§") + " " + cf.getString("TransformouItens").replace("&", "§").replace("%quantidade%", ""+getAmount(p, new ItemStack(Material.LAPIS_ORE))).replace("%tipo%", "Lapis"));
				p.getInventory().addItem(lapis);
				removeItems(p.getInventory(), Material.LAPIS_ORE, getAmount(p, new ItemStack(Material.LAPIS_ORE)));
				e.setCancelled(true);
				p.closeInventory();
			}
		}
	}

}
