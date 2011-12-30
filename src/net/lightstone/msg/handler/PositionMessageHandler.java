package net.lightstone.msg.handler;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

import net.lightstone.EventFactory;
import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.PositionMessage;
import net.lightstone.net.Session;

public final class PositionMessageHandler extends MessageHandler<PositionMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, PositionMessage message) {
        if (player == null) {
            return;
        }

        PlayerMoveEvent event = EventFactory.onPlayerMove(player, player.getLocation(), new Location(player.getWorld(), message.getX(), message.getY(), message.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch()));

        if (event.isCancelled()) {
            return;
        }

        Location l = event.getTo();
        l.setYaw(player.getLocation().getYaw());
        l.setPitch(player.getLocation().getPitch());

        player.setRawLocation(l);
    }

}
