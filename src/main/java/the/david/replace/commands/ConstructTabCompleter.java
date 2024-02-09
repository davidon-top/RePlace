package the.david.replace.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ConstructTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete( CommandSender sender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("create");
            list.add("delete");
            list.add("mode");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("mode")) {
            list.add("reverse");
            list.add("down");
            list.add("up");
            list.add("north");
            list.add("east");
            list.add("south");
            list.add("west");
            list.add("off");
        }
        return list;
    }
}
