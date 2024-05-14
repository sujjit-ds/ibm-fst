//Get the copyright text
//        Goal: Print the first copyright text in the footer to the console
//        Open a browser.
//        Navigate to ‘http://alchemy.hguy.co/crm’.
//        Get the first copyright text in the footer.
//        Print the text to the console.
//        Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3{

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebElement cText=driver.findElement(By.xpath("//*[@id=\"admin_options\"]"));

        System.out.println(cText.getText());

        driver.quit();
    }
}
