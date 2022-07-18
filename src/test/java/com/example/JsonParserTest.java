package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.gson.annotations.SerializedName;

class MyObject {
    @SerializedName("key")
    String field;
}

public class JsonParserTest {
    @Test
    public void shouldParseJson() {
        String json = "{ \"key\": \"value\" }";
        MyObject parsed = JsonParser.parse(json, MyObject.class);

        assertEquals(parsed.field, "value");
    }
}
