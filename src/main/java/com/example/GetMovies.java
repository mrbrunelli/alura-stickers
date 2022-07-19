package com.example;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

public class GetMovies {
    private final Http http;
    private final JsonParser parser;

    public GetMovies(Http http, JsonParser parser) {
        this.http = http;
        this.parser = parser;
    }

    public List<Movie> execute() throws IOException, InterruptedException {
        HttpResponse<String> response = this.http.get("https://fake-movie-database-api.herokuapp.com/api?s=Batman");
        MovieResponse movieResponse = this.parser.parse(response.body(), MovieResponse.class);
        return movieResponse.search;
    }
}
