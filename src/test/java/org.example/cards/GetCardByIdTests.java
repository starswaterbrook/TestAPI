package org.example.cards;

import org.example.base.BaseTest;
import org.example.dataproviders.CardDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.example.models.Card;
import io.restassured.response.Response;
import org.example.utils.ApiResponseParser;
import org.testng.Assert;


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
    public void testGetCardById_Detailed(Card testCard) {
        Response response = given()
                .pathParam("id", testCard.getId())
                .when()
                .get("/cards/{id}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        try {
            Card responseCard = ApiResponseParser.parseResponseToCard(response);
            Assert.assertEquals(responseCard, testCard, "The response card data does not match the test card data.");
        } catch (Exception e) {
            Assert.fail("Failed to parse response into Card object: " + e.getMessage());
        }
    }
}
