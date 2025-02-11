package org.example.dataproviders;

import org.example.utils.JsonDataLoader;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class SetDataProviders {
    @DataProvider(name = "validSetCodes")
    public static Object[][] createValidSetCodes() {
        return new Object[][]{
                {"KTK", "Khans of Tarkir"},
                {"ISD", "Innistrad"},
                {"VMA", "Vintage Masters"}
        };
    }

    @DataProvider(name = "invalidSetCodes")
    public static Object[][] createInvalidSetCodes() {
        return new Object[][]{
                {"XXXX"},
                {"1234"},
                {"invalidSetCode"}
        };
    }

    @DataProvider(name = "detailedSetData")
    public static Object[][] createDetailedSetData() throws IOException {
        return JsonDataLoader.loadSetData("detailedSetTestData.json");
    }

    @DataProvider(name = "validSetNames")
    public static Object[][] createValidSetNames() {
        return new Object[][]{
                {"Khans of Tarkir"},
                {"Innistrad"},
                {"Vintage Masters"}
        };
    }

    @DataProvider(name = "invalidSetNames")
    public static Object[][] createInvalidSetNames() {
        return new Object[][]{
                {"NonExistentSet1"},
                {"FakeSet2025"}
        };
    }

    @DataProvider(name = "validComplexQueryData")
    public static Object[][] createValidComplexQueryData() {
        return new Object[][]{
                {"Khans of Tarkir", "expansion", "Khans of Tarkir"},
                {"Innistrad", "expansion", "Innistrad"},
                {"Vintage Masters", "masters", null}
        };
    }

    @DataProvider(name = "invalidComplexQueryData")
    public static Object[][] createInvalidComplexQueryData() {
        return new Object[][]{
                {"NonExistentSet", null, null}
        };
    }

    @DataProvider(name = "validBoosterSetCodes")
    public static Object[][] createValidBoosterSetCodes() {
        return new Object[][]{
                // this endpoint is broken
        };
    }

    @DataProvider(name = "invalidBoosterSetCodes")
    public static Object[][] createInvalidBoosterSetCodes() {
        return new Object[][]{
                {"XXXX"},
                {"1234"},
                {"invalidSetCode"}
        };
    }
}
