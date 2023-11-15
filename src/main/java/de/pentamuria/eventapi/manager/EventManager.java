package de.pentamuria.eventapi.manager;

import de.pentamuria.eventapi.eventapi.EventAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class EventManager {

    private final EventAPI plugin;
    private int task;
    private EventType eventType;

    public EventManager(EventAPI eventAPI) {
        this.plugin = eventAPI;
        eventType = EventType.NOTHING;
    }

    public void start() {
        stop();
        startEvent();
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

            @Override
            public void run() {

                startEvent();
                for(Player all : Bukkit.getOnlinePlayers()) {
                    plugin.scoreboardAPI.getPlayerScoreboard().updateEvent(all, getEventType().getTitle());
                }

            }

            //}, 20*60*20, 20*60*20);
        }, 20*60*30, 20*60*30);
    }

    private void startEvent() {
        this.eventType = randomEvent();
        Bukkit.getServer().broadcastMessage("§7------------------§8[§bEvent§8]§7------------------");
        Bukkit.getServer().broadcastMessage(plugin.pr + "Das Event " + eventType.title + " §7hat §agestartet");
        Bukkit.getServer().broadcastMessage(plugin.pr + eventType.description);
        Bukkit.getServer().broadcastMessage("§7---------------------------------------------------");
        for(Player all : Bukkit.getOnlinePlayers()) {
            plugin.scoreboardAPI.getPlayerScoreboard().updateEvent(all, getEventType().getTitle());
        }
    }

    public boolean stop() {
        if(Bukkit.getScheduler().isCurrentlyRunning(task)) {
            Bukkit.getScheduler().cancelTask(task);
            return true;
        }
        return false;
    }

    public void skip() {
        start();
    }

    private EventType randomEvent() {
        int index = (int)(Math.random() * EventType.values().length);
        return EventType.values()[index];
    }

    public int getTask() {
        return task;
    }
    public void setTask(int task) {
        this.task = task;
    }
    public EventType getEventType() {
        return eventType;
    }
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
