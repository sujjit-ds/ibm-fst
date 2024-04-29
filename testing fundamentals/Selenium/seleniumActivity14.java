//Activity 14
//
//Tables #2
//
//Using Selenium:
//
//Open a new browser to https://v1.training-support.net/selenium/tables
//Get the title of the page and print it to the console.
//Using xpaths on the second table Find the number of rows and columns in the table and print them.
//Find and print the cell value at the second row second column.
//Click the header of the first column to sort by name.
//Find and print the cell value at the second row second column again.
//Print the cell values of the table footer.
//Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class seleniumActivity14 {

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

        WebElement table= driver.findElement(By.xpath("//*[@id=\"sortableTable\"]"));
        int rowCount = table.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr")).size();
        System.out.println("Number of rows: " + rowCount);

        int columnCount = table.findElements(By.xpath("//*[@id=\"sortableTable\"]/thead/tr/th")).size();
        System.out.println("Number of columns: " + columnCount);

        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")).getText());

        WebElement headerFirstName = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/thead/tr/th[1]"));
        headerFirstName.click();
        //Actions actions = new Actions(driver);
        //actions.click(headerFirstName).pause(2000).perform();
        //System.out.println("Sorted");

        System.out.println(table.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]")).getText());

        System.out.println(table.findElement(By.xpath(" /html/body/div/div[2]/div/div[3]/div[2]/table/tfoot")).getText());


    }
}
