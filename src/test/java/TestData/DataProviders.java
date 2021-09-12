package TestData;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "CredentialsData")
    public static Object[][] set() {
        return new Object[][]{
                {"test@gmail.com", "12345678"},
                {"test2@gmail.com", "87654321"}
        };
    }
}
