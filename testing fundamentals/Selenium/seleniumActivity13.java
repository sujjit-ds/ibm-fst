//Activity 13
//Tables #1
//Using Selenium:
//Open a new browser to https://v1.training-support.net/selenium/tables
//Get the title of the page and print it to the console.
//Using xpaths on the first table:
//Find the number of rows and columns in the table and print them.Find and print all the cell values in the third row of the table.
//Find and print the cell value at the second row second column.
//Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumActivity13 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/tables");

        // getting page's title and print it in console
        String title = driver.getTitle();
        System.out.println(title);

        // Find the table element
        WebElement table = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table"));

        int rowCount = table.findElements(By.xpath(".//tr")).size();
        System.out.println("Number of rows: " + rowCount);

        int columnCount = table.findElements(By.xpath(".//tr[1]/td")).size();
        System.out.println("Number of columns: " + columnCount);

        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[3]")).getText());

        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/table/tbody/tr[3]/td[2]")).getText());
        driver.quit();
    }
}
//
//        // Find number of rows in the table
//        int rowCount = table.findElements(By.xpath("//tbody/tr")).size();
//        System.out.println("Number of rows: " + rowCount);
//
//        // Find number of columns in the table
//        int columnCount = table.findElements(By.xpath("//tbody/tr[1]/td")).size();
//        System.out.println("Number of columns: " + columnCount);
//
//        // Print all cell values in the third row
//        System.out.println("Cell values in the third row:");
//        for (int i = 1; i <= columnCount; i++) {
//            WebElement cell = table.findElement(By.xpath("//tbody/tr[3]/td[" + i + "]"));
//            System.out.println(cell.getText());
//        }
//
//        // Find and print the cell value at the second row, second column
//        WebElement cell2_2 = table.findElement(By.xpath("//tbody/tr[2]/td[2]"));
//        System.out.println("Value at second row, second column: " + cell2_2.getText());
//
//        // Close the browser
//        driver.quit();
//    }

