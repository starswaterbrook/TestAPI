package org.example.types;

import org.example.base.BaseTest;
import org.example.dataproviders.TypesDataProviders;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetSubtypesTests extends BaseTest {
    @Test(dataProvider = "subtypesData", dataProviderClass = TypesDataProviders.class)
    public void testGetAllSupertypes(List<String> subtypes) {
        given()
                .when()
                .get("/subtypes")
                .then()
                .statusCode(200)
                .body("subtypes", not(hasSize(0)))
                .body("subtypes", hasItems(subtypes.toArray(new String[0])));
    }
}