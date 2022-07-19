package com.example;

import com.google.gson.Gson;

public class JsonParserImplementation implements JsonParser {
    public <T> T parse(String json, Class<T> obj) {
        return new Gson().fromJson(json, obj);
    }
}
