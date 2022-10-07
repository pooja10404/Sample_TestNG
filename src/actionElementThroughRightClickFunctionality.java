import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class actionElementThroughRightClickFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeTest
    public void setUp() {
        File f = new File("tools");
        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.out.println("absolute=="+absolute);
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    // we perform rightclick in action element
    public void actionElementThroughRightClickFunctionality() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement leaveOption = driver.findElement(By.xpath("(//span[contains(normalize-space(),'Leave')])[1]"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        //this operation perform Right click on(leaveOption)
        actions.contextClick(leaveOption).perform();
        Thread.sleep(2000);
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}


