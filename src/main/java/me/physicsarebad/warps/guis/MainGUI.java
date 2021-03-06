package me.physicsarebad.warps.guis;

import me.physicsarebad.warps.Utils.items.ItemCrafter;
import me.physicsarebad.warps.Warps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class MainGUI implements Listener {
    private Inventory inv;

    public enum WarpType {
        PUBLIC("Public ", 0),
        PRIVATE("Private ", 1),
        SERVER("Server ", 2);

        public String name;
        public int id;

        WarpType(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    public MainGUI() {
        inv = Bukkit.createInventory(null, InventoryType.HOPPER, "Warps");

        inv.setItem(0, ItemCrafter.getItem(Material.GREEN_STAINED_GLASS_PANE, ChatColor.GREEN+""+ChatColor.BOLD+"Public Warps"));
        inv.setItem(2, ItemCrafter.getItem(Material.PURPLE_STAINED_GLASS_PANE, ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Server Warps"));
        inv.setItem(4, ItemCrafter.getItem(Material.RED_STAINED_GLASS_PANE, ChatColor.RED+""+ChatColor.BOLD+"Private Warps"));

        for (int i = 0; i < 4; i++) {
            if (inv.getItem(i) == null) {
                inv.setItem(i, ItemCrafter.getItem(Material.GRAY_STAINED_GLASS_PANE, " "));
            }
        }
    }

    public void openInventory(HumanEntity e) {
        e.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Warps")) {
            e.setCancelled(true);
            switch (e.getRawSlot()) {
                case 0:
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                    Warps.getInstance().getMenu(WarpType.PUBLIC).openInventory(e.getWhoClicked());
                    break;
                case 2:
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                    Warps.getInstance().getMenu(WarpType.SERVER).openInventory(e.getWhoClicked());
                    break;
                case 4:
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                    Warps.getInstance().getMenu(WarpType.PRIVATE).openInventory(e.getWhoClicked());
                    break;
            }
        }
    }
}
