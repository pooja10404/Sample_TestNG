import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class actionElementThroughClickAndHoldFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website

    @BeforeTest
    public void setUp() {
        File f = new File("tools");
        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/tap-hold-event-handler/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void actionElementThroughClickAndHoldFunctionality() throws InterruptedException {
        WebElement tapandHoldBox = driver.findElement(By.xpath("(//div[contains(text(),'taphold click')])[1]"));
        Actions actions = new Actions(driver);
        //this operation perform click and hold on(tapandHoldBox)
        actions.clickAndHold(tapandHoldBox).perform();
    }
    @AfterClass
     public void tearDown()
    {
        driver.close();
        driver.quit();
        driver=null;
    }
}