package net.minecraft.server;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

// lightstone start
import java.util.logging.Handler;
import org.unxoft.lightstone.util.ShortConsoleLogFormatter;
import org.unxoft.lightstone.util.TerminalConsoleHandler;
// lightstone end

public class ConsoleLogManager {

    public static Logger a = Logger.getLogger("Minecraft");
    public static Logger global = Logger.getLogger(""); // lightstone

    public ConsoleLogManager() {}

    // lightstone - change of method signature!
    public static void init(MinecraftServer server) {
        ConsoleLogFormatter consolelogformatter = new ConsoleLogFormatter();

        a.setUseParentHandlers(false);
        // lightstone start
        ConsoleHandler consolehandler = new TerminalConsoleHandler(server.reader);

        for (Handler handler: global.getHandlers()) {
            global.removeHandler(handler);
        }

        consolehandler.setFormatter(new ShortConsoleLogFormatter(server));
        global.addHandler(consolehandler);
        // lightstone end

        a.addHandler(consolehandler);

        try {
            // lightstone start
            String pattern = (String)server.options.valueOf("log-pattern");
            int limit = ((Integer)server.options.valueOf("log-limit")).intValue();
            int count = ((Integer)server.options.valueOf("log-count")).intValue();
            boolean append = ((Boolean)server.options.valueOf("log-append")).booleanValue();
            FileHandler filehandler = new FileHandler(pattern, limit, count, append);
            // lightstone start

            filehandler.setFormatter(consolelogformatter);
            a.addHandler(filehandler);
            global.addHandler(filehandler); // lightstone
        } catch (Exception exception) {
            a.log(Level.WARNING, "Failed to log to server.log", exception);
        }
    }
}
