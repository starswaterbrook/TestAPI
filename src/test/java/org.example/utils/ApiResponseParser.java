package org.example.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.example.models.Card;
import org.example.models.CardSet;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;


public class ApiResponseParser {
    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static Card parseResponseToCard(Response response) throws IOException {
        JsonNode rootNode = mapper.readTree(response.getBody().asString());
        JsonNode cardNode = rootNode.path("card");

        Card card = mapper.treeToValue(cardNode, Card.class);
        card.setId(cardNode.get("multiverseid").asText());

        return card;
    }

    public static CardSet parseResponseToCardSet(Response response) throws IOException {
        return mapper.readTree(response.getBody().asString())
                .path("set")
                .traverse(mapper)
                .readValueAs(CardSet.class);
    }
}
