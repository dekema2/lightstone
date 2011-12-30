package net.lightstone.msg.handler;

import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.Message;
import net.lightstone.net.Session;

public abstract class MessageHandler<T extends Message> {

    public abstract void handle(Session session, GlowPlayer player, T message);

}
