import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

//Activity 7
//In the @BeforeMethod method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterMethod method, use close() to close the browser once the test is done.
//Add a @DataProviders method credentials() with the name parameter set to "Authentication".
//Set the return type of the method as Object[][].
//It should return two Objects with a username and a password each.
//Write a @Test method, with the parameter dataProvider set to name of the @DataProvider method.
//Add them as formal parameters for the test method.
//In the @Test method:
//
//Use findElements() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input.
//Click the login button.
//Run the test script as a TestNG Test.


public class testNGActivity7 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @DataProvider(name="Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                {"admin", "password"},
                {"admin1","pass1"}
    };
    }

    @Test(dataProvider = "Authentication")
    public void test(String username,String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);


        loginButton.click();

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
