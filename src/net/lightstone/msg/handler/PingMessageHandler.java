package net.lightstone.msg.handler;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.PingMessage;
import net.lightstone.net.Session;

public class PingMessageHandler extends MessageHandler<PingMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, PingMessage message) {
        if (session.getPingMessageId() == message.getPingId()) {
            session.pong();
        }
    }
    
}
