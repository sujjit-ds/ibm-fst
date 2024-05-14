//Menu checking
//Goal: Make sure that the “Activities” menu item exists and is clickable
//Open a browser.
//Navigate to ‘http://alchemy.hguy.co/crm’ and login using the credentials provided.
//Locate the navigation menu.
//Ensure that the “Activities” menu item exists.
//Close the browser

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

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

        WebElement activities=driver.findElement(By.xpath("//*[@id=\"grouptab_3\"]"));

        System.out.println(activities.isDisplayed());

        driver.quit();


    }

}
