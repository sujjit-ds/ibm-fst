//Activity 17
//Selects #1
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/selects
//Get the title of the page and print it to the console.
//On the Single Select:
//Select the second option using the visible text. • Select the third option using the index
//Select the fourth option using the value. Get all the options and print them to the console
//Close the browser

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class seleniumActivity17 {

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

        WebElement DropDown = driver.findElement(By.xpath("//*[@id=\"single-select\"]"));
        DropDown.click();

     //   WebElement DropDown=driver.findElement(By.tagName("select"));
        Select select=new Select(DropDown);
        List<WebElement> options=select.getOptions();
        select.selectByVisibleText("Option 2");
        select.selectByIndex(3);
        select.selectByValue("4");

        System.out.println("Options:");
        for (WebElement o : options) {
            System.out.println(o.getText());
        }

        driver.quit();
    }

}

