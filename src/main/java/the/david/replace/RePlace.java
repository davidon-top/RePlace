package the.david.replace;

import org.bukkit.plugin.java.JavaPlugin;
import the.david.replace.commands.*;
import the.david.replace.events.PlayerPlace;

public final class RePlace extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("rp").setExecutor(new CommandRP());
        this.getCommand("rp").setTabCompleter(new ConstructTabCompleter());
        getServer().getPluginManager().registerEvents(new PlayerPlace(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
