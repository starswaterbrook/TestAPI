package org.example.cards;

import org.example.base.BaseTest;
import org.example.dataproviders.CardDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.example.models.Card;


public class GetCardByIdTests extends BaseTest {
    @Test(dataProvider = "validCardIds", dataProviderClass = CardDataProviders.class)
    public void testGetCardById_Valid(String cardId, String expectedName) {
        given()
                .pathParam("id", cardId)
                .when()
                .get("/cards/{id}")
                .then()
                .statusCode(200)
                .body("card.name", equalTo(expectedName));
    }

    @Test(dataProvider = "invalidCardIds", dataProviderClass = CardDataProviders.class)
    public void testGetCardById_Invalid(String cardId) {
        given()
                .pathParam("id", cardId)
                .when()
                .get("/cards/{id}")
                .then()
                .statusCode(404);
    }

    @Test(dataProvider = "detailedCardData", dataProviderClass = CardDataProviders.class)
    public void testGetCardById_Detailed(Card card) {
        given()
                .pathParam("id", card.getId())
                .when()
                .get("/cards/{id}")
                .then()
                .statusCode(200)
                .body("card.name", equalTo(card.getName()))
                .body("card.layout", equalTo(card.getLayout()))
                .body("card.cmc", equalTo((float)card.getCmc()))
                .body("card.colors", equalTo(card.getColors()))
                .body("card.colorIdentity", equalTo(card.getColorIdentity()))
                .body("card.type", equalTo(card.getType()))
                .body("card.supertypes", equalTo(card.getSupertypes()))
                .body("card.types", equalTo(card.getTypes()))
                .body("card.subtypes", equalTo(card.getSubtypes()))
                .body("card.rarity", equalTo(card.getRarity()))
                .body("card.set", equalTo(card.getSet()))
                .body("card.setName", equalTo(card.getSetName()))
                .body("card.text", equalTo(card.getText()))
                .body("card.artist", equalTo(card.getArtist()))
                .body("card.number", equalTo(card.getNumber()))
                .body("card.power", equalTo(card.getPower()))
                .body("card.toughness", equalTo(card.getToughness()));
    }
}
