import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class dropDownVisibleTextFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeTest
    public void setUp() {
        File f = new File("tools");
        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void dropDownVisibleTextFunctionality() throws InterruptedException {
        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submit);
        actions.perform();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.name("country")));// this is select class
        // select dropdown by visible text
        Thread.sleep(2000);
        dropdown.selectByVisibleText("ALGERIA");
        Thread.sleep(2000);

    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }


}
