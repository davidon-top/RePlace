package the.david.replace.events;

import ed.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerPlace implements Listener {
    public void setRotation (Block b, BlockFace face) {
        BlockData data = b.getBlockData();
        if (data instanceof Directional) {
            Directional dir = (Directional) data;
            dir.setFacing(face);
            b.setBlockData(dir);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        PlayerInventory inv = player.getInventory();
        ItemStack offhand = inv.getItemInOffHand();
        if (offhand.getType() == Material.CARROT_ON_A_STICK) {
            NBTItem nbt = new NBTItem(offhand);
            if (nbt.hasTag("RPWrench")) {
                Block block = e.getBlockPlaced();
                switch (nbt.getString("RPWrench")) {
                    case "reverse":
                        BlockData data = block.getBlockData();
                        if (data instanceof Directional) {
                            Directional dir = (Directional) data;
                            dir.setFacing(dir.getFacing().getOppositeFace());
                            block.setBlockData(dir);
                        }
                        break;
                    case "down":
                        setRotation(block, BlockFace.DOWN);
                        break;
                    case "up":
                        setRotation(block, BlockFace.UP);
                        break;
                    case "north":
                        setRotation(block, BlockFace.NORTH);
                        break;
                    case "east":
                        setRotation(block, BlockFace.EAST);
                        break;
                    case "south":
                        setRotation(block, BlockFace.SOUTH);
                        break;
                    case "west":
                        setRotation(block, BlockFace.WEST);
                        break;
                    case "off":
                        break;
                }
            }
        }
    }
}
