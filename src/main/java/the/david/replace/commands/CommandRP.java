package the.david.replace.commands;

import ed.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CommandRP implements CommandExecutor {
    public void replaceItem(ItemStack item, PlayerInventory inv, String replace) {
        if (replace.equalsIgnoreCase("main")) {
            inv.setItemInMainHand(item);
        } else if (replace.equalsIgnoreCase("off")) {
            inv.setItemInOffHand(item);
        }
    }

    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        PlayerInventory inv = player.getInventory();
        ItemStack itemMain = inv.getItemInMainHand();
        NBTItem nbtItem;
        ItemStack itemOff = inv.getItemInOffHand();
        String replace;
        if (itemMain.getType() == Material.CARROT_ON_A_STICK) {
            nbtItem = new NBTItem(itemMain);
            replace = "main";
        } else if (itemOff.getType() == Material.CARROT_ON_A_STICK) {
            nbtItem = new NBTItem(itemOff);
            replace = "off";
        } else {
            player.sendMessage("You need to be holding a carrot on a stick in main hand or ofhand");
            return false;
        }
        if (args.length < 1) {
            return false;
        }
        switch (args[0]) {
            case "create":
                if (nbtItem.hasTag("RPWrench")) {
                    player.sendMessage("This item already is rotato thinkey");
                } else {
                    nbtItem.setString("RPWrench", "reverse");
                    replaceItem(nbtItem.getItem(), inv, replace);
                }
                return true;
            case "delete":
                if (nbtItem.hasTag("RPWrench")) {
                    nbtItem.removeKey("RPWrench");
                    replaceItem(nbtItem.getItem(), inv, replace);
                } else {
                    player.sendMessage("Item that you are holding doesnt have rotato thinkey on it so cant remove it.");
                }
                return true;
            case "mode":
                if (!(args.length >= 2)) {
                    if (nbtItem.hasTag("RPWrench")) {
                        player.sendMessage("Mode: " + nbtItem.getString("RPWrench"));
                        return true;
                    } else {
                        player.sendMessage("Item you are holding doesnt have rotato thinkey on it, create one by holding carrot on a stick and running /rp create");
                        return false;
                    }
                }
                if (!nbtItem.hasTag("RPWrench")) {
                    player.sendMessage("Item you are holding doesnt have rotato thinkey on it, create one by holding carrot on a stick and running /rp create");
                    return false;
                }
                switch (args[1]) {
                    case "reverse":
                        nbtItem.setString("RPWrench", "reverse");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "down":
                        nbtItem.setString("RPWrench", "down");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "up":
                        nbtItem.setString("RPWrench", "up");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "north":
                        nbtItem.setString("RPWrench", "north");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "east":
                        nbtItem.setString("RPWrench", "east");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "south":
                        nbtItem.setString("RPWrench", "south");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "west":
                        nbtItem.setString("RPWrench", "west");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    case "off":
                        nbtItem.setString("RPWrench", "off");
                        replaceItem(nbtItem.getItem(), inv, replace);
                        return true;
                    default:
                        player.sendMessage("Invalid argument.");
                        return false;
                }
            default:
                player.sendMessage("Invalid argument.");
                return false;
        }
    }
}
