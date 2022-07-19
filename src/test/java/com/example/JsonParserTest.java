package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.annotations.SerializedName;

class MyObject {
    @SerializedName("key")
    String field;
}

public class JsonParserTest {
    @Test
    public void shouldParseJson() {
        JsonParser sut = new JsonParserImplementation();

        String json = "{ \"key\": \"value\" }";
        MyObject result = sut.parse(json, MyObject.class);

        assertEquals(result.field, "value");
    }
}
