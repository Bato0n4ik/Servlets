package org.andreev.sockets.socket;

import java.io.IOException;
import java.net.*;

public class DatagramClient {
    public static void main(String[] args) throws IOException {
        InetAddress address = Inet4Address.getByName("localhost");
        try(DatagramSocket socket = new DatagramSocket()){
            byte[] buff = "Hello, bitch, i'm your client!".getBytes();;
            DatagramPacket packet = new DatagramPacket(buff, buff.length, address, 7777);
            socket.send(packet);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}
