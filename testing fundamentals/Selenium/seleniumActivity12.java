//Activity 12
//Check if elements are enabled
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/dynamic-controls
//Get the title of the page and print it to the console.
//On the page, perform:
//Find the text field.
//Check if the text field is enabled and print it.
//Click the "Enable Input" button to enable the input field.
//Check if the text field is enabled again and print it.
//Close the browser

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumActivity12 {

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

        WebElement textBox=driver.findElement(By.xpath("//*[@id=\"input-text\"]"));
        System.out.println("is the textbox enabled : "+textBox.isEnabled());
        WebElement inputBtn= driver.findElement(By.xpath("//*[@id=\"toggleInput\"]"));
        inputBtn.click();

        System.out.println("is the textbox enabled : "+textBox.isEnabled());
        driver.quit();
    }
}