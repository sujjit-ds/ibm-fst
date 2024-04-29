//Activity 15
//Dynamic Attributes #1
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/dynamic-attributes
//Get the title of the page and print it to the console
//Find the username and password input fields. Type in the credentials
//username: admin
//password: password
//Wait for login message to appear and print the login message to the console
//Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity15 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement username = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[1]/input"));
        username.click();
        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[2]/input"));
        pass.click();
        pass.sendKeys("password");

        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[1]/div/div/button"));
        login.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
        WebElement message=driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(message.getText());

        driver.quit();

    }
}

