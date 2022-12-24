package de.pentamuria.eventapi.commands;

import de.pentamuria.eventapi.eventapi.EventAPI;
import de.pentamuria.eventapi.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class COMMAND_event implements CommandExecutor {
    private final EventAPI plugin;

    public COMMAND_event(EventAPI eventAPI) {
        this.plugin = eventAPI;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player)sender;

        if(args.length == 1) {
           if(args[0].equalsIgnoreCase("skip")) {
               if(p.hasPermission("pentamuria.event.skip")) {
                   p.sendMessage(plugin.pr + "Du hast das momentane Event §bgeskippt");
                   plugin.eventManager.skip();
               } else {
                   p.sendMessage(plugin.pr + "§cKeine Berechtigung für diesen Befehl");
               }
           }
        } else {
            Inventory inv = Bukkit.createInventory(null, 27, "§5Events");
            inv.setItem(13, new ItemBuilder(plugin.eventManager.getEventType().getMat())
                    .setName(plugin.eventManager.getEventType().getTitle())
                    .addLoreLine("§7")
                    .addLoreLine(plugin.eventManager.getEventType().getDescription())
                    .toItemStack());
            for(int i = 0; i<inv.getSize();i++) {
                if(inv.getItem(i)==null) {
                    inv.setItem(i, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE, 1).setName("§c").toItemStack());
                }
            }
            p.openInventory(inv);
        }


        return true;
    }
}
