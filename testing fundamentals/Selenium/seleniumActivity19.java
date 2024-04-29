//Activity 19
//Alerts #1
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/javascript-alerts
//Get the title of the page and print it to the console.
//Find the button to open a CONFIRM alert and click it.
//        Switch the focus from the main window to the Alert box and get it and print it
//        Close the alert once with Ok and again with Cancel.
//        Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity19 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");



        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement Confirm=driver.findElement( By.xpath("//*[@id=\"confirm\"]"));
        Confirm.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.accept();
        Confirm.click();
        alert.dismiss();

        driver.quit();

    }
}
