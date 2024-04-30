//Activity 3
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.
//        Assert.assertEquals("Expected message", "Actual Message");

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGActivity3 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void login() {

        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("password");

        WebElement log=driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button"));
        log.click();

        WebElement message = driver.findElement(By.id("action-confirmation"));
        String confirmationMessage = message.getText();

        // Assert the confirmation message
        Assert.assertEquals(confirmationMessage, "Welcome Back, admin");

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
