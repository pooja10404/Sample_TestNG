import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class windowHandleFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://nxtgenaiacademy.com/multiplewindows/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void window_Handle_Functionality() {
        try {
            System.out.println("Starting the test case");
            // Store the current window handle
            String winHandleBefore = driver.getWindowHandle();
            // identify element with cssSelector and Perform the click operation that opens new window
            WebElement newBrowserTab = driver.findElement(By.cssSelector("button[onclick='newBrwTab()']"));
            newBrowserTab.click();
            // check whether element is enabled or not
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
            // identify element with cssSelector and Perform the actions on new window
            WebElement courseFeatures= driver.findElement(By.cssSelector("li[id='menu-item-6044']>a "));
            courseFeatures.click();
            Thread.sleep(2000);
            // Switch back to original browser (first window)
            driver.switchTo().window(winHandleBefore);
            Thread.sleep(2000);

        }catch(Exception e){}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}