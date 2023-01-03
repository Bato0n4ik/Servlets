package org.andreev.sockets.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        var httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("Content-type", "text/html")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("E://IdeaProjects//FirstSevlet//resources//first.json")))
                .build();

        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response2 = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> response3 = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        printResponse(response3);
    }

    public static <T> void printResponse(CompletableFuture<? extends HttpResponse<T>> response) throws ExecutionException, InterruptedException {
        System.out.println(response.get().headers());
        System.out.println(response.get().body());
    }
}
