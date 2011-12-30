package net.lightstone.msg.handler;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.inventory.GlowInventory;
import net.lightstone.inventory.GlowItemStack;
import net.lightstone.msg.QuickBarMessage;
import net.lightstone.net.Session;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class QuickBarMessageHandler extends MessageHandler<QuickBarMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, QuickBarMessage message) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            player.kickPlayer("Now now, don't try that here. Won't work.");
            return;
        }
        GlowInventory inv = player.getInventory();
        int slot = inv.getItemSlot(message.getSlot());

        if (slot < 0 || slot > 8
                || Material.getMaterial(message.getId()) == null) {
            return;
        }
        GlowItemStack newItem = new GlowItemStack(message.getId(), message.getAmount(), message.getDamage(), message.getNbtData());
        GlowItemStack currentItem = inv.getItem(slot);

        inv.setItem(slot, newItem);
        if (currentItem != null) {
            player.setItemOnCursor(currentItem);
        } else {
            player.setItemOnCursor(null);
        }
    }
    
}
