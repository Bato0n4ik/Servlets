package org.andreev.sockets.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException {
        var inetAddress = Inet4Address.getByName("localhost");

        try(Socket connection = new Socket(inetAddress, 7777);
        DataOutputStream dataOutput = new DataOutputStream(connection.getOutputStream());
            DataInputStream dataInput = new DataInputStream(connection.getInputStream());
            Scanner scanner = new Scanner(System.in)){
            dataOutput.writeUTF("Hello I,m Client!");

            /*StringBuffer buff = new StringBuffer();
            while(dataInput.available()!= 0){
                char elem = (char)dataInput.read();
                buff.append(elem);
            }
            System.out.println("Response from server: " + buff);*/
            String request;
            while(scanner.hasNextLine()){
                request = scanner.nextLine();
                dataOutput.writeUTF(request);
                System.out.println("Response from server: " + dataInput.readUTF());
            }

        }
        catch(Exception exc){
            exc.printStackTrace();
        }

    }
}
