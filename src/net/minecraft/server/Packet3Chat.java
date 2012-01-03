package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException; // lightstone

public class Packet3Chat extends Packet {

    public String message;

    public Packet3Chat() {}

    public Packet3Chat(String s) {
        /* lightstone start - handle this later
        if (s.length() > 119) {
            s = s.substring(0, 119);
        }
        // lightstone end */

        this.message = s;
    }

    public void a(DataInputStream datainputstream) throws IOException { // lightstone
        this.message = a(datainputstream, 119);
    }

    public void a(DataOutputStream dataoutputstream) throws IOException { // lightstone
        a(this.message, dataoutputstream);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return this.message.length();
    }
}
