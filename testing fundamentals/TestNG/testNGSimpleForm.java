import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
//import AuthenticationDataProvider;

public class testNGSimpleForm extends AuthenticationDataProvider{
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

//    @DataProvider(name="Authentication")
//    public static Object[][] credentials() {
//        return new Object[][]{
//                {"sandy", "kumar","sandy@gmail.com","9999999999","Hi"},
//                {"Narayana", "kumar","nara@gmail.com","9999989999","Hi"},
//                {"suj", "jit","suj@gmail.com","9779999999","Hi"}
//        };
//    }

    @Test(dataProvider = "Authentication")
    //@Test(dataProvider = "Authentication" ,dataProviderClass = AuthenticationDataProvider.class)
    // also add extends
    public void test(String firstName1, String lastName1, String email1, String number1, String message1) {
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement number = driver.findElement(By.id("number"));
        WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[5]/textarea"));

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"simpleForm\"]/div/div[6]/div[1]/input"));
        WebElement clear=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[2]/input"));

        firstName.sendKeys(firstName1);
        lastName.sendKeys(lastName1);
        email.sendKeys(email1);
        number.sendKeys(number1);
        message.sendKeys(message1);

        submit.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        clear.click();

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}