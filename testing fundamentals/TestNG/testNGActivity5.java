//Activity 5
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/target-practice
//In the @AfterClass method, use close() to close the browser once the test is done.

//Activity 5
//Write tests for:
//
//Checking the page title
//Header Tests:
//Find the third header and assert the text in the h3 tag.
//Find and assert the colour of the fifth header tag element.
//Button Tests:
//Find the button with the class olive and assert it text.
//Find and assert the colour of the first button in the third row.
//Group the Header tests under a group, HeaderTests.
//Group the Button tests under a group, ButtonTests.
//Activity 5
//In testng.xml:
//
//Run all the tests from this activity.
//Run only the tests that are in the HeaderTests group.
//Run only the tests that are in the ButtonTests group.
//Exclude the tests that are in the HeaderTests group

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testNGActivity5 {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void assertTitle() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }

    @Test(groups = {"HeaderTests"})
    public void headerTesth3() {

        WebElement thirdHead = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        String th = thirdHead.getText();
        Assert.assertEquals("Third header", th);

    }

    @Test(groups = {"HeaderTests"})
    public void fifthHeaderTag() {

        WebElement fifthHead = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String col = fifthHead.getCssValue("color");
        Assert.assertEquals("rgb(33, 186, 69)", col);

    }

    @Test(groups = {"ButtonTests"})
    public void buttonWithClassOlive() {
        WebElement oliveButton = driver.findElement(By.cssSelector("button.olive"));
        String buttonText = oliveButton.getText();
        Assert.assertEquals("Olive", buttonText);
    }

    @Test(groups = {"ButtonTests"})
    public void firstButtonThirdRowColor() {
        WebElement firstButtonThirdRow = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        String buttonColor = firstButtonThirdRow.getCssValue("background-color");
        // Asserting color in RGBA format
        Assert.assertEquals("rgb(165, 103, 63)", buttonColor);
    }

        @AfterClass
        public void afterMethod () {
            //Close the browser
            driver.quit();
        }
    }

