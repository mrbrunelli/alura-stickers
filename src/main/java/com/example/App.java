package com.example;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GetMovies getMovies = new GetMovies(new HttpImplementation(), new JsonParserImplementation());
        List<Movie> movies = getMovies.execute();

        for (Movie movie : movies) {
            System.out.println(movie.title);
            System.out.println(movie.poster);
            System.out.println(movie.year);
            System.out.println();
        }
    }
}
