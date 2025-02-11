package org.example.dataproviders;

import org.example.utils.JsonDataLoader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;


public class TypesDataProviders {
    @DataProvider(name = "typesData")
    public static Object[][] createTypes() throws IOException {
        List<String> types = JsonDataLoader.loadListFromJson("typeTestData.json", "types");

        return new Object[][]{{types}};
    }

    @DataProvider(name = "subtypesData")
    public static Object[][] createSubtypes() throws IOException {
        List<String> subtypes = JsonDataLoader.loadListFromJson("subtypeTestData.json", "subtypes");

        return new Object[][]{{subtypes}};
    }

    @DataProvider(name = "supertypesData")
    public static Object[][] createSupertypes() throws IOException {
        List<String> supertypes = JsonDataLoader.loadListFromJson("supertypeTestData.json", "supertypes");

        return new Object[][]{{supertypes}};
    }
}
