//Activity 6
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//Once the Class file is created, import
//By
//        WebDriver
//FirefoxDriver
//        WebElement
//Parameters
//
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Write a @Test method, with the annotation @Parameters below @Test.
//        Pass "username" and "password" as the parameters. Also add them as formal parameters for the test method.
//        Use findElements() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input. Then click() the login button.

//In testng.xml,
//
//        Add the <parameter> tags before the <classes> tag.
//        Add name parameters for username and password.
//        Set their value to "admin" and "password", respectively.
//        Save all the files and RUN testng.xml, NOT the test script.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testNGActivity6 {

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
    @Parameters({"username","password"})
    public void test(String username,String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);


        loginButton.click();

    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
