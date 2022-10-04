import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class alertDismissFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pooja//jar files//chromedriver.exe");
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
           // Switching to Alert
            driver.switchTo().alert();
           // To click on the ‘Cancel’ button of the alert. (Dismiss the alert)
            driver.switchTo().alert().dismiss();
            }catch(UnhandledAlertException e){e.getAlert();}
        }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
