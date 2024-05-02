
//FOR testNGSimpleForm Code

import org.testng.annotations.DataProvider;

public class AuthenticationDataProvider {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                {"sandy", "kumar", "sandy@gmail.com", "9999999999", "Hi"},
                {"Narayana", "kumar", "nara@gmail.com", "9999989999", "Hi"},
                {"suj", "jit", "suj@gmail.com", "9779999999", "Hi"}
        };
    }
}
