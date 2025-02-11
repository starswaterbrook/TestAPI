package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Card;
import org.example.models.CardSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class JsonDataLoader {
    public static Object[][] loadCardData(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = JsonDataLoader.class.getClassLoader().getResourceAsStream(fileName);
        List<Card> cards = mapper.readValue(inputStream, new TypeReference<List<Card>>() {});
        Object[][] data = new Object[cards.size()][1];
        for (int i = 0; i < cards.size(); i++) {
            data[i][0] = cards.get(i);
        }
        return data;
    }

    public static Object[][] loadSetData(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = JsonDataLoader.class.getClassLoader().getResourceAsStream(fileName);
        List<CardSet> sets = mapper.readValue(inputStream, new TypeReference<List<CardSet>>() {});
        Object[][] data = new Object[sets.size()][1];
        for (int i = 0; i < sets.size(); i++) {
            data[i][0] = sets.get(i);
        }
        return data;
    }

    public static List<String> loadListFromJson(String filePath, String key) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = JsonDataLoader.class.getClassLoader().getResourceAsStream(filePath);

        if (inputStream == null) {
            throw new IOException("File not found: " + filePath);
        }

        Map<String, Object> jsonMap = mapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {});
        return (List<String>) jsonMap.get(key);
    }
}