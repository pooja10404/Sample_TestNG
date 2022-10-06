import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;


public class ExplicitWaitFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void Explicit_wait_Functionality() {
        try {


            // Click on timer button to start
            driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

            // Create object of WebDriverWait class and it will wait max of 20 seconds.
            // By default it will accepts in Seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Here we will wait until element is not visible, if element is visible then it will return web element
            // or else it will throw exception
            WebElement element = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

            // if element found then we will use- In this example I just called isDisplayed method
            boolean status = element.isDisplayed();

            // if else condition
            if (status) {
                System.out.println("===== WebDriver is visible======");
            } else {
                System.out.println("===== WebDriver is not visible======");
            }

        }catch(UnhandledAlertException e){e.getAlert();}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }

}
