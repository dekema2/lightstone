package net.lightstone.msg.handler;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.GroundMessage;
import net.lightstone.net.Session;

public class GroundMessageHandler extends MessageHandler<GroundMessage> {
    @Override
    public void handle(Session session, GlowPlayer player, GroundMessage message) {
        if (player != null) {
            player.setOnGround(message.isOnGround());
        }
    }
}
