package com.example;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GetMovies getMovies = new GetMovies(new HttpImplementation(), new JsonParserImplementation());
        List<Movie> movies = getMovies.execute();

        GenerateSticker generateSticker = new GenerateSticker();

        for (Movie movie : movies) {
            String urlWithOutDimensions = movie.poster.replaceAll("._.+_", "");
            InputStream poster = new URL(urlWithOutDimensions).openStream();
            generateSticker.generate(poster, "Top das galáxias", "output/" + movie.title);

            System.out.println(movie.title);
            System.out.println(movie.poster);
            System.out.println(movie.year);
            System.out.println();
        }
    }
}
