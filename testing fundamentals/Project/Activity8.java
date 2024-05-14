//Traversing tables
//Goal: Open the accounts page and print the contents of the table.
//Open the browser to the Alchemy CRM site and login.
//Navigate to the Sales -> Accounts page.
//Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
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

public class Activity8 {
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

        WebElement sales = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        sales.click();
        action.moveToElement(sales).perform();

        WebElement accounts = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]"));

        accounts.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/h2")));

        // Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console.
        WebElement table = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table"));
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[3]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[5]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[7]/td[3]/b/a")).getText());
        System.out.println(table.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[9]/td[3]/b/a")).getText());

        // close browser
        driver.quit();
    }

}