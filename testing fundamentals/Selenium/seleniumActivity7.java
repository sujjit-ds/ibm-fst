//Activity 7 Drag and Drop
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/drag-drop
//Get the title of the page and print it to the console.
//On the page, perform:
//Find the ball and simulate a click and drag to move it into "Dropzone 1".
//Verify that the ball has entered Dropzone 1.
//        Once verified, move the ball into "Dropzone 2".
//Verify that the ball has entered Dropzone 2.
//Close the browser.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity7 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();


        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println("Title of the page: " + driver.getTitle());

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        Actions actions = new Actions(driver);


        actions.dragAndDrop(draggable, dropzone1).perform();

        String d1=dropzone1.getText();
        System.out.println(d1);
//        if (dropzone1.getText().equals("Dropped!")) {
//            System.out.println("Ball has entered Dropzone 1");
//        } else {
//            System.out.println("Ball did not enter Dropzone 1");
//        }
//

        actions.dragAndDrop(draggable, dropzone2).perform();
        String d2=dropzone2.getText();
        System.out.println(d2);
//
//        if (dropzone2.getText().equals("Dropped!")) {
//            System.out.println("Ball has entered Dropzone 2");
//        } else {
//            System.out.println("Ball did not enter Dropzone 2");
//        }

    }
}


