package com.example;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface Http {
    public HttpResponse<String> get(String url) throws IOException, InterruptedException;
}
