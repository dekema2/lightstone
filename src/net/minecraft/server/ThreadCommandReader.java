package net.minecraft.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.unxoft.lightstone.Main.*;

public class ThreadCommandReader extends Thread {

    final MinecraftServer server;

    public ThreadCommandReader(MinecraftServer minecraftserver) {
        this.server = minecraftserver;
    }

    public void run() {
        // lightstone start
        if (!useConsole) {
            return;
        }
        // lightstone end

        jline.ConsoleReader bufferedreader = this.server.reader; // lightstone
        String s = null;

        try {
            // lightstone start - JLine disabling compatibility
            while (!this.server.isStopped && MinecraftServer.isRunning(this.server)) {
                if (useJline) {
                    s = bufferedreader.readLine(">", null);
                } else {
                    s = bufferedreader.readLine();
                }
                if (s != null) {
                    this.server.issueCommand(s, this.server);
                }
                // lightstone end
            }
        } catch (IOException ioexception) {
            // lightstone
            java.util.logging.Logger.getLogger(ThreadCommandReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ioexception);
        }
    }
}
