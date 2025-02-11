package org.example.sets;

import org.example.base.BaseTest;
import org.example.dataproviders.SetDataProviders;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetSetsTests extends BaseTest {
    @Test
    public void testGetAllSets() {
        given()
                .when()
                .get("/sets")
                .then()
                .statusCode(200)
                .body("sets", not(hasSize(0)));
    }

    @Test(dataProvider = "validSetNames", dataProviderClass = SetDataProviders.class)
    public void testGetSetsByName_Valid(String setName) {
        given()
                .queryParam("name", setName)
                .when()
                .get("/sets")
                .then()
                .statusCode(200)
                .body("sets.name", hasItem(setName));
    }

    @Test(dataProvider = "invalidSetNames", dataProviderClass = SetDataProviders.class)
    public void testGetSetsByName_Invalid(String setName) {
        given()
                .queryParam("name", setName)
                .when()
                .get("/sets")
                .then()
                .statusCode(200)
                .body("sets", hasSize(0));
    }

    @Test(dataProvider = "invalidComplexQueryData", dataProviderClass = SetDataProviders.class)
    public void testGetSetsQueryComplex_Invalid(String name, String type, String block) {
        var request = given();

        if (name != null) request.queryParam("name", name);
        if (type != null) request.queryParam("type", type);
        if (block != null) request.queryParam("block", block);

        var response = request.when().get("/sets");

        if ("NonExistentSet".equals(name)) {
            response.then()
                    .statusCode(200)
                    .body("sets", hasSize(0));
        } else {
            response.then()
                    .statusCode(400);
        }
    }

    @Test(dataProvider = "validComplexQueryData", dataProviderClass = SetDataProviders.class)
    public void testGetSetsQueryComplex_Valid(String name, String type, String block) {
        var request = given();

        if (name != null) request.queryParam("name", name);
        if (type != null) request.queryParam("type", type);
        if (block != null) request.queryParam("block", block);

        var response = request.when().get("/sets");

        if ("NonExistentSet".equals(name)) {
            response.then()
                    .statusCode(200)
                    .body("sets", hasSize(0));
        } else {
            response.then()
                    .statusCode(200)
                    .body("sets.name", hasItem(name))
                    .body("sets.type", hasItem(type))
                    .body("sets.block", hasItem(block));
        }
    }
}
