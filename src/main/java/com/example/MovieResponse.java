package com.example;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("Search")
    List<Movie> search;
}
