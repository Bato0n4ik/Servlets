package org.andreev.sockets.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class DatagramServer {
    public static void main(String[] args) {
        byte[] buff = new byte[512];
        try(DatagramSocket socket = new DatagramSocket(7777)){
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            socket.receive(packet);
            System.out.println(new String(buff));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
