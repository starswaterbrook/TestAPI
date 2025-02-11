package org.example.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.example.models.Card;
import org.example.models.CardSet;

import java.io.IOException;


public class ApiResponseParser {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static Card parseResponseToCard(Response response) throws IOException {
        return mapper.readTree(response.getBody().asString())
                .path("card")
                .traverse(mapper)
                .readValueAs(Card.class);
    }

    public static CardSet parseResponseToCardSet(Response response) throws IOException {
        return mapper.readTree(response.getBody().asString())
                .path("set")
                .traverse(mapper)
                .readValueAs(CardSet.class);
    }
}
