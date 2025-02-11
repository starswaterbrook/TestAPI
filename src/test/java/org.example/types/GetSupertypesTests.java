package org.example.types;

import org.example.base.BaseTest;
import org.example.dataproviders.TypesDataProviders;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetSupertypesTests extends BaseTest {
    @Test(dataProvider = "supertypesData", dataProviderClass = TypesDataProviders.class)
    public void testGetAllSupertypes(List<String> supertypes) {
        given()
                .when()
                .get("/supertypes")
                .then()
                .statusCode(200)
                .body("supertypes", not(hasSize(0)))
                .body("supertypes", hasItems(supertypes.toArray(new String[0])));
    }
}