package org.andreev.sockets.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("file:E:\\IdeaProjects\\FirstSevlet\\src\\org\\andreev\\sockets\\Client.java");
        URLConnection urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    public static void testRequest() throws IOException {
        URL url = new URL("https://google.com");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);//For POST, PUT, PATCH requests...

        try(OutputStream request = urlConnection.getOutputStream()){
        }
    }
}
