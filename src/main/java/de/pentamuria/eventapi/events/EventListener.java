package de.pentamuria.eventapi.events;

import de.pentamuria.eventapi.eventapi.EventAPI;
import de.pentamuria.eventapi.manager.EventType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class EventListener implements Listener {
    private final EventAPI plugin;

    public EventListener(EventAPI eventAPI) {

        this.plugin = eventAPI;
        this.plugin.getServer().getPluginManager().registerEvents(this, eventAPI);
    }

    @EventHandler
    public void onEventFood(FoodLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {
            if(plugin.eventManager.getEventType().equals(EventType.NO_HUNGER))e.getEntity().setFoodLevel(20);
        }
    }

    @EventHandler
    public void onEventFall(EntityDamageEvent e) {
        if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            if(plugin.eventManager.getEventType().equals(EventType.NO_FALL))e.setCancelled(true);
        }
    }
}
