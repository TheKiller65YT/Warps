package me.physicsarebad.warps.storage;

import me.physicsarebad.warps.Utils.items.ItemCrafter;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Warp {
    private int id;
    private OfflinePlayer creator;
    private Material mat;
    private String name;
    private Location warpLoc;
    private String password;
    private boolean glow;

    public Warp(int id, OfflinePlayer creator, Material mat, String name, Location warpLoc, String password, boolean glow) {
        this.id = id;
        this.creator = creator;
        this.mat = mat;
        this.name = name;
        this.warpLoc = warpLoc;
        this.password = password;
        this.glow = glow;
    }

    public ItemStack getDisplayItem(Player viewer) {
        List<String> lore = new ArrayList<>();
        if (viewer.hasPermission("warps.admin") || viewer.getUniqueId() == creator.getUniqueId()) {
            lore.add(ChatColor.GREEN + "Shift Right Click to Edit");
            lore.add(ChatColor.RED + "Right Click to Delete");
        }
        lore.add(ChatColor.DARK_PURPLE+"Left Click to teleport");
        return ItemCrafter.getItem(mat, 1, ChatColor.YELLOW+name, lore, glow);
    }

    public OfflinePlayer getCreator() {
        return creator;
    }

    public Location getWarpLocation() {
        return warpLoc;
    }

    public Material getMaterial() {
        return mat;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean getGlow() {
        return glow;
    }

    public int getId() {
        return id;
    }

    public void setMaterial(Material mat) {
        this.mat = mat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGlow(boolean glow) {
        this.glow = glow;
    }
}
