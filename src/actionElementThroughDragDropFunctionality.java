import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class actionElementThroughDragDropFunctionality {
    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeTest
    public void setUp() {
        File f = new File("tools");
        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void actionElementThroughDragDropFunctionality() throws InterruptedException {
        WebElement madridOption = driver.findElement(By.xpath("(//div[contains(@id,'dropContent')]/..//div[contains(text(),'Copenhagen')])[2]"));
        WebElement italyOption = driver.findElement(By.xpath("//div[contains(text(),'Italy')]"));
        Actions actions = new Actions(driver);
        //this operation perform dragAnddrop on(madridOption) and(italyOption)
        actions.dragAndDrop(madridOption, italyOption).perform();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}
