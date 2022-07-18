package com.example;

import com.google.gson.Gson;

public class JsonParser {
    public static <T> T parse(String json, Class<T> obj) {
        return new Gson().fromJson(json, obj);
    }
}
