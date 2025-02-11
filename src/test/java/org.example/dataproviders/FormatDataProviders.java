package org.example.dataproviders;

import org.example.utils.JsonDataLoader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;


public class FormatDataProviders {
    @DataProvider(name = "formats")
    public static Object[][] createFormats() throws IOException {
        List<String> formats = JsonDataLoader.loadListFromJson("formatTestData.json", "formats");

        return new Object[][]{{formats}};
    }
}
