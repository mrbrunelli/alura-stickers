package com.example;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")
    String title;

    @SerializedName("Poster")
    String poster;

    @SerializedName("Year")
    String year;
}
