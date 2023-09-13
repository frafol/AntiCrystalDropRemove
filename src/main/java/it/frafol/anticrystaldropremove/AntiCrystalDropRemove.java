package it.frafol.anticrystaldropremove;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiCrystalDropRemove extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("The plugin has been enabled successfully.");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {

        Entity entity = event.getEntity();

        if (entity == null) {
            return;
        }

        if (entity.getType() != EntityType.ENDER_CRYSTAL) {
            return;
        }

        event.setYield(0);
    }
}
