package org.andreev.sockets.server;

public class HttpServerRunner {
    public static void main(String[] args) throws InterruptedException {
        HttpServerDemo httpServer = new HttpServerDemo(9000, 100);
        new Thread(new HttpServerRunnerHelper(httpServer)).start();
        httpServer.run();

    }
}
