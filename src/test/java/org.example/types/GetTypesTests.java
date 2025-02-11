package org.example.types;

import org.example.base.BaseTest;
import org.example.dataproviders.TypesDataProviders;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetTypesTests extends BaseTest {
    @Test(dataProvider = "typesData", dataProviderClass = TypesDataProviders.class)
    public void testGetAllFormats(List<String> typeNames) {
        given()
                .when()
                .get("/types")
                .then()
                .statusCode(200)
                .body("types", not(hasSize(0)))
                .body("types", hasItems(typeNames.toArray(new String[0])));
    }
}