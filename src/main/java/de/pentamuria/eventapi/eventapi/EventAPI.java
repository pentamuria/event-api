package de.pentamuria.eventapi.eventapi;

import de.pentamuria.eventapi.commands.COMMAND_event;
import de.pentamuria.eventapi.events.EventListener;
import de.pentamuria.eventapi.events.InventoryClickListener;
import de.pentamuria.eventapi.manager.EventManager;
import de.pentamuria.system.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventAPI extends JavaPlugin {

    String prefix = "§bEventAPI §8- §7";
    public String pr = "§bEvent §8- §7";

    public EventManager eventManager;
    public Main pentamuria;

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadCommands();
        loadEvents();
        eventManager = new EventManager(this);
        Bukkit.getConsoleSender().sendMessage("§7-----------§8[§bEventAPI§8]§7-----------");
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde erfolgreich §agestartet");
        if(Bukkit.getServer().getPluginManager().getPlugin("Main")!=null) {
            pentamuria = (Main) Bukkit.getServer().getPluginManager().getPlugin("Main");
            Bukkit.getConsoleSender().sendMessage(pr + "Verbindung zu §5Pentamuria §7wurde §ainitialisiert");
        } else {
            Bukkit.getConsoleSender().sendMessage(pr + "Verbindung zu §5Pentamuria §ist §4fehlgeschlagen");
            Bukkit.getConsoleSender().sendMessage(pr + "§cBitte sofort §5Pentamuria §chinzufügen");
        }
        Bukkit.getConsoleSender().sendMessage("§7---------------------------------");
        eventManager.start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde erfolgreich §4deaktiviert");
    }

    private void loadCommands() {
        COMMAND_event cCOMMAND_event = new COMMAND_event(this);
        getCommand("event").setExecutor(cCOMMAND_event);
    }

    private void loadEvents() {

        new InventoryClickListener(this);
        new EventListener(this);
    }
}
