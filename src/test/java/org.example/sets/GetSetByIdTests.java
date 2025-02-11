package org.example.sets;

import org.example.base.BaseTest;
import org.example.dataproviders.SetDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.example.models.CardSet;


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
    public void testGetSetByCode_Detailed(CardSet set) {
        given()
                .pathParam("code", set.getCode())
                .when()
                .get("/sets/{code}")
                .then()
                .statusCode(200)
                .body("set.name", equalTo(set.getName()))
                .body("set.code", equalTo(set.getCode()))
                .body("set.releaseDate", equalTo(set.getReleaseDate()))
                .body("set.type", equalTo(set.getType()))
                .body("set.block", equalTo(set.getBlock()));
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
