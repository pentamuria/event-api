package de.pentamuria.eventapi.manager;


import de.pentamuria.eventapi.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum EventType {
    FRIEDEN(
            "§eFrieden",
            "§7Während diesem Event herrscht §eabsoluter Frieden",
            Material.FEATHER
    ),
    LEVEL_UP(
            "§aLevel UP",
            "§7Während diesem Event erhälst du §adoppelte XP",
            Material.EXPERIENCE_BOTTLE
    ),
    NOTHING(
            "§cKeins",
            "§7Momentan läuft hier §ckein Event",
            Material.BARRIER
    )
    ;

    String title;
    String description;
    Material mat;

    /**
     * Event Types
     * @param title
     * @param description
     * @param mat
     */
    EventType(String title, String description, Material mat) {
        this.title = title;
        this.description = description;
        this.mat = mat;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Material getMat() {
        return mat;
    }
    public void setMat(Material mat) {
        this.mat = mat;
    }
}
