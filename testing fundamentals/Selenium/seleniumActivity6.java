//Activity 6
//        Input Events #2
//
//        Using Selenium:
//
//        Open a new browser to
//
//        https://v1.training-support.net/selenium/input-events
//        Get the title of the page and print it to the console. • On the page, perform:
//        Press the key of first letter of your name in caps
//        Press CTRL+a and the CTRL+c to copy all the text on the page. (Paste the text in a text editor to verify results.)
//
//        Close the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity6 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        System.out.println("Title of the page: " + driver.getTitle());

        new Actions(driver)
                .sendKeys("S")
                .perform();

        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"a");

        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,"c");

        driver.quit();

    }
}


