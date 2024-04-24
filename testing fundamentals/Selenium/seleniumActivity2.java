//Activity 2
//Sending Input
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/login-form Get the title of the page and print it to the console.
//Find the username field using any locator and enter "admin" into it.
//Find the password field using any locator and enter "password" into it Find the "Log in" button using any locator and click it.
//Close the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;

public class seleniumActivity2 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        System.out.println("Title of the page: " + driver.getTitle());

        // Get ID from Browser
        WebElement username = driver.findElement(By.id("username"));
        username.click();
        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("password");

        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        login.click();

        System.out.println("Title of the new page: " + driver.getTitle());
        //driver.quit();

    }
}
