//List of Activities:
//Verify the website title
//Goal: Read the title of the website and verify the text
//Open a browser.
//Navigate to ‘http://alchemy.hguy.co/crm’.
//Get the title of the website.
//Make sure it matches “SuiteCRM” exactly.
//If it matches, close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        System.out.println("Title of the page: " + driver.getTitle());
        assert(driver.getTitle().contains("SuiteCRM"));

        driver.quit();
    }
}
