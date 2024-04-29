//Activity 22
//Popups
//
//Using Selenium:
//
//Open a new browser to https://v1.training-support.net/selenium/popups • Print the title of the page.
//
//Find the Sign in button and hover over it. Print the tooltip message. • Click the button to open the Sign in form.
//
//        Enter the credentials
//        username: admin
//        password: password
//        Click login and print the message on the page after logging in.
//        Finally, close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity22 {

    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/popups");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        WebElement signIn= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button"));
        Actions action = new Actions(driver);
        action.moveToElement(signIn).perform();

        String tooltipMessage = signIn.getAttribute("data-tooltip");
        System.out.println("Tooltip Message: " + tooltipMessage);

        signIn.click();


        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("password");


        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();


        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"action-confirmation\"]"));
        System.out.println("Login Success Message: " + successMessage.getText());

        driver.quit();
    }
    }