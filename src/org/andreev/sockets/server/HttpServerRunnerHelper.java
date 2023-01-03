package org.andreev.sockets.server;

public class HttpServerRunnerHelper implements Runnable{

    private HttpServerDemo serverDemo;

    public HttpServerRunnerHelper(HttpServerDemo serverDemo){
        this.serverDemo = serverDemo;
    }

    @Override
    public void run() {
        while(serverDemo.getResponseCounter() < 3){
            continue;
        }
        serverDemo.setFlagStop();

    }
}
