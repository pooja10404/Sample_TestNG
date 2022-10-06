import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class findElements_ByclassName {
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
        driver.get("https://demoqa.com/text-box/");
        driver.manage().window().maximize();
    }
    @Test
    public void find_element_by_name() {
        try {
            Thread.sleep(3000);// Find elements using tag name
            // Find elements using tag name
            WebElement parentElement = driver.findElement (By.className("button"));

            if(parentElement != null) {
                System.out.println("Element found by ClassName");
            }
        }
        catch(Exception e){}
    }


    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
        driver=null;
    }
}