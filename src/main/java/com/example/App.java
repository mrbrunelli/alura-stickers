package com.example;

import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        Http http = new Http();
        HttpResponse<String> response = http.get("https://fake-movie-database-api.herokuapp.com/api?s=Batman");

        MovieResponse movieResponse = JsonParser.parse(response.body(), MovieResponse.class);

        for (Movie movie : movieResponse.search) {
            System.out.println(movie.title);
            System.out.println(movie.poster);
            System.out.println(movie.year);
            System.out.println();
        }
    }
}
