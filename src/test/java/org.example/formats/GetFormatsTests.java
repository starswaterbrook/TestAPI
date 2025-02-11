package org.example.formats;

import org.example.base.BaseTest;
import org.example.dataproviders.FormatDataProviders;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class GetFormatsTests extends BaseTest {
    @Test(dataProvider = "formats", dataProviderClass = FormatDataProviders.class)
    public void testGetAllFormats(List<String> formatNames) {
        given()
                .when()
                .get("/formats")
                .then()
                .statusCode(200)
                .body("formats", not(hasSize(0)))
                .body("formats", hasItems(formatNames.toArray(new String[0])));
    }
}