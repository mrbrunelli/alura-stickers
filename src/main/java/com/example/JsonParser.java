package com.example;

public interface JsonParser {
    <T> T parse(String json, Class<T> obj);
}
