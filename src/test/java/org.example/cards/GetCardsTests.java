package org.example.cards;

import org.example.base.BaseTest;
import org.example.dataproviders.CardDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetCardsTests extends BaseTest {
    @Test
    public void testGetAllCards() {
        given()
                .when()
                .get("/cards")
                .then()
                .statusCode(200)
                .body("cards", not(hasSize(0)));
    }

    @Test(dataProvider = "validCardNames", dataProviderClass = CardDataProviders.class)
    public void testGetCardsByName_Valid(String cardName) {
        given()
                .queryParam("name", cardName)
                .when()
                .get("/cards")
                .then()
                .statusCode(200)
                .body("cards.name", hasItem(cardName));
    }

    @Test(dataProvider = "invalidCardNames", dataProviderClass = CardDataProviders.class)
    public void testGetCardsByName_Invalid(String cardName) {
        given()
                .queryParam("name", cardName)
                .when()
                .get("/cards")
                .then()
                .statusCode(200)
                .body("cards", hasSize(0));
    }

    @Test(dataProvider = "invalidComplexQueryData", dataProviderClass = CardDataProviders.class)
    public void testGetCardsQueryComplex_Invalid(String name, String layout, Integer cmc, String[] colors, String type) {
        var request = given();

        if (name != null) request.queryParam("name", name);
        if (layout != null) request.queryParam("layout", layout);
        if (cmc != null) request.queryParam("cmc", cmc);
        if (colors != null) request.queryParam("colors", String.join(",", colors));
        if (type != null) request.queryParam("type", type);

        var response = request.when().get("/cards");

        if ("NonExistentCard".equals(name)) {
            response.then()
                    .statusCode(200)
                    .body("cards", hasSize(0));
        } else {
            response.then()
                    .statusCode(400);
        }
    }

    @Test(dataProvider = "validComplexQueryData", dataProviderClass = CardDataProviders.class)
    public void testGetCardsQueryComplex_Valid(String name, String layout, Integer cmc, String[] colors, String type) {
        var request = given();

        if (name != null) request.queryParam("name", name);
        if (layout != null) request.queryParam("layout", layout);
        if (cmc != null) request.queryParam("cmc", cmc);
        if (colors != null) request.queryParam("colors", String.join(",", colors));
        if (type != null) request.queryParam("type", type);

        var response = request.when().get("/cards");

        if ("NonExistentCard".equals(name)) {
            response.then()
                    .statusCode(200)
                    .body("cards", hasSize(0));
        } else {
            response.then()
                    .statusCode(200)
                    .body("cards.name", hasItem(name))
                    .body("cards.layout", hasItem(layout))
                    .body("cards.cmc", hasItem((float)cmc));
        }
    }
}
