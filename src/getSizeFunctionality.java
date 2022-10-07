import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class getSizeFunctionality {

    WebDriver driver;
    //Method to set up the browser and open the website
    @BeforeClass
    public void setUp() {
        File f = new File("tools");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolute+"//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testkru.com/Elements/TextFields");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void getSize_Functionality() {
        try {
            System.out.println("Starting the test case");
            // identify element with cssSelector and Perform the click operation that opens new window
            WebElement firstName = driver.findElement(By.cssSelector("input[id=firstName]"));
            Dimension dimension = firstName.getSize();
            // verify excepted and actual text
            Assert.assertEquals(dimension.getHeight(), 37);
            // verify excepted and actual text
            Assert.assertEquals(dimension.getWidth(), 429);


        }catch(Exception e){}
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}
