package net.lightstone.msg.handler;

import org.bukkit.Location;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.RotationMessage;
import net.lightstone.net.Session;

public final class RotationMessageHandler extends MessageHandler<RotationMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, RotationMessage message) {
        if (player == null)
            return;

        Location loc = player.getLocation();
        loc.setYaw(message.getRotation());
        loc.setPitch(message.getPitch());
        player.setRawLocation(loc);
    }

}
