//Logging into the site
//Goal: Open the site and login with the credentials provided
//Open the browser
//Navigate to ‘https://alchemy.hguy.co/crm’. .
//Find and select the username and password fields
//Enter login credentials into the respective fields
//Click login
//Verify that the homepage has opened.
//Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebElement login=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));

        login.sendKeys("admin");

        WebElement pass=driver.findElement(By.xpath("//*[@id=\"username_password\"]"));

        pass.sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();

        driver.quit();

    }

}
