//Counting Dashlets
//Goal: Open the homepage and count the number of the dashlets on the page.
//Open the browser to the Alchemy CRM site and login.
//Count the number of Dashlets on the homepage.
//Print the number and title of each Dashlet into the console.
//Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity10 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));

        login.sendKeys("admin");

        WebElement pass = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));

        pass.sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();

        driver.findElement(By.cssSelector(".navbar-brand")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div[2]/div/table/tbody/tr/td[1]")));

        List<WebElement> count = driver.findElements(By.className("dashlet-title"));

        int count1=0;

        for (WebElement element : count) {
            System.out.println("Title: " + element.getText());
            count1++;
        }
        System.out.println("Total No. of Dashlets:  "+count1);
    }

}
