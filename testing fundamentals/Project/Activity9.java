//Traversing tables 2
//Goal: Open the leads page and print the usernames and full names from the table.
//Open the browser to the Alchemy CRM site and login.
//Navigate to the Sales -> Leads.
//Find the table on the page and print the first 10 values in the Name column and the User column of the table to the console.
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

public class Activity9 {

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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));

        // Find the table and extract data
        WebElement leadsTable = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody"));
        List<WebElement> rows = leadsTable.findElements(By.tagName("tr"));

        System.out.println("Printing first 10 values in Name column and User column:");
        for (int i = 0; i < Math.min(10, rows.size()); i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));
            String name = columns.get(2).getText();
            String user = columns.get(6).getText();
            System.out.println("Name: " + name + ", User: " + user);
        }

        // Close the browser
        driver.quit();
    }

}
