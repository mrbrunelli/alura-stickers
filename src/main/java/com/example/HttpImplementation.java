package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpImplementation implements Http {
    private HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> get(String url) throws IOException, InterruptedException {
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        return this.client.send(request, BodyHandlers.ofString());
    }
}
