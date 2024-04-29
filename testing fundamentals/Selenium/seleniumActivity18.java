//Activity 18
//Selects #2
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/selects
//Get the title of the page and print it to the console.
//On the Multi Select
//Select the "JavaScript" option using the visible text. Select the 4th, 5th and 6th options using the index.
//Select the "NodeJS" option using the value.
//Deselect the 5th option using index.
//Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity18 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/selects");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement DropDown = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]"));
        DropDown.click();

        //   WebElement DropDown=driver.findElement(By.tagName("select"));
        Select select = new Select(driver.findElement(By.id("multi-select")));
        select.selectByVisibleText("Javascript");
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByIndex(6);
        select.selectByValue("node");
        select.deselectByIndex(5);
    }
}
