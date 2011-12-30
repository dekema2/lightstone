package net.lightstone.msg.handler;

import java.util.logging.Level;
import net.lightstone.EventFactory;
import net.lightstone.GlowServer;
import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.KickMessage;
import net.lightstone.net.Session;

public final class KickMessageHandler extends MessageHandler<KickMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, KickMessage message) {
        session.disconnect("Goodbye!", true);
    }

}
