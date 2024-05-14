//Get the url of the header image
//Goal: Print the url of the header image to the console
//Open a browser.
//Navigate to ‘http://alchemy.hguy.co/crm’.
//Get the url of the header image.
//Print the url to the console.
//Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebElement url=driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));

        System.out.println(url.getAttribute("href"));

        driver.quit();
    }
}
