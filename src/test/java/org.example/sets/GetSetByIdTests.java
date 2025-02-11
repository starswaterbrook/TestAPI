package org.example.sets;

import org.example.base.BaseTest;
import org.example.dataproviders.SetDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.example.models.CardSet;
import io.restassured.response.Response;
import org.example.utils.ApiResponseParser;
import org.testng.Assert;


public class GetSetByIdTests extends BaseTest {
    @Test(dataProvider = "validSetCodes", dataProviderClass = SetDataProviders.class)
    public void testGetSetByCode_Valid(String setCode, String expectedName) {
        given()
                .pathParam("code", setCode)
                .when()
                .get("/sets/{code}")
                .then()
                .statusCode(200)
                .body("set.name", equalTo(expectedName));
    }

    @Test(dataProvider = "invalidSetCodes", dataProviderClass = SetDataProviders.class)
    public void testGetSetByCode_Invalid(String setCode) {
        given()
                .pathParam("code", setCode)
                .when()
                .get("/sets/{code}")
                .then()
                .statusCode(404);
    }

    @Test(dataProvider = "detailedSetData", dataProviderClass = SetDataProviders.class)
    public void testGetSetByCode_Detailed(CardSet testSet) {
        Response response = given()
                .pathParam("code", testSet.getCode())
                .when()
                .get("/sets/{code}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        try {
            CardSet responseSet = ApiResponseParser.parseResponseToCardSet(response);
            Assert.assertEquals(responseSet, testSet, "The response set data does not match the test set data.");
        } catch (Exception e) {
            Assert.fail("Failed to parse response into CardSet object: " + e.getMessage());
        }
    }

    @Test(dataProvider = "validBoosterSetCodes", dataProviderClass = SetDataProviders.class)
    public void testGetSetByCode_ValidBooster(String setCode) {
        given()
        .pathParam("code", setCode)
                .when()
                .get("/sets/{code}/booster")
                .then()
                .statusCode(200);
    }

    @Test(dataProvider = "invalidBoosterSetCodes", dataProviderClass = SetDataProviders.class)
    public void testGetSetByCode_InvalidBooster(String setCode) {
        given()
                .pathParam("code", setCode)
                .when()
                .get("/sets/{code}/booster")
                .then()
                .statusCode(404);
    }
}
