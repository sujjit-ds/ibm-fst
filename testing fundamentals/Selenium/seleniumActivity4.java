//Activity 4
//
//        Target Practice
//
//        Using Selenium:
//
//        Open a new browser to https://v1.training-support.net/selenium/target-practice
//        Get the title of the page and print it to the console.
//
//        Using xpath:
//
//        Find the 3rd header on the page and print it's text to the console.
//        Find the 5th header on the page and print it's color.
//
//        Using any other locator:
//
//        Find the violet button and print all it's classes.
//        Find the grey button and print it's text.
//        Close the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;

public class seleniumActivity4 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("Title of the page: " + driver.getTitle());

        WebElement thirdHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h3"));
        System.out.println("Third header: " + thirdHeader.getText());


        WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        System.out.println("Fifth header: " + fifthHeader.getCssValue("color"));

        WebElement violetButton = driver.findElement(By.cssSelector(".violet"));
        System.out.println("Violet Button: " + violetButton.getAttribute("class"));

        WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("Grey Button: " + greyButton.getText());

        driver.quit();

    }
}


