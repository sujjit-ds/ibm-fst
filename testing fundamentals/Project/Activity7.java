//Reading additional information
//Goal: Reading a popup that contains additional information about the account/lead.
//Open the browser to the Alchemy CRM site and login.
//Navigate to Sales -> Leads
//In the table, find the Additional information icon at the end of the row of your newly created lead. Click it.
//Read the popup and print the phone number displayed in it.
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

public class Activity7 {

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebElement login=driver.findElement(By.xpath("//*[@id=\"user_name\"]"));

        login.sendKeys("admin");

        WebElement pass=driver.findElement(By.xpath("//*[@id=\"username_password\"]"));

        pass.sendKeys("pa$$w0rd");

        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();

        WebElement sales=driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
        sales.click();
        action.moveToElement(sales).perform();

        WebElement leads=driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]"));

        leads.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[1]/h2")));

        // In the table, find the Additional information icon at the end of the row of your newly created lead. Click it
        driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[10]/span/span")).click();

        // Read the popup and print the phone number displayed in it.
        WebElement phNum = driver.findElement(By.className("phone"));
        String num = phNum.getText();
        System.out.println(phNum);

        driver.quit();

    }
}
