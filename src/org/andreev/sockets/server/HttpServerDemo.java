package org.andreev.sockets.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerDemo {

    private final int port;
    private final ExecutorService pool;
    private static boolean flagStop = false;

    private volatile int responseCounter;

    public HttpServerDemo(int port, int poolSize) {
        this.port = port;
        pool = Executors.newFixedThreadPool(poolSize);
    }

    public void run()  {
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while(!flagStop){
                Socket socket = serverSocket.accept();
                System.out.println("Socket get Response!");
                pool.submit(() -> processSocket(socket));
                responseCounter++;
            }
        }
        catch(IOException exc){
            throw new RuntimeException();
        }
    }

    private void processSocket(Socket socket) {
        try(socket; InputStream input = new DataInputStream(socket.getInputStream());
            OutputStream output = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Request: " + new String(input.readNBytes(400)));

            Thread.sleep(4000);

            byte[] body = Files.readAllBytes(Path.of("E://IdeaProjects//FirstSevlet//resources//first.json"));

            byte[] header = """ 
                HTTP/1.1 200 OK
                content-type: text/html
                content-length: %s
                """.formatted(body.length).getBytes();
            output.write(header);
            output.write(System.lineSeparator().getBytes());
            output.write(body);

        }
        catch (IOException | InterruptedException e) {
            //TODO: LOG IT'S ERROR!
            e.printStackTrace();
        }
    }

    public void setFlagStop(){
        flagStop = true;
    }

    public int getResponseCounter(){
        return responseCounter;
    }

}
