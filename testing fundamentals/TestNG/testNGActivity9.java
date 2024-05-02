//Create a TestNG Class with the annotations
//@Test
//@BeforeMethod
//@BeforeTest
//@AfterTest
//Once the Class file is created, import
//By
//        WebDriver
//FirefoxDriver
//        Alert
//Reporter
//In the @BeforeTest method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/javascript-alerts
//In the @AfterTest method, use close() to close the browser once the test is done.
//Make three @Test methods - simpleAlertTestCase(), confirmAlertTestCase(), promptAlertTestCase().
//Each @Test method will open a type of alert and getText() from it and print it in the console.
//Use driver.switchTo().alert() to switch focus to the alert.
//In the @BeforeMethod method, use driver.switchTo().defaultContent() to switch focus back to the page.
//Confirm and Prompt Alerts can be closed using alert.accept() and alert.dismiss().
//        For the prompt alert, use alert().sendKeys() to type the text in the input box.
//        Use the logger methods to add logging sentences.
//        Add assertions statement in each test method.
//        Run the test script as a TestNG Test.
//        Observe results in the Console and the generated HTML file.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class testNGActivity9 {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

    }

    @BeforeMethod
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        driver.findElement(By.id("simple")).click();

        Alert simpleAlert = driver.switchTo().alert();

        String alertText = simpleAlert.getText();
        System.out.println("Simple Alert Text: " + alertText);
        Assert.assertEquals(alertText, "This is a JavaScript Alert!");

        simpleAlert.accept();

        Reporter.log("Simple Alert");
    }

    @Test
    public void confirmAlertTestCase() {
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();

        String alertText = confirmAlert.getText();
        System.out.println("Confirm Alert Text: " + alertText);
        Assert.assertEquals(alertText, "This is a JavaScript Confirmation!");

        confirmAlert.dismiss();

        Reporter.log("Confirm Alert");
    }

    @Test
    public void promptAlertTestCase() {
        driver.findElement(By.id("prompt")).click();

        Alert promptAlert = driver.switchTo().alert();

        String alertText = promptAlert.getText();
        System.out.println("Prompt Alert Text: " + alertText);

        Assert.assertEquals(alertText, "This is a JavaScript Prompt!");

        promptAlert.sendKeys("Test Input");
        promptAlert.accept();

        Reporter.log("Prompt Alert");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
