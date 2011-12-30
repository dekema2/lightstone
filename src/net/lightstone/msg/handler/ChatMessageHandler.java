package net.lightstone.msg.handler;

import java.util.logging.Level;

import org.bukkit.ChatColor;

import net.lightstone.GlowServer;
import net.lightstone.entity.GlowPlayer;
import net.lightstone.msg.ChatMessage;
import net.lightstone.net.Session;

public final class ChatMessageHandler extends MessageHandler<ChatMessage> {

    @Override
    public void handle(Session session, GlowPlayer player, ChatMessage message) {
        if (player == null)
            return;

        String text = message.getMessage();
        text = text.trim();
        
        if (text.length() > 100) {
            session.disconnect("Chat message too long.");
        } else {
            player.chat(text);
        }
    }

}
