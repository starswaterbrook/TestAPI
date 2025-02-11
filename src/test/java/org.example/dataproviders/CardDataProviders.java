package org.example.dataproviders;

import org.example.utils.JsonDataLoader;
import org.testng.annotations.DataProvider;

import java.io.IOException;


public class CardDataProviders {
    @DataProvider(name = "validCardNames")
    public static Object[][] createValidCardNames() {
        return new Object[][]{
                {"Black Lotus"},
                {"Ancestral Recall"}
        };
    }

    @DataProvider(name = "invalidCardNames")
    public static Object[][] createInvalidCardNames() {
        return new Object[][]{
                {"NonExistentCard1"},
                {"NonExistentCard2"}
        };
    }

    @DataProvider(name = "validComplexQueryData")
    public static Object[][] createValidComplexQueryData() {
        return new Object[][]{
                {"Champion of the Parish", "normal", 1, new String[]{"W"}, "Creature — Human Soldier"},
                {"Narset, Enlightened Master", "normal", 6, new String[]{"R", "U", "W"}, "Legendary Creature — Human Monk"}
        };
    }

    @DataProvider(name = "invalidComplexQueryData")
    public static Object[][] createInvalidComplexQueryData() {
        return new Object[][]{
                {"NonExistentCard", null, null, null, null},
                {"Champion of the Parish", "normal", -1, new String[]{"W"}, "Creature — Human Soldier"}
        };
    }

    @DataProvider(name = "validCardIds")
    public Object[][] createValidCardData() {
        return new Object[][]{
                {"386616", "Narset, Enlightened Master"},
                {"409574", "Strip Mine"},
                {"409580", "Champion of the Parish"}
        };
    }

    @DataProvider(name = "invalidCardIds")
    public Object[][] createInvalidCardData() {
        return new Object[][]{
                {"000000"},
                {"invalidId"},
                {" "}
        };
    }

    @DataProvider(name = "detailedCardData")
    public Object[][] createDetailedCardData() throws IOException {
        return JsonDataLoader.loadCardData("detailedCardTestData.json");
    }
}
