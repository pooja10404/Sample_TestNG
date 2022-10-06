import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ImplicitWaitFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void implicit_wait_Functionality() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //This element will appear after 5 secs
            driver.findElement(By.id("visibleAfter")).click();

        }catch(UnhandledAlertException e){e.getAlert();}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
