package net.lightstone.msg.handler;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.RespawnMessage;
import net.lightstone.net.Session;

public class RespawnMessageHandler extends MessageHandler<RespawnMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, RespawnMessage message) {
        player.setHealth(20);
        player.teleport(player.getWorld().getSpawnLocation());
    }
}
