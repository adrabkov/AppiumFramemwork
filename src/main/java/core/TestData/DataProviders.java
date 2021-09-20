package core.TestData;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "RegistrationData")
    public Object[][] setRegistrationData() {
        return new Object[][]{
                {"Argentina", "Alex", "Male"},
                {"Belarus", "Nastya", "Female"}
        };
    }
}
