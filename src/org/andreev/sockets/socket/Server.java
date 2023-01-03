package org.andreev.sockets.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket socket = new ServerSocket(7777);
            Socket serverSocket = socket.accept();
        var outputStream = new DataOutputStream(serverSocket.getOutputStream());
        var inputStream = new DataInputStream(serverSocket.getInputStream());
        Scanner scanner = new Scanner(System.in)){
            outputStream.writeUTF("Hello from Server!");
            String request = inputStream.readUTF();
            while(!"stop".equals(request)){
                System.out.println("Request from client: " +  request);
                String response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }

        }
    }
}
