import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

public class alertDismissFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.out.println("absolute=="+absolute);
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void alert_Functionality() {
       try {
            System.out.println("Starting the test case");
            WebElement clickMeButton = driver.findElement(By.id("confirmButton"));
            clickMeButton.click();
           Thread.sleep(2000);
           // Switching to Alert
            driver.switchTo().alert();
           // To click on the ‘Cancel’ button of the alert. (Dismiss the alert)
            driver.switchTo().alert().dismiss();
           Thread.sleep(2000);
            }catch(UnhandledAlertException e){e.getAlert();} catch (InterruptedException e) {
           e.printStackTrace();
       }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
