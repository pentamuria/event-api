package de.pentamuria.eventapi.events;

import de.pentamuria.eventapi.eventapi.EventAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {


    private final EventAPI plugin;

    public InventoryClickListener(EventAPI eventAPI) {
        this.plugin = eventAPI;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEventInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§5Events")) {
            e.setCancelled(true);
        }
    }
}
