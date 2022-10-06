import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        Select dropdown = new Select(driver.findElement(By.name("country")));// this is select class
        // select dropdown by visible text
        dropdown.selectByVisibleText("ALGERIA");

    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }


}
