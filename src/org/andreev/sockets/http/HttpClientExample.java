package org.andreev.sockets.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET().
                build();

        HttpRequest request2 = HttpRequest.newBuilder(URI.create("https://google.com"))
                .POST(HttpRequest.BodyPublishers.ofString("Fuck you server!"))
                .build();

        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        response.headers().map().entrySet().forEach(System.out::println);
    }
}
