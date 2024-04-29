//Activity 11
//
//Check if elements are selected
//
//Using Selenium:
//
//Open a new browser to https://v1.training-support.net/selenium/dynamic-controls
//
//Get the title of the page and print it to the console.
//
//On the page, perform:
//
//Find the checkbox input element.
//        Check if the checkbox is selected and print the result.
//Click the checkbox to select it.
//Check if the checkbox is selected again and print the result.
//Close the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumActivity11 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        //Actions builder = new Actions(driver);
        // create wait object

        WebElement checkBox=driver.findElement(By.xpath("//*[@id=\"dynamicCheckbox\"]/label"));
        System.out.println("is the element selected : "+checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());
        driver.quit();

    }
}