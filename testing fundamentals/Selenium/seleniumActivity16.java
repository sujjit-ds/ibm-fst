//Activity 16
//Dynamic Attributes #2
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/dynamic-attributes
//Get the title of the page and print it to the console.
// Find the input fields of the Sign Up form.
//Fill in the details in the fields with your own data
//Wait for success message to appear and print it to the console.
//Close the browser

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumActivity16 {

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

        WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[1]/input"));
        username.click();
        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/div[2]/input"));
        pass.click();
        pass.sendKeys("password");

        WebElement conPass = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[3]/input"));
        conPass.click();
        conPass.sendKeys("password");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[4]/input"));
        email.click();
        email.sendKeys("123@abc.com");

        WebElement signUp = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[3]/div/div/button"));
        signUp.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"action-confirmation\"]")));
        WebElement message=driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println(message.getText());

        driver.quit();
    }
}
