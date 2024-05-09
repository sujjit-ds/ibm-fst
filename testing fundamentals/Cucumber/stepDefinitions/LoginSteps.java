package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Login page")
    public void userIsOnLoginPage() throws Throwable {
        // Initialize WebDriver and open the login page
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() throws Throwable {
        // Enter username and password
        WebElement username = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));

        username.sendKeys("admin");
        pass.sendKeys("password");
    }

    @Then("Read the page title and confirmation message")
    public void readPageTitleAndConfirmationMessage() throws Throwable {
        // Click on login button and wait for title change
        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        login.click();
//        wait.until(ExpectedConditions.titleIs("Login Form - Training Support"));

        // Read and print the page title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the page: " + pageTitle);

        // Print confirmation message
        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));
        System.out.println("Confirmation message: " + confirmationMessage.getText());
    }

    @And("Close the Browser")
    public void closeTheBrowser() throws Throwable {
        // Close the browser
        driver.quit();
    }
}
